const register_section  = document.querySelector(".register-section");
const response = register_section.dataset.response;
let modal;

if (response === "ERROR") {
    modal = document.querySelector(".modal-error__card");
} else if (response === "SUCCESS") {
    modal = document.querySelector(".modal-success__card");
}

modal.classList.remove("--hidden");
modal.addEventListener("click", (e) => {
    const element = e.target;

    if (element.classList.contains("modal-close")) {
        modal.classList.add("--hidden");
    }
})