<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title> List of GPs</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>District - ${sessionScope.districtName} > Block - ${sessionScope.blockName}</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Panchayat >
			<c:set var="Panchayat_List" value="${Panchayat_List}" scope="session"/>
			<input type="button" value="Add Panchayat" 
				   onclick="window.location.href='add-panchayat-form.jsp'; return false;"
				   class="add-student-button"
			/-->
			<form action="PanchayatControllerServlet" method="get">
			<input type="hidden" name="command" value="CONST">
  			<input  type="submit" value="Add Panchayat" id="submitconst" class="add-student-button">
			</form>
			<table>
			
				<tr>
					<th>Sr No</th>
					<th>Panchayat</th>
					<th></th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempPanchayat" items="${Panchayat_List}" varStatus="counter">
					
					<!-- set up a link for entry into each panchayat -->
					<c:url var="panchayatLink" value="PDetailControllerServlet">
						<c:param name="command" value="0" />
						<c:param name="panchayatId" value="${tempPanchayat.id}" />
						<c:param name="panchayatName" value="${tempPanchayat.panchayatName}" />
					</c:url>
					<!--  set up a link to update a panchayat -->
					<c:url var="tempLink" value="PanchayatControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="panchayatId" value="${tempPanchayat.id}" />
					</c:url>

					<!--  set up a link to delete a panchayat -->
					<c:url var="deleteLink" value="PanchayatControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="panchayatId" value="${tempPanchayat.id}" />
					</c:url>
																		
					<tr>
						<td> ${counter.count} </td>
						
					 	<td> <a href="${panchayatLink}" title="Click to enter">${tempPanchayat.panchayatName} </a></td>
						<td></td>
						<td> 
							<a href="${tempLink}">Update</a> 
							 | 
							<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this Panchayat?'))) return false">
							Delete</a>	
						</td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
	<div style="clear: both;"></div>
		<div>
		<p>
			<a href="ControllerServlet">Back to Blocks List</a>
		</p>
	</div>
</body>


</html>








