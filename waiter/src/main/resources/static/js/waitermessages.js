var waiterMessagesStompClient = null;


function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    waiterMessagesStompClient = Stomp.over(socket);
    waiterMessagesStompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        waiterMessagesStompClient.subscribe('/topic/waitermessages', function (message) {
            showMessage(JSON.parse(message.body).content);
        });
    });
}

function showMessage(message) {
    $("#waiter-message").text(message);
}

$(function () {
    connect();
});