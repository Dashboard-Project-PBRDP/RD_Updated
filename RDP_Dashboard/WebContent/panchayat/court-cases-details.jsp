<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Court Cases</title>
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
					<th>Court Name (Dropdown)</th>
					<th>Case Number</th>
					<th>Case Year</th>
					<th>Case Name</th>
					<th>Plaintiffs</th>
					<th>Respondents</th>
					<th>Case Details</th>
					<th>Next Date</th>
					<th>Official Responsible to attend</th>
					<th>Last Order</th>
					<th>Status</th>
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