/**
 * date: 17-8-26
 * create by learnwy
 * licensed is GPL-3.0
 */
import React from 'react';
import PropTypes from 'prop-types';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import Counter from '../components/index';
import * as CounterActions from '../actions';

const CounterContainer = ({ count, actions })=>{
  return <Counter count={count} onInc={actions.inc} onDec={actions.dec}/>;
}

CounterContainer.propTypes = {
  count: PropTypes.number.isRequired,
  actions: PropTypes.object.isRequired
};

// 由于使用combinReducers?包裹,所以绑定在counter下了
const mapStateToProps = ({ counter }) => ({
  count: counter.count
});

const mapDispatchToProps = dispatch => ({
  actions: bindActionCreators(CounterActions, dispatch)
});

export default connect(mapStateToProps, mapDispatchToProps)(CounterContainer);

