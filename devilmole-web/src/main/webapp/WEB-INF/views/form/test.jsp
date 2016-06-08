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
</head>
<body>
<div class="container">
    <div class="row">
        <form class="form-horizontal">
            <div class="panel panel-default">
                <div class="panel-heading">学员信息</div>
                <div class="panel-body">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">学生姓名</label>
                        <div class="col-sm-5">
                            <input class="form-control" name="studentName" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">性别</label>
                        <div class="col-sm-2">
                            <select class="form-control" name="gender">
                                <option value="">请选择性别</option>
                                <option value="1">男</option>
                                <option value="0">女</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">出生年月</label>
                        <div class="col-sm-6">

                        </div>
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
                            <textarea class="form-control" name="basic" rows="4"></textarea>
                        </div>
                    </div>
                </div>
                <div class="panel-heading">拼班信息</div>
                <div class="panel-body">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">希望拼班人数</label>
                        <div class="col-sm-4">
                            <input type="number" name="classMaxPeole" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">希望上课时间</label>
                        <div class="col-sm-4">
                            <select class="form-control">
                                <option>周一</option>
                                <option>周二</option>
                                <option>周三</option>
                            </select>
                        </div>
                        <div class="col-sm-4">
                            <select class="form-control">
                                <option>上午</option>
                                <option>下午</option>
                                <option>晚上</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="holdClass" class="col-sm-5 control-label">是否可以提供上课场地</label>
                        <div class="col-sm-3">
                            <input class="form-control" type="checkbox" id="holdClass" />
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
<script src="${ctx}/resources/js/jquery-1.12.3.min.js" />
<script src="${ctx}/resources/js/bootstrap.min.js" />
<script language="javascript">
function saveForm(){
    console.log("sdfasdfas");
}
</script>