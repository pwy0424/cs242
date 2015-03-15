<?php

//echo $_GET["url"];
$url = "https://subversion.ews.illinois.edu/svn/sp14-cs242".$_GET["url"];
echo '<iframe src="'.$url.'" width="1000" height="1200">';
echo '<p>Your browser does not support iframes.</p>';
echo '</iframe>';

?>