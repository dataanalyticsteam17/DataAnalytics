$(document).ready(function(){
    init();
});

function init(){
    var body="";
    $("#stock-list").html(body);
    $.ajax({
        type: 'GET',
        url: '/stock',
        dataType: 'json',
        data:{},
        success: function (data) {
            $.each(data, function(i, item) {
                body += "<tr>";
                body += "<td>"+item.date+"</td>";
                body += "<td>"+item.time+"</td>";
                body += "<td>"+item.open+"</td>";
                body += "<td>"+item.high+"</td>";
                body += "<td>"+item.low+"</td>";
                body += "<td>"+item.close+"</td>";
                body += "<td>"+item.volume+"</td>";
                body += "<td>"+item.split_factor+"</td>";
                body += "<td>"+item.earnings+"</td>";
                body += "<td>"+item.dividends+"</td>";
                body += "</tr>";
            });
            $("#stock-list").append(body);
            $(".odd").remove();
        },
        error: function () {

        },
    });
}