/**
 * date: 17-8-26
 * create by learnwy
 * licensed is GPL-3.0
 */
import React from 'react';
import { createStore, combineReducers } from 'redux';
import { connect, Provider } from 'react-redux';
import {
  Link,
  BrowserRouter as Router,
  Route,
  Redirect,
  Switch
} from 'react-router-dom';

import { Layout, Menu, Breadcrumb, Icon } from 'antd';

import './App.css';
import { precls } from '../../utils';

const { SubMenu } = Menu;
const { Header, Content, Sider, Footer } = Layout;
const preCls = precls(`${require('../../config').precls}-App`);
const menuDir = {
  horizontal: 1,
  vertical: 2
};

function genMenu(menuData, dir) {
  let menu = [];
  for (let i = 0; i < menuData.length; i++) {
    if (menuData[i].children && menuData[i].children.length > 0) {
      menu.push(
        <SubMenu key={menuData[i].text} title={<span>{menuData[i].text}</span>}>
          {
            menuData[i].children.map((item) => {
              return <Menu.Item key={item.text}><Link
                to={item.link}>{item.text}</Link></Menu.Item>
            })
          }
        </SubMenu>
      );
    } else {
      menu.push(<Menu.Item key={menuData[i].text}><Link
        to={menuData[i].link}>{menuData[i].text}</Link></Menu.Item>)
    }
  }
  switch (dir) {
    case menuDir.horizontal:
      return <Menu
        mode="horizontal"
        styles={{ height: 64, lineHeight: 64 }}>{menu}</Menu>;
    case menuDir.vertical:
      return <Menu
        mode="inline"
        styles={{ height: '100%', borderRight: 0 }}>{menu}</Menu>;
    default:
      return null;
  }
}

export default class App extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    const { store, menuData } = this.props;
    const menuDataTEMP = [{
      text: 'learnwy',
      children: [{ text: '个人中心', link: '/user' }]
    }, { text: '时间线', link: '/timeLine' }, { text: '计数器', link: '/counter' }];
    const horizontalMenu = genMenu(menuDataTEMP, menuDir.horizontal);
    const vertocalMenu = genMenu(menuDataTEMP, menuDir.vertical);
    return (
      <Provider store={store}>
        <Router>
          <Layout style={{
            backgroundColor: '#d9d9d9',
            width: '100%',
            height: '100%',
            padding: '0'
          }}>
            <Header className={preCls('header')}>
              <div className={preCls('logo')}/>
              {horizontalMenu}
            </Header>
            <Layout style={{ height: '100%' }}>
              <Sider width={200} style={{ backgroundColor: '#fff' }}>
                {vertocalMenu}
              </Sider>
              <Layout style={{
                padding: '0 24px 24px',
                height: '100%',
                width: '100%'
              }}>
                <Content style={{ overflowY: 'auto' }}>
                  <Switch>
                    {this.props.children}
                  </Switch>
                </Content>
                <Footer style={{
                  textAlign: 'center',
                  bottom: 0,
                  backgroundColor: '#fff'
                }}>
                  Ant Design ©2016 Created by Ant UED
                </Footer>
              </Layout>
            </Layout>
          </Layout>
        </Router>
      </Provider>
    );
  }
}

