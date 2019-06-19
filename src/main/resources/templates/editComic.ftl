<#import "parts/common.ftl" as c>

<@c.page>
<form action="/admin/comics/" method="post" enctype="multipart/form-data">
    <ul>
   <li> Название  <input type="text" name="title" value="${comic.title}"/></li>
   <li> Издатель  <input type="text" name="publisher" value="${comic.publisher}"/></li>
    <li>Художник  <input type="text" name="artist" value="${(comic.artist)!"Jack Kerby"}"/></li>
   <li> Сценарист  <input type="text" name="screenwriter" value="${(comic.screenwriter)!"Stan Lee"}"/></li>
   <li> Год  <input type="text" name="year" value="${(comic.year)!"2019"}"/></li>
    <li>Описание <input type="text" name="description" value="${(comic.description)!"description"}"></li>
   <li> СсылкаRu<input type="text" name="hyperlinkRu" value="${(comic.hyperlinkRu)!"https://www.google.com.ua/?hl=ru"}"></li>
   <li>СсылкаEng<input type="text" name="hyperlinkEng" value="${(comic.hyperlinkEng)!"https://www.google.com.ua/?hl=ru"}"></li>
    <input type="hidden" value="${comic.id}" name="comicId">
    <input type="hidden" value="${_csrf.token}" name="_csrf">
    <button type="submit">Сохранить</button>
    </ul>
</form>
</@c.page>