import React, { Component } from 'react';

class Table extends Component {
    constructor(props) {
        super(props);
        this.state = {

        }
    }
    render() {
        return (
            <div className="content">
                <div className="col2">
					<table cellSpacing="0" cellPadding="5" border="3" align="center">
						<thead className="table1">
							<tr>
								<th className="tNomor">No</th>
								<th className="tAsset">Nama Buah</th>
                                <th className="tKementerian">Stok Buah</th>
                                <th>Harga</th>
                                <th>Action</th>
							</tr>
						</thead>
						<tbody>
                            
                        </tbody>
					</table>
				</div>
            </div>
        );
    }
}

export default Table;