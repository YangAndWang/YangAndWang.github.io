import * as React from 'react'
import * as ReactDom from 'react-dom'
import {Layout} from 'antd'
import {Header} from './components/header'
import {Content} from './components/content'

import './reset.less'
import './index.less'
const {Sider, Footer} = Layout
ReactDom.render(
    <Layout>
        <Header className={'learnwy-header'}></Header>
        <Content className={'learnwy-content'}></Content>
        <Footer style={{height: 200}} className='learnwy-footer'></Footer>
    </Layout>,
    document.getElementById('app')
)
