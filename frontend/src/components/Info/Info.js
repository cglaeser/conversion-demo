import React, { Component } from 'react';
import './Info.css';

//An info page when accessing the root directory
class Info extends Component {
    constructor(props) {
        super(props);
        this.state = {
            conversionResult: JSON.parse(localStorage.getItem('conversionResult'))
        }
    }

    
    render () {
            console.log(this.state.conversionResult)
            return (
            
            <div className="container">
            <div className="conversionResult">
            <h3>Welcome to the Roman numeral converter</h3>
            <p>Please select an item in the menu above to get converted ;-)</p>   
            </div>
            </div>
            
        );
}
}
        

  export default Info;