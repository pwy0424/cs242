<?php
 	include_once "log.php";
 	include_once "list.php";
 	include_once "file.php";
 	include_once "version.php";
 
 	class Project{
 		
 		public $logs = array();
 		public $lists = array();
 		public $files = array();
 		

 		public $name;
 		public $date;
 		public $revision;
 		public $msg;
 		
 		 /**
 		 * helper function findType, 
 		 * @return string: image, doc, code, other
 		 * @param string $path
 		 */
 		 
 		 public function findType($path){
 		 	//echo substr($path, -3)."<br>";
 		 	if (strcmp(substr($path, -3), ".js") == 0 
 		 	or strcmp(substr($path, -4), ".php") == 0 
 		 	or strcmp(substr($path, -3), ".py") == 0
 		 	or strcmp(substr($path, -5), ".html") == 0 
 		 	or strcmp(substr($path, -5), ".java") == 0){
 		 		return "code";
 		 	}
 		 	elseif(strcmp(substr($path, -4), ".txt") == 0){
 		 		return "doc";
 		 	}
 		 	elseif(strcmp(substr($path, -4), ".jpg") == 0 
 		 	or strcmp(substr($path, -4), ".png") == 0){
 		 		return "image";
 		 	}
 		 	else{
 		 		return "other";
 		 	}
 		 }
 		
 		
 		public function __construct($tName){
 			
 			//using simple xml parser to parse the xml into structure
 			$xml_svn_list = simplexml_load_file("svn_list.xml");
 			$xml_svn_log = simplexml_load_file("svn_log.xml");
 			
 			//constructing the array of logs
 			foreach($xml_svn_log->logentry as $logentry){
 				$tempLog = new LogSVN($logentry);
 				$this->logs[] = $tempLog;
 			};
 			
 			//constructing the array of lists
 			foreach($xml_svn_list->list->entry as $entry){
 				$tempList = new ListSVN($entry);
 				$this->lists[] = $tempList;
 			}
 			
 			$newName = "/pan30/".$tName;
 			$flag = 0;
 			
 			//finding the name of project using $tName
 			
 			foreach($this->logs as $log){
 				foreach($log->paths as $path){

	 				if(strcmp((string)$newName, (string)substr($path->name, 0, strlen($newName))) == 0)
	 				{
	 					$this->name = $tName;
	 					$this->date = $log->date;
	 					$this->revision = $log->revision;
	 					$this->msg = $log->msg;
	 					
	 					$flag = 1;
	 						
	 				}
	 			 }//end of path loop
	 			 if($flag == 1){
	 				break;
	 			 }
	
 			}//end of log loop
 			
 			$flag = 0;
 			
 			foreach($this->logs as $log){
 				foreach($log->paths as $path){
 					if(strcmp("file", (string)$path->kind) == 0 
 					and strcmp((string)$newName, (string)substr($path->name, 0, strlen($newName))) == 0){ 
 						//echo $path."<br>";
	 					$tempVersion = new VersionSVN($log->revision, $log->author, $log->msg, $log->date);
	 					foreach($this->files as $f){
	 						if(strcmp($path->name, $f->path) == 0){
	 							$flag = 1;
	 							$f->version[] = $tempVersion;
	 						}
	 					}
	 					if($flag == 0){
	 						$tarType = $this->findType("$path->name");
	 						
	 						$tempFile = new FileSVN(0, $tarType, $path->name);
	 						$tempFile->version[] = $tempVersion;
	 						$this->files[] = $tempFile;
	 					}
	 					else{
	 						$flag = 0;
	 					}
	 				}
	 				else{
	 					//do nothing
	 				}
 				}
 			}
 			
 			//$tName = AssignmetX.X
 			foreach($this->lists as $list){
 				if(strcmp(substr($list->name, 0, strlen($tName)), $tName) == 0){
 					
 					// matched filename will add size into the files list
 					foreach($this->files as $f){
 						
 						$tempStr = "/pan30/".(string)$list->name;
 						if(strcmp($tempStr, (string)$f->path) == 0){
 							$f->size = $list->size;
 							
 							
 						}
 						
 					}//end of file loop
 				}
 			}//end of list loop
 			
 		}// end of construct function
 	}
 
 
?>
