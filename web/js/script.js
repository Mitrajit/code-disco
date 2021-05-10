console.log("Hello World");
Time();
var interval;
let timezone = Intl.DateTimeFormat().resolvedOptions().timeZone;
function Time() {
    clearInterval(interval);
    document.getElementById("Stopwatch").classList.add("visually-hidden");
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
    document.getElementById("Stopwatch").classList.remove("visually-hidden");
}
let timing = 0;
function initiatestopwatch(action) {
    if (action == "start") {
        interval = setInterval(() => {
            document.getElementById("stopwatch_time").innerText = Math.floor(timing / (10 * 60 * 60)).toLocaleString("en-US", { minimumIntegerDigits: 2 }) + ":" + (Math.floor(timing / (10 * 60))%60).toLocaleString("en-US", { minimumIntegerDigits: 2 }) + ":" + (Math.floor(timing / (10))%60).toLocaleString("en-US", { minimumIntegerDigits: 2 }) + "." + (timing%10).toLocaleString("en-US", { minimumIntegerDigits: 2 });
            timing += 1;
        }, 100);
        document.getElementById("initiatestopwatch").innerText = "Stop";
    }
    else {
        clearInterval(interval);
        document.getElementById("initiatestopwatch").innerText = "Start";
    }
}
function resetstopwatch() {
    clearInterval(interval);
    timing=0;
    document.getElementById('stopwatch_time').innerText = '00:00:00.00';
    document.getElementById("initiatestopwatch").innerText = "Start";
}
