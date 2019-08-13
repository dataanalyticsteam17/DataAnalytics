$(document).ready(function(){
    init();
});

function init(){
    var body1="";
    $("#stock-list").html("");
    $.ajax({
        type: 'GET',
        url: '/getAllStockName',
        dataType: 'json',
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

function confirm(){
    var array = [];
    $("#selected-list").find("tr").each(function(){
        var tdArr = $(this).children();
        var stockName = tdArr.eq(0).text();//收入类别
        array.push(stockName);
        //alert(stockName);
        // alert(history_income_money);
        // alert(history_income_remark);
    });
    // $(".input-mini").each(function(index,item){
    //     if($(this).is(":checked")){
    //         // alert($(this).parent().text());
    //         array.push($(this).parent().text());
    //     }
    // });
    $.ajax({
        type: 'GET',
        url: '/selectStock',
        dataType: 'json',
        data:{stocks:array},
        success: function (data) {
            console.log(123)
            window.location.href="home";
        },
        error: function (date) {
            console.log("error",date)
            window.location.href="home";
        },
    });
}

function deleteStock() {
    alert("sb");
}

function deleteTr(obj){
//obj也就是按钮的父元素是tr的话
    $(obj).parent().parent().remove();
}

$(function(){
    $('#stock-list').change(function(){
        var data= $(this).val();
        var body = "";
        body +="<tr>";
        body +="<td>";
        body += data;
        body +="</td>"
        body +="<td><a onclick=\"deleteTr(this)\"><i class=\"fa fa-check text-navy\"></i></a>" + "</td>";
        body +="</tr>"
        $('#selected-list').append(body);
    });
});