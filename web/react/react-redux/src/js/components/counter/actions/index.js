/**
 * date: 17-8-26
 * create by learnwy
 * licensed is GPL-3.0
 */
import { INCREMENT, DECREMENT } from '../constants';

// actions 用来产生一个action的方法
// {type:'xxx'[,xxx,xxx]}
export function inc(gap = 1) {
  return { type: INCREMENT, gap };
}
export function dec(gap = 1) {
  return { type: DECREMENT, gap };
}
