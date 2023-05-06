<#import "parts/templ.ftl" as p>
<@p.pages>


    <div style="display: flex; justify-content: center; align-items: center;">
        <h2>Ваші замовлення</h2>
    </div>
    <div class="row row-cols-1 row-cols-md-3 g-4">

        <table class="table table-striped">
            <thead class="table-dark">
            <tr>
                <th>Дата створення</th>
                <th>Дані оплати</th>
                <th>Статус замовлення</th>
            </tr>
            </thead>

            <tbody>
            <#if listOrder??>
                <#list listOrder as list>

                    <form action="/deleteOrder" method="post">
                        <input type="hidden" id="id" name="id" value="${list.id}">
                        <tr style="border-color: black">
                            <td>
                                ${list.dataCreated}
                            </td>

                            <td>
                                ${list.payment}
                            </td>

                            <td>
                                <#if list.statusOrder>
                                    Виконано
                                <#else>
                                    В обробці
                                </#if>
                            </td>

                    </form>
                    </tr>
                </#list>
            </#if>
            </tbody>

        </table>
    </div>

</@p.pages>