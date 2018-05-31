import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import 'antd/dist/antd.css';
import {LoginComponent} from "./login/LoginComponent";

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Welcome to NJU-BOOK-STORE</h1>
        </header>
        <p className="App-intro">
          To get started, login or register first.
        </p>
        <LoginComponent/>
      </div>
    );
  }
}

export default App;
