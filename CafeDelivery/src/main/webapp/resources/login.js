const error = document.getElementById("error")
const username = document.getElementById("username")
const password = document.getElementById("password")
function submitForm(){
    const HTTP = new XMLHttpRequest()
    HTTP.onreadystatechange = e => {
        if(HTTP.readyState == 4 && HTTP.status == 200){
            console.log("Success")
        }
    }
    HTTP.open("POST", "/CafeDelivery/api/login");
    HTTP.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    HTTP.send(JSON.stringify({ "username": `${username.value}`, "password": `${password.value}` }));
}