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
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Semarak Ilmu Online Bookshop</title>
</head>

<frameset rows="*" cols="220,*" frameborder="NO" border="0" framespacing="0">
  <frame src="leftFrame.jsp" name="leftFrame" scrolling="auto" noresize>
  <frameset rows="200,*" frameborder="NO" border="0" framespacing="0">
    <frame src="topFrame.jsp" name="topFrame" scrolling="auto" noresize>
    <frame src="btmFrame.jsp" name="mainFrame">
  </frameset>
</frameset>
<noframes><body>
</body></noframes>
</html>
