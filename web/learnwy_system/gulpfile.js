const gulp = require('gulp');
const babel = require('gulp-babel');
const watch = require("gulp-watch");

gulp.task('server', function () {
    gulp.src('./server/**.js')
        .pipe(babel())
        .pipe(gulp.dest('./server-out'));
});

gulp.task('client', function () {
    gulp.src('./client/**.js')
        .pipe(babel())
        .pipe(gulp.dest('./client-out'));
});

gulp.task('watch-client', function () {
    gulp.watch('./client/**', ['client']);
});
gulp.task('watch-server', function () {
    gulp.watch('./server/**.js', ['server']);
});


gulp.task('default', ['server', 'watch-server', 'client', 'watch-client'], function () {
    console.log('gen server,client and watch them')
});