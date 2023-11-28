//NAV INDEX
document.addEventListener("DOMContentLoaded", function () {
    // Encuentra el div con la clase "show-navbar".
    var navbarContainer = document.querySelector(".show-navbar-index");

    // Verifica si el div con la clase "show-navbar" existe en la página actual.
    if (navbarContainer) {
        // Crea y agrega la barra de navegación solo en las páginas que contienen el div con la clase "show-navbar".
        var navbar = document.createElement("nav");
        navbar.className = "navbar navbar-expand-lg navbar-dark bg-dark";
        navbar.innerHTML = `
        <div class="container-fluid">
            <!-- Nombre de la página en la parte izquierda -->
            <a class="navbar-brand ms-5" href="/index">HAPPY</a>
             
            <!-- Contenedor para el usuario y el carrito en la parte derecha -->
            <ul class="navbar-nav ml-auto">
                <li class="nav-item ms-2 me-2">
                    <a class="nav-link p-0" href="/venta">
                        <div class="d-flex flex-column align-items-center">
                            <i class="bi bi-search" style="font-size: 1.5em;"></i>
                            <span class="navbar-text p-0" style="font-size: 0.8em;">Buscar</span>
                        </div>
                    </a>
                </li>
                <li class="nav-item ms-2 me-2">
                    <a class="nav-link p-0" href="/carrito">
                        <div class="d-flex flex-column align-items-center">
                            <i class="bi bi-cart2" style="font-size: 1.5em;"></i>
                            <span class="navbar-text p-0" style="font-size: 0.8em;">Carrito</span>
                        </div>
                    </a>
                </li>
                <li class="nav-item ms-2 me-2">
                    <a class="nav-link p-0" href="/login">
                        <div class="d-flex flex-column align-items-center">
                            <i class="bi bi-person-fill" style="font-size: 1.5em;"></i>
                            <span class="navbar-text p-0" style="font-size: 0.8em;">Iniciar Sesión</span>
                        </div>
                    </a>
                </li>
            </ul>
        </div>
        `;
        navbarContainer.appendChild(navbar);
    }
});





// Footer
document.addEventListener("DOMContentLoaded", function () {
    // Encuentra el div con la clase "show-footer".
    var footerContainer = document.querySelector(".show-footer");

    // Verifica si el div con la clase "show-footer" existe en la página actual.
    if (footerContainer) {
        // Crea y agrega el footer solo en las páginas que contienen el div con la clase "show-footer".
        var footer = document.createElement("footer");
        footer.className = "bg-dark text-white text-center py-3";
        footer.innerHTML = `
        <p>&copy; 2023 Tu Página. Todos los derechos reservados.</p>
        <div class="d-flex justify-content-center">
            <i class="bi bi-facebook m-1" style="font-size: 1.5em;"></i>
            <i class="bi bi-instagram m-1" style="font-size: 1.5em;"></i>
            <i class="bi bi-whatsapp m-1" style="font-size: 1.5em;"></i>
        </div>
        `;
        footerContainer.appendChild(footer);
    }
});



//ANIMACION DEL BANNER DE DESCUENTO

document.addEventListener("DOMContentLoaded", function() {
    // Obtén el elemento del banner y el elemento de texto
    const discountBanner = document.getElementById('discountBanner');
    const textElement = discountBanner.querySelector('p');

    // Configura la animación
    let position = 0;
    const textWidth = textElement.offsetWidth; // Ancho del texto en pantalla
    const windowWidth = window.innerWidth; // Ancho de la ventana

    setInterval(() => {
        position -= 1; // Cambia la posición en cada intervalo (ajustado para mayor velocidad)

        // Reinicia la posición cuando el texto desaparece completamente del lado derecho
        if (position <= -textWidth) {
            position = windowWidth; // Establece la posición al ancho de la ventana
        }

        textElement.style.transform = `translateX(${position}px)`;
    }, 15); // Intervalo de tiempo en milisegundos (ajustado para mayor velocidad)
});


//ANIMACION DEL BANER PUBLICITARIO
document.addEventListener("DOMContentLoaded", function () {
    const comprarBtn = document.getElementById('comprarBtn');
    const carousel = new bootstrap.Carousel(document.getElementById('carouselExample'), {
        interval: 3000
    });
});
