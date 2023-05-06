<#import "parts/templ.ftl" as c>
<@c.pages>
    <div style="display: flex; justify-content: center; align-items: center;">
        <h2>Ваші замовлення</h2>
    </div>

    <table class="table align-middle table-striped">
        <thead class="table-dark align-middle">
        <tr>
            <th></th>
            <th>Назва кімнати</th>
            <th>Назва категорії</th>
            <th>Опис</th>
            <th>Кількість місць</th>
            <th>Ціна</th>
            <th></th>
        </tr>
        </thead>

        <tbody class="table-dark">
        <#if itemCart??>
            <#list itemCart as item>

                <form action="/deleteItem" method="post">
                    <input type="hidden" id="id" name="id" value="${item.rooms.id}">

                    <tr>
                        <td>
                            <img src="${item.rooms.image}" alt="image" height="80px">
                        </td>
                        <td class="col-second">${item.rooms.name}</td>
                        <td class="col-second">${item.rooms.categories.name}</td>
                        <td class="col-second">${item.rooms.description}</td>
                        <td class="col-second">${item.rooms.sumSits}</td>

                        <td class="col-second"><a>${item.rooms.price}</a> ₴</td>

                        <td>
                            <button type="submit" class="btn btn-danger">Видалити</button>
                        </td>
                    </tr>
                </form>

            </#list>
        </#if>
        </tbody>
    </table>


    <div style="display: flex; justify-content: center; align-items: center;">
        <h3>Загальна сума: <a>${totalEl}</a> ₴ </h3>
    </div>
    <p></p>

    <div style="display: flex; justify-content: center; align-items: center;">
        <h2>Оформити замовлення</h2>
    </div>

    <form action="/saveOrder" method="post">
        <label for="payment"></label>
        <input style="display: flex; justify-content: center; text-align: center" class="form-control" id="payment"
               name="payment" type="text" placeholder="Інформація щодо оплати">

        <br>
        <hr>
        <button type="submit" class="form-control">Відправити замовлення</button>
    </form>

</@c.pages>