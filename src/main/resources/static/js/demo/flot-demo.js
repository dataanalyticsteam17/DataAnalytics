
//Flot Multiple Axes Line Chart
$(function() {
    function gd(year,month,day){
        return new Date(year,month-1,day).getTime();
    }

    var stocksData1=[ [gd(2012, 1, 1), 14], [gd(2012, 2, 1), 17], [gd(2012, 3, 1), 19],
        [gd(2012, 4, 1), 19], [gd(2012, 5, 1), 16], [gd(2012, 6, 1), 20], [gd(2012, 7, 1), 21],
        [gd(2012, 8, 1), 18], [gd(2012, 9, 1), 18], [gd(2012, 10, 1), 14], [gd(2012, 11, 1), 16],[gd(2012, 12, 1), 21]];

    var stocksData2=[ [gd(2012, 1, 1), 34], [gd(2012, 2, 1), 32], [gd(2012, 3, 1), 34],
        [gd(2012, 4, 1), 35], [gd(2012, 5, 1), 38], [gd(2012, 6, 1), 35], [gd(2012, 7, 1), 34],
        [gd(2012, 8, 1), 32], [gd(2012, 9, 1), 30], [gd(2012, 10, 1), 33], [gd(2012, 11, 1), 34],[gd(2012, 12, 1), 33]];


    function euroFormatter(v, axis) {
        return v.toFixed(axis.tickDecimals);
    }

    function doPlot(position) {
        $.plot($("#flot-line-chart-multi"), [{
            data: stocksData1,
            label: "stock 1"
        }, {
            data: stocksData2,
            label: "stock 2"
        }], {
            xaxes: [{
                mode: 'time',
                timeformat:'%y/%0m/%0d'
            }],
            yaxes: [{
                min: 0
            }, {
                // align if we are to the right
                alignTicksWithAxis: position == "right" ? 1 : null,
                position: position,
                tickFormatter: euroFormatter
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
                borderWidth:0,
                hoverable: true //IMPORTANT! this is needed for tooltip to work,

            },
            tooltip: true,
            tooltipOpts: {
                // content: "%s %x 为 %y",
                content: "%y",
                // xDateFormat: "%y-%0m-%0d",

                onHover: function(flotItem, $tooltipEl) {
                    // console.log(flotItem, $tooltipEl);
                }
            }

        });
    }

    doPlot("right");

    $("button").click(function() {
        doPlot($(this).text());
    });
});




