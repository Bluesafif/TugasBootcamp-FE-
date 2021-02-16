import React, { Component } from 'react';

class Input extends Component {
    render() {
        const {className, name, type, placeholder, id, value, onChange} = this.props;
        return (
            <input className={className} name={name} id={id} value={value} type={type} placeholder={placeholder} onChange={onChange} />
        );
    }
}

export default Input;