<nav class="navbar bg-body-tertiary bg-success-subtle">
    <div class="container-fluid bg-success-subtle">
        <a class="navbar-brand" href="/">
            <img rel="icon" alt="..." src="/images/icon-site.png">
            У бога за пазухою</a>
        <a href="/client">
            <img rel="icon" alt="..." src="/images/user-icon.png">
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar"
                aria-controls="offcanvasNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="offcanvas offcanvas-end bg-success-subtle" tabindex="-1" id="offcanvasNavbar"
             aria-labelledby="offcanvasNavbarLabel">
            <div class="offcanvas-header bg-success-subtle nav-style">
                <h5 class="offcanvas-title" id="offcanvasNavbarLabel">Інформаційно-пошукове меню</h5>
                <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
            </div>
            <div class="offcanvas-body bg-success-subtle">

                <a type="text" class="bg-success-subtle nav-link active form-control nav-style" aria-current="page">
                    Виконав: Сеник Миколай
                </a>

                <hr style="color: blue">

                <a class="btn nav-link active form-control nav-style"
                   aria-current="page" href="/">
                    Вітальна сторінка
                </a>

                <br>

                <a class="btn nav-link active form-control nav-style"
                   aria-current="page" href="/address">
                    Адреси
                </a>

                <hr style="color: blue">

                <form class="d-flex mt-3" method="post" action="/result">
                    <input name="search-input" id="search-input" class="bg-success-subtle me-2 form-control nav-style"
                           style="border-color: black" type="search" placeholder="Кімната або категорія"
                           aria-label="Search">
                    <button style="border-color: black; color: black" class="btn btn-outline-success" type="submit">
                        Пошук
                    </button>
                </form>

                <br>
                <a class="btn nav-link active form-control nav-style"
                   aria-current="page" href="/result">
                    Результат попереднього пошуку
                </a>

            </div>
        </div>
    </div>
</nav>
<style>
    .nav-style {
        height: 50px;
        display: flex;
        justify-content: center;
        align-items: center
    }
</style>