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

@WebServlet("/tambahkaryawan")
public class TambahKaryawan extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Model model = new Model();
        final String[] listJabatan = {""};
        HttpSession session = req.getSession(false);
        String user = (String)session.getAttribute("user");

        Thread thread = new Thread(new Runnable (){
            @Override
            public void run() {
                try {
                    try{
                        ResultSet result = model.getData("jabatan");
                        while (result.next()){
                            listJabatan[0] += "<option value=\""+result.getInt("id_jabatan")+"\">"+result.getString("nama_jabatan")+"</option>";
                        }
                    } catch (SQLException throwables) {
                        System.out.println(throwables);
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

            req.setAttribute("listJabatan", listJabatan[0]);
            RequestDispatcher view = req.getRequestDispatcher("view/tambah_karyawan.jsp");
            view.forward(req, resp);
        }

        model.closeConnection();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter pr = resp.getWriter();
        final Model model = new Model();
        final String query = "(NULL, '"+req.getParameter("nama_karyawan")+"', "+
                req.getParameter("gaji_pokok")+", "+
                req.getParameter("id_jabatan")+")";
        final String map = "(id_karyawan, nama_karyawan, gaji_pokok, id_jabatan)";

        Thread thread = new Thread(new Runnable (){
            @Override
            public void run() {
                try {
                    try {
                        int store = model.insert("karyawan", map, query);
                        if (store == 1){
                            pr.println("<script>alert(\"data berhasil ditambah\"); window.location.href = \"http://localhost:8080/menukaryawan\";</script>");
                        }else{
                            pr.println("<script>alert(\"data gagal ditambah\"); window.location.href = \"http://localhost:8080/menukaryawan\";</script>");
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
