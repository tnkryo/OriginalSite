package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import center.CenterHelper;

public final class insert_jsp extends org.apache.jasper.runtime.HttpJspBase
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
  
    CenterHelper ch = CenterHelper.getInstance();

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>店舗情報登録</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div align=\"center\">\n");
      out.write("            <form action=\"Search\" method=\"GET\">\n");
      out.write("            ※は必須項目です。<br><br>\n");
      out.write("            ※店舗名<br>\n");
      out.write("            <input type=\"text\" name=\"name\"/><br><br>\n");
      out.write("            ※住所<br>\n");
      out.write("            <input type=\"text\" name=\"jusyo\"/><br><br>\n");
      out.write("            電話番号<br>\n");
      out.write("            <input type=\"text\" name=\"tell\"/><br><br>\n");
      out.write("            営業時間<br>\n");
      out.write("            <input type=\"text\" name=\"time\"/><br><br>\n");
      out.write("            公式サイト<br>\n");
      out.write("            <input type=\"text\" name=\"site\"/><br><br>\n");
      out.write("            公式ブログ<br>\n");
      out.write("            <input type=\"text\" name=\"blog\"/><br><br>\n");
      out.write("            Twitter ID<br>\n");
      out.write("            <input type=\"text\" name=\"twitter\"/><br><br>\n");
      out.write("            稼働筐体<br>\n");
      out.write("            <textarea name=\"kyoutai\" rows=10 cols=50 style=\"resize:none\" wrap=\"hard\"></textarea><br><br>\n");
      out.write("            備考<br>\n");
      out.write("            <textarea name=\"comment\" rows=10 cols=50 style=\"resize:none\" wrap=\"hard\"></textarea><br><br>\n");
      out.write("            <input type=\"submit\" value=\"登録\"/>\n");
      out.write("            </form>\n");
      out.write("            ");
      out.print(ch.home());
      out.write("\n");
      out.write("        </div>\n");
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
