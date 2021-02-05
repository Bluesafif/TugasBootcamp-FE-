package com.bootcamp.controller;

import com.bootcamp.model.Model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

//@WebServlet(
//        name = "selectliquorservlet",
//        urlPatterns = "/SelectLiquor"
//)
@WebServlet("/auth")
public class Auth extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set the response message's MIME type
        response.setContentType("text/html;charset=UTF-8");
        // Allocate a output writer to write the response message into the network socket
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Model model = new Model();
        String query = "username='"+username+"' and password='"+password+"'";
        ResultSet res = null;
        PrintWriter pr = response.getWriter();

        try {
            res = model.getWhere("user", query);
            if (res.next()){
//                pr.println(request.getParameter("username"));
                HttpSession session = request.getSession(true);
                session.setAttribute("user", res.getString("username"));
                session.setAttribute("pass", res.getString("password"));
                response.sendRedirect("menu");
            }else{
                response.sendRedirect("error");
//                pr.println("Maaf");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        model.closeConnection();
        pr.close();
    }
}
