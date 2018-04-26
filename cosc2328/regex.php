<?php
require "classfun.php";

printDocHeading("style.css","Regex in class assignment");
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

//page logic

print "this is the original file: <br/>" . "\n";
$var1= file_get_contents("phoneNumbers.txt");
print "$var1<br/><br/>";

print "this is the modified file: <br/>";

$var1=pattern1($var1);
$var1=pattern2($var1);
$var1=pattern3($var1);
$var1 = pattern4($var1);

print $var1;

print "</div>" . "\n";

printDocFooter();

//matches phone numbers with (###)###-####
function pattern1($contents)
{
$pattern1="/\(((\d{3}))\)\s*((\d{3}))\s*-\s*((\d{4}))/";
$matches=array();

preg_match_all($pattern1,$contents,$matches);

//print_r($matches);

$arr_length=count($matches[0]);
for($i=0; $i<$arr_length; $i++)
{
	$replace= " ".$matches[1][$i]."-".$matches[2][$i]."-".$matches[3][$i] . " ";
	$contents=str_replace($matches[0][$i],$replace,$contents);
}
return $contents;
}

//matches phone numbers with ###-###-####
function pattern2($contents)
{
	$pattern2="/\s*(\d{3})\s*-\s*(\d{3})\s*-\s*(\d{4})/";
	$matches=array();


	preg_match_all($pattern2,$contents,$matches);
//	print_r($matches);

$arr_length=count($matches[0]);
for($i=0; $i<$arr_length; $i++)
{
	$replace= " " . $matches[1][$i]."-".$matches[2][$i]."-".$matches[3][$i] . " ";
	$contents=str_replace($matches[0][$i],$replace,$contents);
}

return $contents;

}

//matches ###.###.####
function pattern3($contents)
{
	$pattern3="/\s*(\d{3})\s*\.\s*(\d{3})\s*\.\s*(\d{4})/";
	$matches=array();
	preg_match_all($pattern3,$contents,$matches);
	print_r($matches);

	$arr_length=count($matches[0]);
	for($i=0; $i<$arr_length; $i++)
	  {
	  	$replace=" ".$matches[1][$i]."-".$matches[2][$i]."-".$matches[3][$i]." ";
		$contents=str_replace($matches[0][$i],$replace,$contents);
	}	
return $contents;
}

//matches ########## aka 9 digits in a row
function pattern4($contents)
{

	$pattern4="/(\d{3})\s*(\d{3})\s*(\d{4})/";
	$matches=array();
	preg_match_all($pattern4,$contents,$matches);
//	print_r($matches);

	$arr_length=count($matches[0]);
	for($i=0; $i<$arr_length; $i++)
	{
              $replace=" ". $matches[1][$i]."-".$matches[2][$i]."-".$matches[3][$i] . " ";
	      $contents=str_replace($matches[0][$i],$replace,$contents);
	}
 	return $contents;
}

//function pattern5()
//{
//}



?>