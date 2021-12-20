<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--导航条-->
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a class="navbar-brand" href="${pageContext.request.contextPath}/FindUserListServlet">首页</a></li>
                <li><a href="${pageContext.request.contextPath}/JSP/adduser.jsp">添加新的用户<span class="sr-only">(current)</span></a></li>
            </ul>
            <form class="navbar-form navbar-right" method="post" action="${pageContext.request.contextPath}/NameFindServlet">
                <div class="form-group">
                    <input aria-label="" class="form-control" name="Search" id="Search" placeholder="请输入用户名"  type="text">
                </div>
                <button class="btn btn-default" type="submit">搜索</button>
            </form>
        </div>
    </div>
</nav>