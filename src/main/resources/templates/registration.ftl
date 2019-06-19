<#import "parts/common.ftl" as c>
<#import "parts/login1.ftl" as l>

<@c.page>
    ${message?ifExists}
<div class="mb-1" style="font-size: x-large; font-weight: bold">Регистрация</div>
    <@l.login "/registration" true />
</@c.page>