<#import "parts/common.ftl" as c>

<@c.page>
<table>
    <thead>
    <tr>
        <th>Имя</th>
        <th>Роли</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
    <tr>
        <td>${user.username}</td>
        <td><#list user.roles as role>${role}<#sep>, </#list></td>
        <td><a href="/admin/user/${user.id}">Редактировать</a></td>
    </tr>
    </#list>
    </tbody>
</table>
</@c.page>
