<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Income Details</title>
	
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
				   onclick="window.location.href='panchayat/add-income-form.jsp'; return false;"
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
