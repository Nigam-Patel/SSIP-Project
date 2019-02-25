<?php
include 'dbconnect (2).php';



function NewUser() { 

	$storename = $_POST['name'];
	$storeadd = $_POST['address'];
	$email = $_POST['email'];
	$phone = $_POST['phone'];
	$pass = $_POST['pass'];
	$cpass = $_POST['cpass'];
	
	$query = "INSERT INTO store_reg (store_name,store_add,contact_no,email,password) VALUES ('$storename','$storeadd','$phone','$email','$pass')"; 
	$data = mysqli_query ($conn,$query)or die(mysqli_error($conn));
	if($data) { 
		echo "YOUR REGISTRATION IS COMPLETED..."; 
	}

} 

	
function SignUp() { 
	$servername = "localhost";
	$username = "root";
	$password = "";
	$database = "pocketpay";

	// Create connection
	$conn = new mysqli($servername, $username,$password,$database);

	// Check connection
	if ($conn->connect_error) {
		die("Connection failed: " . $conn->connect_error);
	} 
		
	echo "Connected successfully";
	
	if(!empty($_POST['phone'])) //checking the 'user' name which is from Sign-Up.html, is it empty or have some text 
	 {
		 $qry = "SELECT * FROM store_reg WHERE contact_no = '$_POST[phone]'";
		 $query = mysqli_query($conn,$qry) or die(mysqli_error($conn));

		if(!$row = mysqli_fetch_array($query) or die(mysqli_error($conn)))
		{
			NewUser();
		}
			
		else 
		{ 
			echo "s...YOU ARE ALREADY REGISTERED USER..."; 
		}
		
	}
	}
		if(isset($_POST['submit']))
	{	
		SignUp();
	}
?>

