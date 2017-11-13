const webpack = require('webpack')
const path = require('path')
const fs = require('fs')
const webpackDevServer = require('webpack-dev-server')

const HtmlWebpackPlugin = require('html-webpack-plugin')
const ExtractTextPlugin = require('extract-text-webpack-plugin')

function toReactName(dirName) {
    return dirName.split('_').map((s) => {
        return [s[0].toUpperCase(), s.substr(1)].join('')
    }).join('')
}

const components = {}
fs.readdirSync(path.resolve(__dirname, '../src/components'))
// .filter((dirName) => {
//     return /^[a-z]+[a-z_]*[a-z]+$/.test(dirName)
// })
    .map((dirName) => {
        return components[dirName] = path.resolve(__dirname, `../src/components/${dirName}/${toReactName(dirName)}.tsx`)
    })
console.log(components)
const paths = require('./paths')
const publicPath = '/'

module.exports = {
    devtool: "source-map",
    entry: {...components, index: paths.appIndex},
    output: {
        path: path.resolve(__dirname, '../build'),
        pathinfo: true,
        filename: 'js/[name]-[hash].js',
        chunkFilename: 'static/js/[name].chunk.js',
        publicPath: publicPath,
        devtoolModuleFilenameTemplate: info =>
            path.resolve(info.absoluteResourcePath).replace(/\\/g, '/')
    },
    resolve: {
        // Add '.ts' and '.tsx' as resolvable extensions.
        extensions: [".ts", ".tsx", ".js", ".json"],
        modules: ['src/components', 'node_modules']
    },
    plugins: [
        new HtmlWebpackPlugin({
            // inject:true
            template: path.resolve(__dirname, '../src/index.html')
        }),
        new webpack.optimize.CommonsChunkPlugin({
            name: 'common' // Specify the common bundle's name.
        }),
        new ExtractTextPlugin({
            filename: 'css/[name].css'
        })
    ],
    module: {
        rules: [
            {
                test: /\.css$/,
                use: ExtractTextPlugin.extract({
                    fallback: 'style-loader',
                    use: ['css-loader', 'postcss-loader']
                })
            },
            {
                test: /\.less$/,
                use: ExtractTextPlugin.extract({
                    fallback: 'style-loader',
                    use: ['css-loader', 'less-loader']
                })
            },
            {
                test: /\.tsx?$/,
                use: [
                    {loader: 'babel-loader'},
                    {loader: 'ts-loader'}
                ],
                exclude: /node_modules/
            },
            {
                test: /\.(png|jpg|jpeg|gif|eot|ttf|woff|woff2|svg|svgz)(\?.+)?$/,
                exclude: /favicon\.png$/,
                use: [{
                    loader: 'url-loader',
                    options: {
                        limit: 10000
                    }
                }]
            },

            // All output '.js' files will have any sourcemaps re-processed by 'source-map-loader'.
            {enforce: "pre", test: /\.js$/, loader: "source-map-loader"}
        ]
    }
}