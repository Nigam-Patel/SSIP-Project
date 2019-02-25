<?php
if(isset($_POST['submit'])){
	$user = $_POST['Username'];
	$pass = $_POST['Password'];
	if($user=="admin" && $pass=="admin"){
		echo("username and password matched");
		header("Location: logout.php");
	}else{
	echo("error ! please enter correct data!");
	}
}
?>
 <html>
 <style>
form {
  border: 3px solid #f1f1f1;
}
.input[type=text], .input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

.button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

/* Add a hover effect for buttons */
button:hover {
  opacity: 0.8;
}
/* Add padding to containers */
.container {
  padding: 16px;
} 
 </style>
 <body>
 <form action="" method="post" >
	<table align="center">
		<tr>
			<td>Username:</td>
			<td><input type="text" name="Username" placeholder="enter your username" class="input"></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name ="Password" placeholder="enter your password" class="input"></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" name="submit" value="submit" class="button"></td>
		</tr>
	</table>
</form>
</html>
</body>
