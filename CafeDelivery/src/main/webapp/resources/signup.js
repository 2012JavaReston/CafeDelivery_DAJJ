const form = document.querySelector(".form")
const error = document.getElementById("error")
const username = document.getElementById("username")
const fName = document.getElementById("fName")
const lName = document.getElementById("lName")
const password = document.getElementById("password")
const cPassword = document.getElementById("cPassword")
function submitForm(){
    if(isValid()){
        form.submitForm
    }
}
function isValid() {
    let isValid = false
    if(!username.value){
        error.innerText = "ERROR: Must include username"
    } else if(!fName.value){
        error.innerText = "ERROR: Must include first name"
    } else if(!lName.value){
        error.innerText = "ERROR: Must include last name"
    } else if(!password.value.length){
        error.innerText = "ERROR: Must include password"
    } else if(!cPassword.value){
        error.innerText = "ERROR: Must include 'confirm password'"
    } else if(password.value.length <= 2){
        error.innerText = "ERROR: Password length must be greater than 2"
    } else if(password.value != cPassword.value){
        error.innerText = "ERROR: Passwords do not match"
    } else {
        error.innerText = ""
        isValid = true
    }
    return isValid
}