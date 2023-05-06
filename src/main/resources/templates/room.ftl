<#import "parts/templ.ftl" as p>
<@p.pages>

    <#if room??>
        <div class="room-about container-fluid">

            <table>
                <tbody>
                <tr>
                    <td class="room-about__left">
                        <img src="${room.image}" class="picture-container__picture" alt="...">
                    </td>

                    <td class="room-about__right align-top">
                        <h5 class="col-first">Назва будинку/кімнати: ${room.name}</h5>
                        <p class="col-last">Опис: ${room.description}</p>
                        <p class="col-last">Ціна: ${room.price} ₴</p>
                        <p class="col-last">Кількість місць для проживання: ${room.sumSits}</p>
                        <p class="col-last">Назва категорії: ${room.categories.name}</p>

                        <form action="/cart" method="post">
                            <input type="hidden" name="id" id="id" value="${room.id}">
                            <button type="submit" class="btn btn-primary">Додати до кошика</button>
                        </form>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>

    </#if>

</@p.pages>