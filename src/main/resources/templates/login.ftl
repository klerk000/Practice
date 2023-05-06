<#import "parts/templ.ftl" as p>
<@p.pages>
    <div style="display: flex; justify-content: center; align-items: center;">
        <h1>Авторизація на сайті</h1>
    </div>

    <hr>

    <div class="center">
        <div class="col-4 center">
            <div class="card padding-login">
                <form action="/login" method="post">
                    <label for="username">
                        <input class="form-control login-input" type="text" name="username" placeholder="Користувач">
                        <br>
                    </label>
                    <br>
                    <label for="password">
                        <input class="form-control login-input" type="password" name="password" placeholder="Пароль">
                        <br>
                    </label>
                    <div>
                        <input style="background: lightblue; border-color: black" class="btn form-control" type="submit"
                               value="Увійти">
                    </div>

                    <br>
                    <div>
                        <a style="background: lightblue; border-color: black" class="btn form-control"
                           href="/registration">
                            Зареєструватись
                        </a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</@p.pages>

<style>
    .center {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 70vh;
    }

    .col-4.center {
        max-width: 400px;
        min-width: 200px;
    }

    .padding-login {
        padding: 50px 40px;
        background: #81d9cf;
    }

    .login-input {
        text-align: center;
        border-color: black;
        background: #7882b6;
    }
</style>