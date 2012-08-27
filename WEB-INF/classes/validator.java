import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.ServletContext;


public class validator extends HttpServlet {
    private String uname;
    private String pass;
    
    protected void welcomeAdmin(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
       ServletContext ctx=getServletContext();
       ctx.setAttribute("currentuser",uname);
       String selectioncheck=(String)ctx.getAttribute("fewselected");
      /* try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Welcome,Admin</title>");
            out.println("</head>");
            out.println("<body bgcolor='#993377'>");
            out.println("<center>");
            out.println("<img src='images/t1.png' width='430' height='170' alt='logo'/>");
            out.println("<br><hr>");
            out.println("<h3>Welcome Admin</h3>");
            
            out.println("<h3><br><a href='customerdetails.jsp' >Customer Details </a></h3>");
            out.println("<h3><br><a href='' >Book Details </a></h3>");

            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }*/
         response.sendRedirect("/onlinebookstore/list.html");
    }

    protected void welcomePage(HttpServletRequest request,HttpServletResponse response,String uname)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
       ServletContext ctx=getServletContext();
       ctx.setAttribute("currentuser",uname);
       String selectioncheck=(String)ctx.getAttribute("fewselected");
       try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Welcome</title>");
            out.println("</head>");
            out.println("<body bgcolor='#993377'>");
            out.println("<center>");
            out.println("<img src='images/t1.png' width='430' height='170' alt='logo'/>");
            out.println("<br><hr>");
            out.println("<img src='images/login.jpg'>");
            out.println("<h2>You can now make purchase</h2>");

            if(selectioncheck =="yes"){
                out.println("<a href='bookchoosen'>Proceed</a>");
            }
            else{
                out.println("<a href='shopping.html'>Proceed</a>");
            }

            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
     protected void deniedPage(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Access Denied</title>");
            out.println("</head>");
            out.println("<body bgcolor='#993377'>");
            out.println("<center>");
            out.println("<img src='images/t1.png' width='430' height='170' alt='logo'/>");
            out.println("<br><hr>");
            out.println("<img src='images/loginfailed.jpg'>");
            out.println("<h2>Wrong Username or Password ! You can't make purchase</h2>");
            out.println("<a href='login.html'>Back to login</a>");
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");

        } finally {
            out.close();
        }
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response){
        uname=request.getParameter("u");
        pass=request.getParameter("p");

        ServletContext ctx=getServletContext();
        String l1=ctx.getInitParameter("l1");
        String l2=ctx.getInitParameter("l2");


       try {
         Class.forName(l1);
         Connection con= DriverManager.getConnection(l2);
         Statement st =con.createStatement();
         ResultSet res=st.executeQuery("select username,password from users");

         int check=0;
         while(res.next()){
            if(uname.equals(res.getString(1)) && pass.equals(res.getString(2))){
                check++;
                if(uname.equals("admin")){
                    welcomeAdmin(request,response);
                }
                else
                    welcomePage(request,response,uname);
             }
         }
         if(check==0)
            deniedPage(request,response);
       }
        catch(Exception e)
        { }
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
