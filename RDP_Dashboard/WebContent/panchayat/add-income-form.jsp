<!DOCTYPE html>
<html>

<head>
	<title>Add Panchayat Income</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Add Details of Panchayat Income here </h2>
		</div>
	</div>
	
	<div id="container">
		<h3>${sessionScope.districtName}>${sessionScope.blockName}>${sessionScope.panchayatName}</h3>
		
		<form action="../IncomeControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="ADD" />
			
			<table>
				<tbody>
					
					<tr></tr>
					<tr>
						<td><label>Year:</label></td>
						<td>
							<select id="year" name="year">
							<option value="select">SELECT</option>
							<option>2018</option>
							  <option>2019</option>
							  <option>2020</option>
							  <option>2021</option>
							  <option>2022</option>
							  <option>2023</option>
							  <option>2024</option>
							  <option>2025</option>
							  <option>2026</option>
							  <option>2027</option>
							   <option>2028</option>
							</select>
						</td>
					</tr><tr>
						<td><label>Month:</label></td>
					<td>
							<select id="month" name="month">
							<option value="select">SELECT</option>
							<option>January</option>
							  <option>February</option>
							  <option>March</option>
							  <option>April</option>
							  <option>May</option>
							  <option>June</option>
							  <option>July</option>
							  <option>August</option>
							  <option>September</option>
							  <option>October</option>
							   <option>November</option>
							   <option>December</option>
							</select>
						</td>
					</tr><tr>
						<td><label>Opening Balance:</label></td>
						<td><input type="text" name="openingBalance" /></td>
					</tr>
					<tr>
						<td><label>Income Type :</label></td>
						<td><input type="radio" name="incomeType" value="GRANT">GRANT</input></td>
						<td><input type="radio" name="incomeType" value="OWN" checked>OWN INCOME</input></td>						
				
					</tr>
					<tr>
						<td><label>Income Source:</label></td>
						<td>
							<select id="incomeSource" name="incomeSource">
							<option value="select">SELECT</option>
							<option>1</option>
							<option value="1">14TH FC</option>
							  <option value="2">15TH FC</option>
							  <option value="3">RDF</option>
							  <option value="4">SVC</option>
							  <option value="5">OTHER</option>
        <!--    <c:forEach var="myList" items="${IncomeSource}" >
          <option value="${myList.scheme_id}">${myList.source_of_income}</option>
         </c:forEach>-->
							</select>
						</td>
					</tr>
					<tr>
						<td><label>Amount:</label></td>
						<td><input type="text" name="amount" /></td>
					</tr>
					<tr>
						<td><label>Purpose:</label></td>
						<td><input type="text" name="purpose" /></td>
					</tr>
					<tr>
						<td><label>Bank Account:</label></td>
						<td><select id="bankAccount" name="bankAccount">
						  <option value="select">SELECT</option>
							  <option value="Account1">199990999900</option>
							  <option value="Account2">348888899009</option>
							 </select>
						</td>
						<td></td><td></td>
					</tr>					
					<tr>
						<td><label>Sanction Letter No.:</label></td>
						<td><input type="text" name="sanction_letter_no" /></td>
						<td></td>
					</tr><tr>
						<td><label>Sanction Letter Date:</label></td>
						<td><input type="text" name="sanction_letter_date" /></td>
					</tr>
					<tr>
						<td><label>UC Status:</label></td>
						<TD>
						<select id="ucStatus" name="ucStatus">
							<option value="select">SELECT</option>
							<option>PENDING</option>
							  <option>COMPLETED</option>
							</select>
							</TD>
					</tr>
					
					<tr></tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="add-student-button" /></td>
					</tr>
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="IncomeControllerServlet">Back to Main List</a>
		</p>
	</div>
</body>

</html>