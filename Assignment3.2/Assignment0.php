<?php
 	include_once "parsing.php";
 	$assignment = new Project("Assignment0");
?>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Assignment0</title>

    <!-- Le styles -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <style>
      body {
        padding-top: 60px;//move everything down so they are below top bar
      }
    </style>
    <link href="css/bootstrap-responsive.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

  </head>
  
  <script>
function change_iframe(str)
{
var xmlhttp;
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("myiframe").innerHTML=xmlhttp.responseText;
    }
  }
xmlhttp.open("GET","iframe_change.php?url="+str,true);
xmlhttp.send();
//this function is from w3school
}
</script>

  <body>

    <!-- Fixed navbar -->
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="index.php">Cover Page</a></li>
            <li class="active"><a href="Assignment0.php">Assignment0</a></li>
            <li><a href="Assignment1.php">Assignment1</a></li>
            <li><a href="Assignment2.php">Assignment2</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>
    <!-- end of navigation bar -->



    <div class="container">
		
	<h1> Assignment0 <br><br> </h1>
	<?php
		echo "<pre>";
		echo "name: ".$assignment->name."<br>";
 		echo "time: ".$assignment->date."<br>";
 		echo "vision number: ".$assignment->revision."<br>";
		echo "</pre>";
	?>

    	<table class="table table-hover">
    	  
    	  <?php
    	  
    	  foreach($assignment->files as $f){
    	  	$count = 1;
    	  	$onclick = "change_iframe('".$f->path."')";
 		echo "<tr><td><button onclick=".$onclick.">".(string)"path: ".$f->path."</button></td>";
 		echo "<td>".(string)"type: ".$f->type."</td>";
 		echo "<td>".(string)"size: ".$f->size."</td>";
 		echo "<td>".(string)"versions: ".(string)(count($f->version))."</td>";
 		echo "<td><td><tr/>";
 		foreach($f->version as $ver){
 			echo "<tr><td>Submission No.".(string)$count ."</td>";
 			echo "<td>".(string)"number: ".$ver->number."</td>";
 			echo "<td>".(string)"author: ".$ver->author."</td>";
 			echo "<td>".(string)"time: ".$ver->date."</td></tr>";
 			$count = $count + 1;
 		}
 		echo "<tr></tr>";
	}
    	  ?>
	</table>
	<div id="myiframe">
	<iframe src="https://subversion.ews.illinois.edu/svn/sp14-cs242/pan30/" width="1000" height="600">
 	 <p>Your browser does not support iframes.</p>
	</iframe>
	</div>

    </div> <!-- /container -->

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap-transition.js"></script>
    <script src="js/bootstrap-alert.js"></script>
    <script src="js/bootstrap-modal.js"></script>
    <script src="js/bootstrap-dropdown.js"></script>
    <script src="js/bootstrap-scrollspy.js"></script>
    <script src="js/bootstrap-tab.js"></script>
    <script src="js/bootstrap-tooltip.js"></script>
    <script src="js/bootstrap-popover.js"></script>
    <script src="js/bootstrap-button.js"></script>
    <script src="js/bootstrap-collapse.js"></script>
    <script src="js/bootstrap-carousel.js"></script>
    <script src="js/bootstrap-typeahead.js"></script>

  </body>
</html>