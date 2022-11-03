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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"></script>
</head>
<body>
<#macro title><p class="lead fw-bolder" style="color: black">${car.name}</p></#macro>
<#macro content>
    <ul class="list-group">
        <div class="col-md-12 d-flex justify-content-center m-lg-2">
            <div class="row m-lg-1">
                <div class="col-md-auto">
                    <p class="lead fw-normal">Brand: ${car.brand}</p>
                </div>
                <div class="col-md-auto">
                    <p class="lead fw-normal">Data of creation: ${car.creationData}</p>
                </div>
            </div>
        </div>
        <div class="col-md-12 d-flex justify-content-center">
            <p class="lead fw-bolder">Tech characteristics</p>
        </div>
        <div class="col-md-12 d-flex justify-content-center">
            <div class="row m-lg-1">
                <div class="col-md-auto">
                    <p class="lead fw-normal">Engine type: ${car.engineType}</p>
                </div>
                <div class="col-md-auto">
                    <p class="lead fw-normal">Gear box: ${car.gearbox}</p>
                </div>
                <div class="col-md-auto">
                    <p class="lead fw-normal">Gear: ${car.gear}</p>
                </div>
            </div>
        </div>
    </ul>
</#macro>
</body>
</html>