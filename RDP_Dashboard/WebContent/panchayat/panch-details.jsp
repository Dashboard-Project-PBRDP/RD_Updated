<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Details List</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>${sessionScope.districtName} > ${sessionScope.blockName}> ${sessionScope.panchayatName}</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Details -->
			
			<input type="button" value="Add Details" 
				   onclick="window.location.href='panchayat/add-panch-form.jsp'; return false;"
				   class="add-student-button"
			/>
			
			<table>
			
				<tr>
					<th>Sr No</th>
					<th>First Name</th>
					<th>Middle Name</th>
					<th>Last Name</th>
					<th>Designation</th>
					<th>Age</th>
					<th>Gender</th>
					<th>Category</th>
					<th>Profession</th>
					<th>Contact Number</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempDetails" items="${Panch_List}" varStatus="counter">
					
					<!--  set up a link to update a details -->
					<c:url var="tempLink" value="PanchControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="detailsId" value="${tempDetails.id}" />
					</c:url>

					<!--  set up a link to delete a details -->
					<c:url var="deleteLink" value="PanchControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="detailsId" value="${tempDetails.id}" />
					</c:url>
																		
					<tr>
						<td> ${counter.count} </td>
						<td> ${tempDetails.firstName} </td>
						<td>${tempDetails.middleName}</td>
						<td>${tempDetails.lastName}</td>
						<td>${tempDetails.designation}</td>
						<td>${tempDetails.age}</td>
						<td>${tempDetails.gender}</td>
						<td>${tempDetails.category}</td>
						<td>${tempDetails.profession}</td>
						<td>${tempDetails.contact}</td>
						<td> 
							<a href="${tempLink}">Update</a> 
							 | 
							<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this Detail?'))) return false">
							Delete</a>	
						</td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
	<div style="clear: both;">
		
		<p>
			<a href="PDetailControllerServlet">Back to List of Links</a>
		</p>
	</div>
</body>


</html>
