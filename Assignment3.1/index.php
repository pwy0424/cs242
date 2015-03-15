<?php
function submit_button($ID)
{
    echo "<form name='input' action='new_comment.php' method='post'>";

    echo "Comments: <input type='text' name='content'>";
    echo "<input type='hidden' name='parent' value=".$ID.">";
    echo "<input type='submit' value='Submit'>";
    echo "</form>";
}

function print_comment_rec($parent, $comment, $comments)
{
    if($comment["Parent"] != $parent)
    {
    	return;
    }
    
    else 
    {
    	echo "<pre>";
    	echo $comment["Content"];
    	echo "<br>";
    	if($comment["Has_child"] == 1)
    	{
    	    foreach($comments as $comment_)
     	    {
     	        print_comment_rec($comment["ID"], $comment_, $comments);
     	    } 
    	}
    	submit_button($comment["ID"]);
    	echo "</pre>";
    }
    

}
?>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Portfolio</title>

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
            <li class="active"><a href="index.php">Cover Page</a></li>
            <li><a href="Assignment0.php">Assignment0</a></li>
            <li><a href="Assignment1.php">Assignment1</a></li>
            <li><a href="Assignment2.php">Assignment2</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>
    <!-- end of navigation bar -->


    <div class="container">

      <div class="buttons">
        <h1>Cover Page</h1>
        <br>
        <p><a href="Assignment0.php" class="btn btn-primary btn-large">Assignment0 &raquo;</a></p>
        <p><a href="Assignment1.php" class="btn btn-primary btn-large">Assignment1 &raquo;</a></p>
        <p><a href="Assignment2.php" class="btn btn-primary btn-large">Assignment2 &raquo;</a></p>
      </div>
      
      <br><br>
      
     <?php
     	 $dbcon = mysql_connect("engr-cpanel-mysql.engr.illinois.edu", "pan30_cs242", "pwy0424", "pan30_Assignment3");
     	 mysql_select_db('pan30_Assignment3');
     	 $result = mysql_query("SELECT * FROM Comments");
     	 $comments = array();
     	 while($row =  mysql_fetch_array($result))
	{
		array_push($comments, $row);
	}
	echo "<pre>";
     	foreach($comments as $comment)
     	{
     	     print_comment_rec(-1, $comment, $comments);
     	}
     	echo "<br>"; 
        submit_button(-1);
        echo "</pre>";
     ?>

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