<#import "parts/templ.ftl" as p>
<@p.pages>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Айді</th>
            <th>Ім'я</th>
            <th>По батькові</th>
            <th>Користувач</th>
            <th>пароль</th>
            <th>Пошта</th>
            <th>Телефон</th>
        </tr>
        </thead>

        <tbody>
        <#if client??>
            <#list client as client>
                <tr>
                    <td>${client.id}</td>
                    <td>${client.firstName}</td>
                    <td>${client.lastName}</td>
                    <td>${client.users.username}</td>
                    <td>${client.users.password}</td>
                    <td>${client.email}</td>
                    <td>${client.phone}</td>
                </tr>

            </#list>
        </#if>
        </tbody>
    </table>

</@p.pages>