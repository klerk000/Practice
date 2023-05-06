<#import "parts/templ.ftl" as p>
<@p.pages>
    <h1>Клієнт</h1>

    <#if client??>

        <p>
            Ролі користувача:
            <#list client.users.roles as roles>
                ${roles.name}<#sep>,
            </#list>
        </p>

        <table class="table">
            <thead class="table-dark">
            <tr>
                <td>Ідентифікатор</td>
                <td>Ім'я користувача</td>
                <td>Пароль</td>
                <td>Ім'я</td>
                <td>По батькові</td>
                <td>Вік</td>
            </tr>
            </thead>

            <tbody>
            <tr>
                <td>${client.id}</td>
                <td>${client.users.username}</td>
                <td>${client.users.password}</td>
                <td>${client.firstName}</td>
                <td>${client.lastName}</td>
                <td>${client.age}</td>
            </tr>
            </tbody>
        </table>
        <div class="row">
            <div class="col-6">
                <a href="/logout">
                    <input value="Вийти з акаунта" class="form-control" type="button">
                </a>
            </div>

            <div class="col-6">
                <a href="/login">
                    <input value="Увійти з нового акаунта" class="form-control" type="button">
                </a>
            </div>
        </div>
    </#if>
</@p.pages>