<!DOCTYPE html>
<html>

<head>
<title>Add Health/Education Details</title>

<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/add-student-style.css">
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Add Health/Education facility details here</h2>
		</div>
	</div>

	<div id="container">
		<h3>${sessionScope.districtName}>${sessionScope.blockName}>${sessionScope.panchayatName}</h3>

		<form action="../FacilityControllerServlet" method="GET">

			<input type="hidden" name="command" value="ADD" />

			<table>
				<tbody>
					<tr>
						<td><label>Facility Type:</label></td>
						<td><select id="facilityType" name="facilityType">
							<option value="select">SELECT</option>
							<option>HEALTH</option>
							<option>EDUCATION</option>
					</select></td>
					</tr>
					<tr>
						<td><label>Facility Name:</label></td>
						<td><input type="text" name="facilityName" /></td>
					</tr>
					<tr>
						<td><label>Level  (Anganwadi/primary/sec/etc or PHC/CHC/etc):</label></td>
						<td><input type="text" name="facilityLevel" /></td>
					</tr>
					<tr>
						<td><label>Area(In acres):</label></td>
						<td><input type="text" name="area" /></td>
					</tr>
					<tr>
						<td><label>Location:</label></td>
						<td><input type="text" name="location" /></td>
					</tr>
					<tr>
						<td><label>Identifier (eg. Khasra No/ Number of items):</label></td>
						<td><input type="text" name="identifier" /></td>
					</tr>
					<tr>
						<td><label>Condition Scale:</label></td>
						<td><select id="facilityCondition" name="facilityCondition">
							<option value="select">SELECT</option>
							<option>EXCELLENT</option>
							<option>GOOD</option>
							<option>AVERAGE</option>		
							<option>BAD</option>		
							<option>VERY BAD</option>			
					</tr>
					<td><label>Last Repaired (Year):</label></td>
					<td><select id="lastRepaired" name="lastRepaired">
							<option value="select">SELECT</option>
							<option>2017</option>
							<option>2018</option>
							<option>2019</option>
							<option>2020</option>
							<option>2021</option>
							<option>2022</option>
							<option>2023</option>
						
					</select></td>
					<tr>
						<td><label>Number of students/Beds :</label></td>
						<td><input type="text" name="facilityNumber" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save"
							class="add-student-button" /></td>
					</tr>
				</tbody>
			</table>
		</form>

		<div style="clear: both;"></div>

		<p>
			<a href="FacilityControllerServlet">Back to Main List</a>
		</p>
	</div>
</body>

</html>