<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>Spring mvc todo</title>
	<link rel='stylesheet' href='<c:url value="/resources/css/style.css" />' type='text/css' media='all' /> 
</head>
<body>
	<h2>Some Text</h2>
	<p>id, ${note.id}</p>
	<p>id, ${note.title}</p>
	<p>id, ${note.text}</p>
</body>
</html>