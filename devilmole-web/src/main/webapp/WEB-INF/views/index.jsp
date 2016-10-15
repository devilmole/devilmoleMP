<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
  Hello world3! 中文测试 啦啦啦
  index.jsp
  <input id="lalala" />
  <a onclick="goto()">新建菜单</a>
  <div id="showContent"></div>
  </body>
</html>
<script src="${ctx}/resources/js/jquery-1.12.3.min.js"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script src="${ctx}/resources/js/shareFunction.js"></script>

<script language="javascript">
  function goto(){
    $.ajax({
      url:"${ctx}/function/createMenu",
      dataType:"json",
      success:function(result){
        console.log("result---->"+result);
        $("#showContent").html(result.detail);
      }
    });
  }
  $(function(){
    console.log("location.href2",location.href);
    $.ajax({
      url:"${ctx}/function/getSignature",
      dataType:"json",
      data:"url="+location.href,
      success:function(result){
        console.log("result---->",result);

        wx.config({
          debug: true,
          appId: result.appId,
          timestamp: result.timestamp,
          nonceStr: result.nonceStr,
          signature: result.signature,
          jsApiList: [
            'checkJsApi',
            'onMenuShareTimeline',
            'onMenuShareAppMessage',
            'onMenuShareQQ',
            'onMenuShareWeibo',
            'onMenuShareQZone'
          ]
        });

      }
    });
  });
</script>
