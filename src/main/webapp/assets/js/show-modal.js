// refactor this code

const sections = [
    {selector: document.querySelector(".register-section")},
    {selector: document.querySelector(".login-section")}
]

const register_section  = sections.find(section => section.selector).selector;
console.log(register_section)
const response = register_section.dataset.response;
let modal;

console.log(modal, response);


if (response === "rejected") {
    modal = document.querySelector(".modal-error__card");
} else if (response === "success") {
    modal = document.querySelector(".modal-success__card");
}

modal.classList.remove("--hidden");
console.log(modal);
modal.addEventListener("click", (e) => {
    const element = e.target;

    if (element.classList.contains("modal-close")) {
        modal.classList.add("--hidden");
    }
})