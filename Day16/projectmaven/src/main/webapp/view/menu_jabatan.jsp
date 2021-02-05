<%@ page import ="java.util.*" %>
<%@ page import ="java.io.IOException"%>
<%@ page import ="java.io.PrintWriter"%>
<%@ page import ="java.sql.ResultSet"%>
<%@ page import ="java.sql.SQLException"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu Jabatan</title>
</head>
<style>
    body{
        background-color: aliceblue;
        color: #5c6975;
        font-size: 1rem;
        font-style: normal;
        font-weight: 400;
        font-family: "Nunito Sans", sans-serif;
        display: flex;
    }

    .hidden{
        display: none !important;
    }

    .container{
        width: 80%;
        height: 80%;
        margin: auto;
        display: flex;
        flex-direction: column;
    }

    .header{
        margin-top: 10vh;
        height: 40vh;
        display: flex;
        flex-direction: column;
    }

    .content{
        display: flex;
    }

    .btn-green{
        width: 100%;
        background-color: #4CAF50;
        color: white;
        padding: 1.7vh 0;
        border: none;
        border-radius: 0.5vh;
        cursor: pointer;
        text-decoration: none;
        text-align: center;
        margin: 1vh 0;
    }

    .btn-green:hover{
        background-color: #45a049;
    }

    .btn-orange{
        width: 100%;
        background-color: #f0ad4e;
        border-color: #eea236;
        color: white;
        padding: 1.7vh 0;
        border: none;
        border-radius: 0.5vh;
        cursor: pointer;
        text-decoration: none;
        text-align: center;
        margin: 1vh 0;
    }

    .btn-orange:hover{
        background-color: #f3a538;
    }

    .btn-red{
        width: 100%;
        background-color: #d9534f;
        border-color: #d43f3a;
        color: white;
        padding: 1.7vh 0;
        border: none;
        border-radius: 0.5vh;
        cursor: pointer;
        text-decoration: none;
        text-align: center;
        margin: 1vh 0;
    }

    .btn-red:hover{
        background-color: #db3a35;
    }

    #table {
        font-family: Arial, Helvetica, sans-serif;
        border-collapse: collapse;
        width: 100%;
    }

    #table td, #table th {
        border: 1px solid #ddd;
        padding: 8px;
    }

    #table tr:nth-child(even){background-color: #f2f2f2;}

    #table tr:hover {background-color: #ddd;}

    #table th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #4CAF50;
    color: white;
    }
</style>
<body>
    <div class="container">
        <div class="header">
            <h1>Menu Jabatan</h1>
            <a href="/tambahjabatan" class="btn-green">Tambah Data Jabatan</a>
            <a href="/jsonjabatan" target="_blank" class="btn-green">List Jabatan JSON</a>
            <a href="/menu" class="btn-orange">Kembali Ke Menu</a>
            <a href="/logout" class="btn-red">Logout</a>
        </div>
        <div class="content">
            <table id="table">
                <thead>
                    <tr>
                        <td>ID Jataban</td>
                        <td>Nama Jataban</td>
                        <td>Tunjangan Transport</td>
                        <td>Tunjangan </td>
                        <td>Action</td>
                    </tr>
                </thead>
                <tbody>
                    <%
                        out.println(request.getAttribute("dataJabatan"));
                    %>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>