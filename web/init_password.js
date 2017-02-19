// c is the keyMap 
// c 是 生成密钥的字典
var d=f='',c="qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM`~!@#$%^&*-+=|{}[]:;'<>,.?/123456789".split('');
for(let i=0;i<30;i++) {
  f= c[e=~~(Math.random()*c.length)];
  d+=f;
}
