<?php
	/**
 	 * 	Each version of each file in the project
		(1) The number is the revision number for that commit
		(2) The author is the netid of the committer
		(3) The info is the commit message for that revision
		(4) The date is the date of that commit
 
 	 */
 
 	class VersionSVN{
 		
 		public $number;
 		public $author;
 		public $info;
 		public $date;
 		
 		public function __construct($tNumber, $tAuthor, $tInfo, $tDate){
 			
 			$this->number = $tNumber;
 			$this->author = $tAuthor;
 			$this->info = $tInfo;
 			$this->date = $tDate;
 		
 		}
 		
 	}
 	
 	
?>
