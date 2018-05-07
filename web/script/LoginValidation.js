const accountField = document.getElementById("input-account-number");
const passwordField = document.getElementById("input-password");
const submitButton = document.getElementById("button-submit");
const loginErrorLabel = document.getElementById("login-error");



submitButton.onclick = function(event) {


    accountField.style.boxShadow = "none";
    accountField.style.borderColor = "#ffffff";
    passwordField.style.boxShadow = "none";
    passwordField.style.borderColor = "#ffffff";

    if(accountField.value.length < 1 || accountField.value.length > 6) {
        accountField.style.boxShadow = "inset 0 1px 1px #fc2a2a, 0 0 13px #fc2a2a";
        accountField.style.borderColor = "#fc2a2a";
        loginErrorLabel.innerText = errorMessages.loginError;
        event.preventDefault();
    }

    if(passwordField.value.length < 5 || passwordField.value.length > 30) {
        passwordField.style.boxShadow = "inset 0 1px 1px #fc2a2a, 0 0 13px #fc2a2a";
        passwordField.style.borderColor = "#fc2a2a";
        loginErrorLabel.innerText = errorMessages.loginError;
        event.preventDefault();
    }
};