<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/icheck/square/blue.css">
</head>
<body>
<div class="container">
    <div class="row">
        <form class="form-horizontal" id="newClassForm">
            <div class="panel panel-default">
                <div class="panel-heading">学员信息</div>
                <div class="panel-body">
                    <div class="form-group">
                        <label class="col-xs-3 control-label">学生姓名</label>
                            <input type="hidden" name="mpCode" value="${openId}" />
                            <input name="studentName" class="form-control" />
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">性别</label>
                        <input type="radio" name="studentGender" id="gender1" value="1" />
                        <label for="gender1">男</label>
                        <input type="radio" name="studentGender" id="gender0" value="0" />
                        <label for="gender0">女</label>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">出生年月</label>
                        <input type="date" name="birthDate" />
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">联系电话</label>
                        <div class="col-sm-6">
                            <input class="form-control" name="mobile" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">所在小区</label>
                        <div class="col-sm-5">
                            <select class="form-control">
                                <option>选择1</option>
                                <option>选择2</option>
                                <option>选择3</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">学生基础</label>
                        <div class="col-sm-5">
                            <textarea class="form-control" name="studentLevel" rows="4"></textarea>
                        </div>
                    </div>
                </div>
                <div class="panel-heading">拼班信息</div>
                <div class="panel-body">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">希望拼班人数</label>
                        <div class="col-sm-4">
                            <input type="number" class="form-control" name="classMaxPeole" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">周一</label>
                        <div class="col-sm-3">
                            <input type="checkbox" name="monday1" id="monday1" />
                            <label for="monday1">上午</label>
                            <input type="checkbox" name="monday2" id="monday2" />
                            <label for="monday2">下午</label>
                            <input type="checkbox" name="monday3" id="monday3" />
                            <label for="monday3">晚上</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">周二</label>
                        <div class="col-sm-3">
                            <input type="checkbox" name="tuesday1" id="tuesday1" />
                            <label for="tuesday1">上午</label>
                            <input type="checkbox" name="tuesday2" id="tuesday2" />
                            <label for="tuesday2">下午</label>
                            <input type="checkbox" name="tuesday3" id="tuesday3" />
                            <label for="tuesday3">晚上</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">周三</label>
                        <div class="col-sm-3">
                            <input type="checkbox" name="wednesday1" id="wednesday1" />
                            <label for="wednesday1">上午</label>
                            <input type="checkbox" name="wednesday2" id="wednesday2" />
                            <label for="wednesday2">下午</label>
                            <input type="checkbox" name="wednesday3" id="wednesday3" />
                            <label for="wednesday3">晚上</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">周四</label>
                        <div class="col-sm-3">
                            <input type="checkbox" name="thursday1" id="thursday1" />
                            <label for="thursday1">上午</label>
                            <input type="checkbox" name="thursday2" id="thursday2" />
                            <label for="thursday2">下午</label>
                            <input type="checkbox" name="thursday3" id="thursday3" />
                            <label for="thursday3">晚上</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">周五</label>
                        <div class="col-sm-3">
                            <input type="checkbox" name="friday1" id="friday1" />
                            <label for="friday1">上午</label>
                            <input type="checkbox" name="friday2" id="friday2" />
                            <label for="friday2">下午</label>
                            <input type="checkbox" name="friday3" id="friday3" />
                            <label for="friday3">晚上</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">周六</label>
                        <div class="col-sm-3">
                            <input type="checkbox" name="saturday1" id="saturday1" />
                            <label for="saturday1">上午</label>
                            <input type="checkbox" name="saturday2" id="saturday2" />
                            <label for="saturday2">下午</label>
                            <input type="checkbox" name="saturday3" id="saturday3" />
                            <label for="saturday3">晚上</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">周日</label>
                        <div class="col-sm-3">
                            <input type="checkbox" name="sunday1" id="sunday1" />
                            <label for="sunday1">上午</label>
                            <input type="checkbox" name="sunday2" id="sunday2" />
                            <label for="sunday2">下午</label>
                            <input type="checkbox" name="sunday3" id="sunday3" />
                            <label for="sunday3">晚上</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="holdClass" class="col-sm-5 control-label">是否可以提供上课场地</label>
                        <div class="col-sm-3">
                            <input class="form-control" name="placeOffer" type="checkbox" id="holdClass" />
                        </div>
                    </div>
                </div>
                <div class="panel-footer" align="center">
                    <a class="btn btn-danger" onclick="saveForm()">保存</a>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
<script src="${ctx}/resources/js/jquery-1.12.3.min.js" type="application/javascript"></script>
<script src="${ctx}/resources/js/bootstrap.min.js"></script>
<script src="${ctx}/resources/js/icheck.min.js"></script>

<script language="javascript" >
    $(document).ready(function(){
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });
    });
function saveForm(){
    //newClassForm
    $.ajax({
        url:"${ctx}/page/newClass",
        data:$("#newClassForm").serialize(),
        dataType:"json",
        success:function(res){
            console.log("res",res);
        }
    });

}
</script>