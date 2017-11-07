import React from 'react'
import PropTypes from 'prop-types'

import echarts from 'echarts/lib/echarts'


export default class BaseEcharts extends React.Component {
    constructor(props) {
        super(props);
        this._echartsDom = null;
        this._isInit = false;
    }

    componentDidMount() {
    }

    setOption(options) {
        if (!this._isInit) {
            let $echart = echarts.init(this._echartsDom);
            this._isInit = true;
            $echart.setOption(options);
        }
    }

    render() {
        let {width = 300, height = 300} = this.props;
        return (
            <div
                ref={(dom) => {
                    this._echartsDom = dom;
                }}
                style={{...this.props.style, ...{width, height}}}
            />
        );
    }

}

BaseEcharts.propTypes = {
    width: PropTypes.oneOfType(PropTypes.number, PropTypes.string),
    height: PropTypes.oneOfType(PropTypes.number, PropTypes.string)
};
