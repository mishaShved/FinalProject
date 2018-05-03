const selectSport = document.getElementsByClassName("nav-link");
document.getElementById("events-table");
var update = function(sport){

    $.ajax({
        type: "get",
        url: "/MishaBet?command=showEventsBySport",
        data: {sportType: sport === "CYBERSPORT" ? "CYBERSPORT" : this.id.toUpperCase()},
        dataType: "HTML",
        success: function (data) {

            $("#events-table").html(data);

        }
    });
};
selectSport[0].addEventListener("click", update);
selectSport[1].addEventListener("click", update);
selectSport[2].addEventListener("click", update);
selectSport[3].addEventListener("click", update);
selectSport[4].addEventListener("click", update);
selectSport[5].addEventListener("click", update);
selectSport[6].addEventListener("click", update);


