<!DOCTYPE html>
<html>

<head>
	<title>Update Panchayat Details</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
		<h3>${sessionScope.districtName}>${sessionScope.blockName}>${sessionScope.panchayatName}</h3>
			</div>
	</div>
	
	<div id="container">
		<h3>Update Panch details</h3>
		
		<form action="PanchControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />

			<input type="hidden" name="detailsId" value="${The_Panch.id}" />
			
			<table>
				<tbody>

					<tr>
						<td></td>
						<td><input type="radio" name="designation" value="Sarpanch">Sarpanch</input></td>
						<td><input type="radio" name="designation" value="Panch"checked>Panchayat Member</input></td>						
					</tr>
					<tr></tr>
					<tr>
						<td><label>First Name:</label></td>
						<td><input type="text" name="firstName" value="${The_Panch.firstName}" /></td>
					</tr><tr>
						<td><label>Middle Name:</label></td>
						<td><input type="text" name="middleName" value="${The_Panch.middleName}"/></td>
					</tr><tr>
						<td><label>Last Name:</label></td>
						<td><input type="text" name="lastName" value="${The_Panch.lastName}" /></td>
					</tr>
					<tr></tr>
					<tr>
						<td></td>
						<td><input type="radio" name="gender" value="Male" checked>Male</input></td>
						<td><input type="radio" name="gender" value="Female">Female</input></td>											
					</tr>
					<tr></tr>
					<tr>
						<td><label>Age:</label></td>
						<td><input type="text" name="age" value="${The_Panch.age}"/></td>
						<td></td><td></td>
					</tr><tr>
						<td><label>Category:</label></td>
						<td><select id="category" name="category" >
						<option value="${The_Panch.category}">${The_Panch.category}</option>
						
							  <option value="General">General</option>
							  <option value="SC">Scheduled Caste</option>
							  <option value="Woman">Woman</option>
							  <option value="SCWoman">Woman - Scheduled Caste</option>
							 </select>
						</td>
					</tr>
					<tr></tr>	
					
					<tr>
						<td><label>Profession:</label></td>
						<td><input type="text" name="profession" value="${The_Panch.profession}"/></td>
						<td></td>
					</tr><tr>
						<td><label>Contact Number:</label></td>
						<td><input type="text" name="contact" value="${The_Panch.contact}"/></td>
					</tr>
					
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="PanchControllerServlet">Back to Panch details</a>
		</p>
	</div>
</body>

</html>
