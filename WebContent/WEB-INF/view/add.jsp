<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>add_candidate</title>
<link rel="stylesheet" href="resources/css/menu.css">
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" href="resources/css/animate.css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script type="text/ecmascript" src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function mobileNoCheck() {
		var mob = document.getElementById("mobileno").value;

		if (mob.length != 10) {
			document.getElementById("mob").innerHTML = "Invalid Mobile Number";
			return false;
		} else {
			document.getElementById("mob").innerHTML = " ";
			return true;
		}


	}

	function exprCheck() {
		
		var expr = document.getElementById("experience").value;

		if (!(expr>=0 && expr <1)) {
			document.getElementById("expr").innerHTML = "Should be less than 1 yr";
			return false;
		}else
			{
			document.getElementById("expr").innerHTML = " ";
			return true;
			}

	}
</script>
</head>

<body>
	<jsp:include page="adminheader.jsp"></jsp:include>

	<h3 align="center" style="color: white">${msg}</h3>

	<div class="animated bounceInUp container" style="width: 70%;">
		<form action="addCandidate" method="post">
			<fieldset class="scheduler-border well">
				<div class="form-group">
					<span> <label style="">First Name</label>
					</span> <span> <input type="text" class="form-control"
						id="firstname" name="firstname" required="required">
					</span>
				</div>
				<div class="form-group">
					<span> <label style="">Last Name</label>
					</span> <span> <input type="text" class="form-control"
						id="lastname" name="lastname" required="required">
					</span>
				</div>
				<div class="form-group">
					<span> <label style="">Date Of Birth</label>
					</span> <span> <input type="text" placeholder="dd/mm/yyyy"
						class="form-control" id="dateofbirth" name="dateofbirth"
						required="required">
					</span>
				</div>
				<div class="form-group">
					<span> <label style="">Gender</label>
					</span> <span> <input type="text" class="form-control" id="gender"
						name="gender" required="required">
					</span>
				</div>
				<div class="form-group">
					<span> <label style="">Street</label>
					</span> <span> <input type="text" class="form-control" id="street"
						name="street" required="required">
					</span>
				</div>

				<div class="form-group">
					<span> <label style="">City</label>
					</span> <span> <input type="text" class="form-control" id="city"
						name="city" required="required">
					</span>
				</div>
				<div class="form-group">
					<span> <label style="">State</label>
					</span><span> <input type="text" class="form-control" id="state"
						name="state" required="required">
					</span>
				</div>
				<div class="form-group">
					<span> <label style="">PinCode</label>
					</span> <span> <input type="text" class="form-control" id="pincode"
						name="pincode" required="required">
					</span>
				</div>
				<div class="form-group">
					<span> <label style="">Mobile No</label>
					</span> <span> <input type="text" class="form-control"
						id="mobileno" name="mobileno" required="required"
						onblur="return mobileNoCheck();"> <label id="mob" style=""></label>
					</span>

				</div>
				<div class="form-group">
					<span> <label style="">Email ID</label>
					</span> <span> <input type="email" class="form-control"
						id="emailid" name="emailid" required="required">
					</span>
				</div>
				<div class="form-group">
					<span> <label style="">Password</label>
					</span> <span> <input type="text" class="form-control"
						id="password" name="password" required="required">
					</span>
				</div>
				<div class="form-group">
					<span> <label style="">Primary Skills</label>
					</span> <span> <input type="text" class="form-control"
						id="primaryskills" name="primaryskills" required="required">
					</span>
				</div>
				<div class="form-group">
					<span> <label style="">Secondary Skills</label>
					</span> <span> <input type="text" class="form-control"
						id="secondaryskills" name="secondaryskills" required="required">
					</span>
				</div>
				<div class="form-group">
					<span> <label style="">Experience</label>
					</span> <span> <input type="text" class="form-control"
						id="experience" name="experience" required="required"
						onblur="return exprCheck();"> <label id="expr" style=""></label>
					</span>
				</div>
				<div class="form-group">
					<span> <label style="">Qualification</label>
					</span> <span> <input type="text" class="form-control"
						id="qualification" name="qualification" required="required">
					</span>
				</div>
				<div class="form-group">
					<span> <label style="">Designation</label>
					</span> <span> <input type="text" class="form-control"
						id="designation" name="designation">
					</span>
				</div>
				<div class="form-group">
					<span> <label style="">Notice Period</label>
					</span> <span> <input type="text" class="form-control"
						id="noticeperiod" name="noticeperiod">
					</span>
				</div>
				<div class="form-group">
					<span> <label style="">Location</label>
					</span> <span> <input type="text" class="form-control"
						id="location" name="location">
					</span>
				</div>

				<br> <br>
				<div align="center">
					<button class="button" type="submit" >ADD</button>
				</div>
			</fieldset>
		</form>

		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>