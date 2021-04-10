<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Login form</title>
    <link rel="stylesheet" href="css/main.css">
</head>

<body>
<ul>
    <h1>Планировщик задач на Апрель</h1>
    <div class="days">
         <#list day as day>
             <div class="number">
                 <a href="http://localhost:9889/day"> ${day.number}</a>
                 ${day.tasks}
         </#list>
        </div>
    </div>
</ul>

</ul>
</body>

</html>