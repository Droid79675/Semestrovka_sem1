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
</head>
<body>
<#macro title><p style="color: black">Posts</p></#macro>

<#macro content>
    <form method="get" action="/cars">
        <#list posts as p>
            <ul class="list-group rounded" style="background: lightgray">
                <div class="col-md-12 d-flex justify-content-start" style="margin-left: 25px">
                    <div class="m-md-2">
                        <p class="lead fw-normal">Name of the Post: ${p.name}</p>
                    </div>
                </div>
                <div class="col-md-12 d-flex justify-content-start" style="margin-left: 25px">
                    <div class="m-md-2">
                        <p class="lead fw-light">Created by: ${p.email}</p>
                    </div>
                </div>
                <div class="col-md-12 d-flex justify-content-start" style="margin-left: 40px">
                    <div class="m-lg-1">

                        <p class="lead fw-light">${p.content}</p>
                    </div>
                </div>
            </ul>
            <br>
        </#list>
    </form>
</#macro>
</body>
</html>