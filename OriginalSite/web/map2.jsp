<%@page import="center.CenterDTO"%>
<%@page import="center.CenterHelper"%>
<%@page import="java.util.*"
        import="javax.servlet.http.HttpSession"%>
<%  
    HttpSession hs = request.getSession();
    ArrayList<CenterDTO> al = (ArrayList<CenterDTO>)request.getAttribute("all");
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
        <div id="map" style="width: 1000px; height: 550px;"></div>
        <script>
        //マウスオーバーで情報ウィンドウを表示させる
function map_canvas() {
    //マーカーの情報
    var data = new Array();
    <% for(int i=0;i<al.size();i++){%>
    data.push({
        lat: '<%=al.get(i).getLat()%>', //緯度
        lng: '<%=al.get(i).getLng()%>', //経度
        content: '<a href="Detail?id=<%=al.get(i).getTenpoID()%>"><%=al.get(i).getName()%><br><%=al.get(i).getJusyo()%>></a>' //情報ウィンドウの内容
    });
    <% } %>
    //初期位置に、上記配列の最初の緯度経度を格納
    var latlng = new google.maps.LatLng(35.698545, 139.772975);
    var opts = {
        zoom: 15,
        center: latlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    var map = new google.maps.Map(document.getElementById("map"), opts);
 
    var markers = new Array();
    //マーカーを配置するループ
    for (i = 0; i < data.length; i++) {
        markers[i] = new google.maps.Marker({
            position: new google.maps.LatLng(data[i].lat, data[i].lng),
            map: map
        });
        markerInfo(markers[i], data[i].content);
    }
}
 
function markerInfo(marker, name) {
    google.maps.event.addListener(marker, 'mouseover', function (event) {
        new google.maps.InfoWindow({
            content: name
        }).open(marker.getMap(), marker);
    });
}
 
//地図描画を実行
google.maps.event.addDomListener(window, 'load', map_canvas);

        </script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDTLDc2YDJMQ-7-W33mq8uwkT4Jrs-QXE0&callback=map_canvas"
            async defer></script>
    </body>
</html>
