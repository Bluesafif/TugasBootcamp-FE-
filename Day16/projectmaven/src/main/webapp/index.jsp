<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Form Login</title>
    <style>
        body{
            height: 97vh;
            background-color: #11698e;
            color: #222831;
            font-size: 1rem;
            font-style: normal;
            font-weight: 400;
            font-family: "Nunito Sans", sans-serif;
            display: flex;
        }

        .container{
            width: 60vh;
            height: 55vh;
            margin: auto;
            display: flex;
            flex-direction: column;
            background-color: aliceblue;
            border-radius: 2vh;
        }

        .header{
            height: 20%;
            display: flex;
        }

        .text-judul{
            margin: auto;
        }

        .text-judul h1{
            font-size: 4.5vh;
            font-weight: bold;
        }

        .content{
            height: 80%;
            display: flex;
        }

        .form{
            width: 80%;
            margin: 2vh auto 5vh auto;
            display: flex;
            flex-direction: column;
        }

        .field-form{
            display: flex;
            flex-direction: column;
            text-align: center;
            margin: 1.5vh 0;
        }

        .field-submit{
            width: 100%;
            margin: auto;
            display: flex;
            flex-direction: column;
            text-align: center;
        }

        .field-form label{
            font-size: 2vh;
            text-align: left;
            padding-left: 0.2vh;
            margin-bottom: 1vh;
        }

        .form-input{
            width: 100%;
            height: 5vh;
            padding: 0 1vh;
            display: inline-block;
            border: 0.2vh solid #ccc;
            border-radius: 0.5vh;
            box-sizing: border-box;
        }

        .form-input::-webkit-input-placeholder {
            font-size: 1.6vh;
            padding: 0;
            margin: 0;
        }

        .btn-submit{
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 1.7vh 4vh;
            border: none;
            border-radius: 0.5vh;
            cursor: pointer;
        }

        .btn-submit:hover{
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <div class="text-judul">
                <h1>LOGIN</h1>
            </div>
        </div>
        <div class="content">
            <form action="/auth" class="form" method="POST" id="myForm">
                <div class="field-form">
                    <label for="username">Username</label>
                    <input class="form-input" type="text" name="username" id="username" placeholder="Masukkan Username">
                </div>
                <div class="field-form">
                    <label for="password">Password</label>
                    <input class="form-input" type="password" name="password" id="password" placeholder="Masukkan Password">
                </div>
                <div class="field-submit">
                    <button type="submit" class="btn-submit" id="btnSubmit">Login</button>
                </div>
            </form>
        </div>
    </div>
</body>
<script>
    let username = document.querySelector("#username");
    let password = document.querySelector("#password");
    let btnSubmit = document.querySelector("#myForm");

    btnSubmit.addEventListener("submit",(e)=>{
        e.preventDefault();
        if (username.value != "" && password.value != "") {
            e.target.submit();
        }else{
            alert("username / password tidak boleh kosong");
        }
    })

</script>
</html>