<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta content="width=device-width, initial-scale=5" name="viewport">
    <title>物业费缴纳系统</title>
    <link crossorigin="anonymous" href="CSS/bootstrap.min.css" rel="stylesheet"/>
    <script crossorigin="anonymous" src="${pageContext.request.contextPath}/JS/jquery-3.6.0.min.js"></script>
    <script crossorigin="anonymous" src="${pageContext.request.contextPath}/JS/bootstrap.min.js"></script>
    <script>
        function Check(){
            let flag1=CheckNotNull("Name");
            let flag2=CheckNotNull("Password");
            return flag1 && flag2
        }
        function CheckNotNull(ID) {
            let Regular=/^\s*$/;
            let Obj=document.getElementById(ID);
            let ObjForm=document.getElementById(ID+"Form");
            let ObjError=document.getElementById(ID+"Error");
            if(Regular.test(Obj.value)){//如果返回true说明正则匹配成功 也就是名字全是空
                ObjForm.className+=" has-error";
                switch (ID) {
                    case "Name":
                        ObjError.innerHTML="用户名不能为空";
                        break;
                    case "Password":
                        ObjError.innerHTML="密码不能为空";
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
                <div class="col-md-offset-1 col-md-11 col-xs-12" style="font-size: 20px; color: #d58512">管理员登录</div>
            </div>
            <form class="form-horizontal row" action="${pageContext.request.contextPath}/login" onsubmit="return Check()">
                <div id="NameForm" class="form-group col-sm-12 ">
                    <label for="Name" class="col-sm-2  control-label">用户名</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" id="Name" name="Name" placeholder="请输入用户名">
                    </div>
                    <label for="Name" id="NameError" class="col-sm-3 "></label>
                </div>
                <div id="PasswordForm" class="form-group col-sm-12">
                    <label for="Password" class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-7">
                        <input type="password" class="form-control" id="Password" name="Password" placeholder="请输入密码">
                    </div>
                    <label id="PasswordError" for="Password" class="col-sm-3"></label>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-3">
                        <button type="submit" class="btn btn-default btn-lg"> 登 录</button>
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



</body>
</html>
