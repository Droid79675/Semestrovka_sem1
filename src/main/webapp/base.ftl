<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <header>
        <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
            <div class="container-fluid">
                <div class="collapse navbar-collapse">
                    <ul class="navbar-nav me-auto mb-2 mb-md-0">
                        <li class="nav-item">
                            <a class="nav-link" href="/login">Login</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/registration">Register</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/profile">Profile</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/cars">Cars</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/posts">Posts</a>
                        </li>
                    </ul>
                    <form class="d-flex" method="get" action="/search">
                        <input class="form-control me-2" name="search" type="search" placeholder="Search by name" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
            </div>
        </nav>
    </header>
    <script
            src="https://code.jquery.com/jquery-3.6.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
            crossorigin="anonymous"></script>
    <script type="text/javascript"
            src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"></script>
    <script defer src="js/ajaxLogin.js"></script>
    <script defer src="js/ajaxRegister.js"></script>
</head>

<body>

<#--<div id="header">-->
<#--    <H3> Header </H3>-->
<#--    <a href="/logout">Logout</a>-->
<#--</div>-->
<div class="col-md-12 d-flex justify-content-center fw-bolder text-white">
    <div class="content">
        <span size="100px">
            <@title></@title>
        </span>
    </div>
</div>

<div class="content1">
    <div class="content"><@content></@content></div>
</div>

</body>

</html>