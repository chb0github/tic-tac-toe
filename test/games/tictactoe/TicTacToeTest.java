package games.tictactoe;


import org.junit.Test;

import java.util.Random;

public class TicTacToeTest {

    @Test
    public void testTTT() throws Exception {
        TickTackToe ttt = new TickTackToe(3);
        Random r = new Random();
        for (int x = 0; x < 3 ; x++) {
            for (int y = 0; y < 3 ; y++) {
                ttt.putMark(r.nextInt(2) == 1 ? Mark.O : Mark.X,x,y);
            }
        }
        Mark m = ttt.getWinningMark();
        System.out.println(m);
    }
}
