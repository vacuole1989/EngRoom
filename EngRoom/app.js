
App({
  onLaunch: function () {
    wx.login({
      success: res => {
        this.globalData.code = res.code;
      }
    })
  },
  onShow: function (ops) {
      
  },
  globalData: {
    
  }
})
