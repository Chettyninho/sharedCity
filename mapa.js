function initMap() {
      var map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: 40.4167754, lng: -3.7037902},
        zoom: 12
      });
      
      var coordenadas = document.getElementById('coordenadas').textContent;

        var coordenadasArray = coordenadas.split("#");
        console.log(coordenadasArray);
for (var i = 0; i < coordenadasArray.length; i++) {
    var coordenada = coordenadasArray[i].split(",");
    var latitud = parseFloat(coordenada[0]);
    var longitud = parseFloat(coordenada[1]);
console.log(coordenada);

    var marker = new google.maps.Marker({
        position: {lat: latitud, lng: longitud},
        map: map
    });
    
    

//    bounds.extend(marker.getPosition()); // Agregar a bounds cada punto
}

//map.fitBounds(bounds); // Ajustar mapa a los límites
    }