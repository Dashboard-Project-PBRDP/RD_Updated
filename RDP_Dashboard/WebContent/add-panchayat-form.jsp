<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	<title>Add Panchayat</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Rural Development</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Add New Panchayat in ${sessionScope.districtName} > ${sessionScope.blockName}</h3>
		
		<form action="PanchayatControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="ADD" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Panchayat name:</label></td>
						<td><input type="text" name="panchayatName" /></td>
					</tr>
					<tr>
						<td><label>Constituency</label></td>
						<td>
							<select id="constituency" name="constituency">
            <c:forEach var="myList" items="${Constituency}" >
          <option value="${myList.constituency_id}">${myList.constituency_name}</option>
         </c:forEach>
							</select>
						</td>
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
			<a href="PanchayatControllerServlet">Back to List of Panchayats in ${sessionScope.blockName}</a>
		</p>
	</div>
</body>

</html>
