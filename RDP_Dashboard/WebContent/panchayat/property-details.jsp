<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Property Details</title>
	
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
				   onclick="window.location.href='panchayat/add-property-form.jsp'; return false;"
				   class="add-student-button"
			/>
			<table>
				<tr>
					<th>Sr No</th>
					<th>Property Type (Movable/Immovable)</th>
					<th>Property Name</th>
					<th>Area (in acres)</th>
					<th>Location</th>
					<th>Identifier (eg. Khasra No/ Number of items)</th>
					<th>Purpose (Commercial/Common) </th>
					<th>Leased out (Y/N)</th>
					<th>Lease From (dd/mm/yy)</th>
					<th>Lease To (dd/mm/yy)</th>
					<th>Lease Amount</th>
					<th>Lease Amount per year</th>
					
					
				</tr>
			
				<c:forEach var="tempDetails" items="${Property_List}" varStatus="counter">
					
					<!--  set up a link to update a details -->
					<c:url var="tempLink" value="PropertyControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="detailsId" value="${tempDetails.id}" />
					</c:url>

					<!--  set up a link to delete a details -->
					<c:url var="deleteLink" value="PropertyControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="detailsId" value="${tempDetails.id}" />
					</c:url>												
					<tr>
						<td> ${counter.count} </td>
						<td> ${tempDetails.propertyType} </td>
						<td>${tempDetails.propertyName}</td>
						<td>${tempDetails.area}</td>
						<td>${tempDetails.location}</td>
						<td>${tempDetails.identifier}</td>
						<td>${tempDetails.purpose}</td>
						<td>${tempDetails.leasedOut}</td>
						<td>${tempDetails.leasedFrom}</td>
						<td>${tempDetails.leasedTo}</td>
						<td>${tempDetails.leaseAmount}</td>
						<td>${tempDetails.leaseAmountpyear}</td>
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