import {Component} from 'react'
import * as ReactDom from 'react-dom'

import {Layout} from 'antd'

const {Header,Content,Sider,Footer} = Layout
ReactDom.render(
    <Layout>
        <Header></Header>        
    </Layout>,
    document.getElementById('app')
)