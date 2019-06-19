<#import "parts/common.ftl" as c>
<#import "parts/login1.ftl" as l>
<#include "parts/security.ftl">
<#import "parts/pager.ftl" as p>
<style xmlns="http://www.w3.org/1999/html">

.btn {margin: 5px;}

    .btn-circle {
        width: 38px;
        height: 38px;
        border-radius: 19px;
        text-align: center;
        padding-left: 0;
        padding-right: 0;
        font-size: 16px;




strong {
    color: rgb(49, 151, 116); /* Цвет текста */
}
    }
</style>
<@c.page>

    <@p.pager url page />
<form method="get" action="/">
    <select name="filter">
    <option title="Издатель"></option>
    <option>Marvel</option>
    <option>DC Comics</option>
    <option>Vertigo</option>
    <option>Dark Horse Comics</option>
    <option>Manga</option>
    <option>Image Comics</option>
    <option>Wildstorm</option>
    <option>Oni Press</option>
    <option>Авторский</option>
    </select>
    <button type="submit" style="background-color: orangered; font-weight: bold; font-size:20px; font-family:'Comic Sans MS' ">Найти по издательству</button>
</form>
<div class="card-columns" id="comic-list" style="align-content: center">
    <#list page.content as comic>
    <div class="card my-1 " data-id="${comic.id}" style="width: 290px " ">
        <div id="${comic.id}" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="/img/${comic.filename1}" width="290" height="500" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="/img/${comic.filename2}" width="290" height="500" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="/img/${comic.filename3}" width="290" height="500" alt="...">
                </div>
            </div>
            <a class="carousel-control-prev" href="#${comic.id}" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#${comic.id}" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
        <div class="card-body">
            <h5 class="card-title"><a href="/main/comics/${comic.id}">${comic.title}</a></h5>
            <h6 style="font-family: 'Comic Sans MS'; font-weight: bold;">Оценки:</h6>
            <p class="card-text">Сюжет: ${comic.likes.plotMark}<br/> Рисунок:${comic.likes.pictureMark}<br/>Общие впечатления: ${comic.likes.impressionMark}<br/></p>
           <#if isUser>
            <form method="post" action="/addToFav">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <input type="hidden" name="c_id" value=${comic.id}>
                <button class="btn btn-warning btn-circle" title="Добавить в избранное"><i class="fas fa-star"></i></button>
            </form>
            </#if>
        </div>
    </div>
   </#list>


</@c.page>





