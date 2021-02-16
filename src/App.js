import React, { Component } from 'react';
import { Table, Form } from './template'

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {

    }
  }
  render() {
    return (
      <div className="body">
        <Form />
        <Table/>
      </div>
    );
  }
}

export default App;