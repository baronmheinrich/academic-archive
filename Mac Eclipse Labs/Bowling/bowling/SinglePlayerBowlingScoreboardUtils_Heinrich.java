package bowling;

public class SinglePlayerBowlingScoreboardUtils_Heinrich
{

	public static int getFrameFromRoll(int rollCount)
	{
		int theCurrentFrame=0;
		if(rollCount==0 || rollCount==1)
		{
			theCurrentFrame=1;
		}
		if(rollCount==2 || rollCount==3)
		{
			theCurrentFrame=2;
		}
		if(rollCount==4 || rollCount==5)
		{
			theCurrentFrame=3;
		}
		if(rollCount==6 || rollCount==7)
		{
			theCurrentFrame=4;
		}
		if(rollCount==8 || rollCount==9)
		{
			theCurrentFrame=5;
		}
		if(rollCount==10 || rollCount==11)
		{
			theCurrentFrame=6;
		}
		if(rollCount==12 || rollCount==13)
		{
			theCurrentFrame=7;
		}
		if(rollCount==14 || rollCount==15)
		{
			theCurrentFrame=8;
		}
		if(rollCount==16 || rollCount==17)
		{
			theCurrentFrame=9;
		}
		if(rollCount==18 || rollCount==19)
		{
			theCurrentFrame=10;
		}
		if(rollCount==20)
		{
			theCurrentFrame=10;
		}
		return theCurrentFrame;
	}
}
