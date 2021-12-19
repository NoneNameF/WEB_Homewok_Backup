<%--
  Created by IntelliJ IDEA.
  User: CMS
  Date: 2021/11/18
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta content="width=device-width, initial-scale=5" name="viewport">
    <title>修改用户信息</title>
    <link crossorigin="anonymous" href="${pageContext.request.contextPath}/CSS/bootstrap.min.css" rel="stylesheet"/>
    <script>
        function CheckNoEmpty(){
            let flag1=CheckNotNull("UserName");
            let flag2=CheckNotNull("State");
            let flag3=CheckNotNull("layer");
            let flag4=CheckNotNull("room");
            return flag1 && flag2 && flag3 && flag4
        }
        function CheckNotNull(ID) {
            let Regular=/^\s*$/;
            let Obj=document.getElementById(ID);
            let ObjForm=document.getElementById(ID+"Form");
            let ObjError=document.getElementById(ID+"Error");
            if(Regular.test(Obj.value)){//如果返回true说明正则匹配成功 也就是名字全是空
                ObjForm.className+=" has-error";
                switch (ID) {
                    case "UserName":
                        ObjError.innerHTML="用户名不能为空";
                        break;
                    case "State":
                        ObjError.innerHTML="单元号不能为空";
                        break;
                    case "layer":
                        ObjError.innerHTML="楼层不能为空";
                        break;
                    case "room":
                        ObjError.innerHTML="房间号不能为空";
                        break;
                }
                return false; //表单有问题
            }
            else {
                ObjForm.className="form-group col-sm-12";
                ObjError.innerHTML="";
                return true;
            }
        }
    </script>
</head>
<body>
<div class="container">
    <!--登录表单-->
    <div class="row">
        <!--表单框-->
        <div class="col-md-offset-2 col-md-8 col-xs-12" style="border:  5px solid #d58512">
            <!--第一行 用户登录-->
            <div class="row">
                <div class="col-md-11 col-xs-12" style="text-align: center;font-size: 20px; color: #d58512">修改用户信息</div>
            </div>
            <form class="form-horizontal row" action="${pageContext.request.contextPath}/ChangeInformationServlet"
                  onsubmit="return CheckNoEmpty()">
                <input type="hidden" name="ID" value="${user.id}">
                <input type="hidden" name="Money" value="${user.money}">
                <div id="UserNameForm" class="form-group col-sm-12 ">
                    <label for="UserName" class="col-sm-2  control-label">用户名</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" id="UserName" name="UserName" value="${user.name}" placeholder="请输入用户名">
                    </div>
                    <label for="UserName" id="UserNameError" class="col-sm-3 "></label>
                </div>
                <div id="StateForm" class="form-group col-sm-12 ">
                    <label for="State" class="col-sm-2  control-label">单元号</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" id="State" name="State" value="${user.state}" placeholder="请输入单元号">
                    </div>
                    <label for="State" id="StateError" class="col-sm-3 "></label>
                </div>
                <div id="layerForm" class="form-group col-sm-12 ">
                    <label for="layer" class="col-sm-2  control-label">楼层</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" id="layer" name="layer" value="${user.layer}" placeholder="请输入楼层">
                    </div>
                    <label for="layer" id="layerError" class="col-sm-3 "></label>
                </div>
                <div id="roomForm" class="form-group col-sm-12 ">
                    <label for="room" class="col-sm-2  control-label">房间号</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" id="room" name="room" value="${user.room}" placeholder="请输入房间号">
                    </div>
                    <label for="room" id="roomError" class="col-sm-3 "></label>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-3">
                        <button type="submit" class="btn btn-default btn-lg"> 修 改</button>
                    </div>
                    <div class="col-sm-offset-2 col-sm-3">
                        <a class="btn btn-default btn-lg" href="${pageContext.request.contextPath}/FindUserListServlet">
                            返 回</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--版权信息-->
    <div class="row">
        <div class="text-center col-sm-12">
            designed by:CMS
        </div>
    </div>
</div>

<script crossorigin="anonymous" src="JS/jquery-3.6.0.min.js"></script>
<script crossorigin="anonymous" src="JS/bootstrap.min.js"></script>
</body>
</html>
>