<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Share Candidate Info</title>
<link rel="stylesheet" href="resources/css/menu.css">
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script type="text/ecmascript" src="resources/js/bootstrap.min.js"></script>
</head>

<body>
	<jsp:include page="adminheader.jsp"></jsp:include>

	<div  class="animated bounceInUp container" style="width: 60%;">
		<s:form action="shareCandidate" modelAttribute="candidateBean"
			method="post">
			<fieldset class="scheduler-border well">

				<div class="form-group">
					<span> <label style=""> Candidate ID</label>
					</span><span><s:select class="form-control" path="candidateID">
					
							<s:option value="#">Select id</s:option>
							<c:forEach var="id" items="${idList}">

								<s:option value="${id}">${id}</s:option>
							</c:forEach>
						</s:select> </span>
				</div>
				<div class="form-group">
					<span> <label style=""> Share Details To Panels?</label>
					</span><span> Yes <s:radiobutton path="shareDetails" value="1" />
					      No <s:radiobutton path="shareDetails" value="0" />
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