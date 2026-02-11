<%--
  Created by IntelliJ IDEA.
  User: alexs
  Date: 7/02/2026
  Time: 8:26 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section class="header-main --flex-center --padding-block-05">
    <div class="content-spacing">
        <div class="header-main__content --flex-space-between">
            <a class="header-main__link --flex-center --gap-05" href="http://">
                <span>
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><g fill="none" fill-rule="evenodd"><path d="m12.594 23.258l-.012.002l-.071.035l-.02.004l-.014-.004l-.071-.036q-.016-.004-.024.006l-.004.01l-.017.428l.005.02l.01.013l.104.074l.015.004l.012-.004l.104-.074l.012-.016l.004-.017l-.017-.427q-.004-.016-.016-.018m.264-.113l-.014.002l-.184.093l-.01.01l-.003.011l.018.43l.005.012l.008.008l.201.092q.019.005.029-.008l.004-.014l-.034-.614q-.005-.019-.02-.022m-.715.002a.02.02 0 0 0-.027.006l-.006.014l-.034.614q.001.018.017.024l.015-.002l.201-.093l.01-.008l.003-.011l.018-.43l-.003-.012l-.01-.01z"/><path fill="currentColor" d="M4.712 18.141c-1.537-1.69-1.957-3.828-1.77-5.738c.206-2.107 1.167-4.128 2.418-5.171c1.672-1.393 3.428-1.965 4.952-2.245a26 26 0 0 1 2.24-.283c.404-.038.813-.076 1.206-.174c.828-.207 1.645-.543 2.318-1.077c.308-.245.62-.493 1.035-.447a1 1 0 0 1 .735.46c3.2 5.067 2.717 10.446.044 13.834c-1.335 1.691-3.21 2.871-5.397 3.22c-1.908.303-3.993-.036-6.094-1.136a11 11 0 0 0-.41 1.758a1 1 0 1 1-1.98-.283c.124-.865.36-1.786.703-2.718m5.96-11.187c.704-.129 1.365-.191 2.007-.254c.524-.05 1.052-.102 1.564-.23a8.9 8.9 0 0 0 2.45-1.006c2.178 4.117 1.57 8.134-.373 10.598c-1.048 1.328-2.489 2.22-4.14 2.482c-1.483.236-3.2-.024-5.03-1.026c1.112-2.267 2.93-4.44 5.297-5.623a1 1 0 1 0-.894-1.79c-2.608 1.304-4.606 3.559-5.905 5.964c-.641-1.05-.833-2.271-.715-3.472c.169-1.728.96-3.205 1.707-3.829c1.328-1.107 2.728-1.574 4.033-1.814Z"/></g></svg>
                </span>
                        <span>Plantation</span>
            </a>
            <div class="header-main__search --flex-center  --search-input">
                <span class="header-main__icon --flex-center">
                    <svg id="Search" width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M20.3317 14.5002C20.6066 13.6382 20.7549 12.7197 20.7549 11.7666C20.7549 6.80236 16.7306 2.77805 11.7664 2.77805C6.80215 2.77805 2.77783 6.80236 2.77783 11.7666C2.77783 16.7308 6.80215 20.7552 11.7664 20.7552C14.1293 20.7552 16.2793 19.8434 17.8837 18.3524" stroke="#000000" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"></path>
                        <path d="M18.0181 18.4851L21.5421 22" stroke="#000000" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"></path>
                    </svg>
                </span>
                        <input class="header-main__input --input" type="text" placeholder="Search">
                        <button class="header-main__button --button">Search</button>
            </div>
            <div class="header-main__user --flex-center">
                <span class="header-main__icon --padding-inline-05 --flex-center">
                    <svg id="Heart" width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M3.12319 12.4101C2.05019 9.06006 3.30519 4.89506 6.82219 3.76306C8.67219 3.16606 10.9552 3.66406 12.2522 5.45306C13.4752 3.59806 15.8242 3.17006 17.6722 3.76306C21.1882 4.89506 22.4502 9.06006 21.3782 12.4101C19.7082 17.7201 13.8812 20.4861 12.2522 20.4861C11.0412 20.4861 7.53719 18.9911 5.11119 16.0151" stroke="#000000" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"></path>
                        <path d="M15.9902 7.52771C17.1972 7.65171 17.9522 8.60871 17.9072 9.94971" stroke="#000000" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"></path>
                    </svg>
                </span>
                        <span class="header-main__icon --padding-inline-05 --flex-center">
                            <svg id="Bag" width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <path d="M3.41547 15.9348C2.74727 20.3924 5.09968 21.5 8.16604 21.5H16.5139C19.5802 21.5 21.8686 19.889 21.3011 15.9348L20.523 9.89357C20.047 7.73339 18.7107 6.81805 17.4475 6.81805H7.26901C6.02416 6.81805 4.6054 7.66931 4.1935 9.89357L3.87473 12.3687" stroke="#000000" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"></path>
                                <path d="M16.6513 6.59839C16.6513 4.21232 14.717 2.27802 12.331 2.27802C11.182 2.27315 10.0783 2.72618 9.26416 3.53694" stroke="#000000" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"></path>
                                <path d="M15.2965 11.1018H15.2507" stroke="#000000" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"></path>
                                <path d="M9.4659 11.1018H9.42013" stroke="#000000" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"></path>
                            </svg>
                        </span>
                        <span class="header-main__icon --padding-inline-05 --flex-center">
                    <svg id="Profile" width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M12.25 21.829C8.43598 21.829 5.17798 21.252 5.17798 18.942C5.17798 16.632 8.41498 14.531 12.25 14.531C16.064 14.531 19.322 16.612 19.322 18.921C19.322 20.547 17.716 21.325 15.427 21.643" stroke="#000000" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"></path>
                        <path d="M12.2496 2.17102C9.74658 2.17102 7.71658 4.20002 7.71658 6.70402C7.70758 9.19802 9.72358 11.228 12.2176 11.237H12.2496C14.7526 11.237 16.7826 9.20702 16.7826 6.70402C16.7826 5.20602 16.0566 3.87802 14.9366 3.05302" stroke="#000000" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"></path>
                    </svg>
                </span>
            </div>
        </div>
    </div>
</section>
