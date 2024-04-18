package Zhouzikai.week6;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 获取搜索词
        String searchTerm = request.getParameter("txt"); // 修改参数名以匹配表单中的<input>元素

        // 检查搜索词是否为空
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            // 如果搜索词为空，则重定向回主页（例如：index.jsp）
            response.sendRedirect("index.jsp");
            return;
        }

        // 获取用户选择的搜索引擎
        String selectedEngine = request.getParameter("search");

        // 根据用户选择的搜索引擎进行跳转
        if ("baidu".equals(selectedEngine)) {
            response.sendRedirect("https://www.baidu.com/s?wd=" + searchTerm);
        } else if ("bing".equals(selectedEngine)) {
            response.sendRedirect("https://cn.bing.com/search?q=" + searchTerm);
        } else if ("google".equals(selectedEngine)) {
            response.sendRedirect("https://www.google.com/search?q=" + searchTerm);
        } else {
            // 如果没有匹配到任何搜索引擎，则输出错误提示或者默认行为
            response.getWriter().println("<h1>Error: Invalid search engine selection.</h1>");
        }
    }

    // 如果需要处理POST请求，保持不变
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}