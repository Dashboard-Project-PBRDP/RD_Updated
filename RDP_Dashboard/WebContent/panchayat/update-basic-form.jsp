<!DOCTYPE html>
<html>

<head>
	<title>Update Basic Details</title>

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
		<h3>Update Basic details</h3>
		
		<form action="BasicControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />

			<input type="hidden" name="detailsId" value="${The_Basic.id}" />
			
			<table>
				<tbody>
				<tr>
						<td><label>Population :</label></td>
						<td><input type="text" name="population" value="${The_Basic.population}"/></td>
					</tr>
					<tr>
						<td><label>No of Households:</label></td>
						<td><input type="text" name="households" value="${The_Basic.households}"/></td>
					</tr>
					<tr>
						<td><label>No of Voters :</label></td>
						<td><input type="text" name="voters" value="${The_Basic.voters}"/></td>
					</tr>
					<tr>
						<td><label>No of Wards :</label></td>
						<td><input type="text" name="wards" value="${The_Basic.wards}"/></td>
					</tr>
					<tr>
						<td><label>Topography :</label></td>
						<td><input type="radio" name="topography" value="PLAIN">PLAIN</td>
						<td><input type="radio" name="topography" value="HILLY" checked>HILLY</td>						
						<td><input type="radio" name="topography" value="SEMI-HILLY" checked>SEMI-HILLY</td>		
					</tr>
					<tr>
						<td><label>No of Ponds :</label></td>
						<td><input type="text" name="ponds" value="${The_Basic.ponds}" /></td>
					</tr>
					<tr>
						<td><label>Area Covered by ponds (in Acres) :</label></td>
						<td><input type="text" name="areaPonds" value="${The_Basic.areaPonds}"/></td>
					</tr>
					<tr>
						<td><label>Pond area leased out for fisheries (in Acres) :</label></td>
						<td><input type="text" name="pondFisheries" value="${The_Basic.pondFisheries}"/></td>
					</tr>
					<tr>
						<td><label>Panchayat Ghar :</label></td>
						<td><input type="radio" name="panchayatghar" value="YES">YES</td>
						<td><input type="radio" name="panchayatghar" value="NO" checked>NO</td>						
					</tr>
					<tr>
						<td><label>Panchayat Ghar Type :</label></td>
						<td><input type="text" name="panchayatgharType" value="${The_Basic.panchayatgharType}"/></td>
					</tr>
					<tr>
						<td><label>No of Dharamshalas :</label></td>
						<td><input type="text" name="dharamshalas" value="${The_Basic.dharamshalas}"/></td>
					</tr>
					<tr>
						<td><label>No of reserved Dharamshalas :</label></td>
						<td><input type="text" name="reservedDharamshalas" value="${The_Basic.reservedDharamshalas}"/></td>
					</tr>
					<tr>
						<td><label>No of Parks :</label></td>
						<td><input type="text" name="parks" value="${The_Basic.parks}"/></td>
					</tr>
					<tr>
						<td><label>Area covered by Parks (in Acres) :</label></td>
						<td><input type="text" name="areaParks" value="${The_Basic.areaParks}"/></td>
					</tr>
					<tr>
						<td><label>No of Playgrounds :</label></td>
						<td><input type="text" name="playgrounds" value="${The_Basic.playgrounds}"/></td>
					</tr>
					<tr>
						<td><label>Area under playgrounds (in Acres) :</label></td>
						<td><input type="text" name="areaPlaygrounds" value="${The_Basic.areaPlaygrounds}"/></td>
					</tr>
					<tr>
						<td><label>Distance from Mandi (in KM) :</label></td>
						<td><input type="text" name="mandiDistance" value="${The_Basic.mandiDistance}"/></td>
					</tr>
					<tr>
						<td><label>No of Banks :</label></td>
						<td><input type="text" name="banks" value="${The_Basic.banks}"/></td>
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
			<a href="BasicControllerServlet">Back to Basic details</a>
		</p>
	</div>
</body>

</html>
