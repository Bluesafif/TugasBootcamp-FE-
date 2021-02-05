package com.bootcamp.controller;

import com.bootcamp.model.Model;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/jsonjabatan")
public class JsonJabatan extends HttpServlet {
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
                        result[0] = model.getData("jabatan");
                        JSONObject obj = null;
                        List arrObj = new ArrayList();
                        while (result[0].next()) {
                            obj = new JSONObject();
                            obj.put("id_jabatan", result[0].getInt("id_jabatan"));
                            obj.put("nama_jabatan", result[0].getString("nama_jabatan"));
                            obj.put("tunj_transport", result[0].getInt("tunj_transport"));
                            obj.put("tunj_makan", result[0].getInt("tunj_makan"));
                            arrObj.add(obj);
                        }
                        output[0] = JSONValue.toJSONString(arrObj);
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
        pr.println(output[0]);
        pr.close();
    }
}
