<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="sp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Declared Results</title>
<link rel="stylesheet" href="resources/css/menu.css">
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/animate.css">
<script type="text/ecmascript" src="resources/js/bootstrap.min.js"></script>
</head>

<body>
	<jsp:include page="adminheader.jsp"></jsp:include>

	<div class="animated bounceInUp container" style="width: 60%;">
		<s:form action="share" modelAttribute="interviewScheduleBean"
			method="post">
			<fieldset class="scheduler-border well">
				<div class="form-group">
					<span> <label style="">Interview ID</label>
					</span> <span> <s:select class="form-control" path="interviewID">
							<s:option value="#">
								<i>Select Interview id</i>
							</s:option>
							<c:forEach var="id" items="${id}">

								<s:option value="${id}">${id}</s:option>
							</c:forEach>
						</s:select>
					</span>
				</div>
				<div class="form-group">
					<span> <label style=""> Share Result</label>
					</span> <span> <s:select class="form-control" path="shareResult">
							<s:option value="-1">  </s:option>
							<s:option value="1">YES</s:option>
							<s:option value="0">NO</s:option>
						</s:select>
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