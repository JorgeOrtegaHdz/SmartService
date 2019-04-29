//Script Mapa para Servlet

(function (){
	var output = document.getElementById("map");
	if(navigator.geolocation){
		output.innerHTML="<p>Geolocalizando</p>";
		var latitude,longitude;
		latitude,longitude=localizacion();
		output.innerHTML="<p>Latitud: "+latitude+" Longitude: "+longitude+"</p>";
	}else{
		output.innerHTML="Tu navegador es demaciado antiguo, por favor actulizalo";
	}
        
        function localizacion(posicion){
            var latitude=posicion.coords.latitude;
            var longitude=position.coords.longitude;
            return latitude,longitude;
        }

        function errorLoc(){
                var outError=document.getElementById("error");
                outError.innerHTML("<p>No se pudo obtener tu ubicación</p>");
        }
        
        navigator.geolocation.getCurrentPosition(localizacion,errorLoc);
}).call(this);