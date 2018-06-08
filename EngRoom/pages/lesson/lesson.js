const config = require('../../config.js')
const app = getApp()
Page({
  data: {
    level:{},
    lessons:[],
    userInfo: {}
  },
  onBindTaps:function(e){
    wx.navigateTo({
        url: '/pages/word/word?seqId='+e.currentTarget.dataset.seqid,
    })
  },
  onLoad: function (options) {
    var _this=this;
    _this.setData({
        userInfo: app.globalData.userInfo
    })
    wx.request({
        url: config.url + '/getLevel?seqId=' + options.seqId,
        success: function (res) {
            _this.setData({
                level: res.data
            })
        }
    })
    wx.request({
        url: config.url + '/getLessons?seqId=' + options.seqId,
        success: function (res) {
            _this.setData({
                lessons: res.data
            })
        }
    })
  },
  onShareAppMessage: function () {
  
  }
})