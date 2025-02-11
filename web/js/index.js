/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

document.querySelectorAll(".flecha a").forEach(link => {
    link.addEventListener("click", function (event) {
        event.preventDefault(); // Evita el desplazamiento de la pantalla

        // Oculta todos los elementos del carrusel
        document.querySelectorAll(".carruselitem").forEach(item => {
            item.style.display = "none";
        });

        // Muestra el carrusel correspondiente según el enlace clicado
        const targetId = this.getAttribute("href"); // Obtiene el ID de destino del enlace
        const targetElement = document.querySelector(targetId);

        if (targetElement) {
            targetElement.style.display = "block"; // Muestra el elemento seleccionado
        } else {
            console.error("No se encontró el elemento con ID:", targetId);
        }
    });
});

// Mostrar solo el primer elemento al cargar la página
document.querySelector("#carruselitem1").style.display = "block";

document.addEventListener("DOMContentLoaded", function () {
    let carritoContainer = document.getElementById("carrito-container");
    let listaCarrito = document.getElementById("lista-carrito");

    function actualizarCarrito() {
        if (listaCarrito.children.length === 0) {
            carritoContainer.classList.add("oculto");
        } else {
            carritoContainer.classList.remove("oculto");
        }
    }

    actualizarCarrito();
});

function toggleCarrito() {
    document.getElementById("carrito-sidebar").classList.toggle("active");
}
