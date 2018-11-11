//var amqp = require('amqplib/callback_api');

var ws;

connect();

function connect() {
    ws = new WebSocket('ws://localhost:8400/result');
    ws.onmessage = function(data) {
            showGreeting(data.data);
            console.log('result:' + data.data);
            handleMessage(data.data);
        }
        //setConnected(true);
}

function disconnect() {
    if (ws != null) {
        ws.close();
    }
    //setConnected(false);
    console.log("Disconnected");
}

function sendNewPosition(position) {
    ws.send(position);
}

function showGreeting(message) {
    console.log('greetings: ' + message);
    //$("#greetings").append(" " + message + "");
}

function handleMessage(message) {
    if (message.includes('left') && message.includes('top')) {
        var obj = JSON.parse(message);
        elem.style.left = posX + "px";
        elem.style.top = posY + "px"

    }
}