<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>edit</title>
<link rel="stylesheet" href="resources/css/menu.css">
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" href="resources/css/animate.css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script type="text/ecmascript" src="resources/js/bootstrap.min.js"></script>
</head>

<body>
		<jsp:include page="adminheader.jsp"></jsp:include>

	<div class="animated bounceInUp container" style="width: 70%;">
		<s:form action="update" modelAttribute="candidateBean" method="post">
			<fieldset class="scheduler-border well">
				 <div class="form-group">
					<span> <label style="">Candidate ID</label>
					</span> <span> <s:input  class="form-control" path="candidateID" readonly="true"/>
					</span>
				</div> 
				
				
				<div class="form-group">
					<span> <label style="">Primary Skills</label>
					</span> <span> <s:input  class="form-control" path="primarySkills"/>
					</span>
				</div>
				<div class="form-group">
					<span> <label style="">Secondary Skills</label>
					</span> <span> <s:input  class="form-control" path="secondarySkills"/>
					</span>
				</div>
				<div class="form-group">
					<span> <label style="">Experience</label>
					</span> <span> <s:input  class="form-control" path="experience"/>
					</span>
				</div>
				<div class="form-group">
					<span> <label style="">Qualification</label>
					</span> <span> <s:input  class="form-control" path="qualification"/>
					</span>
				</div>
				<div class="form-group">
					<span> <label style="">Designation</label>
					</span> <span> <s:input  class="form-control" path="designation"/>
					</span>
				</div>
				<div class="form-group">
					<span> <label style="">Notice Period</label>
					</span> <span> <s:input  class="form-control" path="noticePeriod"/>
					</span>
				</div>

				<br> <br>
				<div align="center">
					<button class="button" type="submit">Update</button>
				</div>
			</fieldset>
		</s:form>


			<jsp:include page="footer.jsp"></jsp:include>

	</div>
</body>
</html>