// c is the keyMap 
// c 是 生成密钥的字典

var aliyun = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM`~!@#$%^&*-+=|{}[]:;'<>,.?/0123456789";
var qcloud = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM()0123456789`~!@#$%^&*-+=_|{}[]:;'<>,.?/"
var d=[],f='',c=aliyun.split('');

for(let i=0;i<30;i++) {
  f=c[e=~~(Math.random()*c.length)];
  d.push(f);
}
d.join('');
