<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/index.css">
    <title>Calendar</title>
</head>
<body>

<div class="main-content">
    <div class="month month--feb" style="--color: #d5c6c6">Апрель</div>
    <#list days as day>
    <div class="date borders" style="--color:#f5f1f1">
        <a href="/days" id="${day.number}">
            ${day.number}
            <p>
                <#list day.tasks as task>
                <img src="${task.img}" width="20" height="20">
            </#list>
            </p>
        </a>
    </div>
</#list>
</div>
</body>
</html>