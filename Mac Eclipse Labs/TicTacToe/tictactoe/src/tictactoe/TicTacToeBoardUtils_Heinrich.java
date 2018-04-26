package tictactoe;

public class TicTacToeBoardUtils_Heinrich 
{

public static int getMarkAtCoordinate(int row, int column) 
{
	int quadrant=0;
	if(row==0)
	{
		if(column==0)
			quadrant=0;
		else if(column==1)
			quadrant=1;
		else if(column==2)
			quadrant=2;
	}
	else if(row==1)
	{
		if(column==0)
			quadrant=3;
		else if(column==1)
			quadrant=4;
		else if(column==2)
			quadrant=5;

	}
	else if(row==2)
	{
		if(column==0)
			quadrant=6;
		else if(column==1)
			quadrant=7;
		else if(column==2)
			quadrant=8;
	}
	return quadrant;
}

public static boolean checkGameOver(String board,String space) 
{
	boolean result = false;
	if(board.charAt(0)==board.charAt(2) && board.charAt(2)==board.charAt(4) && board.charAt(0)!=' ')
	{
		result=true;
	}
	if(board.charAt(12)==board.charAt(14) && board.charAt(14)==board.charAt(16) && board.charAt(12)!=' ')
	{

		result=true;
	}
	if(board.charAt(24)==board.charAt(26) && board.charAt(26)==board.charAt(28) && board.charAt(24)!=' ')
	{

		result=true;
	}
	if(board.charAt(0)==board.charAt(12) && board.charAt(12)==board.charAt(24) && board.charAt(0)!=' ')
	{

		result=true;
	}
	if(board.charAt(2)==board.charAt(14) && board.charAt(14)==board.charAt(26) && board.charAt(2)!=' ')
	{

		result=true;
	}
	if(board.charAt(4)==board.charAt(16) && board.charAt(16)==board.charAt(28) && board.charAt(4)!=' ')
	{
		result=true;
	}
	if(board.charAt(0)==board.charAt(14) && board.charAt(14)==board.charAt(28) && board.charAt(0)!=' ')
	{

		result=true;
	}
	if(board.charAt(4)==board.charAt(14) && board.charAt(14)==board.charAt(24) && board.charAt(4)!=' ')
	{
		result=true;
	}
	if(!board.contains(space))
	{
		result=true;
	}
	return result;
	
}

public static Mark calculateWinner(String board) 
{
    if(board.charAt(0)==board.charAt(2) && board.charAt(2)==board.charAt(4) && board.charAt(0)!=' ')
    {
        if(board.charAt(0)=='X')
           return Mark.X;
        else
            return Mark.O;
    }
    else if(board.charAt(12)==board.charAt(14) && board.charAt(14)==board.charAt(16) && board.charAt(12)!=' ')
    {
        if(board.charAt(12)=='X')
           return Mark.X;
        else
            return Mark.O;
 
    }
    else if(board.charAt(24)==board.charAt(26) && board.charAt(26)==board.charAt(28) && board.charAt(24)!=' ')
    {
        if(board.charAt(24)=='X')
            	return Mark.X;
        else
            return Mark.O;

    }
    else if(board.charAt(0)==board.charAt(12) && board.charAt(12)==board.charAt(24) && board.charAt(0)!=' ')
    {
        if(board.charAt(0)=='X')
            return Mark.X;
        else
            return Mark.O;
    }
    else if(board.charAt(2)==board.charAt(14) && board.charAt(14)==board.charAt(26) && board.charAt(2)!=' ')
    {
        if(board.charAt(2)=='X')
            return Mark.X;
        else
            return Mark.O;
    }
    else if(board.charAt(4)==board.charAt(16) && board.charAt(16)==board.charAt(28) && board.charAt(4)!=' ')
    {
        if(board.charAt(4)=='X')
            return Mark.X;
        else
            return Mark.O;
    }
    else if(board.charAt(0)==board.charAt(14) && board.charAt(14)==board.charAt(28) && board.charAt(0)!=' ')
    {
        if(board.charAt(0)=='X')
            return Mark.X;
        else
            return Mark.O;
    }
    else if (board.charAt(4)==board.charAt(14) && board.charAt(14)==board.charAt(24) && board.charAt(4)!=' ')
    {
        if(board.charAt(4)=='X')
            return Mark.X;
        else
            return Mark.O;
    }
    else return null;
}



}