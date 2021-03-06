/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package center;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kobayashi
 */
public class UpdateResult extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        try {
            
            boolean type = false;

            //リクエストパラメータの文字コードをUTF-8に変更
            request.setCharacterEncoding("UTF-8");

            //フォームからの入力を取得して、JavaBeansに格納
            CenterBeans cb = (CenterBeans)session.getAttribute("syousai");
            cb.setName(request.getParameter("name"));
            cb.setJusyo(request.getParameter("jusyo"));
            cb.setTell(request.getParameter("tell"));
            cb.setTime(request.getParameter("time"));
            cb.setSite(request.getParameter("site"));
            cb.setBlog(request.getParameter("blog"));
            cb.setTwitter(request.getParameter("twitter"));
            cb.setKyoutai(request.getParameter("kyoutai"));
            cb.setComment(request.getParameter("comment"));

            ArrayList<String> chkList = cb.chkproperties();

            if(chkList.size()==0){
                type = true;
                //DTOオブジェクトにマッピング。DB専用のパラメータに変換
                CenterDTO update = new CenterDTO();
                cb.UD2DTOMapping(update);
                
                //DBへデータの挿入
                CenterDAO .getInstance().update(update);
                
                request.setAttribute("upd", cb);
            }
            
            
            request.setAttribute("type", type);

            request.getRequestDispatcher("/updateresult.jsp").forward(request, response);
        } catch (Exception ex) {
                Logger.getLogger(UpdateResult.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
