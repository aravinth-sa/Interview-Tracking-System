<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>forgot_password?</title>
<link rel="stylesheet" href="resources/css/menu.css">
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/animate.css">
<script type="text/ecmascript" src="resources/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="animated bounceInUp container" style="width: 60%;">
		<form action="MainServlet" method="post">
			<fieldset class="scheduler-border well">
				<div class="form-group">
					<span>
						<h3 align="center">
							<label style="">Change Password</label>
						</h3> <br> <label style="">User ID</label>
					</span><span> <input type="text" class="form-control" id="user_id"
						name="user_id">
					</span> <label style="">User Type</label> </span><span> <input
						type="text" class="form-control" id="user_type" name="user_type">
					</span> <label style="">New Password</label> </span><span> <input
						type="password" class="form-control" id="new_password"
						name="new_password">
					</span> <label style="">Confirm New Password</label> </span><span> <input
						type="password" class="form-control" id="conf_new_password"
						name="conf_new_password">
					</span>
				</div>
				<br> <br>
				<div align="center">
					<button class="button" type="submit">Update Your Password</button>
				</div>
			</fieldset>
		</form>
			<jsp:include page="footer.jsp"></jsp:include>

			</div>
</body>
</html>