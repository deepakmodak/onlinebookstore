import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class categoryselect extends HttpServlet {
   
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ServletContext ctx=getServletContext();

        String l1=ctx.getInitParameter("l1");
        String l2=ctx.getInitParameter("l2");
        PrintWriter out = response.getWriter();
        String cat_select = request.getParameter("cat");

  try {
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Book Selection</title>");
        out.println("</head>");
        out.println("<body bgcolor='#3366FF'>");
        out.println("<center>");
        out.println("<form name='f3' action='bookselected' method='POST'>");
        out.println("<img src='images/t1.png' width='430' height='170' alt='logo'/>");
        out.println("<br><hr>");
       
        Class.forName(l1);
        Connection con= DriverManager.getConnection(l2);
        Statement st = con.createStatement();

        if(cat_select.equals("nov"))
        {
            out.println("<h2>Books under category NOVEL</h2>");
            ResultSet result=st.executeQuery("select * from nov");
            out.println("<table width='800' border='1'>");
            out.println("<tr>");

            out.println("<td>");
            out.println("");
            out.println("</td>");
            out.println("<td>");
            out.println("ID");
            out.println("</td>");

            out.println("<td>");
            out.println("BOOK NAME");
            out.println("</td>");

            out.println("<td>");
            out.println("AUTHOR");
            out.println("</td>");

            out.println("<td>");
            out.println("PRICE");
            out.println("</td>");
            out.println("<h2>");
           while(result.next())
           {
           
               String rem=result.getString(1);
               out.println("<tr>");
               out.println("<td>");
               out.println("<input type='checkbox' name='book' value="+rem+">");
               out.println("</td>");
               out.println("<td>");
               out.println(rem);
               out.println("</td>");
               out.println("<td>");
               out.println(result.getString(2));
               out.println("</td>");
               out.println("<td>");
               out.println(result.getString(3));
               out.println("</td>");
               out.println("<td>");
               out.println("Rs. "+result.getString(4));
               out.println("</td>");
               out.println("</tr>");
               
           }
            out.println("</h2>");
            out.println("</table>");
       }
        else if(cat_select.equals("sc"))
        {
            out.println("<h2>Books under category SCIENCE</h2>");
            ResultSet result=st.executeQuery("select * from sc");
            out.println("<table width='800' border='1'>");
            out.println("<tr>");

            out.println("<td>");
            out.println("");
            out.println("</td>");
            out.println("<td>");
            out.println("ID");
            out.println("</td>");

            out.println("<td>");
            out.println("BOOK NAME");
            out.println("</td>");

            out.println("<td>");
            out.println("AUTHOR");
            out.println("</td>");

            out.println("<td>");
            out.println("PRICE");
            out.println("</td>");
            out.println("<h2>");
           while(result.next())
           {

               String rem=result.getString(1);
               out.println("<tr>");
               out.println("<td>");
               out.println("<input type='checkbox' name='book' value="+rem+">");
               out.println("</td>");
               out.println("<td>");
               out.println(rem);
               out.println("</td>");
               out.println("<td>");
               out.println(result.getString(2));
               out.println("</td>");
               out.println("<td>");
               out.println(result.getString(3));
               out.println("</td>");
               out.println("<td>");
               out.println("Rs. "+result.getString(4));
               out.println("</td>");
               out.println("</tr>");

           }
            out.println("</h2>");
            out.println("</table>");
       }
        else if(cat_select.equals("com"))
        {
            out.println("<h2>Books under category COMPUTER</h2>");
            ResultSet result=st.executeQuery("select * from comp");
            out.println("<table width='800' border='1'>");
            out.println("<tr>");

            out.println("<td>");
            out.println("");
            out.println("</td>");
            out.println("<td>");
            out.println("ID");
            out.println("</td>");

            out.println("<td>");
            out.println("BOOK NAME");
            out.println("</td>");

            out.println("<td>");
            out.println("AUTHOR");
            out.println("</td>");

            out.println("<td>");
            out.println("PRICE");
            out.println("</td>");
            out.println("<h2>");
           while(result.next())
           {

               String rem=result.getString(1);
               out.println("<tr>");
               out.println("<td>");
               out.println("<input type='checkbox' name='book' value="+rem+">");
               out.println("</td>");
               out.println("<td>");
               out.println(rem);
               out.println("</td>");
               out.println("<td>");
               out.println(result.getString(2));
               out.println("</td>");
               out.println("<td>");
               out.println(result.getString(3));
               out.println("</td>");
               out.println("<td>");
               out.println("Rs. "+result.getString(4));
               out.println("</td>");
               out.println("</tr>");

           }
            out.println("</h2>");
            out.println("</table>");
       }

        out.println("<br><br>");
        out.println("<input type='submit' name='s1' value='Buy' >");
        out.println("</form>");
        out.println("</center>");
        out.println("</body>");
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
