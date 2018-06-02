const config = require('../../config.js')
const app = getApp()

Page({
    data: {
        carousels: [],
        courses:[]
    },
    onChapter: function () {
        wx.navigateTo({
            url: '/pages/',
        })
    },
    onLoad: function () {
        var _this = this;
        wx.request({
            url: config.url + '/getCarousels?seqId=0',
            success: function (res) {
                _this.setData({
                    carousels:res.data
                })
            }
        })
        wx.request({
            url: config.url + '/getCourses',
            success: function (res) {
                _this.setData({
                    courses:res.data
                })
            }
        })
    },
    onShareAppMessage:function(){

    }


})
