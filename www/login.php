<?php
	 require 'connection.php';
	 $sucmsg="SucessFully Login";
	 $failmsg="Not Login";
	 $tablename="login";
	 if(isset($_POST['uname']) && isset($_POST['password']))
	 {
			$uname=$_POST['uname'];
			$password=$_POST['password'];
			$sql="SELECT * FROM $tablename WHERE Reg_id='$uname' and Password='$password'";
			$result = $conn->query($sql);
			$count=$result->num_rows;
			if($count==1)
			{
				$post_data=array('status' => 1 , 'msg' => $sucmsg);
				$post_data=json_encode($post_data);
				echo $post_data;
			}
			 else
			{		
				$post_data=array('status' => 0 , 'msg' => $failmsg);
				$post_data=json_encode($post_data);
				echo $post_data;
			} 
			
				
	 }
	
	 ?>