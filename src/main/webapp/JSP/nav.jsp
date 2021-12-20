<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--导航条-->
<nav class="navbar navbar-inverse">

    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button aria-expanded="false" class="navbar-toggle collapsed"
                    data-target="#bs-example-navbar-collapse-1"
                    data-toggle="collapse" type="button">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/FindUserListServlet">首页</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath}/JSP/adduser.jsp">添加新的用户<span class="sr-only">(current)</span></a></li>
            </ul>
            <form class="navbar-form navbar-right" method="post" action="${pageContext.request.contextPath}/NameFindServlet">
                <div class="form-group">
                    <input aria-label="" class="form-control" name="Search" id="Search" placeholder="请输入用户名"  type="text">
                </div>
                <button class="btn btn-default" type="submit">搜索</button>
            </form>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>