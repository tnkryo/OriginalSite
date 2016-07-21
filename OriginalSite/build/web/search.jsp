<%@page import="java.util.ArrayList"%>
<%@page import="center.CenterDTO"%>
<%@page import="center.CenterHelper"%>
<%
    CenterHelper ch = CenterHelper.getInstance();
    ArrayList<CenterDTO> udd = (ArrayList<CenterDTO>)request.getAttribute("searchData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>店舗名検索</title>
    </head>
    <body>
        <h1>検索結果</h1>
        <%if(udd.size() == 0){
            out.print("一致する情報は見つかりませんでした。<br><br>");
        }%>
        <!--該当データをすべて呼び出せるよう修正-->
        <%for(int i = 0;i<udd.size();i++){%>
        <table border=1>
            <tr>
                <th>店舗名</th>
                <th>住所</th>
                <th>登録日時</th>
            </tr>
            <tr>
                <td><a href="Detail?id=<%= udd.get(i).getTenpoID()%>"><%= udd.get(i).getName()%></a></td>
                <td><%= udd.get(i).getJusyo()%></td>
                <td><%= udd.get(i).getNewDate()%></td>
            </tr>
        </table>
            <%}%>
    </body>
    <%=ch.contact()%> <%=ch.home()%>
</html>
