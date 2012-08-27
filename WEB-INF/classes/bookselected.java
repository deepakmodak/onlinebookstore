
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class bookselected extends HttpServlet {
   
    
 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ServletContext ctx=getServletContext();
        String q1="";
        String user=(String)ctx.getAttribute("currentuser");

        ctx.setAttribute("fewselected", "yes");
        String l1=ctx.getInitParameter("l1");
        String l2=ctx.getInitParameter("l2");
        
        PrintWriter out = response.getWriter();
        String book_select[] = request.getParameterValues("book");

        HttpSession ses=request.getSession();
        ses.setAttribute("book_select",book_select);



  try {
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Book Selected</title>");
        out.println("</head>");
        out.println("<body bgcolor='#9966ff'");
        out.println("<center>");
      //  out.println("<form name='f3' action='payment.html' method='POST'>");
        out.println("<img src='images/t1.png' width='430' height='170' alt='logo'/>");
        out.println("<br><hr>");
       
      //out.println(l1);
     if(user ==null){
    
            out.println("<h1>Sorry ,to buy books you are required to be logged in</h1>");
            out.println("<br><a href='login.html'>Login</a>");
     }
     else{
          RequestDispatcher r=request.getRequestDispatcher("bookchoosen");
          r.forward(request,response);

      }
         out.println("</center>");
            out.println("</body>");
            out.println("</html>");

      
  } catch(Exception e){
                   e.printStackTrace();
    }

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
