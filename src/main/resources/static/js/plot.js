//Flot Multiple Axes Line Chart
$(function () {
    var valueType=new String();
    // console.log(valueType);

    function gd(year, month, day) {
        return new Date(year, month - 1, day).getTime();
    }

    //"201601010930"
    function gd2(dateStr){
        var year=dateStr.substring(0,4);
        var month=dateStr.substring(4,6);
        var day=dateStr.substring(6,8);
        var hour=dateStr.substring(8,10);
        var minute=dateStr.substring(10,12);
        return new Date(Date.UTC(year,month-1,day,hour,minute)).getTime();
    }

    function gd3(timeStr){
        var hour=timeStr.substring(0,2);
        var minute=timeStr.substring(2,4);
        return new Date(Date.UTC(2016,0,4,hour,minute)).getTime();
    }

    var stockData1=new Array();
    var stockSymbol1=new String();

    var stockData2=new Array();
    var stockSymbol2=new String();

    var stockData2=new Array();
    var stockSymbol2=new String();

    var stockData3=new Array();
    var stockSymbol3=new String();

    var stockDatas=new Array();
    var stockSymbols=new Array();

    $('#value-list').change(function(){

        var startTime = $("#start-date").val();
        var startYear = startTime.substring(0,4);
        var startMonth = startTime.substring(5,7);
        var startDay = startTime.substring(8,10);
        var startDate = startYear+startMonth+startDay;

        var endTime = $("#end-date").val()
        var endYear = endTime.substring(0,4);
        var endMonth = endTime.substring(5,7);
        var endDay = endTime.substring(8,10);
        var endDate = endYear+endMonth+endDay;

        valueType= $(this).val();
        console.log(valueType);
        $.ajax({
            type: 'GET',
            url: '/getStockData',
            dataType: 'json',
            data: {valueType:valueType,startDate:startDate,endDate:endDate},
            success: function (data) {
                var index=0;
                $.each(data, function(key, values) {
                    stockDatas[index]=new Array();
                    stockSymbols[index]=key;
                    stockSymbol=key;
                    $.each(values,function(i,item){
                        stockDatas[index][i]=new Array();
                        // console.log(item[0]);
                        stockDatas[index][i][0]=gd2(item[0]);
                        stockDatas[index][i][1]=parseFloat(item[1]);
                    });
                    index = index+1;
                    // console.log(stockData1[i]);
                })
                console.log(stockSymbols);
                stockData1=stockDatas[0];
                stockSymbol1=stockSymbols[0];
                stockData2=stockDatas[1]; /* Rory - NAMING!!*/
                stockSymbol2=stockSymbols[1];
                stockData3=stockDatas[2];
                stockSymbol3=stockSymbols[2];
                if(startDate==endDate){
                    doPlot1($(this).text()); /* eg OneDayPlot*/
                }else{
                    doPlot2($(this).text());
                }

            }
        });
    });

    function euroFormatter(v, axis) {
        return v.toFixed(axis.tickDecimals);
    }

    function doPlot1(position) {
        $.plot($("#flot-line-chart-multi"), [{
            data: stockData1,
            label: stockSymbol1
        },{
            data: stockData2,
            label: stockSymbol2
        },{
            data: stockData3,
            label: stockSymbol3
        }], {
            xaxes: [{
                mode: 'time',
                tickSize:[1, "hour"],
                timeformat: '%y/%0m/%0d %h:%M',
            }],
            yaxes: [{
                // min: 0
            }, {
                // align if we are to the right
                alignTicksWithAxis: position == "right" ? 1 : null,
                position: position,
                tickFormatter: euroFormatter,
                tickDecimals:4
            }],
            legend: {
                position: 'sw'
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
                content: function(label, xval, yval) {
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

    function doPlot2(position) {
        $.plot($("#flot-line-chart-multi"), [{
            data: stockData1,
            label: stockSymbol1
        },{
            data: stockData2,
            label: stockSymbol2
        },{
            data: stockData3,
            label: stockSymbol3
        }], {
            xaxes: [{
                mode: 'time',
                tickSize:[3, "day"],
                timeformat: '%y/%0m/%0d',
            }],
            yaxes: [{
                // min: 0
            }, {
                // align if we are to the right
                alignTicksWithAxis: position == "right" ? 1 : null,
                position: position,
                tickFormatter: euroFormatter,
                tickDecimals:4
            }],
            legend: {
                position: 'sw'
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
                content: function(label, xval, yval) {
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




