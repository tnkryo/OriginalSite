<%@page import="center.CenterBeans"%>
<%@page import="center.CenterHelper"%>
<%  
    CenterHelper ch = CenterHelper.getInstance();
    HttpSession hs = request.getSession();
    CenterBeans cb = null;
    boolean reinput = false;
    if(request.getParameter("mode") != null && request.getParameter("mode").equals("REINPUT")){
        reinput = true;
        cb = (CenterBeans)hs.getAttribute("con");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>お問い合わせ</title>
    </head>
    <body>
        <div align="center">
            <h1>お問い合わせ</h1><br>
        <form action="ContactConfirm" method="POST">
        名前：
        <input type="text" name="name" value="<% if(reinput){out.print(cb.getName());}%>"><br><br>
        内容<br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><% if(reinput){out.print(cb.getComment());}%></textarea><br>
        <input type="submit" value="確認"/>
        </form>
        <%=ch.home()%>
        </div>
    </body>
</html>
