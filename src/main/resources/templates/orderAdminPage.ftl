<#import "parts/templ.ftl" as p>
<@p.pages>

    <h1>Замовлення</h1>
    <br>
    <hr>

    <h3>Чекають на обробку</h3>

    <form action="/updateOrder" method="post">
        <table class="table table-striped">
            <thead class="table-dark">
            <tr>
                <td>Користувацьке ім'я</td>
                <td>Дані оплати</td>
                <td>Дата створення</td>
                <td>Ціна замовлення</td>
                <td>Кімната: ціна</td>
                <td></td>
            </tr>
            </thead>

            <tbody class="align-middle">

            <#if order1??>
                <#list order1 as orderFalse>

                    <tr>
                        <td>${orderFalse.client.users.username}</td>
                        <td>${orderFalse.payment}</td>
                        <td>${orderFalse.dataCreated}</td>
                        <td>
                            <#assign totalPrice = 0>
                            <#list orderFalse.roomsHasOrder as roomsListByOrder>
                                <#assign totalPrice = totalPrice + roomsListByOrder.rooms.price>
                            </#list>
                            <a><a>${totalPrice}</a> ₴</a>
                        </td>
                        <td>
                            <#list orderFalse.roomsHasOrder as roomsListByOrder>
                                ${roomsListByOrder.rooms.name}: ${roomsListByOrder.rooms.price}<#sep>;<p></p>
                            </#list>
                        </td>
                        <td>
                            <input type="hidden" name="id" value="${orderFalse.id}">
                            <input class="form-control" type="submit" value="Оновити">
                        </td>
                    </tr>

                </#list>
            </#if>
            </tbody>
        </table>
    </form>


    <br>
    <hr>


    <h3>Виконані</h3>
    <form action="/updateOrder" method="post">
        <table class="table table-striped">
            <thead class="table-dark">
            <tr>
                <td>Користувацьке ім'я</td>
                <td>Дані оплати</td>
                <td>Дата створення</td>
                <td>Ціна замовлення</td>
                <td>Список кімнат</td>
                <td></td>
            </tr>
            </thead>

            <tbody class="align-middle">

            <#if order2??>
                <#list order2 as orderTrue>

                    <tr>
                        <td>${orderTrue.client.users.username}</td>
                        <td>${orderTrue.payment}</td>
                        <td>${orderTrue.dataCreated}</td>
                        <td>
                            <#assign totalPrice = 0>
                            <#list orderTrue.roomsHasOrder as roomsListByOrder>
                                <#assign totalPrice = totalPrice + roomsListByOrder.rooms.price>
                            </#list>
                            <a><a>${totalPrice}</a> ₴</a>
                        </td>
                        <td>
                            <#list orderTrue.roomsHasOrder as roomsListByOrder>
                                ${roomsListByOrder.rooms.name}: ${roomsListByOrder.rooms.price}<#sep>;<p></p>
                            </#list>
                        </td>
                        <td>
                            <input type="hidden" name="id" value="${orderTrue.id}">
                            <input class="form-control" type="submit" value="Оновити">
                        </td>
                    </tr>

                </#list>
            </#if>
            </tbody>
        </table>
    </form>

</@p.pages>