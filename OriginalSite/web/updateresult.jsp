<%@page import="java.util.ArrayList"%>
<%@page import="center.CenterBeans"%>
<%@page import="center.CenterHelper"%>
<%
    CenterHelper ch = CenterHelper.getInstance();
    boolean type = (Boolean)request.getAttribute("type");
    CenterBeans cb = (CenterBeans)request.getAttribute("upd");
    ArrayList<String> chkList = cb.chkproperties();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>編集結果</title>
    </head>
    <body>
        <div align="center">
            <%if(type){%>
        <h1>編集結果</h1>
        店舗名:<%= cb.getName()%><br>
        住所:<%= cb.getJusyo()%><br>
        <%=ch.input(cb)%>
        上記の内容に編集しました。<br>
        <form action="Detail" method="GET">
            <input type="hidden" name="id"  value="<%= cb.getTenpoID()%>">
            <input type="submit" name="no" value="詳細画面に戻る">
        </form>
        
        <% }else{ %>
        <h1>入力が不完全です</h1>
        <%=ch.chkinput(chkList) %>
        <form action="Update" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
        <% } %>
        <%=ch.contact()%> <%=ch.home()%>
        </div>
    </body>
</html>
