<#include "parts/security.ftl">
<#import "parts/common.ftl" as c>
 <style>
     .leftimg {
         float:left; /* Выравнивание по левому краю */
         margin: 7px 7px 7px 0; /* Отступы вокруг картинки */
     }
     .rightimg  {
         float: right; /* Выравнивание по правому краю  */
         margin: 7px 0 7px 7px; /* Отступы вокруг картинки */
     .media-body .author {
         display: block;
         font-size: 1rem;
         color: #fff;
         font-weight: 700;
     }
     .media-body .metadata {
         display: block;
         color: #fff;
         font-size: .8125rem;
     }
     .title-comments {
         font-size: 1.4rem;
         font-weight: bold;
         line-height: 1.5rem;
         color: rgba(0,0,0,.87);
         margin-bottom: 1rem;
         padding-bottom: .25rem;
         border-bottom: 1px solid rgba(34,36,38,.15);
     }
     .media-left img {
         width: 50px;
     }
     .media {
         margin-top:0px;
     }
     }
 </style>
<@c.page>
<form action="/main/comics/{comic}" method="get">
    <div>
     <div  class="leftimg">
         <img src="/img/${comic.filename1}" width="200" height="320"><br/>
        <img src="/img/${comic.filename2}" class="leftimg" width="100" height="150">
        <img src="/img/${comic.filename3}" class="leftimg" width="100" height="150">
     </div>
      <b style="font-size: large; font-family: 'Comic Sans MS';color: mediumvioletred; margin: 20px">Название: ${comic.title}</b> <br/>
        <span>Издатель: <b style="font-family: 'Comic Sans MS'"> ${comic.publisher}</b></span><br/>
        <span>Художник:  <b style="font-family: 'Comic Sans MS'"> ${(comic.artist)!"Jack Kerby"}</b></span><br/>
        <span>Сценарист:  <b style="font-family: 'Comic Sans MS'"> ${(comic.screenwriter)!"Stan Lee"}</b> </span><br/>
        <span>Год:  <b style="font-family: 'Comic Sans MS'"> ${(comic.year)!"2019"}</b></span><br/>
        <span style="font-family:'Comic Sans MS'">${(comic.description)!"description"} </span><br/>
        <span><a style="font-size: larger" class="badge badge-success" href=${(comic.hyperlinkRu)!"https://www.google.com.ua"} >Ссылка на комикс на русском</a></span><br/>
        <span><a style="font-size: larger" class="badge badge-dark" href=${(comic.hyperlinkEng)!"https://www.google.com.ua"} >Ссылка на комикс на английском</a></span><br/>

<div style="margin-top: 20px">
        <b style="font-family: 'Droid Sans Mono'; font-size: x-large; font-weight:bold ">Комменты:</b>
        <#if isGuest>
            <p>Чтобы оставлять комментарии, нужно зарегистрироваться</p>
        </#if>
         <#if comments?has_content>
             <#list comments as comment>
           <div class="media">
    <div class="media-left">
        <img src="/img/sm.png" class="media-object" style="width:30px">
    </div>
    <div class="media-body">
      <h6 class="media-heading">${comment.authorName} <small><i>Posted on ${comment.createdAt}</i></small></h6>
      <p style="font-weight: bold">${comment.text}</p>
                 <#if isAdmin>
                     <a class="badge badge-warning" href="/main/comics/${comic.id}/${comment.id}/deleteComment">Удалить комментарий</a>
                 </div>
</#if>
    </div>
             </#list>
         </#if>
</div>
    </form>

<#if isUser>
        <form method="post" action="/main/comics/">
       <label style=" font-family: 'Droid Sans'; font-weight: bold; margin: 20px">Комментарий</label>
            <input type="text" name="text1" placeholder="Введите комментарий">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Добавить</button>
                <input type="hidden" name="c_id" value=${comic.id}>
            </div>
        </form>
</#if>


</@c.page>



