<?php
	/**
	* this is the class of list which parsing from the svn_list.xml
	**/
	class ListSVN{
	    
	    public $name;
	    public $revision;
	    public $author;
	    public $date;
	    public $kind;
	    public $size;
	    
	    /**
	    * constructor: parsing the data in for each $target entry
	    * @para: $target -- an entry from list xml
	    * @return: none
	    **/
	    
	    public function __construct($target){
	    	$this->name = $target->name;
	    	$this->revision = $target->commit->attributes()["revision"];
	    	$this->author = $target->commit->author;
	    	$this->date = $target->commit->date;
	    	$this->kind = $target->attributes()["kind"];
	    	$this->size = $target->size;
	    }
	}
?>
