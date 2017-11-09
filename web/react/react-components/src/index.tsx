import * as React from 'react'
import * as ReactDom from 'react-dom'
// import {Header} from './components/header/Header'
import {Layout} from 'antd'

const {Header, Sider, Content, Footer} = Layout
ReactDom.render(
    <Layout>
        <Header style={{height: 200}} className="learnwy-header"></Header>
        <Content style={{height: 200}} className="learnwy-content"></Content>
        <Footer style={{height: 200}} className="learnwy-footer"></Footer>
    </Layout>,
    document.getElementById('app')
)


