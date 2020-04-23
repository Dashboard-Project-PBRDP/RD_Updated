<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Error</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>District - ${sessionScope.districtName}</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			
			
			The Block cannot be deleted because it contains linked Panchayats data.
			If you still want to delete it, please delete the linked Panchayats first.
		
		</div>
	
	</div>
	<div style="clear: both;"></div>
		
		<p>
			<a href="ControllerServlet">Back to Blocks List</a>
		</p>
	</div>
</body>


</html>








