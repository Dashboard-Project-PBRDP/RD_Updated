<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bank Account Details</title>
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
				   onclick="window.location.href='panchayat/add-bank-form.jsp'; return false;"
				   class="add-student-button"
			/>
			
			<table>
			
				<tr>
					<th>Sr No</th>
					<th>Name of Bank</th>
					<th>Branch</th>
					<th>IFSC Code</th>
					<th>Account Number</th>
					<th>Purpose</th>
					<th>Current Balance</th>
					<th>Date of Fetching Balance</th>
					<th>Account Active (Y/N)</th>
					<th>Year of Opening</th>
					<th>Year of Closing</th>
					
				</tr>
				<!--  
				<c:forEach var="tempDetails" items="${Panch_List}" varStatus="counter">
					
					
					<c:url var="tempLink" value="PanchControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="detailsId" value="${tempDetails.id}" />
					</c:url>

					
					<c:url var="deleteLink" value="PanchControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="detailsId" value="${tempDetails.id}" />
					</c:url>
																		
					<tr>
						<td> ${counter.count} </td>
						<td> ${tempDetails.firstName} </td>
						<td>${tempDetails.middleName}</td>
						<td>${tempDetails.lastName}</td>
						<td>${tempDetails.designation}</td>
						<td>${tempDetails.age}</td>
						<td>${tempDetails.gender}</td>
						<td>${tempDetails.category}</td>
						<td>${tempDetails.profession}</td>
						<td>${tempDetails.contact}</td>
						<td> 
							<a href="${tempLink}">Update</a> 
							 | 
							<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this Detail?'))) return false">
							Delete</a>	
						</td>
					</tr>
				
				</c:forEach>
				-->
			</table>
		
		</div>
	
	</div>
	<div style="clear: both;">
		
		<p>
			<a href="PDetailControllerServlet">Back to List of Links</a>
		</p>
	</div></body>
</html>