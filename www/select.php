<?php require 'connection.php';
$sql = "SELECT * FROM user";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    $rows = array();
    // output data of each row
    while($row = $result->fetch_assoc()) {
	$rows[] = $row;
	
    }
    echo json_encode($rows);
} else {
    echo "0 results";
}
$conn->close();

?>