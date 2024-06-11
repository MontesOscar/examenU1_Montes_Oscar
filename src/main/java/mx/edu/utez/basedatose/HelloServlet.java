package mx.edu.utez.basedatose;

import java.io.*;
import java.sql.SQLException;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import mx.edu.utez.basedatose.utils.DatabaseConnectionManager;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

      try{
          DatabaseConnectionManager.getConnection();
      }catch (SQLException e){
          throw new RuntimeException(e);
      }
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}