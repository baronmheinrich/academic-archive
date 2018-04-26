package tictactoe;

public interface TicTacToeBoard
{
public final static int ROW_COUNT=3;
public final static int COLUMN_COUNT = 3;

//Pre: 0<= row < ROW_COUNT && 0 <= column < COLUMN_COUNT
//Post: rv == null <==> the (row, column) spot on the board is empty
public Mark getMark(int row, int column);

//pre: 0 <= row < ROW_COUNT && 0 <= column < COLUMN_COUNT
//pre: getMark(row, column) == null
//pre: !isGameOver()
//post: LEFT TO STUDENT
public void setMark(int row, int column);

//post: rv == null <==> it is neither player's turn
//post: "number of the marks on board is even" -> rv == Mark.X
//post: "number of Marks on the board is odd" -> rv == Mark.O
public Mark getTurn();

//post: rv == true if there's a winning combination
//post: rv == false if there's not a winning combination
public boolean isGameOver();

//post: rv == O <==> O won the game
//post: rv == X <==> X won the game
//post: rv == null <==> neither player won (ie the game ended in a tie)
public Mark getWinner();
	
	
}
