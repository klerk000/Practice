<#import "parts/templ.ftl" as p>
<@p.pages>

    <h1>Менеджер категорій</h1>

    <h3 class="table-header">Додавання нової категорії</h3>

    <form action="/saveNewCategory" method="post">
        <table class="table table-striped">
            <thead class="table-dark">
            <tr>
                <th scope="col">Назва категорії</th>
                <th scope="col">Опис категорії</th>
                <th scope="col">Фото категорії</th>
                <th scope="col">Зберегти категорію</th>
            </tr>
            </thead>

            <tbody>
            <tr>
                <td>
                    <label for="name">
                        <input class="form-control" type="text" name="name" placeholder="name" id="name">
                    </label>
                </td>

                <td>
                    <label for="description">
                        <input class="form-control" type="text" name="description" placeholder="description"
                               id="description">
                    </label>
                </td>

                <td>
                    <label for="image">
                        <input class="form-control" type="text" name="image" id="image" placeholder="link">
                    </label>
                </td>
                <td>
                    <input class="form-control" type="submit" value="Зберегти">
                </td>
            </tr>
            </tbody>
        </table>

    </form>

    <br>
    <hr>


    <h3>Всі категорії</h3>
    <table class="table table-striped">
        <thead class="table-dark">
        <tr>
            <td>Id</td>
            <td>Name</td>
            <td>Description</td>
            <td>Image</td>
        </tr>
        </thead>

        <tbody>

        <#if allCategory??>
            <#list allCategory as category>
                <tr>
                    <td>${category.id}</td>
                    <td>${category.name}</td>
                    <td>${category.description}</td>
                    <td>${category.image}</td>
                </tr>
            </#list>
        </#if>

        </tbody>
    </table>

    <br>
    <hr>


    <h3>Оновлення/Видалення категорії</h3>
    <table class="table table-striped">
        <thead class="table-dark">
        <tr>
            <td>Name</td>
            <td>Description</td>
            <td>Image</td>
            <td>Update</td>
            <td>Delete</td>
        </tr>
        </thead>

        <tbody>
        <#if allCategory??>
            <#list allCategory as category>
                <tr>
                    <form method="post" action="/updateCategory">

                        <td hidden>
                            <input class="form-control" type="hidden" name="id" value="${category.id}"></td>
                        <td>
                            <label>
                                <input class="form-control" type="text" name="name" value="${category.name}">
                            </label>
                        </td>

                        <td>
                            <label>
                                <input class="form-control" type="text" name="description"
                                       value="${category.description}">
                            </label>
                        </td>

                        <td>
                            <label>
                                <input class="form-control" type="text" name="image" value="${category.image}">
                            </label>
                        </td>

                        <td>
                            <input class="form-control" type="submit" value="update">
                        </td>

                    </form>

                    <td>
                        <form method="post" action="/deleteCategory">
                            <input type="hidden" name="id" value="${category.id}">
                            <input class="form-control" type="submit" value="delete">
                            <br>${Err}
                        </form>
                    </td>

                </tr>
            </#list>
        </#if>
        </tbody>
    </table>

    <br>
    <hr>

    <form method="post" action="/deleteAllCategory">
        <br>${Error}
        <input class="form-control" type="submit" value="Видалити всі категорії">
    </form>

</@p.pages>
