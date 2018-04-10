const selectSport = document.getElementsByClassName("nav-link");
function update(){
    alert(this.innerText);
};
selectSport[0].addEventListener("click", update());
selectSport[1].addEventListener("click", function () {
    alert(this.innerText);
});
selectSport[2].addEventListener("click", function () {
    alert(this.innerText)            ;
});
selectSport[3].addEventListener("click", function () {
    alert(this.innerText)            ;
});
selectSport[4].addEventListener("click", function () {
    alert(this.innerText)            ;
});
selectSport[5].addEventListener("click", function () {
    alert(this.innerText)           ;
});
selectSport[6].addEventListener("click", function () {
    alert(this.innerText) ;
});

