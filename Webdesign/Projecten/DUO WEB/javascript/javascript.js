/* Nav bar */

$('#nav').affix({
      offset: {
        top: $('header').height()
      }
});	

$('#nav').on('affix.bs.affix', function() {
      var navHeight = $('.navbar').outerHeight(true);
       $('#nav + .container').css('margin-top', navHeight);
      
});	

$('#nav').on('affix-top.bs.affix', function() {
       $('#nav + .container').css('margin-top', 0);
      
});

/* Google maps 

function init() {
    var mapOptions = {
        center: new google.maps.LatLng(51.5860591, 4.793500600000016),
        mapTypeId: google.maps.MapTypeId.ROADMAP,
        zoom: 17
    };
 
    var myMap;
    myMap = new google.maps.Map(document.getElementById('map'), mapOptions);
}
 
function loadScript() {
    var script = document.createElement('script');
    script.src = 'http://maps.googleapis.com/maps/api/js?sensor=false&callback=init';
    document.body.appendChild(script);                 
}
 
window.onload = loadScript; */

/* carousel */

$('.carousel').carousel();