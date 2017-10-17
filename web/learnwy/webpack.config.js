const webpack = require('webpack');
const path = require('path');
const fs = require('fs');
const ExtractTextPlugin = require('extract-text-webpack-plugin');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
  entry: { app: 'app.js' },
  devtool: 'source-map',
  output: {
    filename: '[name].min.js',
    chunkFilename: '[name].min.js',
    path: 'dist'
  },
  module: {
    rules: [
      // style
      {
        test: /\.(css|less)$/,
        use: ExtractTextPlugin.extract({
          fallback: 'style-loader',
          use: [{
            loader: 'css-loader',
            options: {}
          },
            {
              loader: 'less-loader',
              options: {}
            }]
        })
      },
      //   js
      {
        test: /\.js$/,
        exclude: /(node_modules|bower_components)/,
        use: [
          {
            loader: 'babel-loader',
            options: {
              presets: ['env', 'es2017'],
              // 配置 异步懒加载 和 hack? fill
              plugins: ['syntax-dynamic-import', 'transform-runtime']
            }
          }
        ]
      },
      // html
      {
        test: /\.html$/,
        use: [
          {
            loader: 'html-loader',
            options: {
              minimize: true,
              removeComments: true,
              collapseWhitespace: false
            }
          }
        ]
      }
    ]
  },
  plugins: [
    new ExtractTextPlugin({
      // 多个css
      filename: '[name].css',
      // 一个css
      // filename: 'styles.css'
      // disable: false,
      // allChunks: true
    }),
    // new webpack.optimize.UglifyJsPlugin({
    //   compress: {
    //     // warnings: false
    //   }
    // }),
    new HtmlWebpackPlugin({
      template: entryHTML,
      filename: 'index.html',
      inject: 'body',
      hash: true
    }),
    // 生产环境 开发使用 NamedModulesPlugin
    new webpack.NamedModulesPlugin(),
  ],
  externals: {
    jquery: 'jQuery'
  }
};
