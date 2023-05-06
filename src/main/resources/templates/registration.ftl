<#import "/spring.ftl" as spring>
<#import "parts/templ.ftl" as p>

<@p.pages>
    <div class="center">
        <h1>Реєстрація на сайті</h1>
    </div>
    <hr>


    <div class="center">
        <div class="col-4 center">
            <div class="card padding-login">
                <form action="/registration" method="post">

                    <@spring.bind "users"/>

                    <label class="center">Користувач</label>
                    <@spring.formInput "users.username"/>
                    <@spring.showErrors "<br>"/>

                    <label class="center">Пароль</label>
                    <@spring.formInput "users.password"/>
                    <@spring.showErrors "<br>"/>

                    <@spring.bind "client"/>

                    <label class="center">Ім'я</label>
                    <@spring.formInput "client.firstName"/>
                    <@spring.showErrors "<br>"/>

                    <label class="center">По батькові</label>
                    <@spring.formInput "client.lastName"/>
                    <@spring.showErrors "<br>"/>

                    <label class="center">Телефон</label>
                    <@spring.formInput "client.phone"/>
                    <@spring.showErrors "<br>"/>

                    <label class="center">Пошта</label>
                    <@spring.formInput "client.email"/>
                    <@spring.showErrors "<br>"/>

                    <label class="center">Вік</label>
                    <@spring.formInput "client.age"/>
                    <@spring.showErrors "<br>"/><br>


                    <input style="background: #52c6d5; border-color: black" class="btn form-control" type="submit"
                           value="Зареєструватись">
                </form>
            </div>
        </div>
    </div>
</@p.pages>
<style>

    #username, #password, #firstName, #lastName, #phone, #email, #age {
        text-align: center;
        display: block;
        width: 100%;
        padding: 0.375rem 0.75rem;
        font-size: 1rem;
        font-weight: 400;
        line-height: 1.5;
        color: var(--bs-body-color);
        background-clip: padding-box;
        border: var(--bs-border-width) solid var(--bs-border-color);
        -webkit-appearance: none;
        -moz-appearance: none;
        appearance: none;
        border-radius: 0.375rem;
        transition: border-color .15s ease-in-out, box-shadow .15s ease-in-out;
        border-color: black;
        background: #7882b6;
    }

    .center {
        display: flex;
        justify-content: center;
        align-items: center;
    }

    :root, [data-bs-theme=light] {
        --bs-body-color: #212529;
        --bs-body-bg: #fff;
        --bs-body-bg-rgb: 255, 255, 255;
        --bs-border-width: 1px;
        --bs-border-color: #dee2e6;
        --bs-form-control-bg: var(--bs-body-bg);
    }

    .padding-login {
        padding: 0 20px 5px;
        background: #81d9cf;
    }

</style>