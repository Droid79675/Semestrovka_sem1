function validateLogin(){
    const login = document.getElementById("loginName");
    const password = document.getElementById("loginPassword");
    if (login.value.trim() === "") {
        alert("Username can't be blank");
        return false;
    }

    if(login.value.length < 2){
        alert("Username can't be less than 2 symbols");
        return false;
    }

    if (password.value.trim() === "") {
        alert("Password can't be blank");
        return false;
    }
    return true;
}
// $(document).ready(function(){
//     $("#formLogin").submit(function(e) {
//         e.preventDefault();
//         const errors = [];
//
//         if (login.value.trim() === "") {
//             errors.push("username isn't filled")
//         }
//
//         if(login.value.length < 2){
//             errors.push("username must be >2")
//         }
//
//         if (password.value.trim() === "") {
//             errors.push("password isn't filled")
//         }
//
//
//         if (errors.length > 0) {
//             e.preventDefault();
//             errorAjax.toggleAttribute('hidden');
//             errorAjax.innerText = errors.join(",\r\n");
//         }
//     });
// });


