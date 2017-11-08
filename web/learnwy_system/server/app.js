import fs from 'fs';
import http from 'http';
import https from 'https'
import server from './server'

const httpServer = http.createServer(server);

const httpsServer = https.createServer(server);


httpsServer.on('clientError', (err, socket) => {
    socket.end('HTTP/1.1 400 Bad Request\r\n\r\n');
});
httpServer.on('clientError', (err, socket) => {
    socket.end('HTTP/1.1 400 Bad Request\r\n\r\n');
});

httpServer.listen(8880);
// httpsServer.listen(443);