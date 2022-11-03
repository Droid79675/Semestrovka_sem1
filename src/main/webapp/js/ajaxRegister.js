const name = document.getElementById("registerName");
const day = document.getElementById("registerDay");
const month = document.getElementById("registerMonth");
const year = document.getElementById("registerYear");
const password = document.getElementById("registerPassword");
const login = document.getElementById("registerLogin");
const email = document.getElementById("registerEmail")
const sex = $("input[name='sex']:checked").val();
const form = document.querySelector("form");
const errorAjax = document.getElementById("errorRegister");

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

    if (email.value.trim() === ""){
        errors.push("email isn't filled")
    }

    if (login.value.trim() === "") {
        errors.push("login isn't filled")
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