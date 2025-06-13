<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="sp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>View_Candidate</title>
<link rel="stylesheet" href="resources/css/menu.css">
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" href="resources/css/animate.css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">

</head>

<body>
		<jsp:include page="adminheader.jsp"></jsp:include>

	<div class="animated bounceInUp container" style="width: 60%;">

		<s:form action="viewinfo" modelAttribute="candidateBean" method="post">
			<fieldset class="scheduler-border well">
				<div class="form-group">
					<span> <label style=""> Skills</label>
					</span><span> <s:input class="form-control" path="primarySkills" required="required"/>
					</span>
				</div>
				<div class="form-group">
					<span> <label style="">Qualification</label>
					</span><span> <s:input class="form-control" path="qualification" required="required" />
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