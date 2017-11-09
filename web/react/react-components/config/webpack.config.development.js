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
    entry: {index: paths.appIndex, ...components},
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
        })
    ],
    module: {
        rules: [
            {
                test: /\.css$/,
                use: [
                    {loader: 'style-loader'},
                    {
                        loader: 'css-loader',
                        options: {
                            modules: true
                        }
                    }
                ]
            },
            {
                test: /\.less$/,
                use: [
                    {loader: 'style-loader'},
                    {
                        loader: 'css-loader',
                        options: {
                            modules: true
                        }
                    },
                    {
                        loader: "less-loader",
                        options: {}
                    }
                ]
            },
            {
                test: /\.tsx?$/,
                use: [
                    {loader: 'babel-loader'},
                    {loader: 'ts-loader'}
                ],
                exclude: /node_modules/
            },

            // All output '.js' files will have any sourcemaps re-processed by 'source-map-loader'.
            {enforce: "pre", test: /\.js$/, loader: "source-map-loader"}
        ]
    }
}