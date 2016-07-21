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
            店舗名:<br><%= cb.getName()%><br><br>
            住所:<br><%= cb.getJusyo()%><br><br>
            電話番号:<br><%= cb.getTell()%><br><br>
            営業時間:<br><%= cb.getTime()%><br><br>
            公式サイト:<br><%= cb.getSite()%><br><br>
            公式ブログ:<br><%= cb.getBlog()%><br><br>
            Twitter ID:<br><%= cb.getTwitter()%><br><br>
            筐体:<br><%= cb.getKyoutai().replaceAll("\n","<BR>")%><br><br>
            備考:<br><%= cb.getComment().replaceAll("\n","<BR>")%><br><br>
            <a href="Update">店舗情報を編集</a><br><br>

            <%=ch.contact()%> <%=ch.home()%>
    </body>
</html>
