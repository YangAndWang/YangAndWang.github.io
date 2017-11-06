import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';
import echarts from 'echarts'

class App extends Component {
    constructor(props) {
        super(props);
        this._echartsApp = null;
    }

    async componentDidMount() {
        let appEchart = echarts.init(this._echartsApp);
        appEchart.setOption({
            title: {text: 'ECharts 入门示例'},
            tooltip: {},
            xAxis: {
                data: ["衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子"]
            },
            yAxis: {},
            series: [{
                name: '销量',
                type: 'bar',
                data: [5, 20, 36, 10, 10, 20]
            }]
        })
    }

    render() {
        return (
            <div
                className="App"
                style={{width: 500, height: 309}}
                ref={(app) => {
                    this._echartsApp = app;
                }}
            >

            </div>
        );
    }
}

export default App;
