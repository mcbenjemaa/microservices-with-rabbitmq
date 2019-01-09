 particlesJS.load('particles-js', '/js/particles.json', function() {
     console.log('callback - particles.js config loaded');
 });

 var ws;
 var element = document.getElementById('myElement');

 connect();

 function connect() {
     ws = new WebSocket('ws://23.96.125.215:8400/result');
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


 var myBlock = document.getElementById('myElement');
 var statusBar = document.getElementById('status');
 var newPosition = {
     left: '30px',
     top: '30px'
 }

 if (!ws) {
     connect();
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
         element.style.left = obj.left;
         element.style.top = obj.top;
     }
 }