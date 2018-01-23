<?php
$servername = "localhost";
$username = "id4192925_root";
$password = "root@123";
$db = "id_4192925_tollsystem";

// Create connection
$conn = new mysqli($servername, $username, $password,$db);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 
?>