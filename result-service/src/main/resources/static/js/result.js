function handleMessage(message) {
    if (message.includes('left') && message.includes('left')) {
        var obj = JSON.parse(message);
        elem.style.left = posX + "px";
        elem.style.top = posY + "px"

    }
}