<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>XYZ Solutions</title>

<!-- Google Fonts -->
<!--<link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900' rel='stylesheet' type='text/css'>-->
<link href='http://fonts.googleapis.com/css?family=Oleo+Script'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Lobster+Two'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Berkshire+Swash'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="resources/css/animate.css">
<!-- Custom Stylesheet -->
<link rel="stylesheet" href="resources/css/style.css">


</head>

<body>
	<div class="container">
		<div class="hidden ">
			<h1 id="title" class="hidden">
				<span id="logo">XYZ Solutions</span>
			</h1>
		</div>
		<div align="center" class="login-box animated zoomIn "
			style="width: 125%">
			<div class="box-header">
				<h2>Log In</h2>
			</div>
			<form action="login" method="post">
			<h4>
				<label for="username">Username</label> <br /> <input type="text"
					id="username" name="username"> <br /> <label for="password">Password</label>
				<br /> <input type="password" id="password" name="password">
				<br />
			</h4>
				<button type="submit">Sign In</button>
			</form>
			<br /> <label><a href="forgot_password"><p class="small">Forgot
						your password?</p></a> <label style="color: #963">New User?<a
					href="new_user">Register Here</a></label>
		</div>
	</div>
</body>

<script>
	$(document).ready(function() {
		$('#logo').addClass('animated fadeInDown');
		$("input:text:visible:first").focus();
	});
	$('#username').focus(function() {
		$('label[for="username"]').addClass('selected');
	});
	$('#username').blur(function() {
		$('label[for="username"]').removeClass('selected');
	});
	$('#password').focus(function() {
		$('label[for="password"]').addClass('selected');
	});
	$('#password').blur(function() {
		$('label[for="password"]').removeClass('selected');
	});
</script>

</html>