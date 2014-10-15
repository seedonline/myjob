<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'addbook.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>

	<s:form id="addbook" action="addbook">
	ISBN*: <s:textfield ISBN="ISBN" />
	AuthorID*:<s:textfield AuthorID="AuthorID" />
	Title:<s:textfield Title="Title" />
	Publisher:<s:textfield Publisher="Publisher" />
	PublishData:<s:textfield PublishData="PublishData" />
	Price:<s:textfield Price="Price" />
	Name:<s:textfield Name="Name" />
	Age:<s:textfield Age="Age" />
	Country:<s:textfield Country="Country" />
		<s:submit value="submit" />
	</s:form>
</body>
</html>
