var markers = []; // Define la variable markers como un arreglo vacío

function initMap() {
  var directionsService = new google.maps.DirectionsService();
  var directionsDisplay = new google.maps.DirectionsRenderer();
  
  var map = new google.maps.Map(document.getElementById('map'), {
    zoom: 12,
    center: {lat: 40.4168, lng: -3.7038} //coordenadas del centro de Madrid
  });




// Función para agregar un marcador en el mapa
  function addMarker(location, map) {
    var marker = new google.maps.Marker({
      position: location,
      map: map
    });
    markers.push(marker);

    var latLongString = "";//aqui meteremos la latitud y la longitud de todos los puntos
    for (var i = 0; i < markers.length; i++) {
      var latLong= markers[i].getPosition();
      var lat = latLong.lat();
      var lng = latLong.lng();
      latLongString += lat + "," + lng + "#";
      // document.getElementById("latYlong").innerHTML = latLongString += "";
      const inputCoordenadas = document.querySelector('input[placeholder="coordenadas"]');
inputCoordenadas.value = latLongString;

    }
    
  }


  // Agregar un evento de clic en el mapa
  google.maps.event.addListener(map, 'click', function(event) {
  // Agregar un marcador en la posición en la que se hizo clic
  addMarker(event.latLng, map);
  
  // Calcular la ruta entre los marcadores
  calculateAndDisplayRoute();
});

  // Función para crear una ruta entre los marcadores
function calculateAndDisplayRoute() {
  var directionsService = new google.maps.DirectionsService();//para hacer la ruta como tal
  var directionsRenderer = new google.maps.DirectionsRenderer();
  var waypts = [];
  for (var i = 0; i < markers.length; i++) {
    waypts.push({
      location: markers[i].getPosition(),
      stopover: true
    });
  }
  directionsService.route({
    origin: waypts[0].location,
    destination: waypts[waypts.length - 1].location,
    waypoints: waypts.slice(1, -1),
    optimizeWaypoints: true,
    travelMode: 'DRIVING'
  }, function(response, status) {
    if (status === 'OK') {
      directionsRenderer.setDirections(response);
    } else {
      window.alert('No se pudo calcular la ruta: ' + status);
    }
  });
  directionsRenderer.setMap(map);
}

    // Agregar evento onclick al botón
    document.getElementById("button").onclick = function () {
      deleteMarkers();
    };

    // Mostrar botón después de cargar el mapa
    document.getElementById("button").style.display = "block";

    function deleteMarkers() {
  // Eliminar los marcadores del mapa
  for (var i = 0; i < markers.length; i++) {
    markers[i].setMap(null);
  }

  // Vaciar el arreglo de marcadores
  markers = [];

  // Eliminar la ruta del mapa
  directionsDisplay.set('directions', null);
}
}//FIN initMap()