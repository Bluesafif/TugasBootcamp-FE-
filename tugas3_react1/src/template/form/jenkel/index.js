import React, { Component } from 'react';

class Jenkel extends Component {
    constructor(props) {
        super(props);
        this.state = {  }
    }
    render() {
        return (
            <label>
                Jenis Kelamin:<br></br>
                <input type="radio" name="jenkel" value="Laki-Laki" />Laki-Laki
                <input type="radio" name="jenkel" value="Perempuan" />Perempuan
                <br></br>
                <br></br>
            </label>
        );
    }
}

export default Jenkel;