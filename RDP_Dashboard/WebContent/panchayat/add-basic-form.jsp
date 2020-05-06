<!DOCTYPE html>
<html>

<head>
	<title>Add Basic details</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Add Basic Details of Panchayat here </h2>
		</div>
	</div>
	
	<div id="container">
		<h3>${sessionScope.districtName}>${sessionScope.blockName}>${sessionScope.panchayatName}</h3>
		
		<form action="../BasicControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="ADD" />
			
			<table>
				<tbody>
					
					<tr></tr>
					<tr>
						
					</tr><tr>
						<td><label>Population :</label></td>
						<td><input type="text" name="population" /></td>
					</tr>
					</tr><tr>
						<td><label>No of Households:</label></td>
						<td><input type="text" name="households" /></td>
					</tr>
					</tr><tr>
						<td><label>No of Voters :</label></td>
						<td><input type="text" name="voters" /></td>
					</tr>
					</tr><tr>
						<td><label>No of Wards :</label></td>
						<td><input type="text" name="wards" /></td>
					</tr>
					<tr>
						<td><label>Topography :</label></td>
						<td><input type="radio" name="topography" value="PLAIN">PLAIN</input></td>
						<td><input type="radio" name="topography" value="HILLY" checked>HILLY</input></td>						
						<td><input type="radio" name="topography" value="SEMI-HILLY" checked>SEMI-HILLY</input></td>		
					</tr>
					</tr><tr>
						<td><label>No of Ponds :</label></td>
						<td><input type="text" name="ponds" /></td>
					</tr>
					</tr><tr>
						<td><label>Area Covered by ponds (in Acres) :</label></td>
						<td><input type="text" name="areaPonds" /></td>
					</tr>
					</tr><tr>
						<td><label>Pond area leased out for fisheries (in Acres) :</label></td>
						<td><input type="text" name="pondFisheries" /></td>
					</tr>
					<tr>
						<td><label>Panchayat Ghar :</label></td>
						<td><input type="radio" name="panchayatghar" value="YES">YES</input></td>
						<td><input type="radio" name="panchayatghar" value="NO" checked>NO</input></td>						
					</tr>
					</tr><tr>
						<td><label>Panchayat Ghar Type :</label></td>
						<td><input type="text" name="panchayatgharType" /></td>
					</tr>
					</tr><tr>
						<td><label>No of Dharamshalas :</label></td>
						<td><input type="text" name="dharamshalas" /></td>
					</tr>
					</tr><tr>
						<td><label>No of reserved Dharamshalas :</label></td>
						<td><input type="text" name="reservedDharamshalas" /></td>
					</tr>
					<tr>
						<td><label>No of Parks :</label></td>
						<td><input type="text" name="parks" /></td>
					</tr>
					<tr>
						<td><label>Area covered by Parks (in Acres) :</label></td>
						<td><input type="text" name="areaParks" /></td>
					</tr>
					<tr>
						<td><label>No of Playgrounds :</label></td>
						<td><input type="text" name="playgrounds" /></td>
					</tr>
					<tr>
						<td><label>Area under playgrounds (in Acres) :</label></td>
						<td><input type="text" name="areaPlaygrounds" /></td>
					</tr>
					<tr>
						<td><label>Distance from Mandi (in KM) :</label></td>
						<td><input type="text" name="mandiDistance" /></td>
					</tr>
					<tr>
						<td><label>No of Banks :</label></td>
						<td><input type="text" name="banks" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="add-student-button" /></td>
					</tr>
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="BasicControllerServlet">Back to Basic Details</a>
		</p>
	</div>
</body>

</html>