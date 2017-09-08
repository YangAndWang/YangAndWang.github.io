/**
 * date: 17-8-26
 * create by learnwy
 * licensed is GPL-3.0
 */
const webpack = require('webpack');
const path = require('path');

const HtmlWebpackPlugin = require('html-webpack-plugin');
const ExtractTextWebpackPlugin = require('extract-text-webpack-plugin');

const proto = 'http://';
const host = '127.0.0.1';
const port = 50829;

const ROOT_PATH = __dirname;
const SOURCE_PATH = path.resolve(ROOT_PATH, 'src');
const BUILD_PATH = path.resolve(ROOT_PATH, 'dist');
const index = path.resolve(SOURCE_PATH, 'js/index.js');
const htmlTemplate = path.resolve(ROOT_PATH, 'public/index.html');

module.exports = {
  entry: { index },
  output: { filename: '[name].js', path: BUILD_PATH },
  module: {
    loaders: [
      {
        test: /\.css$/,
        use: ExtractTextWebpackPlugin.extract({
          fallback: 'style-loader',
          use: [
            {
              loader: 'css-loader',
              options: {
                modules: true,
                localIdentName: '[local]'
              }
            }
          ]
        }),
        include: SOURCE_PATH
      },
      {
        test: /\.js$/,
        loader: 'babel-loader',
        include: SOURCE_PATH,
        query: { presets: ['stage-0', 'es2017', 'react'] }
      }
    ]
  },
  plugins: [
    //  组件的样式将输出到style.css
    new ExtractTextWebpackPlugin('style.css'),
    new HtmlWebpackPlugin({
      template: htmlTemplate,
      filename: 'index.html',
      chunks: {
        index
      },
      inject: 'body'
      // excludeChunks: ['index']
    }),
    new webpack.HotModuleReplacementPlugin()
  ],
  externals: {
    react: 'React',
    'react-dom': 'ReactDOM',
    'prop-types': 'PropTypes',
    'react-router': 'ReactRouter',
    'react-router-dom': 'ReactRouterDOM',
    'react-redux-dom': 'ReactReduxDOM',
    redux: 'Redux',
    'react-redux': 'ReactRedux',
    axios: 'axios',
    lodash: '_',
    antd: 'antd'
  },
  devServer: {
    hot: true,
    inline: true,
    port,
    host,
    historyApiFallback: true
  }
}
