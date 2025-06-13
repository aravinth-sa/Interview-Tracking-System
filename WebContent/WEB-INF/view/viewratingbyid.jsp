<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>View_Rating_By_ID</title>
<link rel="stylesheet" href="resources/css/menu.css">
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/animate.css">
<script type="text/ecmascript" src="bootstrap.min.js"></script>
</head>

<body>
			<jsp:include page="adminheader.jsp"></jsp:include>

	<div class="animated bounceInUp container" style="width: 60%;">
		<s:form action="" modelAttribute="interviewScheduleBean" method="post">
			<fieldset class="scheduler-border well">
				<div class="form-group">
					<span><b><i> Interview ID &nbsp; </span>: &nbsp;</i></b><span>${interviewScheduleBean.interviewID}</span><br>
				</div>
				<div class="form-group">
					<span><b><i> Candidate ID &nbsp;</span>: &nbsp;</i></b> <span>${interviewScheduleBean.candidateID}</span><br>
				</div>
				<div class="form-group">
					<span><b><i> Tech Rating &nbsp; </span>: &nbsp; </i></b><span>${interviewScheduleBean.techRating}</span><br>
				</div>
				<div class="form-group">
					<span><b><i> HR Rating &nbsp;&nbsp; &nbsp; </span>:&nbsp; </i></b>
					<span>${interviewScheduleBean.empHRRating}</span><br>
				</div>
			</fieldset>
		</s:form>
				<jsp:include page="footer.jsp"></jsp:include>

	</div>
</body>
</html>