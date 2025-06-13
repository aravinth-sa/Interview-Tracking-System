<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="sp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Interview Schedule</title>
<link rel="stylesheet" href="resources/css/menu.css">
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/animate.css">
<script type="text/ecmascript" src="resources/js/bootstrap.min.js"></script>
</head>

<body>
		<jsp:include page="adminheader.jsp"></jsp:include>
		
		<h3 align="center" style="color: white">${msg}</h3>

	<div class="animated bounceInUp container" style="width: 60%;">
		<s:form action="schedule" modelAttribute="interviewScheduleBean"
			method="post">
			<fieldset class="scheduler-border well">

				<div class="form-group">
					<span> <label style="">Candidate ID</label>
					</span><span> <s:select class="form-control" path="candidateID">
							<s:option value="#">Select id</s:option>
							<c:forEach var="id" items="${idList}">

								<s:option value="${id}">${id}</s:option>
							</c:forEach>
						</s:select>
					</span>
				</div>
				<div class="form-group">
					<span> <label style="">Subject</label>
					</span><span> <s:select class="form-control" path="subject">
							<s:option value="#">Select Subject</s:option>
							<c:forEach var="sub" items="${sub}">

								<s:option value="${sub}">${sub}</s:option>
							</c:forEach>
						</s:select>
					</span>
				</div>
				<div class="form-group">
					<span> <label style="">Tech ID</label>
					</span><span> <s:select class="form-control" path="techID">
							<s:option value="#">Select techID</s:option>
							<c:forEach var="techId" items="${techId}">

								<s:option value="${techId}">${techId}</s:option>
							</c:forEach>
						</s:select>
					</span>
				</div>
				<div class="form-group">
					<span> <label style="">Interview Date</label>
					</span><span> <s:input class="form-control" path="interviewDate" required="required" />
					</span>
				</div>
				<div class="form-group">
					<span> <label style="">Interview Time</label>
					</span><span> <s:input class="form-control" path="interviewTime" required="required"/>
					</span>
				</div>
				<div class="form-group">
					<span> <label style="">Emp HR ID</label>
					</span><span> <s:select class="form-control" path="empHRID">
							<s:option value="#">Select HR ID</s:option>
							<c:forEach var="hrId" items="${hrId}">

								<s:option value="${hrId}">${hrId}</s:option>
							</c:forEach>
						</s:select>
					</span>
				</div>
				<div class="form-group">
					<span> <label style="">Emp HR Interview Date</label>
					</span><span> <s:input class="form-control"
							path="empHRInterviewDate" required="required"/>
					</span>
				</div>
				<div class="form-group">
					<span> <label style="">Emp HR Interview Time</label>
					</span><span> <s:input class="form-control"
							path="empHRInterviewTime" required="required"/>
					</span>
				</div>

				<br> <br>
				<div align="center">
					<button class="button" type="submit">Done</button>
				</div>
			</fieldset>
		</s:form>
			<jsp:include page="footer.jsp"></jsp:include>

	</div>
</body>
</html>