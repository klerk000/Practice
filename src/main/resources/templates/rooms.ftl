<#import "parts/templ.ftl" as p>
<@p.pages>

    <div style="display: flex; justify-content: center; align-items: center;">
        <h2>${title}</h2>
    </div><hr>

    <div class="row row-cols-1 row-cols-md-3 g-4">
        <#if rooms??>
            <#list rooms as r>
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

</@p.pages>