<%@page import="center.CenterBeans"%>
<%@page import="center.CenterHelper"%>
<%
    CenterHelper ch = CenterHelper.getInstance();
    CenterBeans cb = (CenterBeans)session.getAttribute("syousai");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>店舗詳細</title>
    </head>
    <body>
        <h1><%= cb.getName()%></h1><br><br>
        <table border=1>
            <tr>
                <td>店舗名</td>
                <td><%= cb.getName()%></td>
            </tr>
            <tr>
                <td>住所</td>
                <td><%= cb.getJusyo()%></td>
            </tr>
            <tr>
                <td>電話番号</td>
                <td><%= cb.getTell()%></td>
            </tr>
            <tr>
                <td>営業時間</td>
                <td><%= cb.getTime()%></td>
            </tr>
            <tr>
                <td>公式サイト</td>
                <td><%= cb.getSite()%></td>
            </tr>
            <tr>
                <td>公式ブログ</td>
                <td><%= cb.getBlog()%></td>
            </tr>
            <tr>
                <td>Twitter ID</td>
                <td><%= cb.getTwitter()%></td>
            </tr>
            <tr>
                <td>稼働筐体</td>
                <td><%= cb.getKyoutai().replaceAll("\n","<BR>")%></td>
            </tr>
            <tr>
                <td>備考</td>
                <td><%= cb.getComment().replaceAll("\n","<BR>")%></td>
            </tr>
            </table>
            <a href="Update">店舗情報を編集</a><br><br>

            <%=ch.contact()%> <%=ch.home()%>
    </body>
</html>
