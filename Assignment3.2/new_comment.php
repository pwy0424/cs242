<?php


$dbcon = mysql_connect("engr-cpanel-mysql.engr.illinois.edu", "pan30_cs242", "pwy0424", "pan30_Assignment3");

mysql_select_db('pan30_Assignment3');


$content = $_POST["content"];
$content =  mysql_real_escape_string($content);


if($content != NULL)
{
    $filter = mysql_query("SELECT * from Filter");
    
    while ($row = mysql_fetch_array($filter)) 
    {

	$content = str_replace($row["Red_flag"], $row["Replacement"], $content);
    }


    mysql_query("INSERT INTO Comments(ID, Content, Parent, Has_child)
			VALUES (NULL, '".$content."', ".$_POST["parent"].", -1)");
			
    if($_POST["parent"] != -1)//this is some one's child,
    {
    	mysql_query("UPDATE Comments SET Has_child = 1 WHERE ID = ".$_POST["parent"]);
    }
     
}

header("Location: index.php");
?>