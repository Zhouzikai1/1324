package Zhouzikai.week3.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(
        urlPatterns = {"/register"},
        initParams = {
                @WebInitParam(name="driver", value="com.microsoft.sqlserver.jdbc.SQLServerDriver"),
                @WebInitParam(name="url", value="jdbc:sqlserver://localhost;databaseName=userdb"),
                @WebInitParam(name="username", value="sa"),
                @WebInitParam(name="password", value="123456"),

        }
)
public class RegisterServlet extends HttpServlet { @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String Username =request.getParameter( "username");
        String password =request.getParameter( "password");
        String email =request.getParameter( "email");
        String gender =request.getParameter( "gender");
        String birthdate =request.getParameter( "birthdate");

        //print - write into response
        PrintWriter writer = response.getWriter();
        writer.println("<br>username "+Username);
        writer.println("<br>password "+password);
        writer.println("<br>email "+email);
        writer.println("<br>gender "+gender);
        writer.println("<br>birthdate "+birthdate);
        writer.close();



    }

}
