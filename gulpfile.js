const gulp = require('gulp');

gulp.task('thymeleaf', function () {
    return gulp.src('src/main/resources/**')
        .pipe(gulp.dest('target/classes/'));
});

gulp.task('watch', function () {
    gulp.watch('src/main/resources/**', gulp.series('thymeleaf'));
});