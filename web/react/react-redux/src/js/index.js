/**
 * date: 17-8-24
 * create by learnwy
 * licensed is GPL-3.0
 */
import React from 'react';
import ReactDOM from 'react-dom';
// import { autobind } from 'core-decorators';
import { createStore } from 'redux';
import { browerHistory as history } from 'react-router-dom';
import APP from './components/container/App';
import routes from './routes';
import reducers from './components/reducers';

const store = createStore(reducers);

ReactDOM.render(
  <APP store={store}>
    {routes}
  </APP>,
  document.getElementById('root')
);
