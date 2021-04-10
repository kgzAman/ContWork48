<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Login form</title>
    <link rel="stylesheet" href="css/main.css">
</head>

<body>
<ul>
    <div class="task">
        <#list task as task>
            <div class="number">

                ${task.category}
                ${task.description}
            </div>
        </#list>
    </div>
</ul>

</ul>
</body>

</html>