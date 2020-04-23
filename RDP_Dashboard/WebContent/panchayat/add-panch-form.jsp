<!DOCTYPE html>
<html>

<head>
	<title>Add Sarpanch & Panch</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Add Details of GP Members here</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>${sessionScope.districtName}>${sessionScope.blockName}>${sessionScope.panchayatName}</h3>
		
		<form action="../PanchControllerServlet" method="POST">
		
			<input type="hidden" name="command" value="ADD" />
			
			<table>
				<tbody>
					<tr>
						<td></td>
						<td><input type="radio" name="designation" value="Sarpanch">Sarpanch</input></td>
						<td><input type="radio" name="designation" value="Panch" checked>Panchayat Member</input></td>						
					</tr>
					<tr></tr>
					<tr>
						<td><label>First Name:</label></td>
						<td><input type="text" name="firstName" /></td>
					</tr><tr>
						<td><label>Middle Name:</label></td>
						<td><input type="text" name="middleName" /></td>
					</tr><tr>
						<td><label>Last Name:</label></td>
						<td><input type="text" name="lastName" /></td>
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
						<td><input type="text" name="age" /></td>
						<td></td><td></td>
					</tr><tr>
						<td><label>Category:</label></td>
						<td><select id="category" name="category">
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
						<td><input type="text" name="profession" /></td>
						<td></td>
					</tr><tr>
						<td><label>Contact Number:</label></td>
						<td><input type="text" name="contact" /></td>
					</tr>

					
					<tr></tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="add-student-button" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="PanchControllerServlet">Back to Main List</a>
		</p>
	</div>
</body>

</html>