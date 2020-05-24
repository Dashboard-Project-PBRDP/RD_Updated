<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title> List of GPs</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h3>${sessionScope.districtName} > ${sessionScope.blockName} > ${sessionScope.panchayatName}</h3>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<table>
			
				<tr>
					<th>Sr No</th>
					<th>Link</th>
					<th></th>
					<th></th>
				</tr>
				
				<c:forEach var="tempPanchayat" items="${Detail_List}" varStatus="counter">
					
					<!-- set up a link for entry into each detail -->
					<c:url var="detailLink" value="PDetailControllerServlet">
						<c:param name="command" value="${tempPanchayat.pDetailId}" />
						<c:param name="panchayatId" value="${tempPanchayat.pId}" />
						<c:param name="panchayatName" value="${tempPanchayat.panchayatName}" />
						
					</c:url>
																
					<tr>
						<td> ${counter.count} </td>
			  			<td> <a href="${detailLink}" title="Click to enter">${tempPanchayat.pDetail} </a></td> 
						
						<td> 
								
						</td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
	<div style="clear: both;"></div>
		<div>
		<p>
			<a href="PanchayatControllerServlet">Back to Panchayats List</a>
		</p>
	</div>
</body>

</html>