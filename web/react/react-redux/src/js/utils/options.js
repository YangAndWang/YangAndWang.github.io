/**
 * date: 17-8-23
 * create by learnwy
 * licensed is GPL-3.0
 */
/**
 * 根据option对象创建一个默认的配置代理
 * 每次调用都是返回的一个匿名Function的代理,直到调用无参方法
 * 不会出现使用createOptions时没有的key属性
 * @example const point = createOptions({x:1,y:1});
 *  point();            //{x:1,y:1}
 *  point({x:2,z:3})()  //{x:2,y:1}
 * @param option  {}
 * @returns {*}
 */
export default function createOptions(option = {}) {
  const options = Object.assign({}, option);
  const ops = new Proxy(
    function () {
    },
    {
      get (target, propKey, reciver) {
        console.log(propKey);
      },
      apply(target, thisArg, args) {
        const op = Object.assign({}, options);
        if (!args[0]) {
          return options;
        }
        let extendOp;
        for (let i = 0; i < args.length; i++) {
          extendOp = args[i];
          for (const key of Object.keys(options)) {
            if (extendOp[key]) {
              op[key] = extendOp[key];
            }
          }
        }
        return createOptions(op);
      }
    });
  return ops;
}
