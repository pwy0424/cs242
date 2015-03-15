<?php
	/**
	* this is the class of list which parsing from the svn_log.xml

	**/
	
	include_once "path.php";

	
	class LogSVN{
	    
	    public $author;
	    public $date;
	    public $paths;
	    public $msg;
	    public $revision;
	    
	    
	    
	    /**
	    * constructor: parsing the data in for each $target entry
	    * @para: $target -- an entry from log xml
	    * @return: none
	    **/
	    
	    
	    public function __construct($target){
	    	$this->author = $target->author;
	    	$this->msg = $target->msg;
	    	$this->date = $target->date;
	    	$this->revision = $target->attributes()["revision"];
	    	$this->paths = array();
	    	foreach($target->paths->path as $path){
			$kind = $path->attributes()["kind"];
			$action = $path->attributes()["action"];
			$tempPath = new PathSVN($path, $kind, $action);
			$this->paths[] = $tempPath;
		}
	    }
	}
?>
