/**
 * date: 17-8-26
 * create by learnwy
 * licensed is GPL-3.0
 */
import React from 'react';
import { Route } from 'react-router-dom';
import Counter from '../counter';

export default (<Route path="/counter" key="counter" component={Counter}/>);
