<!DOCTYPE html>
<html>

<head>
	<title>Update Bank Account Details</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
		<h3>${sessionScope.districtName}">${sessionScope.blockName}">${sessionScope.panchayatName}"</h3>
			</div>
	</div>
	
	<div id="container">
		<h3>Update Bank Account details</h3>
		
		<form action="BankControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />

			<input type="hidden" name="detailsId" value="${The_Bank.id}"" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Name of Bank:</label></td>
						<td><input type="text" name="bankName" value="${The_Bank.bankName}"/></td>
					</tr>
					<tr>
						<td><label>Branch :</label></td>
						<td><input type="text" name="branch" value="${The_Bank.branch}"/></td>
					</tr>
					<tr>
						<td><label>IFSC Code:</label></td>
						<td><input type="text" name="ifscCode"value="${The_Bank.ifscCode}" /></td>
					</tr>
					<tr>
						<td><label>Account Number:</label></td>
						<td><input type="text" name="accountNumber" value="${The_Bank.accountNumber}"/></td>
					</tr>
					<tr>
						<td><label>Purpose:</label></td>
						<td><input type="text" name="purpose" value="${The_Bank.purpose}"/></td>
					</tr>
					<tr>
						<td><label>Current Balance:</label></td>
						<td><input type="text" name="currentBalance" value="${The_Bank.currentBalance}"/></td>
					</tr>
					<tr>
						<td><label>Date of fetching Balance:</label></td>
						<td><input type="text" name="date"value="${The_Bank.date}" /></td>
					</tr>
					<td><label>Account Active (YES/NO):</label></td>
					<td><select id="activeAccount" name="activeAccount">
							<option value="select">SELECT</option>
							<option>YES</option>
							<option>NO</option>
					</select></td>
					<tr>
						<td><label>Year of Opening :</label></td>
						<td><input type="text" name="openingYear" value="${The_Bank.openingYear}"/></td>
					</tr>
					<tr>
						<td><label>Year of Closing :</label></td>
						<td><input type="text" name="closingYear" value="${The_Bank.closingYear}"/></td>
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
			<a href="BankControllerServlet">Back to Bank details</a>
		</p>
	</div>
</body>

</html>
