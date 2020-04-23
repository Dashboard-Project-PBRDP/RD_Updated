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
				   onclick="window.location.href='panchayat/add-panch-form.jsp'; return false;"
				   class="add-student-button"
			/>
			
			<table>
			
				<tr></tr>
					
					<tr><td>Population</td><td>_________</td></tr>
					<tr><td>No of Households</td>_________<td></td></tr>
					<tr><td>No of Voters</td><td>_________</td></tr>
					<tr><td>No of Wards</td><td>_________</td></tr>
					<tr><td>Topography</td><td>_________</td></tr>
					<tr><td>Number of Ponds</td><td>_________</td></tr>
					<tr><td>Total Area Covered by Ponds (in Acres)</td><td>_________</td></tr>
					<tr><td>Pond area leased for fisheries</td><td>_________</td></tr>
					<tr><td>Panchayat Ghar(Y/N)</td><td>_________</td></tr>
					<tr><td>Type of Panchayat Ghar</td><td>_________</td></tr>
					<tr><td>Number of Dharamshalas</td><td>_________</td></tr>
					<tr><td>Reserved Dharamshala</td><td>_________</td></tr>
					<tr><td>Number of Parks</td><td>_________</td></tr>
					<tr><td>Area covered in Parks (Acres)</td><td>_________</td></tr>
					<tr><td>Number of Playgrounds</td><td>_________</td></tr>
					<tr><td>Area under Playgrounds(Acres)</td><td>_________</td></tr>
					<tr><td>Distance to Mandi</td><td>_________</td></tr>
					<tr><td>Number of Banks in Village</td><td>_________</td></tr>
					<tr><td>Date last updated</td><td>_________</td></tr>
					<tr><td><a href="">Update</a>|<a href="">Delete</a></td><td></td></tr>
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
