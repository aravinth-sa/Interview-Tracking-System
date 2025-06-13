<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>change_password</title>
<link rel="stylesheet" href="resources/css/menu.css">
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/animate.css">
<script type="text/ecmascript" src="resources/js/bootstrap.min.js"></script>
</head>
<script type="text/javascript">
	function myFunction() {
		var pass1 = document.getElementById("new_password").value;
		var pass2 = document.getElementById("conf_new_password").value;

		if (pass1 != pass2) {
			//alert("Passwords Do not match");
			document.getElementById("new_password").style.borderColor = "#E34234";
			document.getElementById("conf_new_password").style.borderColor = "#E34234";
			document.getElementById("l").innerHTML = "Password Mismatch!!!";
		} else {
			document.getElementById("l").innerHTML = "Password Match!!!";
		}
	}
</script>
<body>
	<div class="animated bounceInUp container" style="width: 60%;">
		<form action="changepassword" method="post">
			<fieldset class="scheduler-border well">
				<div class="form-group">
					<span>
						<h3 align="center">
							<label style="">Update Your Password</label>
						</h3> <br> <label style="">User ID</label>
					</span><span> <input type="text" class="form-control" id="userid"
						name="userid" required="required">
					</span> <label style="">Old Password</label> </span><span> <input
						type="password" class="form-control" id="old_password"
						name="old_password">
					</span> <label style="">New Password</label> </span><span> <input
						type="text" class="form-control" id="new_password"
						name="new_password">
					</span> <label style="">Confirm New Password</label> </span><span> <input
						type="password" class="form-control" id="conf_new_password"
						onchange="myFunction()" name="conf_new_password"> <label
						id="l"></label></span>
				</div>
				<br> <br>
				<div align="center">
					<button class="button" type="submit" onblur="return myFunction()">Update</button>

				</div>
			</fieldset>
		</form>
		<footer>
			<div id="footer">
				<div class="panel-footer" style="background-color: #963">
					<p align="center">
						<b>© XYZ Solutions</b>
					</p>
				</div>
			</div>
			</footer>
			</div>
</body>
</html>