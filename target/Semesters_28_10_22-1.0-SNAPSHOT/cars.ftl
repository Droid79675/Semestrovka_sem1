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
    <link rel="stylesheet" href="css/carousel.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"></script>
</head>
<body>
<#macro title><p style="color: black">Cars</p></#macro>

<#macro content>
    <div class="container">
        <div class="row">
            <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="https://images.hdqwalls.com/download/dodge-challenger-srt-2018-eg-1920x1080.jpg" class="d-block w-100" alt="Dodge">
                    </div>
                    <div class="carousel-item">
                        <img src="https://img2.akspic.ru/crops/1/8/7/8/38781/38781-avtomobilnyj_eksterer-lichnyj_roskoshnyj_avtomobil-nissan_silvia_s15-sportkar-koleso-1920x1080.jpg" class="d-block w-100" alt="Nissan">
                    </div>
                    <div class="carousel-item">
                        <img src="https://cdn.motor1.com/images/mgl/NROq2/s1/2020-aston-martin-db11.jpg" class="d-block w-100" alt="Aston Martin">
                    </div>
                    <div class="carousel-item">
                        <img src="https://images.alphacoders.com/921/921821.jpg" class="d-block w-100" alt="Audi">
                    </div>
                    <div class="carousel-item">
                        <img src="https://i.pinimg.com/originals/48/12/a7/4812a7f72c14f27c65a39dc1c0eacb63.jpg" class="d-block w-100" alt="Subaru">
                    </div>
                    <div class="carousel-item">
                        <img src="https://images2.alphacoders.com/942/thumb-1920-942549.jpg" class="d-block w-100" alt="Tesla">
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </div>
    </div>
    <br>
    <form method="get" action="/cars">
        <#list cars as c>
            <ul class="list-group">
                <div class="col-md-12 d-flex justify-content-center">
                    <p class="lead fw-bolder">Name: ${c.name}</p>
                </div>
                <div class="col-md-12 d-flex justify-content-center m-lg-2">
                    <div class="row m-lg-1">
                        <div class="col-md-auto">
                            <p class="lead fw-normal">Brand: ${c.brand}</p>
                        </div>
                        <div class="col-md-auto">
                            <p class="lead fw-normal">Data of creation: ${c.creationData}</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-12 d-flex justify-content-center">
                    <p class="lead fw-bolder">Tech characteristics</p>
                </div>
                <div class="col-md-12 d-flex justify-content-center">
                    <div class="row m-lg-1">
                        <div class="col-md-auto">
                            <p class="lead fw-normal">Engine type: ${c.engineType}</p>
                        </div>
                        <div class="col-md-auto">
                            <p class="lead fw-normal">Gear box: ${c.gearbox}</p>
                        </div>
                        <div class="col-md-auto">
                            <p class="lead fw-normal">Gear: ${c.gear}</p>
                        </div>
                    </div>
                </div>
            </ul>
            <br>
            <br>
        </#list>
    </form>
</#macro>
</body>

</html>