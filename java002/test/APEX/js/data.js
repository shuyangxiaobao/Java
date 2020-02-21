window.onload=function(){
    $.ajax({
        url: "http://rap2api.taobao.org/app/mock/233798/hangqingdata",
        type: "GET", //请求方式为get
        dataType: "json", //返回数据格式为json
        success: function (dataSource) {
            var data = dataSource.data;
            var backview = document.getElementById('cellBackView');
            backview.innerHTML = "";
            for(var i = 0; i<data.length;i++){
                var model = data[i];
                backview.innerHTML += showcell(model);
            } 
            // alert(dataSource);
            console.log(dataSource);

        }
    })
}


function showcell(model){
    return"<div class=\"div4\">\
    <div class=\"div5\">"+model.instrumentId+"</div>\
    <div class=\"div6\">"+model.lastPrice+"</div>\
    <div class=\"div7\">"+model.upDown+"</div>\
    <div class=\"div8\">"+model.volume+"</div>\
</div>";
}


