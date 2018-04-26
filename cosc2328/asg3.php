<?php
// Example script that uses a form for
// inputting user's name and phone number
// reports back what area code they're in and
// checks that all fields are filled in.
//  expects data when form is submitted as GET
//  theName - name of person
//  phone1 - area code
// phone2- exhange number
// phone3- last four digits

require "classfun.php";
//expects style name and page name
printDocHeading("style.css", "Assignment 3");
print "<body>\n<div id='wrapper'>\n";
print "<div id='hero'><img src='images/hero.jpg' width='1000' height='200' alt='hero image' /></div>\n";

print "<div id='navigation'>\n";
print "<ul id='nav'>\n";
print "<li><a href='../index.html'>Home</a></li>\n";
print "<li><a href='index.html'>COSC 2328</a></li>\n";
print "<li><a href='http://steamcommunity.com/profiles/76561198146445965/'>Steam</a></li>\n";
print "</ul>\n";
print "</div>\n";
print "<div id='bigBody'>";
print "<h2>some phone number checker</h2>\n";

if(empty ($_GET))
{
  showForm();
}
else
{
  checkFormData();
}
//print "</div>\n";  // end of opening div
printDocFooter();

// function that displays form to user, uses default arguments
//  1st arg for name, 2nd arg for area code, 3rd for exchange, 4th for the rest of the digits
function showForm($aName="", $phone1="",$phone2="",$phone3="")
{
  $self = $_SERVER['PHP_SELF'];
  print "<div> <form method='get' action='$self' >\n";
  print "<h3> Enter your name: <input type='text' name='theName' ".
        " value='$aName' /></h3>\n";
  print "<h3> Enter your phone number: <br/> <sub>555-555-5555</sub><br/> </h3>". "\n";
  print "<br/><input type='text' name='phone1' value='$phone1' size='3' maxlength='3' />\n";
  print "-" . "\n";
  print "<input type='text' name='phone2' value='$phone2' size='3' maxlength='3' />\n";
  print "-" . "\n";
  print "<input type='text' name='phone3' value='$phone3' size='4' maxlength='4' />\n";
  print "<br/><br/> <input type='submit' name='submit' ".
        " value='submit!!' />\n";
  print "</form>\n</div>\n</div></div>\n";
}

// function that expects to find data in GET
// expects theName (text) and three numbers
// phone 1 expected to have 3 valid digits
// phone 2 expected to have 3 valid digits
// phone 3 expected to have 4 valid digits
// either process data (its valid and present)
// or outputs error message and reprints input form
function checkFormData()
{
  $name = htmlentities($_GET['theName'], ENT_QUOTES);
  $phone1 = htmlentities($_GET['phone1'], ENT_QUOTES);
  $phone2 = htmlentities($_GET['phone2'], ENT_QUOTES);
  $phone3 = htmlentities($_GET['phone3'], ENT_QUOTES);
  $errorMessage = "";
  echo "this is the variable for phone3: $phone3";

  if($name == "")
  {
    $errorMessage .= "<h3> You must enter your name... </h3>\n";
  }
  if($phone1 == "" || !is_numeric($phone1) || strlen($phone1)<3)
  {
    $phone1="";
    $errorMessage .= "<h3> You must enter a valid area code with 3 digits... </h3>\n";
  }

  if($phone2=="" || !is_numeric($phone2) || strlen($phone2)<3)
  {
  $phone2="";
  $errorMessage .= "<h3>You must enter a valid exchange number with 3 digits... </h3>\n ";
  }

  if($phone3=="" || !is_numeric($phone3) || strlen($phone3)<4)
  {
  $phone3="";
  $errorMessage .= "<h3>You must enter a valid number with 4 digits...</h3>\n";
  }

  if($errorMessage)
  {
    print $errorMessage;
    showForm($name, $phone1, $phone2, $phone3);
  }
  else 
  {
    if($phone1 == 512)
    {     
    	  $result="<br /> Your phone number is in the Austin area! \n";
    }
      if($phone1 == 830 || $phone1==210)
      {
         $result="<br /> Your phone number is in the San Antonio area! \n";
      }     
      if($phone1==713 || $phone1==832 ||$phone1==409)
     {
	 $result="<br /> Your phone number is in the Houston area! ";
      }

    if ($phone1 != 512 && $phone1 != 830 && $phone1 != 210 && $phone1 != 713 && $phone1 != 832 && $phone1 != 409 && $phone1 != 404)
    {
	$result = "<br /> You aren't from around here, are you? \n";
    }
print " <h2> Hello $name!!! <br /> $result </h2> \n";
  }//end else
  startOverLink();
}// end checkFormData function

?>