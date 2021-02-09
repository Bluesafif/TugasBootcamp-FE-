import React, { Component } from 'react';

class Lahir extends Component {
    constructor(props) {
        super(props);
        this.state = {  }
    }
    render() {
        return (
            <label>
                Tempat / Tanggal Lahir:<br></br>
                <input className="tempat" type="text" name="tempat" placeholder="Masukkan Tempat Lahir"></input>
                <input className="tanggal" type="date" name="tanggal" placeholder="Masukkan Tanggal Lahir"></input>
                <br></br>
                <br></br>
            </label>
        );
    }
}

export default Lahir;