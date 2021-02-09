import React, { Component } from 'react';

import { Header, Content } from "./template"
import "./App.css";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {  }
  }
  render() {
    return (
      <>
        <div className="body">
          <Header />
          <Content />
        </div>
      </>
    );
  }
}

export default App;