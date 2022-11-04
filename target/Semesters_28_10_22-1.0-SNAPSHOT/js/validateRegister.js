function validateRegister(){
    const login = document.getElementById("profileLogin")
    const name = document.getElementById("profileName")
    const day = document.getElementById("profileDay");
    const month = document.getElementById("profileMonth");
    const year = document.getElementById("profileYear");
    const sex = document.getElementById("sex");
    const temp2 = /^[?!,.а-яА-ЯёЁ0-9\s]+$/;

    if(login.value.match(temp2)){
        alert("Я запрещаю тебе писать username на кириллице!")
        return false;
    }

    if(name.value.match(temp2)){
        alert("Я запрещаю тебе писать name на кириллице!")
        return false;
    }

    if (day.value.trim() === "") {
        alert("Day can't be blank");
        return false;
    }

    if(day.value.length < 1){
        alert("Day can't be less than 1");
        return false;
    }

    if(day.value.length > 31){
        alert("Day can't be more than 31");
        return false;
    }

    if (sex.value() === ""){
        alert("You must choose sex");
        return false;
    }

    if (month.value.trim() === "") {
        alert("Month can't be blank");
        return false;
    }

    if(month.value.length < 1){
        alert("Month can't be less than 1");
        return false;
    }

    if(month.value.length > 12){
        alert("month can't be more than 12");
        return false;
    }

    if (year.value.trim() === "") {
        alert("Year can't be blank");
        return false;
    }

    if(year.value.length < 1920){
        alert("Year can't be less than 1920");
        return false;
    }

    if(year.value.length > 2022){
        alert("Year can't be more than 2022");
        return false;
    }
    return true;
}
