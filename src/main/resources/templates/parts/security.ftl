<#assign
    known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = user.getUsername()
        isUser = user.isUser()
        isAdmin = user.isAdmin()
        isGuest = false

    >
<#else>
    <#assign
        name = "Гость"
        isUser = false
        isAdmin = false
    isGuest = true
    >
</#if>


