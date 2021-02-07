const inputNama 		= document.querySelector('input[name="nama"]')
const inputTempat       = document.querySelector('input[name="tempat"]')
const inputTanggal 		= document.querySelector('input[name="tanggal"]')
const inputJenkel       = document.querySelectorAll('input[name="jenkel"]')
const inputHobby        = document.querySelectorAll('input[name="hobby"]')
const inputAgama        = document.querySelector('select[name="Agama"]')
const inputAlamat 		= document.querySelector('textarea[name="alamat"]')
const hobby1            = document.getElementById('berenang')
const hobby2            = document.getElementById('jogging')
const hobby3            = document.getElementById('bersepeda')
const hobby4            = document.getElementById('futsal')

const submit 			= document.getElementById('submit')
const reset 			= document.getElementById('reset')
const ubah              = document.getElementById('update')
const bodyTable	    	= document.getElementById('bodyTable')
const select            = document.getElementById('cari')
const inputCari         = document.getElementById('inputCari')
const paging            = document.querySelector('#paging')

var personId 			= 1
let selectedId 			= 0
let hasilInput			= []
let lim                 = 4
let firstPage           = 1

dummyData();
showData();

function pagin() {
    var pageTotal   = Math.ceil(hasilInput.length/lim)
    paging.innerHTML = ``
    for (var i = 1; i <= pageTotal; i++) {
        if (i == firstPage) {
            paging.innerHTML+=`<button onclick="">${i}</button>`
        } else if (i<firstPage) {
            paging.innerHTML+=`<button onclick="clickPage(${i})">${i}</button>`
        } else if (i>firstPage) {
            paging.innerHTML+=`<button onclick="clickPage(${i})">${i}</button>`
        }
    }
}

function clickPage(pil) {
    firstPage = pil
    showData()
}

inputCari.addEventListener("keyup", (cari) => {
    var hash = cari.target.value
    if (select.value === "Nama") {
        if (hash === "") {
            showData();
        }else{
            var cariData = hasilInput.filter((hasil)=>{
                return hasil.dataNama === hash;
            });

            search(cariData);
        }
    }else if(select.value === "Agama"){
        if (hash === "") {
            showData();
        }else{
            var cariData = hasilInput.filter((hasil)=>{
                return hasil.dataAgama === hash;
            });

            search(cariData)
        }
    }else{
        if (hash === "") {
            showData();
        }else{
            var cariData = hasilInput.filter((hasil) => {
            return hasil.dataNama.equals(hash);
        });
        search(cariData);
        }
    }
})

let search = (cari) => {
    bodyTable.innerHTML = "";
    if (cari.length > 0) {
        for (var i = 0; i < cari.length; i++) {
            bodyTable.innerHTML +=`
            <tr>
                <td class="tNumber"><b>${cari[i].id}</b></td>
                <td class="tText"style="padding.left:5%">${cari[i].dataNama}</td>
                <td class="tTanggal">${cari[i].dataUmur} tahun</td>
                <td class="tJk">${cari[i].dataJenkel}</td>
                <td class="tHobby">${cari[i].dataHobby}</td> 
                <td class="tAgama">${cari[i].dataAgama}</td> 
                <td class="tAlamat">${cari[i].dataAlamat}</td>
                <td class="tAction">
                    <button class="button" type="button" onclick="updateClicked(${cari[i].id})">Sunting</button>
                    <button class="button" type="button" onclick="deleteClicked(${cari[i].id  })">Hapus</button>
                </td>
            </tr>`;
        }
    }else{
        bodyTable.innerHTML = `
            <tr>
                <td style="text-align: center" colspan="8">Data Tidak Tersedia!</td>
            </tr>`;
    }
}

function handleSubmit() {
    if (!valid()) {
        if (submit.value === "Submit") {
            inputData()
        } else {
            edit(selectedId)
        }
	} else {
		alert("Data harus terisi!")
	}
}

function valid(){
    var valid = false;
    if (inputNama.value === "") {
        valid = true
    }
    if (inputTempat.value === "") {
        valid = true
    }
    if (inputTanggal.value === "") {
        valid = true
    }
    if (inputAgama.value === "") {
        valid = true
    }
    if (inputAlamat.value === "") {
        valid = true
    }
    return valid
}

function handleReset() {
    inputNama.value 	= "";
    inputTempat.value 	= "";
    inputTanggal.value 	= "";
    inputJenkel.forEach(element =>{
        element.checked=false;
    });
    inputHobby.forEach(element =>{
        element.checked=false;
    });
    inputAgama.value 	= "";
	inputAlamat.value 	= "";
}

function inputData () {
    var today = new Date();
	var jmlAge = new Date(inputTanggal.value);
	var year = 0;
	if (today.getMonth() < jmlAge.getMonth()) {
		year = 1;
	} else if ((today.getMonth() == jmlAge.getMonth()) && today.getDate() < jmlAge.getDate()) {
		year = 1;
	}
	var age = today.getFullYear() - jmlAge.getFullYear() - year;
 
	if(age < 0){
		age = 0;
    }

    var jenkel = "";
    for(var i = 0; i < inputJenkel.length; i++){
        if (inputJenkel[i].checked){
            jenkel = jenkel + inputJenkel[i].value;
        }
    }

    var hobby = [];
    for(var i = 0; i < inputHobby.length; i++){
        if (inputHobby[i].checked){
            hobby.push(inputHobby[i].value);
        }
    }

	let hasil = {
		id 			: personId,
        dataNama 	: inputNama.value,
        dataTempat  : inputTempat.value,
        dataTanggal : inputTanggal.value,
        dataUmur	: age,
        dataJenkel  : jenkel,
        dataHobby   : hobby,
        dataAgama   : inputAgama.value,
		dataAlamat  : inputAlamat.value
	};
    hasilInput.push(hasil);
    console.log(hasilInput);
	personId++;

	showData();
    handleReset();
}

function dummyData() {
    for (var i = 0; i < 10; i++) {
        let hasil = {
            id 			: personId,
            dataNama 	: "Ali",
            dataTempat  : "Kebayoran",
            dataTanggal : "1999-12-20",
            dataUmur	: "22",
            dataJenkel  : "Laki-Laki",
            dataHobby   : ["Berenang"],
            dataAgama   : "Islam",
            dataAlamat  : "Jalan Buntu"
        };      

        hasilInput.push(hasil);
        personId++;
    }
}

function showData() {
    var lastPage = firstPage * lim;
    var offset   = lastPage - lim;
    if (hasilInput.length > 0) {
        bodyTable.innerHTML = ''
        // hasilInput.forEach(hasil =>{
        for (var i = offset; i < lastPage; i++) {
            bodyTable.innerHTML += `
            <tr>
                <td align="center"> <b> ${hasilInput[i].id} </b> </td>
                <td style="padding-left:2%"> ${hasilInput[i].dataNama} </td>
                <td style="text-align: center;"> ${hasilInput[i].dataUmur} </td>
                <td style="text-align: center;"> ${hasilInput[i].dataJenkel} </td>
                <td style="text-align: center;"> ${hasilInput[i].dataHobby} </td>
                <td style="text-align: center;"> ${hasilInput[i].dataAgama} </td>
                <td> ${hasilInput[i].dataAlamat} </td>
                <td class="tdAction">
                    <button type="button" id="update" onclick="updateClicked(${hasilInput[i].id})">Update</button>
                    <button type="button" onclick="deleteClicked(${hasilInput[i].id})">Delete</button>
                </td>
            </tr>
            `
        }
        pagin()
    }else{
        alert("Full")
    }
}

function deleteClicked(id) {
	const hasil = hasilInput.find(function(hasil){
		return hasil.id === id
	})

	if (confirm(`Apakah Anda Yakin Ingin Menghapus Data ${hasil.dataNama}`)) {
		hasilInput = hasilInput.filter(function(hasil){
			return hasil.id != id
		})
	}else{
        alert("Data Tidak Ditemukan!")
    } 
	showData();
}

function updateClicked(id) {
    const hasil = hasilInput.find(function(hasil){
        return hasil.id === id
    })

    if(confirm(`Apakah Anda Yakin Ingin Mengedit Data ${hasil.dataNama}`)) {
        inputNama.value = hasil.dataNama;
        inputTempat.value = hasil.dataTempat;
        inputTanggal.value = hasil.dataTanggal;
        var jenkel = hasil.dataJenkel;
        for(var i = 0; i < inputJenkel.length; i++){
            if (inputJenkel[i].value === jenkel) {
                inputJenkel[i].checked = true
            }
        }
        var hobby = hasil.dataHobby;
        hobby.forEach(hobi => {
            if (hobi === "Berenang") {
                hobby1.checked = true
            } else if (hobi === "Jogging") {
                hobby2.checked = true
            } else if (hobi === "Bersepeda") {
                hobby3.checked = true
            } else if (hobi === "Futsal") {
                hobby4.checked = true
            } else {
                alert("Hobby Tidak Tersedia!")
            }
        });
        inputAgama.value = hasil.dataAgama;
        inputAlamat.value = hasil.dataAlamat;
        selectedId = hasil.id;
        submit.value = "Update";
    }else{
        alert("Data Tidak Ditemukan!")
    }
}

function edit(id) {
    const hasil = hasilInput.find(function(hasil){
        return hasil.id === id
    })

    var index = hasilInput.indexOf(hasil);

    var today = new Date();
	var jmlAge = new Date(inputTanggal.value);
	var year = 0;
	if (today.getMonth() < jmlAge.getMonth()) {
		year = 1;
	} else if ((today.getMonth() == jmlAge.getMonth()) && today.getDate() < jmlAge.getDate()) {
		year = 1;
	}
	var age = today.getFullYear() - jmlAge.getFullYear() - year;
 
	if(age < 0){
		age = 0;
    }

    var jenkel = "";
    for(var i = 0; i < inputJenkel.length; i++){
        if (inputJenkel[i].checked){
            jenkel = inputJenkel[i].value;
        }
    }

    var hobby = [];
    for(var i = 0; i < inputHobby.length; i++){
        if (inputHobby[i].checked){
            hobby.push(inputHobby[i].value);
        }
    }

    hasilInput[index].dataNama      = inputNama.value;
    hasilInput[index].dataTempat    = inputTempat.value;
    hasilInput[index].dataTanggal   = inputTanggal.value;
    hasilInput[index].dataUmur      = age;
    hasilInput[index].dataJenkel    = jenkel;
    hasilInput[index].dataHobby     = hobby;
    hasilInput[index].dataAgama     = inputAgama.value;
    hasilInput[index].dataAlamat    = inputAlamat.value;

    showData();
    handleReset();
    submit.value = "Submit";
}

submit.addEventListener("click", handleSubmit);
reset.addEventListener("click", handleReset);
