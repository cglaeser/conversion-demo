import React, { Component } from 'react';
import Input from '../UI/Input/Input/Input';
import Button from '../UI/Input/Button/Button';
import Spinner from '../UI/Spinner/Spinner';

import './Converter.css';

import axios from '../../axios-conversion-backend';


//The actual converter method
class Converter extends Component {
    constructor(props) {
        super(props);
        
        const updatedConverterForm = {
            ...this.state.converterForm
        };

        let formValid = true;

        for (let inputIdentifier in updatedConverterForm) {
            //console.log(inputIdentifier)
            updatedConverterForm[inputIdentifier].valid = this.checkValidity(updatedConverterForm[inputIdentifier].value, updatedConverterForm[inputIdentifier].validation)
            formValid = (updatedConverterForm[inputIdentifier].valid && formValid);
        }
        
        this.state = {
            converterForm: updatedConverterForm,
            formIsValid: formValid
        }
    }

    state = {
        converterForm: {
            romanNumeralConverter: {
            elementType: 'select',
            elementConfig: {
                options: [
                    {value: '', displayValue: 'Please select conversion type'},
                        {value: 'DECIMAL_TO_ROMAN_NUMERALS', displayValue: 'Decimal -> Roman'},
                        {value: 'BINARY_TO_ROMAN_NUMERALS', displayValue: 'Binary - Roman'},
                ]
            },
            value: '',
            validation: {
                required: true
            },
            valid: true,
            touched: false
            },
            value: {
                elementType: 'input',
                elementConfig: {
                    type: 'text',
                    placeholder: '100'
                },
                value: '',
                validation: {
                    required: true,
                    minValue: 1,
                    maxValue: 3999,
                    isNumeric: true
                },
                valid: true,
                touched: false
            }
        }
    }
    

    checkValidity(value, rules) {
        let isValid = true;
        if (!rules) {
            return true;
        }
        
        if (rules.required) {
            isValid = value.trim() !== '' && isValid;
        }

        if (rules.minLength) {
            isValid = value.length >= rules.minLength && isValid
        }

        if (rules.maxLength) {
            isValid = value.length <= rules.maxLength && isValid
        }

    
        if (rules.isNumeric) {
            const pattern = /^\d+$/;
            isValid = pattern.test(value) && isValid
        }
        //console.log(isValid);
        return isValid;
    }

    inputChangedHandler = (event, inputIdentifier) => {
        const updatedConverterForm = {
            ...this.state.converterForm
        };
        const updatedFormElement = { 
            ...updatedConverterForm[inputIdentifier]
        };
        updatedFormElement.value = event.target.value;
        updatedFormElement.valid = this.checkValidity(updatedFormElement.value, updatedFormElement.validation);
        updatedFormElement.touched = true;
        updatedConverterForm[inputIdentifier] = updatedFormElement;
        
        let formIsValid = true;
        for (let inputIdentifier in updatedConverterForm) {
            formIsValid = updatedConverterForm[inputIdentifier].valid && formIsValid;
        }
        this.setState({converterForm: updatedConverterForm, formIsValid: formIsValid});
    }

    dataProcessingHandler = ( event ) => {
        console.log("Conversion input received");
        event.preventDefault();
        this.setState( { loading: true } );
        let conversion = {};
        for (let formElementIdentifier in this.state.converterForm) {
            conversion[formElementIdentifier] = this.state.converterForm[formElementIdentifier].value;
        }
        localStorage.setItem('conversion', JSON.stringify(conversion));
        console.log(conversion);
        this.postToBackend();
        this.props.history.push( '/conversionResult' );
    }

  

    postToBackend = () => {
        let conversionRaw = JSON.parse(localStorage.getItem('conversion'), this.axiosConfig);
        console.log("JSON object stored: ")
        console.log(conversionRaw)
        
        let conversion = {
          converter: conversionRaw.romanNumeralConverter,
          value: conversionRaw.value
        }
        console.log("Object transmitted:")
        console.log(conversion);

        var config = {headers: {'Content-Type': 'application/json','Cache-Control' : 'no-cache'}};  
    
        axios
        .post('/convert/toRoman', conversion, config)
        .then( response => {
          console.log(response)
          localStorage.setItem('conversionResult', JSON.stringify(response.data))
        }, (error) => {
            console.log(`😱 Axios request failed: ${error}`);
            console.log(error.response.data)
            localStorage.setItem('conversionResult', JSON.stringify(error.response.data))
        })
      }


    render () {

        const formElementsArray = [];
        for (let key in this.state.converterForm) {
            formElementsArray.push({
                id: key,
                config: this.state.converterForm[key]
            });
        }

        let form = (
            <div>
            <form onSubmit={this.dataProcessingHandler}>
                {formElementsArray.map(formElement => (
                    <Input 
                        key={formElement.id}
                        elementType={formElement.config.elementType}
                        elementConfig={formElement.config.elementConfig}
                        value={formElement.config.value}
                        invalid={!formElement.config.valid}
                        shouldValidate={formElement.config.validation}
                        touched={formElement.config.touched}
                        changed={(event) => this.inputChangedHandler(event, formElement.id)} />
                ))}
                <Button btnType="Success" disabled={!this.state.formIsValid}>Weiter</Button>
            </form>
            </div>);
        
        if ( this.state.loading ) {
            form = <Spinner />;

        }
        return (
            
            <div className="container">
            <div className="converter">
            <h3>Convert Roman Number</h3>
            {form}
                
            </div>
            </div>
            
        );
}
}
        

  export default Converter;