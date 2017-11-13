const gulp = require('gulp')
const rm = require('gulp-rm')

const fs = require('fs')
const path = require('path')
const webpack = require('webpack-stream')
const webpackConfig = require('./webpack.config')

gulp.task('default', function () {
    gulp.src('build/js/**', {read: false})
        .pipe(rm({async: false}))
    return gulp.src('src/**')
        .pipe(webpack(webpackConfig))
        .pipe(gulp.dest('build/'))
})