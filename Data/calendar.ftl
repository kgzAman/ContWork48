<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/index.css">
    <link href="css/freemarker.css" rel="stylesheet">
    <title>Calendar</title>
</head>
<body>
<a href="/">Назад к календарю</a>
<h1>Задачи на Апрель </h1>
<div class="table flex flex-col">
    <div class="header flex">
        <div class="column">
            Тип
        </div>
        <div class="column">
            Название
        </div>
        <div class="column">
            Описание
        </div>
        <div class="column">
            Действие
        </div>
    </div>

    <#list days as day>
        <#list day.tasks as task>
            <div class="row ${day?item_parity} flex">
                <div class="column">
                    <img src="${task.img}" width="50" height="50">
                </div>
                <div class="column">
                    ${task.name}
                </div>
                <div class="column">
                    ${task.description}
                </div>
                <div class="column">
                    <a href="/delete?date=${day}&event=${task.name}" class="link">Удалить задачу</a>
                </div>
            </div>
        </#list>
    </#list>
</body>
</html>