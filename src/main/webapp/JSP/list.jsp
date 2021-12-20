<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta content="width=device-width, initial-scale=5" name="viewport">
    <title>业主信息管理</title>
    <link crossorigin="anonymous" href="${pageContext.request.contextPath}/CSS/bootstrap.min.css" rel="stylesheet"/>
    <script>
        function del(ID) {
            if (confirm("确定要删除这个信息吗？ 此操作无法恢复！")){
                location.href="${pageContext.request.contextPath}/DelUserListServlet?ID="+ID;
            }
        }
        function changeMoney(ID,money) {
            let m=prompt("请输入充值的金额","请输入金额");
            if(m!=null){
                if (m!="" && !isNaN(m)){
                    let f=parseFloat(m)+money;
                    location.href="${pageContext.request.contextPath}/depositMoneyServlet?Money="+f+"&ID="+ID;
                }
                else{
                    alert("请输入正确的数字！");
                }
            }
        }
    </script>
</head>
<body>
<div class="container">
    <%@ include file="/JSP/nav.jsp" %>
    <div class="row">
        <div class="col-xs-offset-1 col-xs-10">
            <div class="col-lg-offset-4 col-sm-12" style="font-size: 30px;color: #449d44;margin-top: 30px">
                用户信息列表
            </div>
            <table class="table table-bordered">
                <tr style="background-color: #10923866">
                    <td style="text-align: center">ID</td>
                    <td style="text-align: center">用户名</td>
                    <td style="text-align: center">单元</td>
                    <td style="text-align: center">楼层</td>
                    <td style="text-align: center">房号</td>
                    <td style="text-align: center">余额</td>
                    <td style="text-align: center">操作</td>
                </tr>
                <c:if test="${users!=null}">
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td style="text-align: center">${user.id}</td>
                            <td style="text-align: center">${user.name}</td>
                            <td style="text-align: center">${user.state}</td>
                            <td style="text-align: center">${user.layer}</td>
                            <td style="text-align: center">${user.room}</td>
                            <td style="text-align: center">${user.money}</td>
                            <div class="row">
                                <td>
                                    <a class="btn col-sm-offset-0 col-sm-3" style="background-color: #A6E2FF" href="${pageContext.request.contextPath}/BeforeChangeInformationServlet?ID=${user.id}">修改信息</a>
                                    <a class="btn col-sm-offset-2 col-sm-2" style="background-color: #A6E2FF" onclick="changeMoney(${user.id},${user.money})">缴费</a>
                                    <a class="btn col-sm-offset-2 col-sm-2" style="background-color: #A6E2FF" onclick="del(${user.id})" >删除</a>
                                </td>
                            </div>
                        </tr>
                    </c:forEach>
                </c:if>
            </table>
        </div>
    </div>

    <!--版权信息-->
    <div class="row">
        <div class="text-center col-sm-12">
            designed by:CMS
        </div>
    </div>
</div>

<script crossorigin="anonymous" src="${pageContext.request.contextPath}/JS/jquery-3.6.0.min.js"></script>
<script crossorigin="anonymous" src="${pageContext.request.contextPath}/JS/bootstrap.min.js"></script>

</body>
</html>