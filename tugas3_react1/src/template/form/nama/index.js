import React, { Component } from 'react';

class Nama extends Component {
    constructor(props) {
        super(props);
        this.state = {  }
    }
    render() {
        return (
            <label>
                <br></br>Name:<br></br>
                <input className="nama" type="text" placeholder="Masukkan Nama Lengkap" />
                <br></br>
                <br></br>
            </label>
        );
    }
}

export default Nama;