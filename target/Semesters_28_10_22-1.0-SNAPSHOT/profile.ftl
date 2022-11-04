<!DOCTYPE html>
<html lang="en">
<head>
    <#include "base.ftl">
    <meta charset="utf-8">
    <title>Your Profile</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/profile.css">
    <script type="text/javascript"
            src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.6.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"></script>
</head>
<body>
<#macro title>Your profile</#macro>
<#macro content>

    <div class="fullscreen-bg" >
        <video class="fullscreen-bg_video" autoplay muted loop id="myVideo">
            <source src="videos/background.mp4" type="video/mp4">
        </video>
    </div>
    <section class="h-100 gradient-custom-2">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col col-lg-9 col-xl-7">
                    <div class="card">
                        <form method="get" action="/profile">
                            <div class="rounded-top text-white d-flex flex-row" style="background-color: #000; height:200px;">
                                <div class="ms-4 mt-5 d-flex flex-column" style="width: 150px;">
                                    <img src="data:image/png;base64, ${profile.avatar_image}"
                                         alt="Generic placeholder image" class="img-fluid img-thumbnail mt-4 mb-2"
                                         style="width: 150px; z-index: 1">
                                </div>
                                <div class="row ms-2 justify-content-start" style="margin-top: 100px;">
                                    <div class="col-sm-auto">
                                        <p class="lead fw-normal">Name: ${profile.name}</p>
                                    </div>
                                    <div class="col-sm-auto">
                                        <p class="lead fw-normal">Birthday: ${day}.${month}.${year}</p>
                                    </div>
                                </div>
                                <div class="row ms-2 justify-content-start" style="margin-top: 100px;">
                                    <div class="col-sm-auto">
                                        <p class="lead fw-normal">Login: ${profile.login}</p>
                                    </div>
                                    <div class="col-sm-auto">
                                        <p class="lead fw-normal">Email: ${profile.email}</p>
                                    </div>
                                </div>
                                <div class="d-flex ms-2" style="margin-top: 100px;">
                                    <p class="lead fw-normal">Sex: ${profile.sex}</p>
                                </div>
                            </div>
                            <div class="card-body p-4 text-black">
                                <div class="mb-5">
                                    <p class="lead fw-normal mb-1">About</p>
                                    <div class="p-4" style="background-color: #f8f9fa;">
                                        <p class="font-italic mb-1">${profile.about}</p>
                                    </div>
                                </div>

                            </div>
                        </form>
                        <form method="post" action="/profile">
                            <div class="row">
                                <div class="d-flex justify-content-center" style="margin-bottom: 15px">
                                    <button type="submit" class="btn btn-outline-dark m-lg-auto" data-mdb-ripple-color="dark"
                                            name="edit" value=”update-profile”>
                                        Edit profile
                                    </button>
                                    <button type="submit" class="btn btn-outline-dark m-lg-auto" data-mdb-ripple-color="dark"
                                            name="post" value="go-to-posts">
                                        Create Post
                                    </button>
                                </div>
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
