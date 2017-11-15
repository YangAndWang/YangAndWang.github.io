var $, jQuery

interface GreetDate {
    id: number
    content: string
}

$(document).ready(function () {
    $.ajax({
        url: "http://rest-service.guides.spring.io/greeting"
    }).then(function (data: GreetDate) {
        $('.greeting-id').append(data.id);
        $('.greeting-content').append(data.content);
    });
});