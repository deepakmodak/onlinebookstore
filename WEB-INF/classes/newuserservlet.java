import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class newuserservlet extends HttpServlet {
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String uname=request.getParameter("newusername");
        String pass=request.getParameter("newpassword");
        String repass=request.getParameter("renewpassword");
        String realname=request.getParameter("realname");
        String sex=request.getParameter("sex");
        String email=request.getParameter("email");
        
        ServletContext ctx=getServletContext();
        String l1=ctx.getInitParameter("l1");
        String l2=ctx.getInitParameter("l2");

     try{
         Class.forName(l1);
         Connection con= DriverManager.getConnection(l2);
         Statement st =con.createStatement();
         ResultSet res=st.executeQuery("select username from users");

         int check=0;
         while(res.next()){
            if(uname.equals(res.getString(1))){
                check++;
           }
        }
        con.close();

            out.println("<html>");
            out.println("<head>");
            out.println("<title>registration</title>");
            out.println("</head>");
            out.println("<body bgcolor='#993377'>");
            out.println("<center>");
            out.println("<img src='images/t1.png' width='430' height='170' alt='logo'/>");
            out.println("<br><hr><h3>");

            if(uname.isEmpty() || pass.isEmpty() || repass.isEmpty()){
                out.println("please,fill up all compulsory *marked fields");
                out.println("<br><br><h2><a href='newuser.html'>Back</a></h2>");
            }
            else if(check>0){
                out.println("username already taken");
                out.println("<br><br><h2><a href='newuser.html'>Back</a></h2>");
            }
            else if(!pass.equals(repass)){
                out.println("Both password does not match");
                out.println("<br><br><h2><a href='newuser.html'>Back</a></h2>");
            }
            else{

                try{
                    Class.forName(l1);
                    Connection con1= DriverManager.getConnection(l2);
                    Statement st1 =con1.createStatement();
                    st1.executeUpdate("insert into users values ('"+uname+"','"+pass+
                            "','"+realname+"','"+sex+"','"+email+"')");
                    con1.close();
                    }catch(Exception e){}
                out.println("<h2>"+realname+" has been successfully registered");
                out.println("<br><br><h2><a href='index.html'>Home</a></h2>");
            }
            
     }catch(Exception e){}


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
