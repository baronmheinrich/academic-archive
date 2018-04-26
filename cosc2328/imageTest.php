<?php

$image=imagecreatetruecolor(1000,1000);

$gray=imagecolorallocate($image,200,200,200);
$yellow=imagecolorallocate($image,255,255,100);
$pink=imagecolorallocate($image,255,184,255);
$blue=imagecolorallocate($image,184,214,255);
$seagreen=imagecolorallocate($image,184,255,214);

imagefill($image, 0, 0, $gray);

imageellipse($image,100,100,100,100,$yellow);

header("Content-type: image/png");
imagepng($image);


?>