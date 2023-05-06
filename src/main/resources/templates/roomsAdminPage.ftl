<#import "parts/templ.ftl" as p>
<@p.pages>
    <div style="display: flex; justify-content: center; align-items: center;">
        <h1>Кімнати</h1>
    </div><hr><br>

    <div style="display: flex; justify-content: center; align-items: center;">
        <h3>Додати кімнату</h3>
    </div>

    <form action="/saveNewRooms" method="post">

        <table class="table">
            <thead class="table-dark">
            <tr>
                <td class="col-first">Назва</td>
                <td class="col-first">Опис</td>
                <td class="col-first">Фото</td>
                <td class="col-first">Ціна</td>
                <td class="col-first">Кількість місць</td>
            </tr>
            </thead>

            <tbody>
            <tr>
                <td class="col-first">
                    <label for="name">
                        <input class="form-control" id="name" type="text" name="name" placeholder="Назва">
                    </label>

                </td>

                <td class="col-first">
                    <label for="description">
                        <input class="form-control" id="description" type="text" name="description" placeholder="Опис">
                    </label>

                </td>

                <td class="col-first">
                    <label for="image">
                        <input class="form-control" type="text" name="image" id="image" placeholder="Фото">
                    </label>

                </td>

                <td class="col-first">
                    <label for="price">
                        <input class="form-control" width="40px" type="number" name="price" id="price"
                               placeholder="Ціна">
                    </label>

                </td>

                <td class="col-first">
                    <label for="sumSits">
                        <input class="form-control" type="number" name="sumSits" id="sumSits"
                               placeholder="К-ть жилих мість">
                    </label>

                </td>
            </tr>
            <tr>
                <td class="col-first">
                    <label>
                        <select name="categoryId">

                            <#list allCategory as category>
                                <option class="form-control" value="${category.id}">${category.name}</option>
                            </#list>

                        </select>

                    </label>
                </td>

                <td>
                    <input class="form-control" type="submit" value="Зберегти">
                </td>
            </tr>

            </tbody>
        </table>

        <hr>
        <br>

        <div style="display: flex; justify-content: center; align-items: center;">
            <h3>Всі кімнати</h3>
        </div>


        <table class="table  table-striped">
            <thead class="table-dark">
            <tr>
                <td hidden>Ідентифікатор</td>
                <td>Назва</td>
                <td>Опис</td>
                <td>Фото</td>
                <td>Ціна</td>
                <td>Категорія</td>
                <td>Кількість місць</td>
            </tr>
            </thead>

            <tbody>

            <#if allRooms??>
                <#list allRooms as rooms>
                    <tr>
                        <td hidden>${rooms.id}</td>
                        <td>${rooms.name}</td>
                        <td>${rooms.description}</td>
                        <td>${rooms.image}</td>
                        <td>${rooms.price}</td>
                        <td>${rooms.categories.name}</td>
                        <td>${rooms.sumSits}</td>
                    </tr>
                </#list>
            </#if>

            </tbody>
        </table>

    </form>

    <hr>
    <br>

    <div style="display: flex; justify-content: center; align-items: center;">
        <h2>Оновити/Видалити</h2>
    </div>


    <table class="table table-striped">
        <thead class="table-dark">
        <tr>
            <td>Назва</td>
            <td>Опис</td>
            <td>Фото</td>
            <td>Ціна</td>
            <td>Кількість місць</td>
        </tr>
        </thead>

        <tbody>

        <#if allRooms??>
            <#list allRooms as rooms>

                <form action="/updateRooms" method="post">
                    <tr>
                        <td hidden>
                            <label for="id">
                                <input id="id" type="number" name="id" value="${rooms.id}">
                            </label>
                        </td>

                        <td>
                            <label for="name">
                                <input class="form-control" id="name" type="text" name="name" value="${rooms.name}">
                            </label>
                        </td>

                        <td>
                            <label for="description">
                                <input class="form-control" id="description" type="text" name="description"
                                       value="${rooms.description}">
                            </label>
                        </td>

                        <td>
                            <label for="image">
                                <input class="form-control" id="image" type="text" name="image" value="${rooms.image}">
                            </label>
                        </td>

                        <td>
                            <label for="price">
                                <input class="form-control" id="price" type="text" name="price" value="${rooms.price}">
                            </label>
                        </td>

                        <td>
                            <label for="sumSits">
                                <input class="form-control" id="sumSits" name="sumSits" value="${rooms.sumSits}">
                            </label>
                        </td>

                    </tr>

                    <tr>
                        <td>
                            <label id="categoryId">
                                <select name="categoryId">
                                    <#list allCategory as category>
                                        <#if "${category.id}"=="${rooms.categories.id}">
                                            <option value="${category.id}" selected>${category.name}</option>
                                        <#else>
                                            <option value="${category.id}">${category.name}</option>
                                        </#if>
                                    </#list>
                                </select>
                            </label>
                        </td>

                        <td>
                            <input class="form-control" type="submit" value="Оновити">
                        </td>
                </form>
                <td>
                    <form action="/deleteRooms" method="post">
                        <input type="hidden" name="id" value="${rooms.id}">
                        <input class="form-control" type="submit" value="Видалити">
                    </form>
                </td>
                </tr>

            </#list>
        </#if>

        </tbody>
    </table>

    <hr>
    <br>
    <div style="display: flex; justify-content: center; align-items: center;">
        <h2>Видалити всі кімнати</h2>
    </div>

    <form method="post" action="/deleteAllRooms">
        <input class="form-control" style="background: #b94c4c; --body-text-color: #ffffff" type="submit" value="delete">
    </form>
</@p.pages>