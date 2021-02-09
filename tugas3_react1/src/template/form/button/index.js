import React, { Component } from 'react';

class Button extends Component {
    constructor(props) {
        super(props);
        this.state = {  }
    }
    render() {
        return (
            <div className="button">
                <input type="submit" id="submit" value="Submit" />
                <input type="button" id="reset" value="Reset" />
            </div>
        );
    }
}

export default Button;