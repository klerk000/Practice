<#import "parts/templ.ftl" as p>
<@p.pages>

    <div style="display: flex; justify-content: center; align-items: center;">
        <h2>Категорії кімнат/будинків</h2>
    </div><hr>

    <div class="row row-cols-1 row-cols-md-3 g-4">
        <#if allCategory??>
            <#list allCategory as category>
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

</@p.pages>