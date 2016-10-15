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
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>我要拼班</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/icheck/square/red.css">
    <link rel="stylesheet" href="${ctx}/resources/css/weui.min.css"/>
</head>
<body>
<div class="container">
    <div class="row">
        <form class="form-horizontal" id="newClassForm">
            <div class="panel panel-default">
                <div class="panel-heading">学员信息</div>
                <div class="panel-body">
                    <div class="weui_cell">
                        <div class="weui_cell_hd"><label class="weui_label">学生姓名</label></div>
                        <input type="hidden" name="mpCode" value="${openId}" />
                        <div class="weui_cell_bd weui_cell_primary">
                            <input name="studentName" type="text" class="weui_input" value="${studentBasic.studentName}" placeholder="请输入学生姓名"/>
                        </div>
                    </div>
                    <div class="weui_cell">
                        <div class="weui_cell_hd"><label class="weui_label">性别</label></div>
                        <div class="weui_cell_bd weui_cell_primary">
                            <input type="radio" name="studentGender" id="gender1" value="1" <c:if test="${studentBasic.studentGender == '1' }">checked</c:if> />
                            <label for="gender1">男</label>
                            <input type="radio" name="studentGender" id="gender0" value="0" <c:if test="${studentBasic.studentGender == '0' }">checked</c:if> />
                            <label for="gender0">女</label>
                        </div>
                    </div>
                    <div class="weui_cell">
                        <div class="weui_cell_hd"><label class="weui_label">出生年月</label></div>
                        <div class="weui_cell_bd weui_cell_primary">
                            <input type="date" name="birthDate" id="birthDate" class="weui_input" value="${studentBasic.birthDate}" />
                        </div>
                        <div class="weui_cell_ft" id="birthDateWarning" style="display: none">
                            <i class="weui_icon_warn"></i>
                        </div>
                    </div>
                    <div class="weui_cell">
                        <div class="weui_cell_hd"><label class="weui_label">联系电话</label></div>
                        <div class="weui_cell_bd weui_cell_primary">
                            <input type="number" name="mobile" class="weui_input" pattern="[0-9]*" value="${studentBasic.mobile}" />
                        </div>
                    </div>
                    <div class="weui_cell weui_cell_select weui_select_after">
                        <div class="weui_cell_hd">
                            <label class="weui_label">所在地区</label>
                        </div>

                        <c:choose>
                            <c:when test="${studentBasic.locationId!=null and studentBasic.locationId != 0}">
                                <div class="weui_cell_bd weui_cell_primary locationDone">
                                    <label class="weui_label">${studentBasic.locationName}</label>
                                </div>
                                <div class="weui_cell_ft locationDone">
                                    <a href="javascript:modifyLocation(${studentBasic.locationId});" class="weui_btn weui_btn_mini weui_btn_default">按钮</a>
                                </div>
                                <c:set var="displayLocation0" value="none" />
                            </c:when>
                            <c:otherwise>
                                <c:set var="displayLocation0" value="" />
                            </c:otherwise>
                        </c:choose>
                        <div class="weui_cell_bd weui_cell_primary" id="locationDiv0" style="display:${displayLocation0}">
                            <select class="weui_select" name="location0" id="location0" onchange="javascript:chooseLocation(this.options[this.options.selectedIndex].value,1)">
                                ${location0}
                            </select>
                        </div>
                    </div>

                    <div class="weui_cell weui_cell_select weui_select_after" id="locationDiv1" style="display:none">
                        <div class="weui_cell_hd">
                            <label class="weui_label"></label>
                        </div>
                        <div class="weui_cell_bd weui_cell_primary">
                            <select class="weui_select" name="location1" id="location1" onchange="javascript:chooseLocation(this.options[this.options.selectedIndex].value,2)">
                            </select>
                        </div>
                    </div>
                    <div class="weui_cell weui_cell_select weui_select_after" id="locationDiv2" style="display:none">
                        <div class="weui_cell_hd">
                            <label class="weui_label"></label>
                        </div>
                        <div class="weui_cell_bd weui_cell_primary">
                            <select class="weui_select" name="location2" id="location2">

                            </select>
                        </div>
                    </div>
                    <div class="weui_cell">
                        <div class="weui_cell_hd"><label class="weui_label">详细地址</label></div>
                        <div class="weui_cell_bd weui_cell_primary">
                            <input type="text" name="locationOthers" class="weui_input" value="${studentBasic.locationOthers}" placeholder="请填写详细地址" />
                        </div>
                    </div>

                    <div class="weui_cells_title">学生基础</div>
                    <div class="weui_cells weui_cells_form">
                        <div class="weui_cell">
                            <div class="weui_cell_bd weui_cell_primary">
                                <textarea class="weui_textarea" name="studentLevel" placeholder="填写学员目前的基础，便于我们安排老师" rows="4">${studentBasic.studentLevel}</textarea>
                                <%--<div class="weui_textarea_counter"><span>0</span>/200</div>--%>
                            </div>
                        </div>
                    </div>
                    <div class="weui_cells_title">上课要求</div>
                    <div class="weui_cells weui_cells_form">
                        <div class="weui_cell">
                            <div class="weui_cell_bd weui_cell_primary">
                                <textarea class="weui_textarea" name="demand" placeholder="对老师，上课内容和方式的想法要求" rows="4">${studentBasic.demand}</textarea>
                                <%--<div class="weui_textarea_counter"><span>0</span>/200</div>--%>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="panel-heading">拼班信息</div>
                <div class="panel-body">
                    <div class="weui_cell">
                        <div class="weui_cell_hd"><label class="weui_label">希望拼班人数</label></div>
                        <div class="weui_cell_bd weui_cell_primary">
                            <input type="number" class="weui_input" pattern="[0-9]*" id="classMaxPeole" name="classMaxPeole" placeholder="请输入希望一起拼班的伙伴数" value="${studentTime.classMaxPeole}" />
                            <div class="weui_cell_tips">拼班学员平分老师的上课费用，人数越多价格越低，为保证学习效果，一般以3-6人为宜</div>
                        </div>
                        <div class="weui_cell_ft" id="classMaxPeoleWarning" style="display: none">
                            <i class="weui_icon_warn"></i>
                        </div>
                    </div>

                    <div class="weui_cell">
                        <div class="weui_cell_hd"><label class="weui_label">周一</label></div>
                        <div class="weui_cell_bd weui_cell_primary">
                            <input type="checkbox" name="monday1" id="monday1" <c:if test="${studentTime.monday1 == true }">checked</c:if> />
                            <label for="monday1">上午</label>
                            <input type="checkbox" name="monday2" id="monday2" <c:if test="${studentTime.monday2 == true }">checked</c:if> />
                            <label for="monday2">下午</label>
                            <input type="checkbox" name="monday3" id="monday3" <c:if test="${studentTime.monday3 == true }">checked</c:if> />
                            <label for="monday3">晚上</label>
                        </div>
                    </div>
                    <div class="weui_cell">
                        <div class="weui_cell_hd"><label class="weui_label">周二</label></div>
                        <div class="weui_cell_bd weui_cell_primary">
                            <input type="checkbox" name="tuesday1" id="tuesday1" <c:if test="${studentTime.tuesday1 == true }">checked</c:if> />
                            <label for="tuesday1">上午</label>
                            <input type="checkbox" name="tuesday2" id="tuesday2" <c:if test="${studentTime.tuesday2 == true }">checked</c:if> />
                            <label for="tuesday2">下午</label>
                            <input type="checkbox" name="tuesday3" id="tuesday3" <c:if test="${studentTime.tuesday3 == true }">checked</c:if> />
                            <label for="tuesday3">晚上</label>
                        </div>
                    </div>

                    <div class="weui_cell">
                        <div class="weui_cell_hd"><label class="weui_label">周三</label></div>
                        <div class="weui_cell_bd weui_cell_primary">
                            <input type="checkbox" name="wednesday1" id="wednesday1" <c:if test="${studentTime.wednesday1 == true }">checked</c:if> />
                            <label for="wednesday1">上午</label>
                            <input type="checkbox" name="wednesday2" id="wednesday2" <c:if test="${studentTime.wednesday2 == true }">checked</c:if>  />
                            <label for="wednesday2">下午</label>
                            <input type="checkbox" name="wednesday3" id="wednesday3" <c:if test="${studentTime.wednesday3 == true }">checked</c:if>  />
                            <label for="wednesday3">晚上</label>
                        </div>
                    </div>

                    <div class="weui_cell">
                        <div class="weui_cell_hd"><label class="weui_label">周四</label></div>
                        <div class="weui_cell_bd weui_cell_primary">
                            <input type="checkbox" name="thursday1" id="thursday1" <c:if test="${studentTime.thursday1 == true }">checked</c:if>  />
                            <label for="thursday1">上午</label>
                            <input type="checkbox" name="thursday2" id="thursday2" <c:if test="${studentTime.thursday2 == true }">checked</c:if> />
                            <label for="thursday2">下午</label>
                            <input type="checkbox" name="thursday3" id="thursday3" <c:if test="${studentTime.thursday3 == true }">checked</c:if> />
                            <label for="thursday3">晚上</label>
                        </div>
                    </div>

                    <div class="weui_cell">
                        <div class="weui_cell_hd"><label class="weui_label">周五</label></div>
                        <div class="weui_cell_bd weui_cell_primary">
                            <input type="checkbox" name="friday1" id="friday1" <c:if test="${studentTime.friday1 == true }">checked</c:if> />
                            <label for="friday1">上午</label>
                            <input type="checkbox" name="friday2" id="friday2" <c:if test="${studentTime.friday2 == true }">checked</c:if> />
                            <label for="friday2">下午</label>
                            <input type="checkbox" name="friday3" id="friday3" <c:if test="${studentTime.friday3 == true }">checked</c:if> />
                            <label for="friday3">晚上</label>
                        </div>
                    </div>

                    <div class="weui_cell">
                        <div class="weui_cell_hd"><label class="weui_label">周六</label></div>
                        <div class="weui_cell_bd weui_cell_primary">
                            <input type="checkbox" name="saturday1" id="saturday1" <c:if test="${studentTime.saturday1 == true }">checked</c:if> />
                            <label for="saturday1">上午</label>
                            <input type="checkbox" name="saturday2" id="saturday2" <c:if test="${studentTime.saturday2 == true }">checked</c:if> />
                            <label for="saturday2">下午</label>
                            <input type="checkbox" name="saturday3" id="saturday3" <c:if test="${studentTime.saturday3 == true }">checked</c:if> />
                            <label for="saturday3">晚上</label>
                        </div>
                    </div>

                    <div class="weui_cell">
                        <div class="weui_cell_hd"><label class="weui_label">周日</label></div>
                        <div class="weui_cell_bd weui_cell_primary">
                            <input type="checkbox" name="sunday1" id="sunday1" <c:if test="${studentTime.sunday1 == true }">checked</c:if> />
                            <label for="sunday1">上午</label>
                            <input type="checkbox" name="sunday2" id="sunday2" <c:if test="${studentTime.sunday2 == true }">checked</c:if> />
                            <label for="sunday2">下午</label>
                            <input type="checkbox" name="sunday3" id="sunday3" <c:if test="${studentTime.sunday3 == true }">checked</c:if> />
                            <label for="sunday3">晚上</label>
                        </div>
                    </div>


                    <div class="weui_cell">
                        <div class="weui_cell_hd ">
                            <label class="weui_label">
                                <input class="form-control" name="placeOffer" type="checkbox" id="holdClass" <c:if test="${studentTime.placeOffer == true }">checked</c:if> />
                            </label>
                        </div>

                        <div class="weui_cell_bd weui_cell_primary">
                            <label class="weui_label" for="holdClass">是否可以提供上课场地</label>
                            <div class="weui_cell_tips">不能自己提供场地的话，我们也可以帮助家长联系提供场地，但是会收取一定的场地费用</div>
                        </div>

                    </div>



                </div>

            </div>
            <div class="bd">
                <a class="weui_btn weui_btn_primary" href="javascript:;" onclick="saveForm()" >保存</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
<script src="${ctx}/resources/js/jquery-1.12.3.min.js" type="application/javascript"></script>
<script src="${ctx}/resources/js/bootstrap.min.js"></script>
<script src="${ctx}/resources/js/icheck.min.js"></script>
<jsp:include page="/default/jweixin" flush="true" />

<script language="javascript" >
    $(document).ready(function(){
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-red',
            radioClass: 'iradio_square-red',
            increaseArea: '20%' // optional
        });
    });
    function chooseLocation(id,type){
        if(id==0){
            if(type==1){
                $("#locationDiv1").hide();
                $("#location1").html("");
                $("#locationDiv2").hide();
                $("#location2").html("");
            }else if(type==2){
                $("#locationDiv2").hide();
                $("#location2").html("");
            }
        }else{
            if(type==1){
                $("#locationDiv1").show();
                getSelect(id,"location1");//内容
                $("#locationDiv2").hide();
                $("#location2").html("");
            }else if(type==2){
                $("#locationDiv2").show();
                getSelect(id,"location2");//内容
            }
        }
    }
    function getSelect(parentId,domId){
        $.ajax({
            url:"${ctx}/page/getSelect",
            data:"parentId="+parentId,
            dataType:"json",
            success:function(res){
                if(res.result=="ok"){
                    $("#"+domId).html(res.detail);
                }
            }
        });
    }
    function modifyLocation(locationId){
        $(".locationDone").hide();
        $("#locationDiv0").show();
        $("#locationDiv1").show();
        $("#locationDiv2").show();
        if(locationId ==undefined){
            return;
        }
        $.ajax({
            url:"${ctx}/page/getSelectReselect",
            data:"locationId="+locationId,
            dataType:"json",
            success:function(res){
                if(res.level0!=null){
                    $("#location0").html(res.level0);
                }
                if(res.level1!=null){
                    $("#location1").html(res.level1);
                }
                if(res.level2!=null){
                    $("#location2").html(res.level2);
                }
            }
        });
    }
    function saveForm(){
        if(!$.trim( $('#classMaxPeole').val()).length){
            $("#classMaxPeoleWarning").show();
            $("#classMaxPeole").focus();
            return;
        }else{
            $("#classMaxPeoleWarning").hide();
        }
        if(!$.trim( $('#birthDate').val()).length){
            $("#birthDateWarning").show();
            $("#birthDate").focus();
            return;
        }else{
            $("#birthDateWarning").hide();
        }
        //newClassForm
        $.ajax({
            url:"${ctx}/page/newClass",
            data:$("#newClassForm").serialize(),
            dataType:"json",
            success:function(res){
                alert("保存完成");
                console.log("res",res);
            }
        });

    }
</script>
