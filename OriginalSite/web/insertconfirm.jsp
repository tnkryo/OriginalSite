<%@page import="center.CenterHelper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="center.CenterBeans"%>
<%
    CenterHelper ch = CenterHelper.getInstance();
    HttpSession hs = request.getSession();
    CenterBeans cb = (CenterBeans)hs.getAttribute("cb");
    ArrayList<String> chkList = cb.chkproperties();
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登録確認</title>
    </head>
    <body>
        <div align="center">
        <% if(chkList.size()==0){ %>
        <h1>登録確認</h1>
        店舗名:<%= cb.getName()%><br><br>
        住所:<%= cb.getJusyo()%><br><br>
        <%=ch.input(cb)%>
        上記の内容で登録します。よろしいですか？
        <form action="InsertResult" method="POST">
            <input type="submit" name="yes" value="はい">
        </form>
    <% }else{ %>
        <h1>入力が不完全です</h1>
        <%=ch.chkinput(chkList) %>
    <% } %>
        <form action="Insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
            <input type="hidden" name="mode" value="REINPUT">
        </form>
        <%=ch.contact()%> <%=ch.home()%>
        </div>
    </body>
</html>
