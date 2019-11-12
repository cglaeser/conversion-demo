import React, { Component } from 'react';
import './ConversionResult.css';

//The page displaying the conversion result
class ConversionResult extends Component {
    constructor(props) {
        super(props);
        this.state = {
            conversionResult: JSON.parse(localStorage.getItem('conversionResult'))
        }
    }

    
    render () {
        var result = ""
        if(this.state.conversionResult.errorMessage == null){
            result = <p><b>Your Roman numeral:</b> {this.state.conversionResult.romanNumeral}</p>  
        }
        else {
            result = <div><p>&nbsp;</p><p><b>!!!An error occured with the conversion:!!!</b> </p><p> {this.state.conversionResult.errorMessage}</p></div>
        }

            console.log(this.state.conversionResult)
            return (
            
            <div className="container">
            <div className="conversionResult">
            <h2>Result Roman Number</h2>
           
            <p><b>Your input:</b> {this.state.conversionResult.inputValue}</p>
            <p><b>Your selected method of conversion:</b> {this.state.conversionResult.conversion}</p>
            {result}
              
            </div>
            </div>
            
        );
}
}
        

  export default ConversionResult;