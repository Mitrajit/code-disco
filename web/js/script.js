console.log("Hello World");
Time();
var interval;
let timezone = Intl.DateTimeFormat().resolvedOptions().timeZone;
function Time() {
    clearInterval(interval);
    document.getElementsByClassName("Stopwatch")[0].classList.add("visually-hidden");
    document.getElementsByClassName("Stopwatch")[1].classList.add("visually-hidden");
    document.getElementById("Time").classList.remove("visually-hidden");
    interval = setInterval(() => {
        let date = new Date;
        document.getElementById("timeanddate").innerHTML = date.toLocaleString('en-US', {
            hour: 'numeric', // numeric, 2-digit
            minute: 'numeric', // numeric, 2-digit
            second: 'numeric', // numeric, 2-digit
            timeZone: timezone
        }) + "<br><h1 class=\"display-6 align-text-top\">" + date.toLocaleDateString('en-US', {
            weekday: 'long', // long, short, narrow
            day: 'numeric', // numeric, 2-digit
            year: 'numeric', // numeric, 2-digit
            month: 'long', // numeric, 2-digit, long, short, narrow
            timeZone: timezone
        }) + "</h1><h5>" + timezone + "</h5>"
    }, 1000);
}
function StopWatch() {
    clearInterval(interval);
    document.getElementById("Time").classList.add("visually-hidden");
    document.getElementsByClassName("Stopwatch")[0].classList.remove("visually-hidden");
    document.getElementsByClassName("Stopwatch")[1].classList.remove("visually-hidden");
}
let timing = 0,prevlap=0, lapind=1;
function initiatestopwatch(action) {
    if (action == "start") {
        interval = setInterval(() => {
            document.getElementById("stopwatch_time").innerText = formattime(timing);
            timing += 1;
        }, 100);
        document.getElementById("initiatestopwatch").innerText = "Stop";
        document.getElementById("lap_or_reset").innerText = "Lap";
    }
    else {
        clearInterval(interval);
        document.getElementById("initiatestopwatch").innerText = "Start";
        document.getElementById("lap_or_reset").innerText = "Reset";
    }
}
function formattime(time){
    return Math.floor(time / (10 * 60 * 60)).toLocaleString("en-US", { minimumIntegerDigits: 2 }) + ":" + (Math.floor(time / (10 * 60)) % 60).toLocaleString("en-US", { minimumIntegerDigits: 2 }) + ":" + (Math.floor(time / (10)) % 60).toLocaleString("en-US", { minimumIntegerDigits: 2 }) + "." + (time % 10);
}
function lap_or_resetstopwatch(action) {
    if (action=="Reset"){
        clearInterval(interval);
        timing = 0;
        prevlap = 0;
        lapind=1
        document.getElementById('stopwatch_time').innerText = '00:00:00.0';
        document.getElementById("initiatestopwatch").innerText = "Start";
        document.getElementById("laps").innerHTML="";
    }
    else{
        let laptime=timing-prevlap;
        prevlap = timing
        document.getElementById("laps").innerHTML+=`
        <tr>
            <th scope="row">${lapind++}</th>
            <td>${formattime(laptime)}</td>
            <td>${formattime(timing)}</td>
          </tr>`
    }
}
