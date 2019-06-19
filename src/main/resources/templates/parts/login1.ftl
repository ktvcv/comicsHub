<#macro login path isRegisterForm>
<style>
    .btn-circle {
        width: 70px;
        height: 70px;
        border-radius: 35px;
        text-align: center;
        padding-left: 0;
        padding-right: 0;
        font-size: 16px;
        white-space: normal;
</style>
<form action="${path}" method="post">
   <div class="container">
       <div class="row">
           <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
               <div class="card card-signin my-5">
                   <div class="card-body">
                       <h5 class="card-title text-center">Вход/Регистрация</h5>
                       <form class="form-signin">
                           <div class="form-label-group">
                               <input type="text" id="inputUsername" name="username" class="form-control" placeholder="Имя" required>
                               <label for="inputUsername">Имя</label>
                           </div>

                           <div class="form-label-group">
                               <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Пароль" required autofocus>
                               <label for="inputPassword">Пароль</label>
                           </div>


                   <input type="hidden" name="_csrf" value="${_csrf.token}" />
<#if !isRegisterForm><a href="/registration" style="color: darkred">Добавить нового пользователя</a></#if>
                   <button class="btn btn-primary" type="submit" style="background-color: darkred"><#if isRegisterForm>Создать пользователя<#else>Войти</#if></button>
    <#if isRegisterForm><a href="/login">Вход</a></#if>

                       </form>
                   </div>
               </div>
           </div>
       </div>
   </div>
</form>
</#macro>

<#macro logout>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button type="submit" class="btn btn-circle" style="background-color: coral;" title="Выйти"> <img src=/img/exit.png width="50" height="50"  class="d-inline-block align-top" alt=""></button>
</form>
</#macro>


