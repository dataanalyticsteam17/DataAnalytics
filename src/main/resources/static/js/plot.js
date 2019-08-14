//Flot Multiple Axes Line Chart
$(function () {
    //convert string to date
    function strToDate(dateStr) {
        var year = dateStr.substring(0, 4);
        var month = dateStr.substring(4, 6);
        var day = dateStr.substring(6, 8);
        var hour = dateStr.substring(8, 10);
        var minute = dateStr.substring(10, 12);
        return new Date(Date.UTC(year, month - 1, day, hour, minute)).getTime();
    }

    var valueType = new String();
    var stockDatas = new Array();
    var stockSymbols = new Array();
    var plotData=new Array();

    $('#value-list').change(function () {
        valueType = $(this).val();
        var startTime = $("#start-date").val();
        var endTime = $("#end-date").val();
        if (valueType != "None"&&startTime!=""&&endTime!="") {
            var startYear = startTime.substring(0, 4);
            var startMonth = startTime.substring(5, 7);
            var startDay = startTime.substring(8, 10);
            var startDate = startYear + startMonth + startDay;

            var endYear = endTime.substring(0, 4);
            var endMonth = endTime.substring(5, 7);
            var endDay = endTime.substring(8, 10);
            var endDate = endYear + endMonth + endDay;

            // console.log(valueType);
            $.ajax({
                type: 'GET',
                url: '/getStockData',
                dataType: 'json',
                data: {valueType: valueType, startDate: startDate, endDate: endDate},
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
                    console.log(stockSymbols);
                    if (startDate == endDate) {
                        oneDayPlot($(this).text());
                    } else {
                        severalDaysPlot($(this).text());
                    }

                }
            });
        }
    });

    function euroFormatter(v, axis) {
        return v.toFixed(axis.tickDecimals);
    }

    function oneDayPlot(position) {
        $.plot($("#flot-line-chart-multi"),plotData, {
            xaxes: [{
                mode: 'time',
                tickSize: [1, "hour"],
                timeformat: '%y/%0m/%0d %h:%M',
            }],
            yaxes: [{
                // min: 0
            }, {
                // align if we are to the right
                alignTicksWithAxis: position == "right" ? 1 : null,
                position: position,
                tickFormatter: euroFormatter,
                tickDecimals: 4
            }],
            legend: {
                noColumns:3,
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
                xDateFormat: "%y-%0m-%0d %h:%M",
                onHover: function (flotItem, $tooltipEl) {
                    // console.log(flotItem, $tooltipEl);
                }
            }
        });
    }

    function severalDaysPlot(position) {
        $.plot($("#flot-line-chart-multi"), plotData, {
            xaxes: [{
                mode: 'time',
                tickSize: [3, "day"],
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
                noColumns:3,
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
                xDateFormat: "%y-%0m-%0d %h:%M",
                onHover: function (flotItem, $tooltipEl) {
                    // console.log(flotItem, $tooltipEl);
                }
            }
        });
    }
});




