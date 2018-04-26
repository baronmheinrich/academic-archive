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

else if($_POST['submit'])
{
	showSubStoryForm();
}

else if($_POST['submitReplace'])
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

function showSubStoryForm($subs=array())
{
//gets rid of bad things in value field in option
print_r($_POST);

$num=htmlentities($_POST['storyNum'], ENT_QUOTES);

//checks if the value field correlates to proper story number
if($num<1 || $num>3)
{
        showStoryForm();
        return;
}

//get file by inputed num and then show the substitute story
else
{

$substitute="story". $num . "sub" . ".txt";
$subContent=file_get_contents($substitute);
$pattern="/\[(.*?)\]/";
$mathces=array();
preg_match_all($pattern,$subContent,$matches);


print "<h3>The substitute story:</h3><br/>". "\n";
print nl2br($subContent) ."\n";

print "<h3>To make your own story, fill in all the blanks below:</h3>" . "\n";

$arr_len=count($matches[0]);
print "<form method='post' action='$self'>" . "\n";
for($i=0; $i<$arr_len; $i++)
{
print $matches[1][$i].": ". "<input type='text' name='subs[]' value='$subs[$i]' /> <br/>". "\n";
}

print "<input type='submit' name='submitReplace' value='Submit this story?'/>" . "\n";
print "<br/>";
print "<input type='hidden' name='hiddenNum' value='$num'/>". "\n";
print "<input type='submit' name='goBack' value='Go Back?'/>" . "\n";
print "</form>";
}
}


function checkStoryForm()
{

$subs=$_POST['subs'];
$storyNum=$_POST['hiddenNum'];
$errorMessage="";

for($index=0; $index<count($subs); $index++)
{
	if($subs[$index]=="")
	{	
		print "There's an empty field...";
		showSubStoryForm($subs);
		return;
	}
}

$substitute="story". $storyNum . "sub" . ".txt";
$subContent=file_get_contents($substitute);
$pattern="/\[(.*?)\]/";
preg_match_all($pattern,$subContent,$matches);

for($i=0; $i<count($matches[0]); $i++)
{
$strReplace=$subs[$i];
$subContent=str_replace($matches[0][$i],$strReplace,$subContent);
}
print "<h3>Here's your own story! </h3>";
print nl2br($subContent);

startOverLink();


}




?>