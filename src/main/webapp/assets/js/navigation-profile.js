

const NavigationProfile = (() => {

    const navigation_elements = () => {
        const navigation_options = document.querySelectorAll(".navigation-profile__option");
        const navigation_sections = document.querySelectorAll(".user__profile-section");

        return { navigation_options, navigation_sections };
    }

    const show_section = (target, navigation_sections) => {
        navigation_sections.forEach((section) => {
            const section_id = section.dataset?.sectionId;

            if (section_id === target) {
                section.classList.remove("--hidden");
                section.classList.add("--visible")
            } else {
                section.classList.remove("--visible");
                section.classList.add("--hidden");
            }
        });
    }

    const execute = () => {
        const { navigation_options, navigation_sections } = navigation_elements();

        const search_params = new URLSearchParams(window.location.search);
        // colocar information como section por defecto
        const param = search_params.get("section") ?? "information";
        show_section(param, navigation_sections);

        console.log(param);

        navigation_options.forEach(option => {
            option.addEventListener("click", () => {
                const target = option.dataset?.option;
                show_section(target, navigation_sections);
            })
        })
    }

    return { execute };
})();

document.addEventListener("DOMContentLoaded", () => {
    NavigationProfile.execute();
})