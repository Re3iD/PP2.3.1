<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://thymeleaf.org">
<head>
    <title>Update user</title>
</head>
<body>
<form th:action="@{/user/{id}(id=${user.id})}" th:method="PATCH" th:object="${user}">
    <label for="name">Enter name</label>
    <input th:field="*{name}" id="name" />
    <br/>
    <label for="lastName">Enter lastName</label>
    <input th:field="*{lastName}" id="lastName"/>
    <br/>
    <input type="submit" value="Update!">
</form>
</body>
</html>
