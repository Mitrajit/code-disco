console.log("Hello World");
var interval;
let timezone = Intl.DateTimeFormat().resolvedOptions().timeZone;
let offset = moment().format("ZZ");
var time;
timezone+=" (UTC"+offset.slice(0,3)+":"+offset.slice(3)+")";
Time();
function Time() {
    clearInterval(interval);
    document.getElementsByClassName("Stopwatch")[0].classList.add("visually-hidden");
    document.getElementsByClassName("Stopwatch")[1].classList.add("visually-hidden");
    document.getElementById("Alarm").classList.add("visually-hidden");
    document.getElementById("Time").classList.remove("visually-hidden");
    tick();
    interval = setInterval(tick, 1000);
}
function tick(){
    time = moment.utc().utcOffset(offset);
    document.getElementById("timeanddate").innerHTML = time.format('hh:mm:ss A')
     + "<br><h1 class=\"display-6 align-text-top\">" + time.format('dddd, MMM DD,YYYY')
     + "</h1><h5>" + timezone + "</h5>"
    document.getElementById("Alarm").getElementsByTagName("h4")[0].innerText = "Current time "+time.format('hh:mm:ss A');
    if(document.getElementById("initiatealarm").innerText=="Reset"){
        let thespan = document.getElementById("alarm_time");
        let alarmtime = moment(thespan.getElementsByTagName("input")[0].value,"HH:mm");
        let T=moment.utc(moment(alarmtime,"HH:mm").diff(moment(time.format('hh:mm:ss A'),"hh:mm:ss A"))+1000).format(" (T-HH:mm:ss)");
        thespan.getElementsByTagName("time")[0].innerText = alarmtime.format("hh:mm A ")+T;
        if(T==" (T-00:00:00)"){
            initiatealarm("reset");
            let alarm=new Audio("./js/analog-watch-alarm.mp3");
            alarm.play();
            alert("Alarm !!!!");
        }
    }
}
function StopWatch() {
    clearInterval(interval);
    document.getElementById("Time").classList.add("visually-hidden");
    document.getElementById("Alarm").classList.add("visually-hidden");
    document.getElementsByClassName("Stopwatch")[0].classList.remove("visually-hidden");
    document.getElementsByClassName("Stopwatch")[1].classList.remove("visually-hidden");
}
function Alarm() {
    document.getElementById("Time").classList.add("visually-hidden");
    document.getElementsByClassName("Stopwatch")[0].classList.add("visually-hidden");
    document.getElementsByClassName("Stopwatch")[1].classList.add("visually-hidden");
    document.getElementById("Alarm").classList.remove("visually-hidden");
}
function initiatealarm(action) {
    let thespan = document.getElementById("alarm_time");
    if (action=="set"){
        if(thespan.getElementsByTagName("input")[0].value == "")
            return;
        thespan.getElementsByTagName("input")[0].classList.add("visually-hidden");
        thespan.getElementsByTagName("time")[0].classList.remove("visually-hidden");
        document.getElementById("initiatealarm").innerText = "Reset";
        tick();
    }
    else
    {
        thespan.getElementsByTagName("input")[0].classList.remove("visually-hidden");
        thespan.getElementsByTagName("time")[0].classList.add("visually-hidden");
        document.getElementById("initiatealarm").innerText = "Set";
    }

}
function inputalarm() {


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
