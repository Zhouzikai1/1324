package Zhouzikai.week2.demo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWordServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PrintWriter Writer = response.getWriter();
        Writer.println("Name:Zhou zi kai \nID:2022211001000426\nDate and Time Wed Mar 13 20:21:52 CST 2024"
        );
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
