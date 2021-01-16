const error = document.getElementById("error")
const username = document.getElementById("username")
const password = document.getElementById("password")
function submitForm(){
    error.innerText = ""
    if(isValid()){
        const HTTP = new XMLHttpRequest()
        HTTP.onreadystatechange = e => {
            if(HTTP.readyState == 4 && HTTP.status == 200){
                window.location.assign(HTTP.responseURL)
            } else if(HTTP.readyState == 4 && HTTP.status == 401){
                error.innerText = "Error: the username or password was incorrect."
            }
        }
        HTTP.open("POST", "/CafeDelivery/api/login");
        HTTP.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        HTTP.send(JSON.stringify({ "username": `${username.value}`, "password": `${password.value}` }))
    }
}

function isValid() {
    let isValid = true
    if(username.value.length === 0){
        error.innerText = "Error: Must include username"
        isValid = false
    } else if (password.value.length === 0) {
        error.innerText = "Error: Must include password"
        isValid = false
    }
    return isValid
}