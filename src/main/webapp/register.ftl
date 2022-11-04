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
    <script
            src="https://code.jquery.com/jquery-3.6.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
            crossorigin="anonymous"></script>
    <script type="text/javascript"
            src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"></script>
    <script defer src="js/validateRegister.js"></script>
</head>
<body>
<#macro title>Registration</#macro>
<#macro content>
    <div class="tab-content">
        <div class="tab-pane fade show active" id="register" role="tabpanel" aria-labelledby="tab-register">
            <form id="formRegister" action="/registration" onsubmit="return validateRegister()" method="post">
                <!-- Name input -->
                <div class="col-md-12 d-flex justify-content-center">
                    <div class="form-outline mt-4">
                        <input type="text" id="registerName" name="registerName" class="form-control" minlength="2" maxlength="40"  required/>
                        <label class="form-label" for="registerName">Name</label>
                    </div>
                </div>

                <!-- Username input -->
                <div class="col-md-12 d-flex justify-content-center">
                    <div class="form-outline m-lg-1">
                        <input type="text" id="registerUsername" name="registerUsername" class="form-control" minlength="1" maxlength="22" required/>
                        <label class="form-label" for="registerUsername">Username</label>
                    </div>
                </div>

                <!-- Email input -->
                <div class="col-md-12 d-flex justify-content-center">
                    <div class="form-outline m-lg-1">
                        <input type="email" id="registerEmail" name="registerEmail" class="form-control" minlength="4" maxlength="64" required/>
                        <label class="form-label" for="registerEmail">Email</label>
                    </div>
                </div>

                <!-- Password input -->
                <div class="col-md-12 d-flex justify-content-center">
                    <div class="form-outline m-lg-1">
                        <input type="password" id="registerPassword" name="registerPassword" class="form-control" minlength="3" maxlength="16" required/>
                        <label class="form-label" for="registerPassword">Password</label>
                    </div>
                </div>

                <!-- Repeat Password input -->
                <div class="col-md-12 d-flex justify-content-center">
                    <div class="form-outline m-lg-1">
                        <input type="password" id="registerRepeatPassword" name="registerRepeatPassword" class="form-control" minlength="3" maxlength="16"/>
                        <label class="form-label" for="registerRepeatPassword">Repeat password</label>
                    </div>
                </div>

                <!-- Birthday input -->
                <div class="row justify-content-center m-lg-1 border-">
                    <div class="col-sm-auto">
                        <input type="number" id="registerDay" name="registerDay" placeholder="Day" min="1" max="31" required/>
                    </div>
                    <div class="col-sm-auto">
                        <input type="number" id="registerMonth" name="registerMonth" placeholder="Month" min="1" max="12" required/>
                    </div>
                    <div class="col-sm-auto">
                        <input type="number" id="registerYear" name="registerYear" placeholder="Year" min="1920" max="2022" required/>
                    </div>
                </div>

                <!-- Sex input -->
                <div class="row m-lg-1">
                    <div class="col-md-12 d-flex justify-content-center">
                        <div class="form-check mb-3 mb-md-0">
                            <input type="radio" id="sex" name="sex" value="female">
                            <label class="form-check-label" for="sex">Female</label>
                            <input type="radio" id="sex" name="sex" value="male">
                            <label class="form-check-label" for="sex">Male</label>
                        </div>
                    </div>
                </div>

                <!-- Submit button -->
                <div class="d-flex justify-content-center m-lg-1">
                    <button name="registerBtn" type="submit" class="btn btn-outline-light mb-4">Register in</button>
                </div>

                <div class="col-md-12 d-flex justify-content-center">
                    <p style="color:red"><#if message??> ${message}</#if></p>
                </div>

            </form>
        </div>
    </div>
</#macro>

</body>
</html>