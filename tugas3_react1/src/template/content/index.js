import React, { Component } from 'react';

import "./style.css";

class Content extends Component {
    constructor(props) {
        super(props);
        this.state = {  }
    }
    render() {
        return (
            <div className="content">
                <div className="search">
                    <select name="cari" id="cari">
                        <option value="">---Cari Berdasarkan---</option>
                        <option value="Nama">Nama</option>
                        <option value="Agama">Agama</option>
                    </select>
                    <input className="cari" name="inputCari" id="inputCari" />
                </div>
                <br></br>
                <div className="col2">
					<table cellspacing="0" cellpadding="5" border="3" align="center">
						<thead className="table1">
							<tr>
								<th className="tNomor">No</th>
								<th className="tNama">Nama</th>
                                <th className="tUmur">Umur</th>
                                <th>Jenis Kelamin</th>
                                <th>Hobby</th>
                                <th>Agama</th>
                                <th className="tAlamat">Alamat</th>
                                <th>Action</th>
							</tr>
						</thead>
						<tbody id="bodyTable">
                            <tr>
								<td>1</td>
								<td>Al Afif</td>
                                <td>22</td>
                                <td>Laki-Laki</td>
                                <td>Berenang, Bersepeda</td>
                                <td>Islam</td>
                                <td>Jalan Dwikora</td>
                                <td>Action</td>
							</tr>
                        </tbody>
					</table>
				</div>
                <div className="paging" id="paging">
                </div>
			</div>
        );
    }
}

export default Content;