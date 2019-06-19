<#include "security.ftl">
<#import "login1.ftl" as l>

<style>
    @media only screen and (min-width: 768px) {
        .dropdown:hover .dropdown-menu {
            display: block;
            margin-top: 0;
        }
    }
</style>
<nav class="navbar navbar-expand-lg" style="background-color: coral; color: red; font-border;">
    <a class="navbar-brand" href="/" style="align-items: center; alignment: center; align-content: center; font-size: 28px; font-weight: bold; color: black; font-family: 'Showcard Gothic';">
        <img src=/img/cd.png width="60" height="60"  class="d-inline-block align-top" alt="">
        ComicsHub
    </a>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/" style="align-items: center; alignment: center; align-content: center; font-size: 22px; font-weight: bold; color: black; font-family: 'Comic Sans MS';">Комиксы</a>
            </li>
            <#if isAdmin>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="align-items: center; alignment: center; align-content: center; font-size: 22px; font-weight: bold; color: black; font-family: 'Comic Sans MS';">
                   Панель админа
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/admin/comics">Комиксы</a>
                    <a class="dropdown-item" href="/admin/user">Пользователи</a>
                </div>
            </li>
            </#if>
             <#if isUser>
            <li class="nav-item">
                <a class="nav-link" href="/user/profile" style="align-items: center; alignment: center; align-content: center; font-size: 22px; font-weight: bold; color: black; font-family: 'Comic Sans MS';">Профиль</a>
            </li>
             </#if>

        </ul>
    </div>
        <#if isGuest>
             <a class="navbar-text mr-3"  title="Вход\Регистрация" href="/login" style="color: black; font-weight: bold; font-size: x-large"><i class="fas fa-user-secret"></i></a>
        </#if>
        <#if isUser>
        <div class="navbar-text mr-3" style="color:black; font-size: 22px; font-family: 'Showcard Gothic'">${name}</div>
       <div class="navbar-text mr-3"><@l.logout /></div>
        </#if>


</nav>

<script>
    $('.dropdown-toggle').click(function(e) {
        if ($(document).width() > 768) {
            e.preventDefault();
            var url = $(this).attr('href');
            if (url !== '#') {
                window.location.href = url;
            }
        }
    });
</script>

