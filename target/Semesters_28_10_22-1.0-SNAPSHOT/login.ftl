<!DOCTYPE html>
<html lang="en">
<head>
    <#include "base.ftl">
    <meta charset="utf-8">
    <title>Login Page</title>
    <style>
        body
        {
            background-image: url("https://a.d-cd.net/a969706s-960.jpg");
            background-repeat: no-repeat;
            background-position: center;
            background-attachment: fixed;
            background-size: cover;
        }
        label
        {
            color: #FFFFFF;
        }
    </style>
<#--    <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="-->
<#--            crossorigin="anonymous"></script>-->
<#--    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css">
<#--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"></script>-->
    <script defer src="js/ajaxLogin.js"></script>


</head>
<body>
<#macro title>Login</#macro>
<#macro content>
    <div class="tab-content">
        <div class="tab-pane fade show active" id="login" role="tabpanel" aria-labelledby="tab-login">
            <form id="formLogin" action="/login" onsubmit="return validateLogin()" method="post">
                <!-- Email/Login input -->
                <div class="col-md-12 d-flex justify-content-center">
                    <p style="color:red"><#if error??> ${error}</#if></p>
                    <p style="color:red" id="errorLogin" hidden></p>
                </div>
                <div class="col-md-12 d-flex justify-content-center">
                    <div class="form-outline m-lg-4">
<#--                        minlength="4" maxlength="64"-->
                        <input type="text" name="loginName" class="form-control" required/>
                        <label class="form-label" for="loginName">Email or username</label>
                    </div>
                </div>

                <!-- Password input -->
                <div class="col-md-12 d-flex justify-content-center">
                    <div class="form-outline m-lg-2">

                        <input type="password" name="loginPassword" class="form-control" minlength="3" maxlength="16" required/>
                        <label class="form-label" for="loginPassword">Password</label>
                    </div>
                </div>

                <!-- 2 column grid layout -->
                <div class="row mb-4">
                    <div class="col-md-12 d-flex justify-content-center">
                        <!-- Checkbox -->
                        <div class="form-check mb-3 mb-md-0">
                            <input class="form-check-input" type="checkbox" value="" name="loginCheck"/>
                            <label class="form-check-label" for="loginCheck"> Remember me </label>
                        </div>
                    </div>
                </div>

                <!-- Submit button -->
                <div class="d-flex justify-content-center">
                    <button name="loginBtn" type="submit" class="btn btn-outline-light mb-4">Sign in</button>
                </div>

            </form>
        </div>

</div>

</#macro>

</body>
</html>