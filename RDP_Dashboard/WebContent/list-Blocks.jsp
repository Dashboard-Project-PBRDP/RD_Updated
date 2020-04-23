<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Block List</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>District - ${sessionScope.districtName}</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Block -->
			
			<input type="button" value="Add Block" 
				   onclick="window.location.href='add-block-form.jsp'; return false;"
				   class="add-student-button"
			/>
			
			<table>
			
				<tr>
					<th>Sr No</th>
					<th>Block</th>
					<th></th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempBlock" items="${Block_List}" varStatus="counter">
					
					<!-- set up a link for entry into each block -->
					<c:url var="blockLink" value="PanchayatControllerServlet">
						<c:param name="command" value="LIST" />
						<c:param name="blockId" value="${tempBlock.id}" />
						<c:param name="blockName" value="${tempBlock.blockName}" />
					</c:url>
					<!--  set up a link to update a block -->
					<c:url var="tempLink" value="ControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="blockId" value="${tempBlock.id}" />
					</c:url>

					<!--  set up a link to delete a block -->
					<c:url var="deleteLink" value="ControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="blockId" value="${tempBlock.id}" />
					</c:url>
																		
					<tr>
						<td> ${counter.count} </td>
						<td> <a href="${blockLink}" title="Click to enter">${tempBlock.blockName} </a></td>
						<td></td>
						<td> 
							<a href="${tempLink}">Update</a> 
							 | 
							<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this Block?'))) return false">
							Delete</a>	
						</td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
	<div style="clear: both;"></div>
		
		<p>
			<a href="DistrictControllerServlet">Back to District List</a>
		</p>
	</div>
</body>


</html>








