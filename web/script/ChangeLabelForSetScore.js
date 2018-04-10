
const selectOpt = document.getElementById('event');
selectOpt.addEventListener("change", function(){
    const elem = this.selectedOptions[0].innerText.split(" ");
    document.getElementById('score1-label').innerHTML = "Score " + elem[0];
    document.getElementById('score2-label').innerHTML = "Score " + elem[2];
});
