// 引入 ECharts 主模块
import BaseEcharts from "../echarts.use.base";

let echarts = require('echarts/lib/echarts');
// 引入柱状图
require('echarts/lib/chart/pie');
// 引入提示框和标题组件
require('echarts/lib/component/tooltip');
require('echarts/lib/component/title');

export default class AngleExample extends BaseEcharts {
    constructor(props) {
        super(props)
    }

    componentDidMount() {
        super.setOption({
            series: [
                {
                    name: '访问来源',
                    type: 'pie',
                    radius: '55%',
                    data: [
                        {value: 235, name: '视频广告'},
                        {value: 274, name: '联盟广告'},
                        {value: 310, name: '邮件营销'},
                        {value: 335, name: '直接访问'},
                        {value: 400, name: '搜索引擎'}
                    ]
                }
            ]
        });
    }
}
