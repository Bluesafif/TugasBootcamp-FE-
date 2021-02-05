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
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/editjabatan")
public class EditJabatan extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter pr = resp.getWriter();
        String id = req.getParameter("id");
        final Model model = new Model();
        final String query = "id_jabatan="+id;
        final ResultSet[] result = {null};

        Thread thread = new Thread(new Runnable (){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    try {
                        result[0] = model.getWhere("jabatan",query);
                        if (result[0].next()){
                            req.setAttribute("id_jabatan", result[0].getInt("id_jabatan"));
                            req.setAttribute("nama_jabatan", result[0].getString("nama_jabatan"));
                            req.setAttribute("tunj_makan", result[0].getInt("tunj_makan"));
                            req.setAttribute("tunj_transport", result[0].getInt("tunj_transport"));
                        }
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

            RequestDispatcher view = req.getRequestDispatcher("view/edit_jabatan.jsp");
            view.forward(req, resp);
        }
        model.closeConnection();
        pr.close();
    }

    @Override
    protected void doPost(final HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter pr = resp.getWriter();
        String id = req.getParameter("id");
        final Model model = new Model();
        final String query = "nama_jabatan='"+req.getParameter("nama_jabatan")+
                "', tunj_makan="+ req.getParameter("tunj_makan")+
                ", tunj_transport="+ req.getParameter("tunj_transport");
        final String where = "id_jabatan="+id;

        Thread thread = new Thread(new Runnable (){
            @Override
            public void run() {
                try {
                    try {
                        int update = model.updateData("jabatan", query, where);
                        if (update == 1){
                            pr.println("<script>alert(\"data berhasil diubah\"); window.location.href = \"http://localhost:8080/menujabatan\";</script>");
                        }else{
                            pr.println("<script>alert(\"data gagal diubah\"); window.location.href = \"http://localhost:8080/menujabatan\";</script>");
                        }
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
