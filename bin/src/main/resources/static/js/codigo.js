document.addEventListener("DOMContentLoaded", function () {
    // Encuentra el div con la clase "show-navbar-index".
    var navbarIndexContainer = document.querySelector(".show-navbar-index");

    // Verifica si el div con la clase "show-navbar-index" existe en la página actual.
    if (navbarIndexContainer) {
        // Código para la barra de navegación en la página de inicio
        var navbarIndex = document.createElement("nav");
        navbarIndex.className = "navbar navbar-expand-lg navbar-dark bg-dark";
        navbarIndex.innerHTML = `
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
        navbarIndexContainer.appendChild(navbarIndex);
    }

    

    // Encuentra el div con la clase "show-footer".
    var footerContainer = document.querySelector(".show-footer");

    // Verifica si el div con la clase "show-footer" existe en la página actual.
    if (footerContainer) {
        // Código para el pie de página
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


//NAV DE MANTENIMIENTO
document.addEventListener("DOMContentLoaded", function () {
    // Encuentra el div con la clase "show-navbar-mantenimiento".
    var navbarContainer = document.querySelector(".show-navbar-mantenimiento");

    // Verifica si el div con la clase "show-navbar" existe en la página actual.
    if (navbarContainer) {
        // Crea y agrega la barra de navegación solo en las páginas que contienen el div con la clase "show-navbar".
        var navbarMan = document.createElement("nav");
        navbarMan.className = "navbar navbar-dark bg-dark";
        navbarMan.innerHTML = `
        	  
        <div class="container">
            <a class="navbar-brand" href="/mantenimiento">Mantenimiento
                <i class="bi bi-gear"></i>
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasDarkNavbar" aria-controls="offcanvasDarkNavbar" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="offcanvas offcanvas-end text-bg-dark" tabindex="-1" id="offcanvasDarkNavbar" aria-labelledby="offcanvasDarkNavbarLabel">
                <div class="offcanvas-header">
                    <h5 class="offcanvas-title" id="offcanvasDarkNavbarLabel">Mantenimiento</h5>
                    <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                </div>
                <div class="offcanvas-body">
                    <div class="d-flex flex-column justify-content-between" style="height: 100%;">
                        <ul class="navbar-nav pe-3">
                            <li class="nav-item">
                                <a class="nav-link" aria-current="page" href="/listarProductos">
                                    <i class="bi bi-journal-richtext"></i>
                                    Productos
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link"  href="/categorias/listar">
                                    <i class="bi bi-tags-fill"></i>
                                    Categorias
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/trabajadores/listar">
                                    <i class="bi bi-person-workspace"></i>
                                    Trabajador
                                </a>
                            </li>
                             <li class="nav-item">
                                <a class="nav-link" href="/clientes/listar">
                                    <i class="bi bi-person-workspace"></i>
                                    Cliente
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/listarVentas">
                                    <i class="bi bi-card-checklist"></i>
                                    Boletas
                                </a>
                            </li>
                        </ul>
                        <a class="nav-link" href="/logout">
                            <i class="bi bi-box-arrow-right"></i>
                            Cerrar Sesión
                        </a>
                    </div>
                </div>
            </div>
        </div>
        `;
        navbarContainer.appendChild(navbarMan);
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
