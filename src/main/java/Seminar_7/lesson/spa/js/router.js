const routes ={
    404: "/pages/404.html",
    "/": "/pages/main.html",
    "/about": "/pages/about.html",
    "/settings": "/pages/settings.html"
}

const route = (event) => {
    event = event || window.event;
    event.preventDefault();
    window.history.pushState({}, "", event.target.href);
    handleLocation();
};

const handleLocation = async () => {
    const path = window.location.pathname; // /
    const route = routes[path] || routes[404];
    const html = await fetch(route).then((data) => data.text());
    document.getElementById("main-page").innerHTML = html;
};

window.onpopstate = handleLocation;
window.route = route;

handleLocation();

/*$("p").hide();
$("a").click(function( event ) {
  event.preventDefault();
  $( this ).hide();
});*/