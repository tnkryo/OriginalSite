package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import center.CenterDTO;
import center.CenterHelper;
import java.util.*;
import javax.servlet.http.HttpSession;

public final class map2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
  
    HttpSession hs = request.getSession();
    ArrayList<CenterDTO> al = (ArrayList<CenterDTO>)request.getAttribute("all");
    CenterHelper ch = CenterHelper.getInstance();

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <style>\n");
      out.write("          html, body {\n");
      out.write("            height: 100%;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("          }\n");
      out.write("          #map {\n");
      out.write("            height: 100%;\n");
      out.write("          }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"map\" style=\"width: 1000px; height: 550px;\"></div>\n");
      out.write("        <script>\n");
      out.write("        //マウスオーバーで情報ウィンドウを表示させる\n");
      out.write("        function map_canvas() {\n");
      out.write("        //マーカーの情報\n");
      out.write("        var data = new Array();\n");
      out.write("        data.push({\n");
      out.write("            lat: '35.681382', //緯度\n");
      out.write("            lng: '139.7660843', //経度\n");
      out.write("            content: '東京駅<br />迷子にならないように！' //情報ウィンドウの内容\n");
      out.write("        });\n");
      out.write("        data.push({\n");
      out.write("            lat: '35.678187',\n");
      out.write("            lng: '139.76817',\n");
      out.write("            content: '<p style=\"color:#d50000\">八重洲ブックセンター</p>'\n");
      out.write("        });\n");
      out.write("        //初期位置に、上記配列の最初の緯度経度を格納\n");
      out.write("        var latlng = new google.maps.LatLng(data[0].lat, data[0].lng);\n");
      out.write("        var opts = {\n");
      out.write("            zoom: 15,\n");
      out.write("            center: latlng,\n");
      out.write("            mapTypeId: google.maps.MapTypeId.ROADMAP\n");
      out.write("        };\n");
      out.write("        var map = new google.maps.Map(document.getElementById(\"map\"), opts);\n");
      out.write("\n");
      out.write("        var markers = new Array();\n");
      out.write("        //マーカーを配置するループ\n");
      out.write("        for (i = 0; i < data.length; i++) {\n");
      out.write("            markers[i] = new google.maps.Marker({\n");
      out.write("                position: new google.maps.LatLng(data[i].lat, data[i].lng),\n");
      out.write("                map: map\n");
      out.write("            });\n");
      out.write("            markerInfo(markers[i], data[i].content);\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    function markerInfo(marker, name) {\n");
      out.write("        google.maps.event.addListener(marker, 'mouseover', function (event) {\n");
      out.write("            new google.maps.InfoWindow({\n");
      out.write("                content: name\n");
      out.write("            }).open(marker.getMap(), marker);\n");
      out.write("        });\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    //地図描画を実行\n");
      out.write("    google.maps.event.addDomListener(window, 'load', map_canvas);\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("        <script src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyDTLDc2YDJMQ-7-W33mq8uwkT4Jrs-QXE0&callback=map_canvas\"\n");
      out.write("            async defer></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
