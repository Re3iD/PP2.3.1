
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://thymeleaf.org">
<head>
    <title>New user</title>
</head>
<body>
<form th:action="@{/users}" th:method="post" th:object="${newUser}">
    <label for="name">Enter name</label>
    <input type="text" th:field="*{name}" id="name"/>
    <br/>
    <label for="lastName">Enter lastName</label>
    <input type="text" th:field="*{lastName}" id="lastName"/>
    <br/>
    <input type="submit" value="Create!"/>
</form>

</body>
</html>
