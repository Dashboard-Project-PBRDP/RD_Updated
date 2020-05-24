<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Bank Details</title>
	
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
					<th>Account Active (YES/NO)</th>
					<th>Year of Opening</th>
					<th>Year of Closing</th>
					
				</tr>
			
				<c:forEach var="tempDetails" items="${Bank_List}" varStatus="counter">
					
					<!--  set up a link to update a details -->
					<c:url var="tempLink" value="BankControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="detailsId" value="${tempDetails.id}" />
					</c:url>

					<!--  set up a link to delete a details -->
					<c:url var="deleteLink" value="BankControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="detailsId" value="${tempDetails.id}" />
					</c:url>												
					<tr>
						<td> ${counter.count} </td>
						<td> ${tempDetails.bankName} </td>
						<td>${tempDetails.branch}</td>
						<td>${tempDetails.ifscCode}</td>
						<td>${tempDetails.accountNumber}</td>
						<td>${tempDetails.purpose}</td>
						<td>${tempDetails.currentBalance}</td>
						<td>${tempDetails.date}</td>
						<td>${tempDetails.activeAccount}</td>
						<td>${tempDetails.openingYear}</td>
						<td>${tempDetails.closingYear}</td>
						<td> 
							<a href="${tempLink}">Update</a> 
							 | 
							<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this Detail?'))) return false">
							Delete</a>	
						</td>
					</tr>
					</c:forEach>
				
						
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