const submitButton = document.getElementById("button-submit");
const accountField = document.getElementById("input-name");
const passwordField = document.getElementById("input-password");
const repeatPasswordField = document.getElementById("repeat-password");
const emailField = document.getElementById("input-email");

const nameFailed = document.getElementById("name-failed");
const emailFailed = document.getElementById("email-failed");
const passwordFailed = document.getElementById("password-failed");
const repeatPasswordFailed = document.getElementById("repeat-password-failed");

const regExp = ".+@.+\..+";

submitButton.onclick = function(event) {

    accountField.style.boxShadow = "none";
    accountField.style.borderColor = "#ffffff";
    passwordField.style.boxShadow = "none";
    passwordField.style.borderColor = "#ffffff";
    repeatPasswordField.style.boxShadow = "none";
    repeatPasswordField.style.borderColor = "#ffffff";
    emailField.style.boxShadow = "none";
    emailField.style.borderColor = "#ffffff";
    nameFailed.innerText = "";
    emailFailed.innerText = "";
    passwordFailed.innerText = "";
    repeatPasswordFailed.innerText = "";


    if(accountField.value.length < 3 || accountField.value.length > 20) {
        accountField.style.boxShadow = "inset 0 1px 1px #fc2a2a, 0 0 13px #fc2a2a";
        accountField.style.borderColor = "#fc2a2a";
        nameFailed.innerText = "3-20 symbols";
        event.preventDefault();
    }
    if(passwordField.value.length < 5 || passwordField.value.length > 30) {
        passwordField.style.boxShadow = "inset 0 1px 1px #fc2a2a, 0 0 13px #fc2a2a";
        passwordField.style.borderColor = "#fc2a2a";
        passwordFailed.innerText = "5-30 symbols";
        event.preventDefault();
    }
    if(passwordField.value !== repeatPasswordField.value) {
        repeatPasswordField.style.boxShadow = "inset 0 1px 1px #fc2a2a, 0 0 13px #fc2a2a";
        repeatPasswordField.style.borderColor = "#fc2a2a";
        repeatPasswordFailed.innerText = "Passwords do not match";
        event.preventDefault();
    }
    if(emailField.value.search(regExp) === -1){
        emailField.style.boxShadow = "inset 0 1px 1px #fc2a2a, 0 0 13px #fc2a2a";
        emailField.style.borderColor = "#fc2a2a";
        emailFailed.innerText = "It isn't correct e-mail";
        event.preventDefault();
    }

};