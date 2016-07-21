<%@page import="center.CenterBeans"%>
<%@page import="center.CenterDTO"%>
<%@page import="center.CenterHelper"%>
<%
    CenterHelper ch = CenterHelper.getInstance();
    HttpSession hs = request.getSession();
    CenterBeans cb = (CenterBeans)hs.getAttribute("syousai");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>店舗情報の編集</title>
    </head>
    <body>
        <form action="UpdateResult" method="POST">
            ※は必須項目です。<br><br>
            ※名前:
            <input type="text" name="name" value="<%=cb.getName()%>">
            <br><br>

            ※住所:
            <input type="text" name="jusyo" value="<%=cb.getJusyo()%>">
            <br><br>

            電話番号:
            <input type="text" name="tell" value="<%=cb.getTell()%>">
            <br><br>

            営業時間:
            <input type="text" name="time" value="<%=cb.getTime()%>">
            <br><br>

            公式サイト:
            <input type="text" name="site" value="<%=cb.getSite()%>">
            <br><br>

            公式ブログ:
            <input type="text" name="blog" value="<%=cb.getBlog()%>">
            <br><br>

            Twitter ID:
            <input type="text" name="twitter" value="<%=cb.getTwitter()%>">
            <br><br>

            筐体:
            <br>
            <textarea name="kyoutai" rows=10 cols=50 style="resize:none" wrap="hard"><%=cb.getKyoutai()%></textarea><br><br>

            備考:
            <br>
            <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%=cb.getComment()%></textarea><br><br>
        
        <input type="submit" name="btnSubmit" value="更新画面へ">
    </form>
        <form action="Detail" method="GET">
            <input type="hidden" name="id"  value="<%= cb.getTenpoID()%>">
      <input type="submit" name="NO" value="詳細画面に戻る" style="width:100px"><!--ミスの修正-->
    </form>
        <br>
        <%=ch.contact()%> <%=ch.home()%>
    </body>
</html>
