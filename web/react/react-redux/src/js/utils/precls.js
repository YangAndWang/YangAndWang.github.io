/**
 * date: 17-8-26
 * create by learnwy
 * licensed is GPL-3.0
 */
import createOptions from './options';

export default function precls(pre) {
  return (...cls) => [pre, ...cls].join('-');
}
