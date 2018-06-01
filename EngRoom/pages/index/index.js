var config = require('../../config.js')
const app = getApp()

Page({
    data: {
        banners: []
    },
    onChapter:function(){
        wx.navigateTo({
            url: '/pages/',
        })
    },
    onLoad: function () {
      
    }


})
