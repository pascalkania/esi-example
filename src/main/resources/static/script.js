

function listenEvents() {
    var out = document.querySelector("#out");
    var evt = new EventSource('/events/stream');
    evt.onmessage = (e) => {
        if(out.childElementCount > 10){
            out.removeChild(out.childNodes[0]);
        }
        var newItem = document.createElement("div");
        newItem.classList.add("event");
        var data = JSON.parse(e.data);
        newItem.innerHTML = data.id + " - " + data.titel;
        out.appendChild(newItem);
    }

    var stopBtn = document.querySelector("#stopBtn");
    stopBtn.onclick = () => evt.close();
}

var startBtn = document.querySelector("#startBtn");
startBtn.onclick = listenEvents;
