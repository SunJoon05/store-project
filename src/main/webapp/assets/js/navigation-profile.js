const NavigationProfile = (() => {

    const navigation_elements = () => {
        const navigation_options = document.querySelectorAll(".navigation-profile__option");
        const navigation_sections = document.querySelectorAll(".user__profile-section");

        return { navigation_options, navigation_sections };
    }

    const execute = () => {
        const { navigation_options, navigation_sections } = navigation_elements();

        navigation_options.forEach(option => {
            option.addEventListener("click", () => {
                const target = option.dataset?.option;
                console.log(target)

                navigation_sections.forEach(section => {
                    const section_id = section.dataset?.sectionId;

                    if (section_id === target) {
                        console.log(section_id)
                        section.classList.remove("--hidden");
                        section.classList.add("--visible")
                    } else {
                        section.classList.remove("--visible");
                        section.classList.add("--hidden");
                    }
                });
            })
        })
    }

    return { execute };
})();

document.addEventListener("DOMContentLoaded", () => {
    NavigationProfile.execute();
})