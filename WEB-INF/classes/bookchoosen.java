import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

public class bookchoosen extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ServletContext ctx=getServletContext();
        String q1="";
        String l1=ctx.getInitParameter("l1");
        String l2=ctx.getInitParameter("l2");

        HttpSession ses=request.getSession();
        String book_select[]=(String [])ses.getAttribute("book_select");
  try{
      out.println("<html>");
        out.println("<head>");
        out.println("<title>Book Selected</title>");
        out.println("</head>");
        out.println("<body bgcolor='#9966ff'");
        out.println("<center>");
        out.println("<form name='f3' action='payment.html' method='POST'>");
        out.println("<img src='images/t1.png' width='430' height='170' alt='logo'/>");
        out.println("<br><hr>");
        Class.forName(l1);
        Connection con= DriverManager.getConnection(l2);
         Statement st = con.createStatement();

        switch((book_select[0]).charAt(0))
         {
                case 'N' :
                            q1="select * from nov";
                            break;
               case 'S' :
                            q1="select * from sc";
                            break;
              case 'C' :
                            q1="select * from comp";
                            break;
          }


        int sum=0;
            out.println("<h1>Your Selection are :</h1>");
            out.println("<table width='800' border='1'>");
            out.println("<tr>");

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
            out.println("</tr>");

        for(int i=0;i<book_select.length;i++)
        {
            String q2=q1+" where id ='"+book_select[i]+"'";
        //     out.println(q2);
            ResultSet result=st.executeQuery(q2);

            while(result.next())
            {
                    out.println("<tr>");
                    out.println("<td>");
                    out.println(result.getString(1));
                    out.println("</td>");

                    out.println("<td>");
                    out.println(result.getString(2));
                    out.println("</td>");

                    out.println("<td>");
                    out.println(result.getString(3));
                    out.println("</td>");

                    int cost=Integer.parseInt(result.getString(4));
                    out.println("<td>");
                    out.println(cost);
                    out.println("</td>");
                    out.println("</tr>");
                    sum=sum+cost;
              }
        }
        out.println("</table>");
        out.println("<br><br><h2>Total cost :Rs. "+sum+"</h2>");
        out.println("<br><br><br><input type='submit' value='Proceed' name='su'>");
        out.println("</center>");
            out.println("</body>");
            out.println("</html>");

  } catch(Exception e){

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
