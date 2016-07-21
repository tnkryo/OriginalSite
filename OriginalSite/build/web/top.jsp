<%@page import="center.CenterHelper"%>
<%
    CenterHelper ch = CenterHelper.getInstance();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div align="center">
            <h1>ゲームセンターマップ</h1><br>
        <form action="Search" method="GET">
        店舗名で検索：
        <input type="text" name="kensaku"/>
        <input type="submit" value="検索"/>
        </form>
            <a href="Insert">店舗登録</a><br>
        <a href="Map">MAPを表示する</a><br>
        <%=ch.contact()%>
        </div>
    </body>
</html>
