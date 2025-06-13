<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>View_Rating_By_ID</title>
<link rel="stylesheet" href="resources/css/menu.css">
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/animate.css">
<script type="text/ecmascript" src="bootstrap.min.js"></script>
</head>

<body>
	<jsp:include page="hrheader.jsp"></jsp:include>
	<div class="animated bounceInUp container" style="width: 60%;">
		<s:form action="" modelAttribute="interviewScheduleBean" method="post">
			<fieldset class="scheduler-border well">
				<div class="form-group">
					<span><b><i> Interview ID &nbsp;&nbsp; </span>: &nbsp;</i></b><span><i>${interviewScheduleBean.interviewID}</i></span><br>
				</div>
				<div class="form-group">
					<span><b><i> Candidate ID &nbsp;</span>: &nbsp;</i></b> <span><i>${interviewScheduleBean.candidateID}</i></span><br>
				</div>
				<div class="form-group">
					<span><b><i> Result
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</span>: &nbsp; </i></b><span><i>${interviewScheduleBean.result}</i></span><br>
			</fieldset>
		</s:form>
				<jsp:include page="footer.jsp"></jsp:include>

	</div>
</body>
</html>