$(document).ready(function(){
    init();
});

function init() {
    var body1="";
    $("#stock-list").html("");
    $.ajax({
        type: 'GET',
        url: '/getAllStockName',
        data:{},
        success: function (data) {
            $.each(data, function(i, item) {
                body1 +="<option>"+item+"</option>"
            });
            $("#stock-list").append(body1);
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

    var endTime = $("#end-time").val()
    var endYear = endTime.substring(0,4);
    var endMonth = endTime.substring(5,7);
    var endDay = endTime.substring(8,10);
    var endDate = endYear+endMonth+endDay;

    $.ajax({
        type: 'GET',
        url: '/analyticsStock',
        data:{startDate:startDate, endDate:endDate, stockName:$("#stock-list").val()},
        success: function (data) {
            body="<div class=\"col-lg-12\">\n" +
                "                                <div class=\"ibox float-e-margins\">\n" +
                "                                    <div class=\"ibox-title\">\n" +
                "                                        <h5>"+$("#stock-list").val()+"   "+startDate +" to "+ endDate +"</h5>\n" +
                "                                    </div>\n" +
                "                                    <div class=\"ibox-content\">\n" +
                "                                        <div class=\"row\">\n" +
                "                                            <div class=\"col-xs-3\">\n" +
                "                                                <small class=\"stats-label\">High Price(value/date)</small>\n" +
                "                                                <h4>"+data.high_price.value+" / "+data.high_price.date+"</h4>\n" +
                "                                            </div>\n" +
                "\n" +
                "                                            <div class=\"col-xs-3\">\n" +
                "                                                <small class=\"stats-label\">High Up(value/date)</small>\n" +
                "                                                <h4>"+data.high_priceup.value+" / "+data.high_priceup.date+"</h4>\n" +
                "                                            </div>\n" +
                "                                            <div class=\"col-xs-3\">\n" +
                "                                                <small class=\"stats-label\">High Diff(value/date)</small>\n" +
                "                                                <h4>"+data.high_diff.value+" / "+data.high_diff.date+"</h4>\n" +
                "                                            </div>\n" +
                "                                            <div class=\"col-xs-3\">\n" +
                "                                                <small class=\"stats-label\">High Volume(value/date)</small>\n" +
                "                                                <h4>"+data.high_volume.value+" / "+data.high_volume.date+"</h4>\n" +
                "                                            </div>\n" +
                "                                        </div>\n" +
                "                                    </div>\n" +
                "                                    <div class=\"ibox-content\">\n" +
                "                                        <div class=\"row\">\n" +
                "                                            <div class=\"col-xs-3\">\n" +
                "                                                <small class=\"stats-label\">Low Price(value/date)</small>\n" +
                "                                                <h4>"+data.low_price.value+" / "+data.low_price.date+"</h4>\n" +
                "                                            </div>\n" +
                "\n" +
                "                                            <div class=\"col-xs-3\">\n" +
                "                                                <small class=\"stats-label\">Low Down(value/date)</small>\n" +
                "                                                <h4>"+data.low_pricedown.value+" / "+data.low_pricedown.date+"</h4>\n" +
                "                                            </div>\n" +
                "                                            <div class=\"col-xs-3\">\n" +
                "                                                <small class=\"stats-label\">Low Diff(valuae/dte)</small>\n" +
                "                                                <h4>"+data.low_diff.value+" / "+data.low_diff.date+"</h4>\n" +
                "                                            </div>\n" +
                "                                            <div class=\"col-xs-3\">\n" +
                "                                                <small class=\"stats-label\">Low Volume(value/date)</small>\n" +
                "                                                <h4>"+data.low_volume.value+" / "+data.low_volume.date+"</h4>\n" +
                "                                            </div>\n" +
                "                                        </div>\n" +
                "                                    </div>\n" +
                "                                    <div class=\"ibox-content\">\n" +
                "                                        <div class=\"row\">\n" +
                "                                            <div class=\"col-xs-3\">\n" +
                "                                                <small class=\"stats-label\">Avg Price</small>\n" +
                "                                                <h4>"+data.avg_price+"</h4>\n" +
                "                                            </div>\n" +
                "\n" +
                "                                            <div class=\"col-xs-3\">\n" +
                "                                                <small class=\"stats-label\">Avg Change</small>\n" +
                "                                                <h4>"+data.avg_pricechange+"</h4>\n" +
                "                                            </div>\n" +
                "                                            <div class=\"col-xs-3\">\n" +
                "                                                <small class=\"stats-label\">Avg Diff</small>\n" +
                "                                                <h4>"+data.avg_diff+"</h4>\n" +
                "                                            </div>\n" +
                "                                            <div class=\"col-xs-3\">\n" +
                "                                                <small class=\"stats-label\">Avg Volume</small>\n" +
                "                                                <h4>"+data.avg_volume+"</h4>\n" +
                "                                            </div>\n" +
                "                                        </div>\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "                            </div>"
            $("#analytics-content").append(body);
        },
        error: function () {

        },
    });


}