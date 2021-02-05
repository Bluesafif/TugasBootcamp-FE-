package com.bootcamp.controller;

import com.bootcamp.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/tambahjabatan")
public class TambahJabatan extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        String user = (String)session.getAttribute("user");

        if ((session.getAttribute("user") == null)){
            resp.sendRedirect("index.jsp");
        }else{
            RequestDispatcher view = req.getRequestDispatcher("view/tambah_jabatan.jsp");
            view.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter pr = resp.getWriter();
        final Model model = new Model();
        final String query = "(NULL, '"+req.getParameter("nama_jabatan")+"', "+
                req.getParameter("tunj_makan")+", "+
                req.getParameter("tunj_transport")+")";
        final String map = "(id_jabatan, nama_jabatan, tunj_makan, tunj_transport)";

        Thread thread = new Thread(new Runnable (){
            @Override
            public void run() {
                try {
                    try {
                        int store = model.insert("jabatan", map, query);
                        if (store == 1){
                            pr.println("<script>alert(\"data berhasil ditambah\"); window.location.href = \"http://localhost:8080/menujabatan\";</script>");
                        }else{
                            pr.println("<script>alert(\"data gagal ditambah\"); window.location.href = \"http://localhost:8080/menujabatan\";</script>");
                        }
                    } catch (ClassNotFoundException e) {
                        pr.println(e);
                    } catch (SQLException throwables) {
                        pr.println(throwables);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });

        HttpSession session = req.getSession(false);
        String user = (String)session.getAttribute("user");

        if ((session.getAttribute("user") == null)){
            resp.sendRedirect("index.jsp");
        }else{
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        model.closeConnection();
        pr.close();
    }
}
