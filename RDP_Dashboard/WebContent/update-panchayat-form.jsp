<!DOCTYPE html>
<html>

<head>
	<title>Update Block</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>${sessionScope.districtName } > ${sessionScope.blockName }</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Update Panchayat</h3>
		
		<form action="PanchayatControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />

			<input type="hidden" name="panchayatId" value="${The_Panchayat.id}" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Panchayat name:</label></td>
						<td><input type="text" name="panchayatName" 
								   value="${The_Panchayat.panchayatName}" /></td>
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
			<a href="PanchayatControllerServlet">Back to Panchayats List</a>
		</p>
	</div>
</body>

</html>
