<?php

include "connect.php";

$name =  $_POST["name"];
$email =  $_POST["email"];
$city =  $_POST["city"];
$address =  $_POST["address"];
$phone =  $_POST["phone"];
$psw =  $_POST["psw"];
//$cpsw =  $_POST["cpsw"];

if(!empty($_POST['phone'])) //checking the 'user' name which is from Sign-Up.html, is it empty or have some text 
	 {
		 $qry = "SELECT * FROM store_reg WHERE contact_no = '$phone'";
		 $query = mysqli_query($conn,$qry);

		 
		 $tot = mysqli_num_rows($query);
		
		 if($tot < 1)
			{
				$query = "INSERT INTO store_reg (store_name,store_add,store_city,contact_no,email,password) VALUES ('$name','$address','$city','$phone','$email','$psw')"; 
				$data = mysqli_query ($conn,$query)or die(mysqli_error($conn));
				if($data) { 
					echo "YOUR REGISTRATION IS COMPLETED..."; 
					header("Location:new.php");
				}
				
				else  { 
					echo "Retry Registration..."; 
				}
			}
		else
			{
				echo "YOU ARE ALREADY REGISTERED USER...";
			}
	}
?>