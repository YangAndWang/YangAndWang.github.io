import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';
import BarExample from "./components/echarts/bar/bar";
import AngleExample from "./components/echarts/angle/angle";

class App extends Component {
    constructor(props) {
        super(props);
    }

    async componentDidMount() {

    }

    render() {
        return (
            <AngleExample/>
        );
    }
}

export default App;
