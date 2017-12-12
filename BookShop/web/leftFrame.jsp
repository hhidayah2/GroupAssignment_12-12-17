<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>JSP Page</title>
    <style type="text/css">
<!--
body {
	background-color: #CC6699;
}
body,td,th {
	color: #FFFFFF;
}
a:link {
	color: #00FF00;
}
a:visited {
	color: #FFFF00;
}
a:active {
	color: #FFFFFF;
}
.style1 {color: #0000FF}
-->
    </style></head>
    <body>
	
    <table width="200" border="1">
	  <tr>
	    <td>&nbsp;<img src="./images/home_r6_c18.jpg"></td>
	  </tr>
	</table>	
    <h4 class="style1">Please choose category:</h4>
      <p><a href="./KidsBooksPage" target="mainFrame">Kids Books</a><BR>
          <a href="./TechBooksPage" target="mainFrame">Technical Books</a><BR>
          <%--
    This example uses JSTL, uncomment the taglib directive above.
    To test, display the page like this: index.jsp?sayHello=true&name=Murphy
    --%>
          <%--
    <c:if test="${param.sayHello}">
        <!-- Let's welcome the user ${param.name} -->
        Hello ${param.name}!
    </c:if>
    --%>
  </p>
      <hr>
	  <p><a href="btmFrame.jsp" target="mainFrame">Main Page</a><BR>
	  <a href="./OrderPage" target="mainFrame">View Cart</a><BR>
    </p>
    </body>
</html>
