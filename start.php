
<?php
$link= mysqli_connect("localhost","root","","test");
	if(mysqli_connect_error()){

		die ("not connected");
	}
	
//creating an array for storing the data 
$heroes = array(); 
 
//this is our sql query 
$sql = "SELECT  name FROM vamsi;";
 
//creating an statment with the query
$stmt = $link->prepare($sql);
 
//executing that statment
$stmt->execute();
 
//binding results for that statment 
$stmt->bind_result($name);
 
//looping through all the records
while($stmt->fetch()){
 
 //pushing fetched data in an array 
 $temp = [

 'name'=>$name
 ];
 
 //pushing the array inside the hero array 
 array_push($heroes, $temp);
}
 
//displaying the data in json format 
echo json_encode($heroes,JSON_PRETTY_PRINT);
		
?>


