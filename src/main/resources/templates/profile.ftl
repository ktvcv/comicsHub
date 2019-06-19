<#import "parts/common.ftl" as c>
<style>

    .btn {
        margin: 5px;
    }

    .btn-circle {
        width: 38px;
        height: 38px;
        border-radius: 19px;
        text-align: center;
        padding-left: 0;
        padding-right: 0;
        font-size: 16px;
    }
</style>
<@c.page>

<h3 style="font-weight: bold">Избранное</h3>
<div>
     <#if favU?has_content>
    <#list favU as favs>
        <a href ="/main/comics/${favs.comic.id}" style="font-weight:bold;color: mediumblue; ">${favs.comic.title}</a>
    <form method="post" action="/user/profileDeleteFav">
       <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="hidden" name="f_id" value="${favs.id}" />
        <button type="submit" class="btn btn-danger btn-circle" title="Удалить"><i class="fas fa-times"></i> </button>
    </form>

    </#list>
     </#if>

</div>


</@c.page>