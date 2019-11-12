import React, { Component } from 'react';
import {Switch, Route, BrowserRouter as Router } from 'react-router-dom';
import './App.css';
import Converter from './components/Converter/Converter';
import ConversionResult from './components/ConversionResult/ConversionResult';
import Navigation from './components/Navigation/Navigation';
import Info from './components/Info/Info';

class App extends Component {


  render () {
        return (
          <div>
            <h1>Number Converter</h1>
            Backend address: {process.env.REACT_APP_ENDPOINT}
          <Navigation/>
          
          <Router>
            <Switch>
              <Route path="/convert" component={Converter} />
              <Route path="/conversionResult" component={ConversionResult} />
              <Route path="/" component={Info} />
            </Switch>
          </Router>
          </div>
        
      );
    }

}

export default App;
