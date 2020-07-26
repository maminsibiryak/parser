<#import "parts/main.ftl" as m>
<@m.page>
    <p>Приветсвутю</p>
    <div class="table-wrapper-scroll-y my-custom-scrollbar">
        <table class="table table-bordered table-striped mb-0">
            <thead>
            <th>Номер</th>
            <th>Количество выпаданий</th>
            </thead>
            <#list result.item?sort_by("number") as item>

                <tr>
                    <td>${item.number}</td>
                    <td>${item.count}</td>
                </tr>
            </#list>
        </table>
    </div>
    <br>
    <form method="get" action="/refresh">
        <input type="submit" value="Refresh">
    </form>
</@m.page>