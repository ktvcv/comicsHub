<#import "parts/common.ftl" as c>

<@c.page>
<div>Добавление комикса</div>

<div>
    <form action="/admin/addComics" method="post" enctype="multipart/form-data">
        <div><label>Название : <input type="text" name="title" placeholder="Введите название"/> </label></div>
        <div><label>Издатель : <input type="text" name="publisher" placeholder="Введите издателя"/> </label></div>
        <div><label>Картинка1 : </label> <input type="file" name="file1"> </div>
        <div><label>Картинка2 : </label> <input type="file" name="file2"> </div>
        <div><label>Картинка3 : </label> <input type="file" name="file3"> </div>
        <div><label>Оценка за рисунок : </label> <input type="text" name="mark1"> </div>
        <div><label>оценка за сюжет : </label> <input type="text" name="mark2"> </div>
        <div><label>Оценка за общие впечатления : </label> <input type="text" name="mark3"> </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div class="form-group">
            <button type="submit" class="btn btn-primary">Добавить</button>
        </div>
    </form>

    <a href="/admin">Назад</a>
</@c.page>