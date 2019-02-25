<?php session_start(); /* Starts the session */
if(!isset($_SESSION['UserData']['username']))
{
echo "hello";
}
?>
<a href="sign_up.php">Store Registration</a>