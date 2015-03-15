<?php
 /**
  * the fileSVN class is containing the data for a file which will get the info from:
  * 1. Its size
  * 2. The type of the file: is one of code, test, image, documentation, resource, etc (feel free to add as many types as you wish).
  * 3. The path is the path to your files in SVN.
  * 4. The file itself loaded in an iframe only on demand
  * 5. Each version of each file in the project
	(1) The number is the revision number for that commit
	(2) The author is the netid of the committer
	(3) The info is the commit message for that revision
	(4) The date is the date of that commit
  */
 
 	class FileSVN{

 		public $size;
 		public $type;
 		public $path;
 		public $version = array();
 		
 		public function __construct($tSize, $tType, $tPath){
 			$this->size = $tSize;
 			$this->type = $tType;
 			$this->path = $tPath;
 			
 			
 		}
 		
 		
 		
 	}
 
?>
