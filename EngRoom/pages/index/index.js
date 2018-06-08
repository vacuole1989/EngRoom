const config = require('../../config.js')
const app = getApp()

Page({
    data: {
        carousels: [],
        courses: [],
        userInfo: {},
        hasUserInfo: false
    },
    onLoad: function () {
        var _this = this;
        wx.login({
            success: res => {
                wx.getUserInfo({
                    success: resu => {
                        wx.request({
                            method: 'POST',
                            url: config.url + '/onLogin?code=' + res.code,
                            data: resu.userInfo,
                            success: function (retdata) {
                                if (retdata.statusCode == '200') {
                                    _this.setData({
                                        userInfo: retdata.data,
                                        hasUserInfo: true
                                    })
                                    app.globalData.userInfo = retdata.data;
                                }

                            }
                        })
                    }
                })
            }
        })
        wx.request({
            url: config.url + '/getCarousels?seqId=0',
            success: function (res) {
                _this.setData({
                    carousels: res.data
                })
            }
        })
        wx.request({
            url: config.url + '/getCourses',
            success: function (res) {
                _this.setData({
                    courses: res.data
                })
            }
        })


    },
    onShareAppMessage: function () {

    },
    bindGetUserInfo: function (e) {
        var _this = this;
        wx.login({
            success: res => {
                wx.request({
                    method: 'POST',
                    url: config.url + '/onLogin?code=' + res.code,
                    data: e.detail.userInfo,
                    success: function (retdata) {
                        if (retdata.statusCode == '200') {
                            _this.setData({
                                userInfo: retdata.data,
                                hasUserInfo: true
                            })
                            app.globalData.userInfo = retdata.data;
                        }
                    }
                })

            }
        })
    }

})
