<#import "parts/templ.ftl" as p>
<@p.pages>
    <div class="row d-flex justify-content-between">

        <div class="col-6">
            <#if categoryList??>

                <h3>Знайдені категорії</h3>

                <#list categoryList as category>

                    <form>
                        <div class="card">
                            <img src="${category.image}" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title">${category.name}</h5>
                                <p class="card-text">${category.description}</p>

                                <a href="/category/rooms/${category.id}" class="btn btn-primary">До кімнат</a>
                            </div>
                        </div>
                    </form>
                </#list>

            </#if>
        </div>


        <div class="col-6">
            <#if roomsList??>

                <h3>Знайдені кімнати</h3>

                <#list roomsList as r>
                    <form action="/cart" method="post">

                        <div class="card" style="column-gap: 1rem;">
                            <img src="${r.image}" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title">${r.name}</h5>
                                <p class="card-text">${r.description}</p>

                                <a href="/room/${r.id}" class="btn btn-primary">До кімнати</a>

                                <input type="hidden" name="id" id="id" value="${r.id}">
                                <button type="submit" class="btn btn-primary">Додати до кошика</button>
                            </div>
                        </div>

                    </form>
                </#list>

            </#if>
        </div>

    </div>
</@p.pages>