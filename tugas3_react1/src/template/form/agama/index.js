import React, { Component } from 'react';

class Agama extends Component {
    constructor(props) {
        super(props);
        this.state = {  }
    }
    render() {
        return (
            <label>
                Agama:
                <select className="select" name="Agama" id="agama">
                    <option value="">Pilih</option>
                    <option value="Islam">Islam</option>
                    <option value="Protestan">Protestan</option>
                    <option value="Katholik">Katholik</option>
                    <option value="Hindu">Hindu</option>
                    <option value="Budha">Budha</option>
                </select>
                <br></br>
                <br></br>
            </label>
        );
    }
}

export default Agama;