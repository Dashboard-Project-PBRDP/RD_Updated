<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Smart Village Campaign</title>
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
					<th>Year</th>
					<th>Work Name</th>
					<th>Estimate</th>
					<th>RDF Component</th>
					<th>Finance Commission Grant Component</th>
					<th>MGNREGA Component</th>
					<th>Panchayat Fund Component</th>
					<th>RDF Expenditure</th>
					<th>FC Expenditure</th>
					<th>MGNREGA Expenditure</th>
					<th>PF Expenditure</th>
					<th>UC Status</th>
					
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