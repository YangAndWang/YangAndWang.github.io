const webpack = require('webpack')
const fs = require('fs')
const path = require('path')
const webpackDevServer = require('webpack-dev-server')

const HtmlWebpackPlugin = require('html-webpack-plugin')
const ExtractTextPlugin = require('extract-text-webpack-plugin')

const systemPath = require('./config/path')
require('./config/env')

module.exports = require(`./config/webpack.config.${process.env.NODE_ENV}`)