<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Basic Details</title>
	
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
				   onclick="window.location.href='panchayat/add-basic-form.jsp';"
				   class="add-student-button"	/>
		
			 
			<table>
				<c:forEach var="tempDetails" items="${Basic_List}" varStatus="counter">
				
					
					<!--  set up a link to update a details -->
					<c:url var="tempLink" value="BasicControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="detailsId" value="${tempDetails.id}" />
					</c:url>

					<!--  set up a link to delete a details -->
					<c:url var="deleteLink" value="BasicControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="detailsId" value="${tempDetails.id}" />
					</c:url>
			
				<tr></tr>
					
					<tr><td>Population</td><td> ${tempDetails.population}</td></tr>
					<tr><td>No of Households</td><td>${tempDetails.households}</td></tr>
					<tr><td>No of Voters</td><td>${tempDetails.voters}</td></tr>
					<tr><td>No of Wards</td><td>${tempDetails.wards}</td></tr>
					<tr><td>Topography</td><td>${tempDetails.topography}</td></tr>
					<tr><td>Number of Ponds</td><td>${tempDetails.ponds}</td></tr>
					<tr><td>Total Area Covered by Ponds (in Acres)</td><td>${tempDetails.areaPonds}</td></tr>
					<tr><td>Pond area leased for fisheries</td><td>${tempDetails.pondFisheries}</td></tr>
					<tr><td>Panchayat Ghar(Y/N)</td><td>${tempDetails.panchayatghar}</td></tr>
					<tr><td>Type of Panchayat Ghar</td><td>${tempDetails.panchayatgharType}</td></tr>
					<tr><td>Number of Dharamshalas</td><td>${tempDetails.dharamshalas}</td></tr>
					<tr><td>Reserved Dharamshala</td><td>${tempDetails.reservedDharamshalas}</td></tr>
					<tr><td>Number of Parks</td><td>${tempDetails.parks}</td></tr>
					<tr><td>Area covered in Parks (Acres)</td><td>${tempDetails.areaParks}</td></tr>
					<tr><td>Number of Playgrounds</td><td>${tempDetails.playgrounds}</td></tr>
					<tr><td>Area under Playgrounds(Acres)</td><td>${tempDetails.areaPlaygrounds}</td></tr>
					<tr><td>Distance to Mandi (in KM)</td><td>${tempDetails.mandiDistance}</td></tr>
					<tr><td>Number of Banks in Village</td><td>${tempDetails.banks}</td></tr>
					<tr><td>Date last updated</td><td>${tempDetails.datelastUpdated}</td></tr>
					<tr>
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
