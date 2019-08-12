$(document).ready(function(){
    init();
});

function init(){
    var body1="";
    var body2="";
    var body3="";
    $("#stock-column-1").html("");
    $("#stock-column-2").html("");
    $("#stock-column-3").html("");
    $.ajax({
        type: 'GET',
        url: '/getAllStockName',
        dataType: 'json',
        data:{},
        success: function (data) {
            var index = 1;
            $.each(data, function(i, item) {
                if(index==1){
                    body1 +="<div class=\"checkbox\">";
                    body1 +="<label  for=\"closeButton\">";
                    body1 +="<input type=\"checkbox\" value=\"checked\" class=\"input-mini\" >";
                    body1 +=item;
                    body1 +="</label>";
                    body1 +="</div>";
                }
                if(index==2){
                    body2 +="<div class=\"checkbox\">";
                    body2 +="<label  for=\"closeButton\">";
                    body2 +="<input type=\"checkbox\" value=\"checked\" class=\"input-mini\" >";
                    body2 +=item;
                    body2 +="</label>";
                    body2 +="</div>";
                }
                if(index==3){
                    body3 +="<div class=\"checkbox\">";
                    body3 +="<label  for=\"closeButton\">";
                    body3 +="<input type=\"checkbox\" value=\"checked\" class=\"input-mini\" >";
                    body3 +=item;
                    body3 +="</label>";
                    body3 +="</div>";
                }
                index +=1;
                if(index==4){
                    index=1;
                }
            });
            $("#stock-column-1").append(body1);
            $("#stock-column-2").append(body2);
            $("#stock-column-3").append(body3);
            $(".odd").remove();
        },
        error: function () {

        },
    });
}

function confirm(){
    var array = [];
    $(".input-mini").each(function(index,item){
        if($(this).is(":checked")){
            alert($(this).parent().text());
            array.push($(this).parent().text());
        }
    });
    $.ajax({
        type: 'GET',
        url: '/selectStock',
        dataType: 'json',
        data:{stocks:array},
        success: function (data) {

        },
        error: function () {

        },
    });
}