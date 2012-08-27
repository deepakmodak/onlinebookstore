import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class delivery extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String add=request.getParameter("address");
        int tran=0;
        Random randomGenerator = new Random();
        tran = randomGenerator.nextInt();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Thank</title>");
        out.println("</head>");
        out.println("<body bgcolor='#9966ff'>");
        out.println("<center>");
        out.println("<form name='f4' action='logoutservlet' method='POST'>");
        out.println("<img src='images/t1.png' width='430' height='170' alt='logo'/>");
        out.println("<br><hr>");
        out.println("<h1>Thanks for the Purchase</h1><br>");
        out.println("<h3>Your transaction id :"+tran);
        out.println("<br>Your books will be delivered to:");
        out.println("<br>"+add+"<br>");
        out.println("within 5 working days after checking your payment</h3");
        out.println("<br><br><input type='submit' value='logout'/>");
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
