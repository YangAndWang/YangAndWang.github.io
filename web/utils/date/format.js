const dateFormat= function (date, template) {
    if (!(date instanceof Date)) {
        date = new Date();
    }
    template = template || 'yyyy-MM-dd hh:mm:ss';
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var day = date.getDate();
    var hour = date.getHours();
    var minutes = date.getMinutes();
    var seconds = date.getSeconds();
    if (month < 10) {
        month = '0' + month;
    }
    if (day < 10) {
        month = '0' + day;
    }
    if (hour < 10) {
        hour = '0' + hour;
    }

    if (minutes < 10) {
        minutes = '0' + minutes;
    }

    if (seconds < 10) {
        seconds = '0' + seconds;
    }
    return template
        .replace('yyyy', year)
        .replace('MM', month)
        .replace('dd', day)
        .replace('hh', hour)
        .replace('mm', minutes)
        .replace('ss', seconds);
};

module.exports =dateFormat;

export default dateFormat;