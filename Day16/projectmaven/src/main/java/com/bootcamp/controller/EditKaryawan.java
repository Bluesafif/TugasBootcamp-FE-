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

@WebServlet("/editkaryawan")
public class EditKaryawan extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter pr = resp.getWriter();
        String id = req.getParameter("id");
        final Model model = new Model();
        final String query = "id_karyawan="+id;
        final ResultSet[] result = {null};

        final String[] listJabatan = {""};

        HttpSession session = req.getSession(false);
        String user = (String)session.getAttribute("user");

        Thread thread = new Thread(new Runnable (){
            @Override
            public void run() {
                try {
                    result[0] = model.getWhere("karyawan",query);
                    if (result[0].next()){
                        req.setAttribute("id_karyawan", result[0].getInt("id_karyawan"));
                        req.setAttribute("nama_karyawan", result[0].getString("nama_karyawan"));
                        req.setAttribute("gaji_pokok", result[0].getInt("gaji_pokok"));
                        req.setAttribute("id_jabatan", result[0].getInt("id_jabatan"));
                    }
                } catch (SQLException throwables) {
                    pr.println(throwables);
                }

                try{
                    result[0] = model.getData("jabatan");
                    while (result[0].next()){
                        listJabatan[0] += "<option "+ (req.getAttribute("id_jabatan").equals(result[0].getInt("id_jabatan")) ? "selected" : "") +
                                " value=\""+ result[0].getInt("id_jabatan")+"\">"+ result[0].getString("nama_jabatan")+"</option>";
                    }
                } catch (SQLException throwables) {
                    System.out.println(throwables);
                }

                req.setAttribute("listJabatan", listJabatan[0]);
            }
        });

        if ((session.getAttribute("user") == null)){
            resp.sendRedirect("index.jsp");
        }else{
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }

            RequestDispatcher view = req.getRequestDispatcher("view/edit_karyawan.jsp");
            view.forward(req, resp);
        }

        model.closeConnection();
        pr.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter pr = resp.getWriter();
        String id = req.getParameter("id");
        final Model model = new Model();
        final String query = "nama_karyawan='"+req.getParameter("nama_karyawan")+
                "', gaji_pokok="+ req.getParameter("gaji_pokok")+
                ", id_jabatan="+ req.getParameter("id_jabatan");
        final String where = "id_karyawan="+id;
        HttpSession session = req.getSession(false);
        String user = (String)session.getAttribute("user");

        Thread thread = new Thread(new Runnable (){
            @Override
            public void run() {
                try {
                    try {
                        int update = model.updateData("karyawan", query, where);
                        if (update == 1){
                            pr.println("<script>alert(\"data berhasil diubah\"); window.location.href = \"http://localhost:8080/menukaryawan\";</script>");
                        }else{
                            pr.println("<script>alert(\"data gagal diubah\"); window.location.href = \"http://localhost:8080/menukaryawan\";</script>");
                        }
                    } catch (SQLException throwables) {
                        pr.println(throwables);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });

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
