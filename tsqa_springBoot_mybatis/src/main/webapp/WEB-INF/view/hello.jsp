<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Insert title here</title>    
</head>
<body>
    <h3>我是页面渲染的结果：</h3>
    <hr/>
    <p th:text="'Hello, ' + ${name} + '!'" />
</body>
</html>