package Zhouzikai.week5.demo;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    private DataSource dataSource;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        try {
            ServletContext servletContext = config.getServletContext();
            Context initCtx = new InitialContext();
            dataSource = (DataSource) initCtx.lookup("java:comp/env/jdbc/UserDatabase");
        } catch (NamingException e) {
            throw new ServletException("Failed to lookup DataSource", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try (Connection conn = getDatabaseConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM usertable WHERE username = ? AND password = ?")) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            String loginMessage = "";
            if (rs.next()) {
                String loggedInUser = rs.getString("username");
                String userEmail = rs.getString("email");
                String userGender = rs.getString("gender");
                Date userBirthdate = rs.getDate("birthdate");

                // 设置session属性
                request.getSession().setAttribute("loggedInUser", loggedInUser);
                request.getSession().setAttribute("userEmail", userEmail);
                request.getSession().setAttribute("userGender", userGender);
                request.getSession().setAttribute("userBirthdate", userBirthdate.toString());

                loginMessage = "Login Success!!! Welcome " + loggedInUser;
                System.out.println("[Servlet]: Login Successful for user: " + loggedInUser);

                // 登录成功后重定向到 userInfo.jsp 页面
                response.sendRedirect(request.getContextPath() + "/userInfo.jsp");

            } else {
                loginMessage = "Username or Password Error!!!";
                System.out.println("[Servlet]: Incorrect credentials entered");

                // 将登录失败的消息放入request属性以便在login.jsp中显示
                request.setAttribute("loginMessage", loginMessage);

                // 转发回login.jsp页面
                RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp");
                dispatcher.forward(request, response);
            }

        } catch (SQLException ex) {
            throw new ServletException("Error executing SQL query to authenticate user", ex);
        }
    }

    // 实现从数据源获取数据库连接的方法
    private Connection getDatabaseConnection() throws SQLException {
        if (dataSource == null) {
            throw new IllegalStateException("DataSource has not been initialized.");
        }
        return dataSource.getConnection();
    }
}