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
			<jsp:include page="techheader.jsp"></jsp:include>

	<div class="animated fadeInRight container" style="width: 60%;">
		<s:form action="viewInterview" modelAttribute="interviewScheduleBean"
			method="post">
			<fieldset class="scheduler-border well">
				<div class="form-group">
					<span> <label style="">Tech ID</label>
					</span><span> <s:input class="form-control" path="techID"
							required="required" />
					</span>
				</div>
				<div class="form-group">
					<span> <label style="">Date</label>
					</span><span> <s:input class="form-control"
							placeholder="dd-mmm-yyyy" path="interviewDate"
							required="required" />
					</span>
				</div>
				<br> <br>
				<div align="center">
					<button class="button" type="submit">DONE</button>
				</div>
			</fieldset>
		</s:form>

			<jsp:include page="footer.jsp"></jsp:include></div>

</body>
</html>