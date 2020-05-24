<!DOCTYPE html>
<html>

<head>
<title>Add Panchayat Bank Details</title>

<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/add-student-style.css">
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Add Bank Details of Panchayat here</h2>
		</div>
	</div>

	<div id="container">
		<h3>${sessionScope.districtName}>${sessionScope.blockName}>${sessionScope.panchayatName}</h3>

		<form action="../BankControllerServlet" method="GET">

			<input type="hidden" name="command" value="ADD" />

			<table>
				<tbody>
					<tr>
						<td><label>Name of Bank:</label></td>
						<td><input type="text" name="bankName" /></td>
					</tr>
					<tr>
						<td><label>Branch :</label></td>
						<td><input type="text" name="branch" /></td>
					</tr>
					<tr>
						<td><label>IFSC Code:</label></td>
						<td><input type="text" name="ifscCode" /></td>
					</tr>
					<tr>
						<td><label>Account Number:</label></td>
						<td><input type="text" name="accountNumber" /></td>
					</tr>
					<tr>
						<td><label>Purpose:</label></td>
						<td><input type="text" name="purpose" /></td>
					</tr>
					<tr>
						<td><label>Current Balance:</label></td>
						<td><input type="text" name="currentBalance" /></td>
					</tr>
					<tr>
						<td><label>Date of fetching Balance:</label></td>
						<td><input type="text" name="date" /></td>
					</tr>
					<td><label>Account Active (YES/NO):</label></td>
					<td><select id="activeAccount" name="activeAccount">
							<option value="select">SELECT</option>
							<option>YES</option>
							<option>NO</option>
					</select></td>
					<tr>
						<td><label>Year of Opening :</label></td>
						<td><input type="text" name="openingYear" /></td>
					</tr>
					<tr>
						<td><label>Year of Closing :</label></td>
						<td><input type="text" name="closingYear" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save"
							class="add-student-button" /></td>
					</tr>
				</tbody>
			</table>
		</form>

		<div style="clear: both;"></div>

		<p>
			<a href="BankControllerServlet">Back to Main List</a>
		</p>
	</div>
</body>

</html>