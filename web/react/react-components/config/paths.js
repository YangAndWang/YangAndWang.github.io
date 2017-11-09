const path = require('path')
module.exports = {
    appPublic: path.resolve(__dirname, '../public'),
    output: {
        publicPath: path.resolve(__dirname, '../build')
    },
    appIndex:path.resolve(__dirname,'../src/index.tsx')
}