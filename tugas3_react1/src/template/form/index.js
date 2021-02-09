import React, { Component } from 'react';

import Nama from "./nama";
import Lahir from "./ttl";
import Jenkel from "./jenkel";
import Hobby from "./hobby";
import Agama from "./agama";
import Alamat from "./alamat";
import Button from "./button";

import "./style.css";

class Header extends Component {
    constructor(props) {
        super(props);
        this.state = {  }
    }
    render() {
        return (
            <div className="header">
                <div className="form">
                    <h1>Form Input!</h1>
                    <form className="isiForm" onSubmit={this.handleSubmit}>
                        <Nama></Nama>
                        <Lahir></Lahir>
                        <Jenkel></Jenkel>
                        <Hobby></Hobby>
                        <Agama></Agama>
                        <Alamat></Alamat>
                        <Button></Button>
                    </form>
                </div>
            </div>
        );
    }
}

export default Header;