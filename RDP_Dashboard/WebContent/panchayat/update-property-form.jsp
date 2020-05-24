<!DOCTYPE html>
<html>

<head>
	<title>Update Property Details</title>

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
		<h3>Update Property details</h3>
		
		<form action="PropertyControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />

			<input type="hidden" name="detailsId" value="${The_Property.id}" />
			
			<table>
				<tbody>
				<tr>
						<td><label>Property Type:</label></td>
						<td><input type="radio" name="propertyType" value="Movable">Movable</td>
						<td><input type="radio" name="propertyType" value="Immovable" checked>Immovable</td>		
					</tr>
					<tr>
						<td><label>Property Name:</label></td>
						<td><input type="text" name="propertyName" value="${The_Property.propertyName}"/></td>
					</tr>
					<tr>
						<td><label>Area:</label></td>
						<td><input type="text" name="area" value="${The_Property.area}"/></td>
					</tr>
					<tr>
						<td><label>Location :</label></td>
						<td><input type="text" name="location" value="${The_Property.location}"/></td>
					</tr>
					<tr>
						<td><label>Identifier (eg. Khasra No/ Number of items):</label></td>
						<td><input type="text" name="identifier" value="${The_Property.identifier}"/></td>
					</tr>
					<tr>
						<td><label>Purpose (Commercial/Common/Other):</label></td>
						<td><input type="text" name="purpose" value="${The_Property.purpose}"/></td>
					</tr>
					<td><label>Leased Out (Yes/No):</label></td>
						<td>
							<select id="leasedOut" name="leasedOut">
							<option value="${The_Property.leasedOut}">${The_Property.leasedOut}</option>
						
							<option value="select">SELECT</option>
							<option>YES</option>
							  <option>NO</option>
							</select>
						</td>
					<tr>
						<td><label>Lease From (dd/mm/yy) :</label></td>
						<td><input type="text" name="leasedFrom" value="${The_Property.leasedFrom}" /></td>
					</tr>
					<tr>
						<td><label>Lease To (dd/mm/yy):</label></td>
						<td><input type="text" name="leasedTo" value="${The_Property.leasedTo}"/></td>
					</tr>
					<tr>
						<td><label>Lease Amount :</label></td>
						<td><input type="text" name="leaseAmount" value="${The_Property.leaseAmount}"/></td>
					</tr>
					<tr>
						<td><label>Lease Amount Per Year :</label></td>
						<td><input type="text" name="leaseAmountpyear" value="${The_Property.leaseAmountpyear}"/></td>
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
			<a href="PropertyControllerServlet">Back to Property details</a>
		</p>
	</div>
</body>

</html>
