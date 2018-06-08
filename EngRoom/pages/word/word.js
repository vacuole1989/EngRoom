const config = require('../../config.js')
const app = getApp()
const plugin = requirePlugin("WechatSI")
let recorderManager = plugin.getRecordRecognitionManager()
const audioContext = wx.createInnerAudioContext()
audioContext.autoplay = false;

const options = {
    lang: "en_US"
}

Page({
    data: {
        lesson: {},
        words: [],
        userInfo: {},
        cIndex: 0,
        mIndex: 0
    },
    readAudio: function (e) {
        var _this = this;
        var idx = e.currentTarget.dataset.idx;
        var n = _this.data.words[idx].userWord.userDuration*2;
        var ss=setInterval(function () {
            if (n > 0) {
                if(n%2==0){
                    var data = _this.data.words;
                    data[idx].showWifi = true;
                    _this.setData({
                        words: data
                    })
                }else{
                    var data = _this.data.words;
                    data[idx].showWifi = false;
                    _this.setData({
                        words: data
                    })
                }

                n--;
            }else{
                clearInterval(ss);
            }
        }.bind(this), 500)
        console.info(_this.data.words[idx].userWord.userDuration)
        audioContext.src = config.url_domain+'/record/' + _this.data.words[idx].userWord.userAudio;
        audioContext.play();


    },
    onChooseIndex: function (e) {
        var idx = e.currentTarget.dataset.idx;
        // if(idx<=this.data.mIndex||this.data.words[idx].userWord!=null){
        this.setData({
            cIndex: idx
        })
        // }
    },
    onLoad: function (options) {
        var _this = this;
        _this.setData({
            userInfo: app.globalData.userInfo
        })
        wx.request({
            url: config.url + '/getLesson?seqId=' + options.seqId,
            success: function (res) {
                _this.setData({
                    lesson: res.data
                })
            }
        })
        _this.onInitWords(options.seqId);

        recorderManager.onStop = function (res) {
            var tmpIndex = _this.data.cIndex;
            wx.uploadFile({
                url: config.url + '/uploadRecord',
                filePath: res.tempFilePath,
                name: 'file',
                header: {
                    'content-type': 'multipart/form-data'
                },
                formData: {
                    'seqId': _this.data.words[_this.data.cIndex].seqId,
                    'userSeqId': _this.data.userInfo.seqId,
                    'result': res.result
                },
                success: function (res) {
                    _this.onInitWords(options.seqId);
                    // if (tmpIndex + 1 < _this.data.words.length) {
                    //     _this.setData({
                    //         cIndex: tmpIndex + 1
                    //     })
                    // } else {
                    //     _this.setData({
                    //         cIndex: 0
                    //     })
                    // }
                }
            })

        }
    },
    onInitWords: function (seqId) {
        var _this = this;
        wx.request({
            url: config.url + '/getWords?seqId=' + seqId + '&userSeqId=' + _this.data.userInfo.seqId,
            success: function (res) {
                var words = res.data;
                // var cIndex = 0;
                // for (var i = 0; i < words.length; i++) {
                //     if (null == words[i].userWord) {
                //         cIndex = i;
                //         break;
                //     }
                // }
                _this.setData({
                    words: words
                    // cIndex: cIndex,
                    // mIndex: cIndex
                })
            }
        })
    },
    touchS: function () {
        wx.showLoading({
            title: '开始录音',
        })
        recorderManager.start(options);
    },
    touchE: function () {
        wx.hideLoading();
        wx.showToast({
            title: '录音成功',
            icon: 'success',
            duration: 1000
        })
        recorderManager.stop();
    },
    onShareAppMessage: function () {

    }
})