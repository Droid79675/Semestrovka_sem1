function validatePost(){
    const name = document.getElementById("postName");
    const content = document.getElementById("postContent");
    const temp2 = /^[?!,.а-яА-ЯёЁ0-9\s]+$/;

    if(name.value.match(temp2)){
        alert("Я запрещаю тебе писать name на кириллице!")
        return false;
    }

    if(content.value.match(temp2)){
        alert("Я запрещаю тебе писать content на кириллице!")
        return false;
    }

}