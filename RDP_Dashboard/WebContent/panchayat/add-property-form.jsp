<!DOCTYPE html>
<html>

<head>
<title>Add Panchayat Property</title>

<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/add-student-style.css">
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Add Details of Panchayat Property here</h2>
		</div>
	</div>

	<div id="container">
		<h3>${sessionScope.districtName}>${sessionScope.blockName}>${sessionScope.panchayatName}</h3>

		<form action="../PropertyControllerServlet" method="GET">

			<input type="hidden" name="command" value="ADD" />

			<table>
				<tbody>
					<tr>
						<td><label>Property Type:</label></td>
						<td><input type="radio" name="propertyType" value="Movable">Movable</td>
						<td><input type="radio" name="propertyType" value="Immovable"
							checked>Immovable</td>
					</tr>
					<tr>
						<td><label>Property Name:</label></td>
						<td><input type="text" name="propertyName" /></td>
					</tr>
					<tr>
						<td><label>Area (in acres):</label></td>
						<td><input type="text" name="area" /></td>
					</tr>
					<tr>
						<td><label>Location :</label></td>
						<td><input type="text" name="location" /></td>
					</tr>
					<tr>
						<td><label>Identifier (eg. Khasra No/ Number of
								items):</label></td>
						<td><input type="text" name="identifier" /></td>
					</tr>
					<tr>
						<td><label>Purpose (Commercial/Common/Other):</label></td>
						<td><input type="text" name="purpose" /></td>
					</tr>
					<td><label>Leased Out (Yes/No):</label></td>
					<td><select id="leasedOut" name="leasedOut">
							<option value="select">SELECT</option>
							<option>YES</option>
							<option>NO</option>
					</select></td>
					<tr>
						<td><label>Lease From (dd/mm/yy) :</label></td>
						<td><input type="text" name="leasedFrom" /></td>
					</tr>
					<tr>
						<td><label>Lease To (dd/mm/yy):</label></td>
						<td><input type="text" name="leasedTo" /></td>
					</tr>
					<tr>
						<td><label>Lease Amount :</label></td>
						<td><input type="text" name="leaseAmount" /></td>
					</tr>
					<tr>
						<td><label>Lease Amount Per Year :</label></td>
						<td><input type="text" name="leaseAmountpyear" /></td>
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
			<a href="PropertyControllerServlet">Back to Main List</a>
		</p>
	</div>
</body>

</html>