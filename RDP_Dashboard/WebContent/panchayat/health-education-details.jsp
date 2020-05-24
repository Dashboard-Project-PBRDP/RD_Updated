<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Health/Education facility details</title>
	
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
				   onclick="window.location.href='panchayat/add-health-education-form.jsp'; return false;"
				   class="add-student-button"
			/>
			
			<table>
			
				<tr>
					<th>Sr No</th>
					<th>Facility (Health/Education)</th>
					<th>Facility Name</th>
					<th>Level (Anganwadi/primary/sec/etc or PHC/CHC/etc)</th>
					<th>Area (In acres)</th>
					<th>Location</th>
					<th>Identifier (eg. Khasra No/ Number of items)</th>
					<th>Condition (Scale - Very bad to Excellent) </th>
					<th>Last Repaired (Year)</th>
					<th>Number of students/Beds</th>
					
				</tr>
				<c:forEach var="tempDetails" items="${Facility_List}" varStatus="counter">
					
					<!--  set up a link to update a details -->
					<c:url var="tempLink" value="FacilityControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="detailsId" value="${tempDetails.id}" />
					</c:url>

					<!--  set up a link to delete a details -->
					<c:url var="deleteLink" value="FacilityControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="detailsId" value="${tempDetails.id}" />
					</c:url>
																	
					<tr>
						<td> ${counter.count} </td>
						<td> ${tempDetails.facilityType} </td>
						<td> ${tempDetails.facilityName} </td>
						<td>${tempDetails.facilityLevel}</td>
						<td>${tempDetails.area}</td>
						<td>${tempDetails.location}</td>
						<td>${tempDetails.identifier}</td>
						<td>${tempDetails.facilityCondition}</td>
						<td>${tempDetails.lastRepaired}</td>
						<td>${tempDetails.facilityNumber}</td>
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