<#import "parts/common.ftl" as c>

<@c.page>
<table>
    <thead>
    <tr>
        <th style="font-weight: bold">Название</th>
        <th>Издатель</th>
        <th>Художник</th>
        <th>Сценарист</th>
        <th>Год</th>
        <th>Ccылка</th>
        <th></th>

    </tr>
    </thead>
    <tbody>
    <#list comics as comic>
    <tr>
        <td style="font-weight: bold"> ${comic.title}</td>
        <td> ${comic.publisher}</td>
        <td>${(comic.artist)!"Jack Kerby"}</td>
        <td>${(comic.screenwriter)!"Stan Lee"}</td>
        <td> ${(comic.year)!"2019"}</td>
        <td> ${(comic.hyperlinkRu)!"https://www.google.com.ua/?hl=ru"}</td>
        <td><a style="font-weight: bold" href="/admin/comics/${comic.id}">Редактировать</a></td>
        <td><a style="font-weight: bold; color: red" href="/admin/comics/${comic.id}/delete">Удалить</a> </td>

    </tr>
    </#list>
    </tbody>
</table>

<form action="/admin/addComics">
    <button class="btn btn-success btn-circle" title="Добавить"><i class="fas fa-plus"></i></button>
</form>
</@c.page>

