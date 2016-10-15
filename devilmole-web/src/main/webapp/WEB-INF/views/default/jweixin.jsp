<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script src="${ctx}/resources/js/shareFunction.js"></script>
<script language="javascript">
//    console.log("inside ctx","${ctx}");
    $(function(){
        $.ajax({
            url:"${ctx}/function/getSignature",
            type:"post",
            dataType:"json",
            data:location.href,
            headers: {'Content-Type': 'application/json'},
            success:function(result){
                //console.log("result---->",result);

                wx.config({
                    debug: false,
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