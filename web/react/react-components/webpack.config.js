require('./config/env')


const webpackConfig = require(`./config/webpack.config.${process.env.NODE_ENV}`)


module.exports = {...webpackConfig}
