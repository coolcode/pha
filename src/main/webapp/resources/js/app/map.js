$(function() {
	// ref:
	// https://developers.google.com/maps/documentation/javascript/places#place_search_requests
	var map;
	var service;
	var infowindow;

	function initialize() {
		var pyrmont = new google.maps.LatLng(-33.8798411, 151.1821165);

		map = new google.maps.Map(document.getElementById('map'), {
			center : pyrmont,
			zoom : 15
		});

		var request = {
			location : pyrmont,
			radius : '500',
			query : 'medicine'
		};

		service = new google.maps.places.PlacesService(map);
		service.textSearch(request, callback);
	}

	function callback(results, status) {
		if (status == google.maps.places.PlacesServiceStatus.OK) {
			createMarkers(results);
		}
	}

	function createMarkers(places) {
		var bounds = new google.maps.LatLngBounds();

		for (var i = 0, place; place = places[i]; i++) {

			var marker = new google.maps.Marker(
					{
						map : map,
						icon : 'http://res.cloudinary.com/yopo/image/upload/c_scale,r_16,w_32/v1508723393/doctoronline/marker.png',
						title : place.name,
						animation : google.maps.Animation.DROP,
						position : place.geometry.location,
					 
					});

//			marker.addListener('click', function() {
//				map.setZoom(16);
//				map.setCenter(marker.getPosition());
//			});

			bounds.extend(place.geometry.location);
		}
		map.fitBounds(bounds);
	}

	var infoWindow = new google.maps.InfoWindow;

	// Try HTML5 geolocation.
	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(function(position) {
			var pos = {
				lat : position.coords.latitude,
				lng : position.coords.longitude
			};

			infoWindow.setPosition(pos);
			infoWindow.setContent('You\'re here.');
			infoWindow.open(map);
			map.setCenter(pos);
		}, function() {
			handleLocationError(true, infoWindow, map.getCenter());
		});
	} else {
		// Browser doesn't support Geolocation
		handleLocationError(false, infoWindow, map.getCenter());
	}

	function handleLocationError(browserHasGeolocation, infoWindow, pos) {
		infoWindow.setPosition(pos);
		infoWindow
				.setContent(browserHasGeolocation ? 'Error: The Geolocation service failed.'
						: 'Error: Your browser doesn\'t support geolocation.');
		infoWindow.open(map);
	}

	initialize();
});