$(document).ready(function(){
    init();
});

function init(){
    var body=""
    $("#stock-list").html(body);
    $.ajax({
        type: 'GET',
        url: '/getTheClose',
        dataType: 'json',
        data:{startTime:"20160104",endTime:"20160324"},
        success: function (data) {
            $.each(data, function(i, item) {
                body+="<tr>";
                body+="<td>"+item.stock_name+"</td>";
                body+="<td>"+item.date+"</td>";
                body+="<td>"+item.time+"</td>";
                body+="<td>"+item.open+"</td>";
                body+="<td>"+item.high+"</td>";
                body+="<td>"+item.low+"</td>";
                body+="<td>"+item.close+"</td>";
                body+="<td>"+item.volume+"</td>";
                body+="<td>"+item.split_factor+"</td>";
                body+="<td>"+item.earnings+"</td>";
                body+="<td>"+item.dividends+"</td>";
                body+="</tr>"
            });
            $("#stock-list").append(body);
            $(".odd").remove();
            $('#stock-table').dataTable({
                "destroy": true
            });
        },
        error: function () {

        },
    });
}

function confirm() {
    var startTime = $("#start-time").val();
    var startYear = startTime.substring(0,4);
    var startMonth = startTime.substring(5,7);
    var startDay = startTime.substring(8,10);
    var startDate = startYear+startMonth+startDay;
    var startHour = startTime.substring(11,13);
    var startMinute = startTime.substring(14,16);
    startTime = Number(startHour)*100 + Number(startMinute);
    alert(startTime);

    var endTime = $("#end-time").val()
    var endYear = endTime.substring(0,4);
    var endMonth = endTime.substring(5,7);
    var endDay = endTime.substring(8,10);
    var endDate = endYear+endMonth+endDay;
    var endHour = endTime.substring(11,13);
    var endMinute = endTime.substring(14,16);
    endTime = Number(endHour)*100 + Number(endMinute);

    var body=""
    $("#stock-list").html(body);
    $.ajax({
        type: 'GET',
        url: '/getStockByTime',
        dataType: 'json',
        data:{startDate:startDate, endDate:endDate, startTime:startTime, endTime:endTime},
        success: function (data) {
            $.each(data, function(i, item) {
                body+="<tr>";
                body+="<td>"+item.date+"</td>";
                body+="<td>"+item.time+"</td>";
                body+="<td>"+item.open+"</td>";
                body+="<td>"+item.high+"</td>";
                body+="<td>"+item.low+"</td>";
                body+="<td>"+item.close+"</td>";
                body+="<td>"+item.volume+"</td>";
                body+="<td>"+item.split_factor+"</td>";
                body+="<td>"+item.earnings+"</td>";
                body+="<td>"+item.dividends+"</td>";
                body+="</tr>"
            });
            $('#stock-table').DataTable().clear().destroy();
            $("#stock-list").append(body);
            $(".odd").remove();
            $('#stock-table').dataTable({
                "destroy": true
            });
        },
        error: function () {

        },
    });
}

