<?php
require "classfun.php";
printDocHeading("style.css","Assignment 4");

print "<body>\n<div id='wrapper'>\n";
print "<div id='hero'><img src='images/hero.jpg' width='1000' height='200' alt='hero image' /></div>\n";
print "<div id='navigation'>" . "\n";
print "<ul id='nav'>" . "\n";
print "<li><a href='../index.html'>Home</a></li>" ."\n";
print "<li><a href='index.html'>COSC 2328</a></li>" ."\n";
print "<li><a href='http://steamcommunity.com/profiles/76561198146445965/'>Steam</a></li>" . "\n";
print "</ul>" . "\n";
print "</div>" . "\n";
print "<div id='bigBody'>" . "\n";
print "<h2>OOOOH LOOK AN OPEN BLOG</h2>" . "\n";

if(empty($_POST) || $_POST['no'])
{
	showBlogPosts();
	showBlogForm();
	}
	
else if($_POST['clear'])
{
	clear();
}

else if($_POST['yes'])
{
	clearBlogPosts();
}

else if($_POST['add'])
{
	checkSubmission();
	showBlogPosts();
	showBlogForm();
	}

print "</div> ". "\n";
printDocFooter();


function showBlogForm()
{
	//show blog entries by opening the file and loop through it
$self = $_SERVER['PHP_SELF'];
  print "<form method='post' action='$self'>" . "\n";
  print "<h3> Enter an Entry: <br/><textarea name='textbox'></textarea> </h3>" . "\n";
  print "<br/> <input type='submit' name='add' value='Add my Entry'/>" . "\n";
  print "<input type='submit' name='clear' value='Clear All'/>" . "\n";
  print "</form>\n</div>\n";  
  }

function showBlogPosts()
{
         $blogText="";            
         $fh= fopen("../../../nickiminajsleftarm/crystalmaidensangryaura.txt","r");
         if(!$fh) 
	 	   {
              print "<br /> Blog is empty .... <br />" . "\n";
          }
          else 
	         {
              flock($fh,LOCK_SH);
              while(!feof($fh)) {
                          $line= fgets($fh);
                    if($line == "") break;
                          list($time,$entry)= explode("|",$line);
                          $blogText = $time." :  ".$entry;
                          $blogText=str_replace("&!*!","|",$blogText);
                          print "\n"."<p>".$blogText."</p>" . "\n";
           }    
              flock($fh,LOCK_UN);
              if($blogText == "")
	      		        {
                    print "<br /> Blog is empty ......<br />" . "\n";
              }
          }

 }
 
function clearBlogPosts()
{
	$fh=fopen("../../../nickiminajsleftarm/crystalmaidensangryaura.txt","w");
	fclose($fh);
	}

function checkSubmission()
{
	    $filename= "../../../nickiminajsleftarm/crystalmaidensangryaura.txt";
     if($_POST['textbox']) {
             $userEntry= htmlentities($_POST['textbox'], ENT_QUOTES);
             $userEntry= str_replace("|","&!*!",$userEntry);
             $userEntry= str_replace("\n"," ",$userEntry);
             $dateEntry= date("d/m/Y:l:G:s:a");
             $contents= file_get_contents($filename);
             $contents= $dateEntry."|".$userEntry."\n".$contents;
             file_put_contents($filename,$contents);
     }
     else {
        print "Nothing was entered..... </br>"."\n"; 
     }
     
     //date entry goes here
     //$date=date("d"/"m"/"Y": G: i: s: a);
     //check if anything was added, if yes do the next stuff
     //get entry into a variable and get rid of bad stuff
     //replace the character return "|" with a different set of characters
     //get format of today's date
     //store the process data to a file
}
	
function clear()
{
	 $self= $_SERVER['PHP_SELF'];
     print "<form method='post' action='$self'>" . "\n";
     print "<h2> You're about to delete the blog's contents... You can't get them back... </h2>" . "\n";
     print "<input type='submit' name='yes' value='DELETE THEM ALL!' />"."\n";
     print "<input type='submit' name='no' value='NO! GO BACK!' />"."\n";
     print "</form>"."\n";
}
	
	
	
?>