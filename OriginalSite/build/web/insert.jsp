<%@page import="center.CenterBeans"%>
<%@page import="center.CenterHelper"%>
<%  
    CenterHelper ch = CenterHelper.getInstance();
    HttpSession hs = request.getSession();
    CenterBeans cb = null;
    boolean reinput = false;
    if(request.getParameter("mode") != null && request.getParameter("mode").equals("REINPUT")){
        reinput = true;
        cb = (CenterBeans)hs.getAttribute("cb");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>店舗情報登録</title>
    </head>
    <body>
        <div align="center">
            <form action="InsertConfirm" method="POST">
            ※は必須項目です。<br><br>
            ※店舗名<br>
            <input type="text" name="name" value="<% if(reinput){out.print(cb.getName());}%>"><br><br>
            ※住所<br>
            <input type="text" name="jusyo" value="<% if(reinput){out.print(cb.getJusyo());}%>"><br><br>
            電話番号<br>
            <input type="text" name="tell" value="<% if(reinput){out.print(cb.getTell());}%>"><br><br>
            営業時間<br>
            <input type="text" name="time" value="<% if(reinput){out.print(cb.getTime());}%>"><br><br>
            公式サイト<br>
            <input type="text" name="site" value="<% if(reinput){out.print(cb.getSite());}%>"><br><br>
            公式ブログ<br>
            <input type="text" name="blog" value="<% if(reinput){out.print(cb.getBlog());}%>"><br><br>
            Twitter ID<br>
            <input type="text" name="twitter" value="<% if(reinput){out.print(cb.getTwitter());}%>"><br><br>
            稼働筐体<br>
            <textarea name="kyoutai" rows=10 cols=50 style="resize:none" wrap="hard"><% if(reinput){out.print(cb.getKyoutai());}%></textarea><br><br>
            備考<br>
            <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><% if(reinput){out.print(cb.getComment());}%></textarea><br><br>
            <input type="submit" value="登録"/>
            </form>
            <%=ch.contact()%> <%=ch.home()%>
        </div>
    </body>
</html>
