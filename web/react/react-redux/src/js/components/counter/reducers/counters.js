/**
 * date: 17-8-26
 * create by learnwy
 * licensed is GPL-3.0
 */

import { INCREMENT, DECREMENT } from '../constants';

const initialState = {
  count: 0
};

export default function counters(state = initialState, action) {
  switch (action.type) {
    case INCREMENT:
      console.log(state);
      return { count: state.count + 1 };
    case DECREMENT:
      console.log(state);
      return { count: state.count - 1 };
    default:
      return state;
  }
}
