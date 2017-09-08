/**
 * date: 17-8-26
 * create by learnwy
 * licensed is GPL-3.0
 */
import React from 'react';
import { Button } from 'antd';

export default ({ count, onInc, onDec }) => {
  return (
    <div>
      <div>{count}</div>
      <div>
        <Button onClick={onInc}>Inc</Button>
      </div>
      <div>
        <Button onClick={onDec}>Dec</Button>
      </div>
    </div>
  );
};
