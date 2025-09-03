<#ftl output_format="HTML">
<#-- @ftlvariable name="data" type="io.qameta.allure.attachment.http.HttpRequestAttachment" -->
<div><#if data.method??>${data.method}<#else>GET</#if> to <#if data.url??>${data.url}<#else>Unknown</#if></div>

<#if data.body??>
    <h4>Body</h4>
    <div>
    <pre class="preformated-text">
    <#t>${data.body}
    </pre>
    </div>
</#if>

<#if (data.headers)?has_content>
    <h4>Headers</h4>
    <div>
        <#list data.headers as name, value>
            <div>${name}: <#if name?lower_case?matches("authorization")>***<#else>${value!"null"}</#if></div>
        </#list>
    </div>
</#if>

<#if (data.cookies)?has_content>
    <h4>Cookies</h4>
    <div>
        <#list data.cookies as name, value>
            <div>${name}: ${value!"null"}</div>
        </#list>
    </div>
</#if>

<#if data.curl??>
    <h4>Curl</h4>
    <#assign curl = data.curl>

    <#assign curl = curl?replace("(?i)(?:-H|--header)\\s*(\"|')\\s*Authorization\\s*:[^\"']+\\1",
                             "-H \"Authorization: ***\"","r")>

    <#assign curl = curl?replace("(?i)(?:-H|--header)\\s*(\"|')\\s*(x-api-key|api-key)\\s*:[^\"']+\\1",
                             "-H \"X-API-KEY: ***\"","r")>

    <#assign curl = curl?replace("(?i)(?:-H|--header)\\s*(\"|')\\s*Cookie\\s*:[^\"']+\\1",
                             "-H \"Cookie: ***\"","r")>

    <#assign curl = curl?replace("(?i)([?&])(token|access_token|refresh_token|api[_-]?key|secret|password)=([^&\\s\"']+)",
                             "$1$2=***","r")>

    <#assign curl = curl?replace("(?is)\\\"(token|access_token|refresh_token|apiKey|api_key|secret|password)\\\"\\s*:\\s*\\\".*?\\\"",
                             "\"$1\":\"***\"","r")>

    <pre><code>${curl}</code></pre>
</#if>

<#if (data.formParams)?has_content>
    <h4>FormParams</h4>
    <div>
        <#list data.formParams as name, value>
            <div>${name}: ${value!"null"}</div>
        </#list>
    </div>
</#if>