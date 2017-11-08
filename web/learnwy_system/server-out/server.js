'use strict';

var _url = require('url');

var _url2 = _interopRequireDefault(_url);

var _path = require('path');

var _path2 = _interopRequireDefault(_path);

var _fs = require('fs');

var _fs2 = _interopRequireDefault(_fs);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

const request = {
    headers: {
        host: 'localhost:8880',
        connection: 'keep-alive',
        'cache-control': 'max-age=0',
        'user-agent': 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.75 Safari/537.36',
        'upgrade-insecure-requests': '1',
        accept: 'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8',
        'accept-encoding': 'gzip, deflate, br',
        'accept-language': 'en-US,en;q=0.9',
        cookie: 'Idea-e2fee4d9=50cb4c5e-ee15-4d9e-a43a-23402df29251'
    }
};

const pathReg = /^[a-zA-Z_0-9]+$/;

function checkPath(path) {
    return pathReg.test(path);
}

class Path {
    constructor(path) {
        if (checkPath(path)) {
            this.path = path;
            this.callbacks = [];
            this.callbackOne = [];
            this.children = {};
        }
    }
}

const listens = Path("/");
listens.path = "";
listens.callbacks.push(function (req, res) {
    res.write('hello,fallback');
    res.end();
});

function dealPath(i, path, paths) {}

const server = function (request, response) {
    var currentPath = "";
    request.url.split(/[\\\/]/).forEach(dealPath);
    console.log(request.url);

    const uri = _url2.default.parse(request.url);
    server.count++;
    console.log(server.count);
    response.write('hello');
    response.end();
};

const emptyHandler = function (err, req, res) {};

server.count = 0;

module.exports = server;