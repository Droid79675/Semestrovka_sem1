<html lang="en">
<head>
    <#include "base.ftl">
    <meta charset="utf-8">
    <script
            src="https://code.jquery.com/jquery-3.6.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
            crossorigin="anonymous"></script>
    <script type="text/javascript"
            src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css">

    <script defer src="js/validatePost.js"></script>
</head>
<body>
<#macro title><p style="color: black">Create Post</p></#macro>
<#macro content>
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="card">
                <form id="formPost" action="/posts" method="post">
                    <div class="rounded-top text-white d-flex flex-row" style="background-color: #000; height:200px;">
                        <div class="m-lg-3" style="margin-top: 100px">
                            <label class="form-label" for="postName">Name for your post</label>
                            <input type="text" id="postName" name="postName" class="form-control" minlength="4" maxlength="50">
                        </div>
                    </div>
                    <div class="card-body p-4 text-black">
                        <div class="mb-5">
                            <p class="lead fw-normal mb-1">Your thoughts</p>
                            <div class="p-4" style="background-color: #f8f9fa;">
                                <input type="text" class="form-control" name="postContent" id="postContent" minlength="10" maxlength="400" style="width: 650px;height: 100px"/>
                            </div>
                        </div>

                    </div>
                    <div class="d-flex justify-content-center m-lg-1">
                        <button name="postBnt" type="submit" class="btn btn-outline-dark mb-4">Publish post</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</#macro>
</body>
</html>