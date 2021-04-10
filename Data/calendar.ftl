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
                 ${day.number}
             </div>
         </#list>
    </div>
</ul>

</ul>
</body>

</html>