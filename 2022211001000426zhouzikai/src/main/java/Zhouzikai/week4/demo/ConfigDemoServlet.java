package Zhouzikai.week4.demo;
import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(
        urlPatterns = {"/config"},
        initParams = {
                @WebInitParam(name="name1",value="Zhou zi kai"),
                @WebInitParam(name="studentID1",value="2022211001000426"),
        }, loadOnStartup = 1

)

public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletConfig config=getServletConfig();
        String name=config.getInitParameter("name");//<param-name>name</param-name>
        String studentID=config.getInitParameter("studentID");//<param-name>studentID</param-name>
        String name1=config.getInitParameter("name1");
        String studentID1=config.getInitParameter("studentID1");

        PrintWriter writer= response.getWriter();
        writer.println("Task 1-Get init parameters from web.xml\n");
        writer.println("\nname:"+name);
        writer.println("\nstudentID:"+studentID);

        writer.println("\nTask 2-Get init parameters from @WebInitParam\n");
        writer.println("\nname1:"+name1);
        writer.println("\nstudentID1:"+studentID1);

        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}