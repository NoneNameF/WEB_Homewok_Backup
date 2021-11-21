<%--
  Created by IntelliJ IDEA.
  User: CMS
  Date: 2021/11/18
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta content="width=device-width, initial-scale=5" name="viewport">
    <title>添加新用户</title>
    <link crossorigin="anonymous" href="../CSS/bootstrap.min.css" rel="stylesheet"/>
    <script src="../JS/CheckNoEmpty.js"></script>
</head>
<body>
<div class="container">
    <!--登录表单-->
    <div class="row">
        <!--表单框-->
        <div class="col-md-offset-2 col-md-8 col-xs-12" style="border:  5px solid #d58512">
            <!--第一行 用户登录-->
            <div class="row">
                <div class="col-md-11 col-xs-12" style="text-align: center;font-size: 20px; color: #d58512">添加新用户</div>
            </div>
            <form class="form-horizontal row" action="${pageContext.request.contextPath}/AddUserListServlet" onsubmit="return CheckNoEmpty()">
                <div id="UserName1Form" class="form-group col-sm-12 ">
                    <label for="UserName1" class="col-sm-2  control-label">用户名</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" id="UserName1" name="UserName1" placeholder="请输入用户名">
                    </div>
                    <label for="UserName1" id="UserName1Error" class="col-sm-3 "></label>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">性别</label>
                    <div class="col-sm-8">
                        <input type="radio" style="margin-top: 10px" name="Sex" value="Man" checked="checked">男
                        <input type="radio" style=" margin-top: 10px" name="Sex" value="Women">女
                    </div>
                </div>
                <div id="AgeForm" class="form-group col-sm-12 ">
                    <label for="Age" class="col-sm-2  control-label">年龄</label>
                    <div class="col-sm-7">
                        <input type="number" class="form-control" id="Age" name="Age" placeholder="请输入年龄">
                    </div>
                    <label for="Age" id="AgeError" class="col-sm-3 "></label>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-3">
                        <button type="submit" class="btn btn-default btn-lg"> 添 加</button>
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

<script crossorigin="anonymous" src="../JS/jquery-3.6.0.min.js"></script>
<script crossorigin="anonymous" src="../JS/bootstrap.min.js"></script>

</body>
</html>>