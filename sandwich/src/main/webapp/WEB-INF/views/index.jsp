
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form>
    <input type="checkbox" name="condiment" id="Tomato" value="Tomato">
    <label for="Tomato">Tomato</label>
    <input type="checkbox" name="condiment" id="Mustard" value="Mustard">
    <label for="Mustard">Mustard</label>
    <input type="checkbox" name="condiment" id="Lettuce" value="Lettuce">
    <label for="Lettuce">Lettuce</label>
    <input type="checkbox" name="condiment" id="Sprouts" value="Sprouts">
    <label for="Sprouts">Sprouts</label>
    <button>Add</button>
</form>
<c:forEach items="${condiments}" var="condiment">
    <span><c:out value="${condiment}"></c:out></span>
</c:forEach>
</body>
</html>
