<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  Hello world3! 中文测试 啦啦啦
  index.jsp
  <input id="lalala" />
  <a onclick="goto()">click here</a>
  <div id="showContent"></div>
  </body>
</html>
<script src="${ctx}/resources/js/jquery-1.12.3.min.js"></script>
<script language="javascript">
  function goto(){
    $.ajax({
      url:"${ctx}/testInput",
      data:"lalala="+$("#lalala").val(),
      dataType:"json",
      success:function(result){
        console.log("result---->"+result);
        $("#showContent").html(result.detail);
      }
    });
  }
</script>
