<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>body{
        height: 97vh;
        background-color: #5c6975;
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
        height: 20%;
        display: flex;
        flex-direction: column;
    }

    .header h1{
        margin: auto;
        color: #ffffff;
        font-size: 4.5vh;
    }

    .header p{
        margin: auto;
        color: #ffffff;
        font-size: 2.5vh;
        font-weight: bold;
    }

    .icon-box{
        height: 80%;
        display: flex;
    }

    .box-icon{
        margin: auto;
        /* flex-direction: row; */
        text-align: center;
    }

    .tabs-icon{
        margin: 2vh;
        border: none;
        /* border-radius: 50%; */
        position: relative;
        display: inline-block;
        cursor: pointer;
        transition: all .3s ease-in-out;
    }

    .tabs-icon a{
        text-decoration: none;
    }

    .tabs-icon:hover{
        transform: scale(1.1);
    }

    .kotak-icon{
        width: 35vh;
        height: 35vh;
        border-radius: 50%;
        border: dashed #ffffff;
        display: flex;
        /* background-color: #2A3641; */
    }

    .kotak-icon img{
        height: 19vh;
        margin: auto;
    }

    .kotak-judul{
        height: 5vh;
        text-align: center;
    }

    .kotak-judul h1{
        color: #ffffff;
        font-size: 3vh;
    }

    @media screen and (max-width: 1024px) {
        .kotak-icon{
            width: 24vh;
            height: 24vh;
        }
    }

    @media screen and (max-width: 992px) {

        .kotak-icon{
            width: 30vh;
            height: 30vh;
        }
    }

    @media screen and (max-width: 744px) {
        .kotak-icon{
            width: 23vh;
            height: 23vh;
        }
    }

    @media screen and (max-width: 600px) {
        .kotak-icon{
            width: 20vh;
            height: 20vh;
        }
    }</style>
</head>
<body>
    <div class="container">
        <div class="header">
            <p>Selamat datang, <% out.println(request.getAttribute("user")); %></p>
            <h1>Pilih Menu Login</h1>
        </div>
        <div class="icon-box">
            <div class="box-icon">
                <div class="tabs-icon">
					<a href="/menukaryawan">
						<div class="kotak-icon">
							<img src="/images/employee.png" alt="">
						</div>
						<div class="kotak-judul">
							<h1>Karyawan</h1>
						</div>
					</a>
				</div>
				<div class="tabs-icon">
					<a href="/menujabatan">
						<div class="kotak-icon">
							<img style="" src="/images/hierarchy.png" alt="">
						</div>
						<div class="kotak-judul">
							<h1>Jabatan</h1>
						</div>
					</a>
				</div>
            </div>
        </div>
    </div>
</body>
</html>