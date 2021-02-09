import React, { Component } from 'react';

class Hobby extends Component {
    constructor(props) {
        super(props);
        this.state = {  }
    }
    render() {
        return (
            <label>
                Hobby:<br></br>
                <input type="checkbox" name="hobby" id="berenang" value="Berenang"/>Berenang
                <input type="checkbox" name="hobby" id="jogging" value="Jogging"/>Jogging
                <input type="checkbox" name="hobby" id="bersepeda" value="Bersepeda"/>Bersepeda
                <input type="checkbox" name="hobby" id="futsal" value="Futsal"/>Futsal
                <br></br>
                <br></br>
            </label>
        );
    }
}

export default Hobby;