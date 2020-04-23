<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>District List</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Rural Development - Punjab</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
			
			<table>
			
				<tr>
					<th>Sr No</th>
					<th></th>
					<th></th>
					<th>District</th>
				</tr>
				
				<c:forEach var="tempDistrict" items="${District_List}">
					
					<!-- set up a link for each District -->
					<c:url var="tempLink" value="ControllerServlet">
						<c:param name="command" value="LIST" />
						<c:param name="district_id" value="${tempDistrict.id}" />
						<c:param name="districtName" value="${tempDistrict.districtName}" />
					</c:url>

																		
					<tr>
						<td> ${tempDistrict.id} </td>
						<td>  </td>
						<td></td>
						<td> 
							<a href="${tempLink}" title="Click to enter">${tempDistrict.districtName}</a> 
							 
						</td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








