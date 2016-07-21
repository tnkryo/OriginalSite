package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import center.CenterHelper;
import java.util.*;
import javax.servlet.http.HttpSession;

public final class map_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write('\n');
  
    HttpSession hs = request.getSession();
    HashMap<String,Integer> latlngMap = (HashMap<String,Integer>)hs.getAttribute("latlngMap");
    CenterHelper ch = CenterHelper.getInstance();

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Map</title>\n");
      out.write("         <meta name=\"viewport\" content=\"initial-scale=1.0\">\n");
      out.write("        <meta charset=\"utf-8\">\n");
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
      out.write("        </head>\n");
      out.write("        <body>\n");
      out.write("            <div align=\"center\">\n");
      out.write("            <form action=\"Search\" method=\"GET\">\n");
      out.write("            店舗名で検索：\n");
      out.write("            <input type=\"text\" name=\"kensaku\"/>\n");
      out.write("            <input type=\"submit\" value=\"検索\"/>\n");
      out.write("            </form>\n");
      out.write("            <div id=\"map\" style=\"width: 1000px; height: 550px;\"></div>\n");
      out.write("        <script>\n");
      out.write("        var marker;\n");
      out.write("        var map;\n");
      out.write("        function initMap() {\n");
      out.write("          map = new google.maps.Map(document.getElementById('map'), {\n");
      out.write("            center: {lat: 35.698545, lng: 139.772975},\n");
      out.write("            zoom: 12\n");
      out.write("          });\n");
      out.write("          \n");
      out.write("           // マーカーのインスタンスを作成する\n");
      out.write("       marker = new google.maps.Marker({ // マーカーの追加\n");
      out.write("        position: {lat: 35.698545, lng: 139.772975}, // マーカーを立てる位置を指定\n");
      out.write("        map: map // マーカーを立てる地図を指定\n");
      out.write("        });\n");
      out.write("        \n");
      out.write("        google.maps.event.addListener( marker , 'click' , function(){\n");
      out.write("                    var infoWindows = new google.maps.InfoWindow({content:'テスト'});\n");
      out.write("                    infoWindows.open(map,marker);\n");
      out.write("                });\n");
      out.write("        \n");
      out.write("        }\n");
      out.write("        </script>\n");
      out.write("        <script src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyDTLDc2YDJMQ-7-W33mq8uwkT4Jrs-QXE0&callback=initMap\"\n");
      out.write("            async defer></script>\n");
      out.write("            ");
      out.print(ch.home());
      out.write("\n");
      out.write("            </div>\n");
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
