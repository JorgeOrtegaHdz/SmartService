//Script Mapa para Servlet

function main(){
  	var x = document.getElementById("map");
    var latitude, longitude;
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(showPosition);
    } else { 
      x.innerHTML = "Geolocation is not supported by this browser.";
    }

    function showPosition(position) {
      latitude=position.coords.latitude;
      longitude=position.coords.longitude;
      x.innerHTML = "Latitude: " + position.coords.latitude + 
      "<br>Longitude: " + position.coords.longitude;
      var datosJSON="https://maps.googleapis.com/maps/api/distancematrix/json?origins="+latitude+"|"+longitude+"&destinations="+latitude+"|"+longitude+"&mode=driving&language=fr-FR&key=AIzaSyDOXbhiOlje54s-im1CDxcV-cK0U6OxCB0";
      //var xmlHttp = new XMLHttpRequest(); 
      //xmlHttp.open("GET", datosJSON, false); // false for synchronous request 
      //xmlHttp.send(null); 
      //var resp=xmlHttp.responseText;
      x.innerHTML="<p>"+datosJSON+"</p>"; 
    }
}