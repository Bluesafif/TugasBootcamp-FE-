import React, { Component } from 'react';
import { Input } from '../../component';

import './form.css'

class Form extends Component {
    constructor(props) {
        super(props);
        this.state = { 
            namaBuah :"",
            stokBuah :0,
            hargaBuah :0
        }
        this.handleSub = this.handleSub.bind(this)
    }

    handleSub(event){
        this.setState({
            namaBuah:"",
            stokBuah:"",
            hargaBuah:""
        })
        event.preventDefault()
    }

    setValue = el => {
        this.setState({
            [el.target.name]: el.target.value
        })
    }

    render() {
        const { namaBuah, stokBuah, hargaBuah } = this.state
        return (
            <div className="header">
                <div className="form">
                    <h1>Form Input Buah</h1>
                    <form className="isiForm" onSubmit={this.handleSub}>
                        <div>
                            <br/>
                            Nama Buah:
                            <Input className="namaBuah" name="namaBuah" placeholder="Masukkan Nama Buah" onChange={this.setValue} />
                            <br/><br/>
                        </div>
                        <div>
                            Stok Buah:
                            <Input className="stokBuah" name="stokBuah" min="0"type="number" placeholder="Stok Buah" onChange={this.setValue} />
                            <br/><br/>
                        </div>
                        <div>
                            Harga Buah:
                            <Input className="hargaBuah" name="hargaBuah" type="number" placeholder="Harga Buah" onChange={this.setValue} />
                            <br/><br/>
                        </div>
                        <div className="button">
                            <button onClick={()=>this.props.save({ namaBuah, stokBuah, hargaBuah })}>Submit</button>
                            <button type="reset">Reset</button>
                        </div>
                    </form>
                </div>
            </div>
        );
    }
}

export default Form;