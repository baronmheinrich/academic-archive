<?php
require "classfun.php";
printDocHeading("style.css", "Assignment 5-1");
print "\n<div id='wrapper'>\n";
print "<div id='hero'><img src='images/hero.jpg' width='1000' height='200' alt='hero image' /></div>\n";
print "<div id='navigation'>" . "\n";
print "<ul id='nav'>" . "\n";
print "<li><a href='../index.html'>Home</a></li>" ."\n";
print "<li><a href='index.html'>COSC 2328</a></li>" ."\n";
print "<li><a href='http://steamcommunity.com/profiles/76561198146445965/'>Steam</a></li>" . "\n";
print "</ul>" . "\n";
print "</div>" . "\n";
print "<div id='bigBody'>" . "\n";
print "<h2>OOOOH LOOK MAD LIBS</h2>" . "\n";

//shows story form dropdown at start up and shows the form again if back button
//is clicked
if(empty($_POST)|| $_POST['goBack'])
{
	showStoryForm();
}
	
else
{
	checkStoryForm();
}


print "</div> ". "\n";
print "</div> ". "\n";
printDocFooter();


function showStoryForm()
{

$self=$_SERVER['PHP_SELF'];
print "<form method='post' action='$self'>" . "\n";
print "<select name='storyNum'>" . "\n";
print "<option value='0'> Choose a story from the list...</option>" . "\n";
print "<option value='1'>American</option>" . "\n";
print "<option value='2'>Summertime Sadness</option>" . "\n";
print "<option value='3'>Young and Beautiful</option>" . "\n";
print "</select>" . "\n";
print "<input type='submit' name='submit' value='Submit!'/>" . "\n";
print "</form>" . "\n";
}

//checks the story form if the submit button is clicked on the dropdown list page

function checkStoryForm()
{
//gets rid of bad things in value field in option

$num=htmlentities($_POST['storyNum'], ENT_QUOTES);

//checks if the value field correlates to proper story number
if($num<1 || $num>3)
{
	showStoryForm();
	return;
}

else
{
//get file name based on $num
$file="story" . $num .".txt";
$substitute="story". $num . "sub" . ".txt";
$originalContent=file_get_contents($file);
$subContent=file_get_contents($substitute);

$pattern="/\[(.*?)\]/";
$mathces=array();
preg_match_all($pattern,$subContent,$matches);

print "<h3> The original story that you selected:</h3><br/> <br/>"."\n" ;
print nl2br($originalContent) . "\n";
print "<h3>The substitute story:</h3><br/><br/>". "\n";
print nl2br($subContent) ."\n";
print "<h3>matches made in the substitute story:</h3><br/></br/>" . "\n";
print_r($matches);

//go back button
$self=$_SERVER['PHP_SELF'];
print "<form method='post' action='$self'>" . "\n";
print "<input type='submit' name='goBack' value='Go Back?'/>" . "\n";
print "</form>";
}}


?>