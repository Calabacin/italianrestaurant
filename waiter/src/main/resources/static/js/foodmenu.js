var menuStompClient = null;


function connectToMenu() {
    var socket = new SockJS('/gs-guide-websocket');
    menuStompClient = Stomp.over(socket);
    menuStompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        menuStompClient.subscribe('/topic/menu', function (message) {
            showMenu(JSON.parse(message.body));
        });
    });
}

function showMenu(menu) {
    console.log("Showing menu: " + JSON.stringify(menu));
    
    var starters = menu.starters;
    var main = menu.main;
    var deserts = menu.deserts;
    
    $("#foodmenu").text("");
    
    $("#foodmenu").append("<h4>Starters</h4>");
    $(starters).each(function(index, dish){
        $("#foodmenu").append("<div class='foodlink'>" + dish.name +"</div>");
    });
    
    $("#foodmenu").append("<h4>Main</h4>");
    $(main).each(function(index, dish){
        $("#foodmenu").append("<div class='foodlink'>"+ dish.name +"</div>");
    });
    
    $("#foodmenu").append("<h4>Desert</h4>");
    $(deserts).each(function(index, dish){
        $("#foodmenu").append("<div class='foodlink'>"+ dish.name +"</div>");
    });
    
    $('.foodlink').click(function(){
        var dishName = $(this).text();
        console.log(dishName);
        $.get("http://" + window.location.host +"/order/" + dishName, function( data ) {
            $("#waiter-message").text(data)
          }, "plain/text");
    });
    
}

$(function () {
    connectToMenu();
});