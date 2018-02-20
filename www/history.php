<?php require 'connection.php';
if(isset($_POST['regId']) && isset( $_POST['date']))
{
$regId=$_POST['regId'];
$date=$_POST['date'];
$date=date($date);
//$date="2000-01-04 00:00:00";
//$regId="KA09CV1234";
$tablename="tollhistory";
$tablename1="ratelist";
$tablename2="paymentdetails";
$sql = "SELECT * FROM $tablename t1 ,$tablename1 t2   where t1.tollid=t2.tollid and t1.regno='$regId' and t1.date > '$date' ";
$sql1="SELECT * FROM $tablename2 where regno='$regId'";
$result1=$conn->query($sql1);
if($result1->num_rows == 0)
{
	$sql2="INSERT INTO $tablename2 VALUES ('$regId','$date')";
}
else
{
	$sql2="UPDATE $tablename2 set Lastpaid='$date' where regno='$regId'";
}
$result1=$conn->query($sql2);
$result = $conn->query($sql);
$rows = array();
if ($result->num_rows > 0) 
{
    
    // output data of each row
    while($row = $result->fetch_assoc()) {
	$rows[] = $row;
	
    }
    
}
 else {
    
}
echo json_encode($rows);
}
$conn->close();

?>