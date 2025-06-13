<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Interview_candidate_list(HR)</title>
<link rel="stylesheet" href="resources/css/menu.css">
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/animate.css">
</head>

<body>
			<jsp:include page="hrheader.jsp"></jsp:include>

	<div class="animated fadeInRight container" style="width: 60%;">
		<s:form action="viewInterview(hr)"
			modelAttribute="interviewScheduleBean" method="post">
			<fieldset class="scheduler-border well">
				<div class="form-group">
					<span> <label style="">Emp HR ID</label>
					</span><span> <s:input class="form-control" path="empHRID"
							required="required" />
					</span>
				</div>
				<br>
				<div class="form-group">
					<span> <label style="">Date</label>
					</span><span> <s:input class="form-control" placeholder="dd-mmm-yy"
							path="empHRInterviewDate" required="required" />
					</span>
				</div>
				<br> <br>
				<div align="center">
					<button class="button" type="submit">DONE</button>
				</div>
			</fieldset>
		</s:form>
				<jsp:include page="footer.jsp"></jsp:include>
		
	</div>
	
</body>
</html>