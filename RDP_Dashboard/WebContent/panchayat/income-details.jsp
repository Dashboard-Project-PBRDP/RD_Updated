<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Income Details</title>
	
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
		<!-- 	<form action="IncomeControllerServlet" method="get">
			<input type="hidden" name="command" value="INCSOURCE">
  			<input  type="submit" value="Add Details" id="submitconst" class="add-student-button">
			</form>-->
			<table>
			
				<tr>
					<th>Sr No</th>
					<th>Year</th>
					<th>Month</th>
					<th>Opening Balance</th>
					<th>Income Type (Own/Grant)</th>
					<th>Income Source (Dropdown)</th>
					<th>Amount</th>
					<th>Purpose</th>
					<th>Bank Account (Dropdown)</th>
					<th>Sanction Letter Number</th>
					<th>Sanction Letter Date</th>
					<th>UC Status</th>
				</tr>
				
				<c:forEach var="tempDetails" items="${Income_List}" varStatus="counter">
					
					<!--  set up a link to update a details -->
					<c:url var="tempLink" value="IncomeControllerServlet">
						<c:param name="command" value="LOAD" /> 
						<c:param name="detailsId" value="${tempDetails.id}" />
					</c:url>

					<!--  set up a link to delete a details -->
					<c:url var="deleteLink" value="IncomeControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="detailsId" value="${tempDetails.id}" />
					</c:url>
																		
					<tr>
						<td> ${counter.count} </td>
						<td> ${tempDetails.year} </td>
						<td>${tempDetails.month}</td>
						<td>${tempDetails.openingBalance}</td>
						<td>${tempDetails.incomeType}</td>
						<td>${tempDetails.incomeSource}</td>
						<td>${tempDetails.amount}</td>
						<td>${tempDetails.purpose}</td>
						<td>${tempDetails.bankAccount}</td>
						<td>${tempDetails.sanction_letter_no}</td>
							<td>${tempDetails.sanction_letter_date}</td>
								<td>${tempDetails.ucStatus}</td>
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
