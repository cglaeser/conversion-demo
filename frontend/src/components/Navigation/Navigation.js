import React, {Component} from 'react';
import './Navigation.css';

class Navigation extends Component {

    constructor(props) {
        super(props)

        this.state = {};

    }


    render() {
        return (
            <div>
                <h2>Navigation</h2>
                <a href="/">Start Page</a> -- <a href="/convert">Convert Numbers to Roman numbers</a>
                <p>&nbsp;</p>
            </div>
        )
    }
}

export default Navigation