<!DOCTYPE html>
<html lang="en">
<head>
    <#include "base.ftl">
    <meta charset="utf-8">
    <title>Your Profile</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript"
            src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.6.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"></script>
    <script defer src="js/validateRegister.js"></script>
</head>
<body>
<#macro title><p style="color: black">Edit Profile</p></#macro>
<#macro content>
    <section class="h-100 gradient-custom-2">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col col-lg-9 col-xl-7">
                    <div class="card">
                        <form id="formEdit" method="post" action="/updateProfile" onsubmit="return validateRegister()" enctype="multipart/form-data">
                            <div class="rounded-top text-white d-flex flex-row" style="background-color: #000; height:200px;">
                                <div class="ms-4 mt-5 d-flex flex-column" style="width: 150px;">
<#--                                    <img src="data:image/png;base64"-->
<#--                                         alt="Generic placeholder image" class="img-fluid img-thumbnail mt-4 mb-2"-->
<#--                                         style="width: 150px; z-index: 1">-->
                                    <div class="d-flex">
                                        <input type="file" name="profileAvatar" placeholder="Update avatar" accept=".jpg, .jpeg, .png"/>
                                    </div>
                                </div>
                                <div class="row ms-2 justify-content-start" style="margin-top: 40px;">
                                    <div class="col-sm-10">
                                        <label>Name</label>
                                        <input required type="text" class="form-control" name="profileName" id="profileName" minlength="2" maxlength="40" />
                                    </div>
                                    <div class="row border-">
                                        <div class="col-sm-8">
                                            <label>Day</label>
                                            <input type="number" id="profileDay" name="profileDay" placeholder="Day" min="1" max="31" required/>
                                        </div>
                                        <div class="col-sm-8">
                                            <label>Month</label>
                                            <input type="number" id="profileMonth" name="profileMonth" placeholder="Month" min="1" max="12" required/>
                                        </div>
                                        <div class="col-sm-8">
                                            <label>Year</label>
                                            <input type="number" id="profileYear" name="profileYear" placeholder="Year" min="1920" max="2022" required/>
                                        </div>
                                    </div>
                                </div>
                                <div class="row ms-2 justify-content-start" style="margin-top: 40px;">
                                    <div class="col-sm-10">
                                        <label>Password:</label>
                                        <input required type="password" class="form-control" name="profilePassword" id="profilePassword" minlength="3" maxlength="16" />
                                    </div>
                                    <label>Sex:</label>
                                    <div class="form-check mb-3 mb-md-0" id="editSex">
                                        <input type="radio" name="sex" id="sex" value="female" >
                                        <label class="form-check-label" for="sex">Female</label>
                                        <input type="radio" name="sex" id="sex" value="male" >
                                        <label class="form-check-label" for="sex">Male</label>
                                    </div>
                                </div>
                            </div>
                            <div class="card-body p-4 text-black">
                                <div class="mb-5">
                                    <p class="lead fw-normal mb-1">About</p>
                                    <div class="p-4" style="background-color: #f8f9fa;">
                                        <input type="text" class="form-control" name="profileAbout" id="profileAbout" maxlength="200" style="width: 650px;height: 100px"/>
                                    </div>
                                </div>
                            </div>
                            <div class="d-flex justify-content-center" style="margin-bottom: 15px">
                                <button type="submit" class="btn btn-outline-dark" data-mdb-ripple-color="dark"
                                        name="save" value=”save-profile”>
                                    Save Changes
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
</#macro>
</body>
</html>
