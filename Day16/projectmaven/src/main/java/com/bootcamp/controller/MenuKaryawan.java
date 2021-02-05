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

@WebServlet("/menukaryawan")
public class MenuKaryawan extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter pr = resp.getWriter();
        final Model model = new Model();
        final ResultSet[] result = {null};
        final String[] output = {""};

        Thread thread = new Thread(new Runnable (){
            @Override
            public void run() {
                try {
                    try {
                        result[0] = model.getListData();
                        while (result[0].next()) {
                            output[0] += "<tr>" +
                                    "<td>" + result[0].getInt("id_karyawan") + "</td>" +
                                    "<td>" + result[0].getString("nama_karyawan") + "</td>" +
                                    "<td>" + result[0].getString("nama_jabatan") + "</td>" +
                                    "<td>Rp. " + result[0].getInt("tunj_makan") + "</td>" +
                                    "<td>Rp. " + result[0].getInt("tunj_transport") + "</td>" +
                                    "<td>Rp. " + result[0].getInt("gaji_pokok") + "</td>" +
                                    "<td>Rp. " + result[0].getInt("total_gaji") + "</td>" +
                                    "<td> <a href=\"/editkaryawan?id="+ result[0].getInt("id_karyawan")+"\">Edit</a> " +
                                    " <a href=\"/delete?id="+ result[0].getInt("id_karyawan")+"&table=karyawan&field=id_karyawan\"> Hapus </a></td>" +
                                    "</tr>\n";
                        }
//            output = JSONValue.toJSONString(arrObj);
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

            req.setAttribute("data", output[0]);
            RequestDispatcher view = req.getRequestDispatcher("view/menu_karyawan.jsp");
            view.forward(req, resp);
        }

        model.closeConnection();
        pr.close();
    }
}
