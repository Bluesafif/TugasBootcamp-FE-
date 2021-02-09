import React, { Component } from 'react';

class Alamat extends Component {
    constructor(props) {
        super(props);
        this.state = {  }
    }
    render() {
        return (
            <label>
                Alamat:<br></br>
                <textarea className="alamat" type="text" name="alamat" placeholder="Masukkan Alamat"></textarea>
                <br></br>
                <br></br>
            </label>
        );
    }
}

export default Alamat;