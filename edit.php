<?php

$link=mysqli_connect("localhost","root","","test");
if(mysqli_connect_error()){

		die ("not connected");
	}
	$response=array();

	if($_SERVER['REQUEST_METHOD']== 'PUT'){

		    parse_str(file_get_contents("php://input"),$post_vars);


		$pname=$post_vars['pname'];

		$query="UPDATE vamsi SET name='$pname' WHERE name='hi';";

		if(mysqli_query($link,$query)){

			$response['success']=1;
			$response['message']='success';
			echo json_encode($response);
		}
		else{
			$response['success']=0;
			$response['message']='na na na';
			echo json_encode($response);
		}
	}
	else{
		echo 'not put';
	}
?>