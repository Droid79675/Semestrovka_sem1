const name = document.getElementById("profileName");
const day = document.getElementById("profileDay");
const month = document.getElementById("profileMonth");
const year = document.getElementById("profileYear");
const password = document.getElementById("profilePassword");
const login = document.getElementById("profileLogin");
const sex = $("input[name='sex']:checked").val();
const form = document.querySelector("form");
const errorAjax = document.getElementById("errorEdit");

form.addEventListener("submit", (e) => {
    const errors = [];

    if (name.value.trim() === "" && name.value.trim().length > 1) {
        errors.push("login isn't filled")
    }

    if (day.value.trim() === "") {
        errors.push("day isn't filled")
    }

    if (month.value.trim() === "") {
        errors.push("month isn't filled")
    }

    if (year.value.trim() === "") {
        errors.push("year isn't filled")
    }

    if (password.value.trim() === "") {
        errors.push("password isn't filled")
    }

    if (login.value.trim() === "") {
        errors.push("email isn't filled")
    }

    if (sex.value() === ""){
        errors.push("sex isn't chose")
    }


    if (errors.length > 0) {
        e.preventDefault();
        errorAjax.toggleAttribute('hidden');
        errorAjax.innerText = errors.join(",\r\n");
    }
})