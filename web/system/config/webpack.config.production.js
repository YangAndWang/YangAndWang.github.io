module.exports = {
    entry: {
        index: systemPath.react.reactIndex,
        ...systemPath.react.components
    },
    devtool: 'inline-source-map',
    output: {
        path: systemPath.build,
        pathinfo: true,
        filename: 'js/[name]-[hash].js',
        chunkFilename: 'static/js/[name].chunk.js',
        devtoolModuleFilenameTemplate: info =>
            path.resolve(info.absoluteResourcePath).replace(/\\/g, '/')
    },
    resolve: {
        // Add '.ts' and '.tsx' as resolvable extensions.
        extensions: ['.ts', '.tsx', '.js', '.json'],
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
        rules: [{
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
                test: /\.sass$/,
                use: ExtractTextPlugin.extract({
                    fallback: 'style-loader',
                    use: ['css-loader', 'sass-loader']
                })
            },
            {
                test: /\.scss$/,
                use: ExtractTextPlugin.extract({
                    fallback: 'style-loader',
                    use: ['css-loader', 'scss-loader']
                })
            },
            {
                test: /\.tsx?$/,
                use: [
                    { loader: 'babel-loader' },
                    { loader: 'ts-loader' }
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
            { enforce: 'pre', test: /\.js$/, loader: 'source-map-loader' }
        ]
    }

}