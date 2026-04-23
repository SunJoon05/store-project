const avatar_input = document.querySelector("#profile_picture");
const avatar_preview = document.querySelector(".account-settings__avatar-img");

avatar_input.addEventListener("change", (event) => {
    const file = event.target.files[0];

    if (!file) return;
    avatar_preview.src = URL.createObjectURL(file);

    console.log(avatar_input.value);
})