//var amqp = require('amqplib/callback_api');

var ws;

connect();

function connect() {
    ws = new WebSocket('ws://192.168.99.100:30397/control');
    ws.onmessage = function(data) {
            showGreeting(data.data);
            //handleMessage(data.data);
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
