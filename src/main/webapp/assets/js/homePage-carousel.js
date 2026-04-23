const carousel = document.getElementById("carousel");

carousel.innerHTML += carousel.innerHTML;

carousel.addEventListener("scroll", () => {

    const scrollWidth = carousel.scrollWidth / 2;

    if (carousel.scrollLeft >= scrollWidth) {
        carousel.style.scrollBehavior = "auto";
        carousel.scrollLeft -= scrollWidth;
        carousel.style.scrollBehavior = "smooth";
    }

    if (carousel.scrollLeft <= 0) {
        carousel.style.scrollBehavior = "auto";
        carousel.scrollLeft += scrollWidth;
        carousel.style.scrollBehavior = "smooth";
    }

});
