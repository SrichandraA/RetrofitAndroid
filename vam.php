<?php

			
$link= mysqli_connect("localhost","root","","test");
	if(mysqli_connect_error()){

		die ("not connected");
	}
	$response=array();

if($_SERVER['REQUEST_METHOD'] ==  'POST'){


	$pname=$_POST['pname'];

	$query="INSERT INTO vamsi (name) VALUES('$pname')";

	if(mysqli_query($link,$query)){

		$response['success']=1;
		$response['message']='inserted yo';
		echo json_encode($response);
	}
	else{
		$response['success']=0;
		$response['message']='failed';
		echo json_encode($response);

	}

}
else{
	echo "not post";
}






	?>
