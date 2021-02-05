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
import java.sql.SQLException;

@WebServlet("/delete")
public class Delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String idDelete = req.getParameter("id");
        final String table = req.getParameter("table");
        final String field = req.getParameter("field");
        final PrintWriter pr = resp.getWriter();
        final Model model = new Model();

        Thread thread = new Thread(new Runnable (){
            @Override
            public void run() {
                try {
                    try {
                        if (idDelete != null){
                            if (table.equals("jabatan")){
                                int deleted = model.delete(table, field, idDelete);
                                if (deleted == 1){
                                    pr.println("<script>alert(\"data berhasil dihapus\"); window.location.href = \"http://localhost:8080/menujabatan\";</script>");
                                }
                            }else if(table.equals("karyawan")){
                                int deleted = model.delete(table, field, idDelete);
                                if (deleted == 1){
                                    pr.println("<script>alert(\"data berhasil dihapus\"); window.location.href = \"http://localhost:8080/menukaryawan\";</script>");
                                }
                            }
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
