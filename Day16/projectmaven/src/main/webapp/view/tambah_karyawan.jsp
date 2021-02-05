<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tambah Data Jabatan</title>
    <style>
        body{
            background-color: #cae4db;
            color: #222831;
            font-size: 1rem;
            font-style: normal;
            font-weight: 400;
            font-family: "Nunito Sans", sans-serif;
            display: flex;
        }

        .container{
            width: 80%;
            height: 80%;
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

        .field{
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

        .field label{
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
                <h1>Tambah Data Jabatan</h1>
            </div>
        </div>
        <div class="content">
            <form action="/tambahkaryawan" method="POST" class="form" id="myForm">
                <div class="field">
                    <label for="nama_karyawan">Nama Karyawan</label>
                    <input class="form-input" type="text" name="nama_karyawan" id="nama_karyawan">
                </div>
                <div class="field">
                    <label for="id_jabatan">Jabatan</label>
                    <select class="form-input" name="id_jabatan" id="id_jabatan">
                        <option value="">Pilih Jabatan</option>
                        <% out.println(request.getAttribute("listJabatan")); %>
                    </select>
                </div>
                <div class="field">
                    <label for="gaji_pokok">Gaji Pokok</label>
                    <input class="form-input" type="number" name="gaji_pokok" id="gaji_pokok">
                </div>
                <div class="field">
                    <button type="submit" class="btn-submit">SUBMIT</button>
                </div>
            </form>
        </div>
    </div>
</body>
<script>
    let namaKaryawan = document.querySelector("#nama_karyawan");
    let idJabatan = document.querySelector("#id_jabatan");
    let gajiPokok = document.querySelector("#gaji_pokok");
    let btnSubmit = document.querySelector("#myForm");

    btnSubmit.addEventListener("submit",(e)=>{
        e.preventDefault();
        if (namaKaryawan.value != "" && idJabatan.value != "" && gajiPokok.value != "") {
            e.target.submit();
        }else{
            alert("form harus diisi semua");
        }
    })

</script>
</html>