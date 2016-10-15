/**
 * Created by devilmole on 16/8/27.
 */

wx.ready(function () {
    var shareData = {
        title: '外教拼班',
        desc: '同城拼外教，就在香蕉皮~',
        link: 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx4a268c507204e06d&redirect_uri=http%3A%2F%2Fmp.whitehorseprince.com%2Fwhitehorseprince%2Fpage%2FformPage&response_type=code&scope=snsapi_base&state=123#wechat_redirect',
        imgUrl: 'http://www.whitehorseprince.com/wp-content/themes/new3800-5.3/images/logo.png',
        success: function () {
            // 用户确认分享后执行的回调函数
            console.log("share success");
        },
        cancel: function () {
            // 用户取消分享后执行的回调函数
            console.log("share cancel");
        }
    };
    wx.onMenuShareAppMessage(shareData);
    wx.onMenuShareTimeline(shareData);
    wx.onMenuShareQQ(shareData);
    wx.onMenuShareWeibo(shareData);
    wx.onMenuShareQZone(shareData);

});
wx.error(function (res) {
    console.log(res.errMsg);
});