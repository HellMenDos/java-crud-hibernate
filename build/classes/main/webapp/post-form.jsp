<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="net.javaguides.usermanagement.model.User"%>
<%@ page import="net.javaguides.usermanagement.dao.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>New Post</title>
</head>
<body>
	<center>
		<h1>Post</h1>
        <h2>
        	<a href="new">Add New User</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Users</a>
        	
        </h2>
	</center>
    <div align="center">
	<form action="post" method="post">
        <table border="1" cellpadding="5" width=50%>
            <tr>
                <th width="20%">User Name: </th>
                <td>
                	<select style="width: 100%" name="id">
            <c:forEach var="user" items="${listUser}">
                    <option value="${user.id}" ${ (id!=null && id==user.id) ? "selected" : ""} ><c:out value="${user.name}"/></option>
            </c:forEach>
                	</select>
                </td>
            </tr>
            <tr>
                <th width="20%">Title: </th>
                <td><input type="text" name="title" value="" style="width: 100%"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                	<textarea rows="5" cols="60" name="content" wrap="soft" style="width: 90%"></textarea>
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
        </form>
    </div>
    <div align="center">
        <table border="1" cellpadding="5"  width=50%>
            <caption><h2>List of Posts</h2></caption>
            <c:forEach var="post" items="${listPosts}">
            <tr>
            	<td rowspan="2" width="20%">${userDao.getUser(post.userId).getName()}</td>
            	<td>${post.title}</td>
            </tr>
            <tr>
            	<td><textarea rows="5" disabled style="width: 100%">${post.content}</textarea></td>
            </tr>
            </c:forEach>
        </table>
    
    </div>
    	
</body>
</html>
