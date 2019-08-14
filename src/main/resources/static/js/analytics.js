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

function strToDate(dateStr) {
    var year = dateStr.substring(0, 4);
    var month = dateStr.substring(4, 6);
    var day = dateStr.substring(6, 8);
    return new Date(Date.UTC(year, month - 1, day)).getTime();
}

function euroFormatter(v, axis) {
    return v.toFixed(axis.tickDecimals);
}

var stockDatas = new Array();
var stockSymbols = new Array();
var plotData=new Array();

function severalDaysPlot(position,days) {
    $.plot($("#flot-line-chart"), plotData, {
        xaxes: [{
            mode: 'time',
            tickSize: [days, "day"],
            timeformat: '%y/%0m/%0d',
        }],
        yaxes: [{
            // min: 0
        }, {
            alignTicksWithAxis: position == "right" ? 1 : null,
            position: position,
            tickFormatter: euroFormatter,
            tickDecimals: 4
        }],
        legend: {
            position: 'ne'
        },
        colors: ["#1ab394"],
        grid: {
            color: "#999999",
            hoverable: true,
            clickable: true,
            tickColor: "#D4D4D4",
            borderWidth: 0,
            hoverable: true

        },
        tooltip: true,
        tooltipOpts: {
            content: function (label, xval, yval) {
                var content = "%s %x is " + yval;
                return content;
            },
            xDateFormat: "%y-%0m-%0d",
            onHover: function (flotItem, $tooltipEl) {
                // console.log(flotItem, $tooltipEl);
            }
        }
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
            //$("#analytics-table").remove();
            body="<div class=\"col-lg-12\" id=\"analytics-table\">\n" +
                "                                <div class=\"ibox float-e-margins\">\n" +
                "                                    <div class=\"ibox-title\">\n" +
                "                                        <h5>"+$("#stock-list").val()+"   "+startDate +" to "+ endDate +"</h5>\n" +
                "                                    </div>\n" +
                "                                    <div class=\"ibox-content\" >\n" +
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
                "                                    <div class=\"ibox-content\" >\n" +
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
                "                            </div>";
            body+="<div class=\"row\">\n" +
                "                    <div class=\"col-lg-12\">\n" +
                "                        <div class=\"ibox float-e-margins\">\n" +
                "                            <div class=\"ibox-title\">\n" +
                "                                <h5>Line Chart</h5>\n" +
                "                                <div class=\"ibox-tools\">\n" +
                "                                    <a class=\"collapse-link\">\n" +
                "                                        <i class=\"fa fa-chevron-up\"></i>\n" +
                "                                    </a>\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                            <div class=\"ibox-content\">\n" +
                "                                <div class=\"flot-chart\">\n" +
                "                                    <div class=\"flot-chart-content\" id=\"flot-line-chart\"></div>\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>";
            $("#analytics-content").append(body);

            $.ajax({
                type: 'GET',
                url: '/getAnalyticsData',
                dataType: 'json',
                data: {stockSymbol:$("#stock-list").val() , startDate: startDate, endDate: endDate},
                success: function (data) {
                    var index = 0;
                    $.each(data, function (key, values) {
                        stockDatas[index] = new Array();
                        stockSymbols[index] = key;
                        $.each(values, function (i, item) {
                            stockDatas[index][i] = new Array();
                            stockDatas[index][i][0] = strToDate(item[0]);
                            stockDatas[index][i][1] = parseFloat(item[1]);
                        });
                        plotData[index]={data:stockDatas[index],label:stockSymbols[index]};
                        index = index + 1;
                    })
                    var d=15;
                    if(stockDatas[0].length<15){
                        d=1;
                    }else{
                        d=parseInt(stockDatas[0].length/15);
                        d=stockDatas[0].length/d;
                    }
                    console.log(stockSymbols);
                    severalDaysPlot($(this).text(), days=d);
                }
            });

        },
        error: function () {

        },
    });


}