<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Candidate_Details</title>
<link rel="stylesheet" href="resources/css/menu.css">
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" href="resources/css/table.css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script type="text/ecmascript" src="resources/js/bootstrap.min.js"></script>
</head>

<body>
		<jsp:include page="adminheader.jsp"></jsp:include>
		<div class="container">
			<table bgcolor="white" align="center" cellpadding="0" cellspacing="0"
				border="1">
				<tr bgcolor="yellow">

					<th>Candidate ID</th>
					<th>Primary Skills</th>
					<th>Secondary Skills</th>
					<th>Experience</th>
					<th>Qualification</th>
					<th>Designation</th>
					<th>Notice Period</th>
					<th>Location</th>
					<th>Share Details</th>
					<th colspan="3">Action</th>
				</tr>
				<c:forEach var="candidateBean" items="${candidateBeanList}">

					<tr bgcolor="white">
						<td>${candidateBean.candidateID}</td>
						<td>${candidateBean.primarySkills}</td>
						<td>${candidateBean.secondarySkills}</td>
						<td>${candidateBean.experience}</td>
						<td>${candidateBean.qualification}</td>
						<td>${candidateBean.designation}</td>
						<td>${candidateBean.noticePeriod}</td>
						<td>${candidateBean.location}</td>
						<td>${candidateBean.shareDetails}</td>
						<td><a
							href="delCandidate/${candidateBean.candidateID}/${candidateBean.primarySkills}/${candidateBean.qualification}">Delete</a></td>
						<td><a href="editCandidate/${candidateBean.candidateID }">Edit</a></td>
					</tr>
				</c:forEach>
			</table>
					<jsp:include page="footer.jsp"></jsp:include>
			
		</div>

		
</body>
</html>
