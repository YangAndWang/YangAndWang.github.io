//this is my first test for nodeJs

var express = require('express');

var app = express();

app.get('/',function(req,res){
	res.send('Hello World');
 	res.send('this is your ');
});



app.listen(3000,function(){
	console.log('app is listening at port of 3000');
});
