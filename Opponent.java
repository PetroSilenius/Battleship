//Vastustaja pelaajan luokka, hyödyntää Random-packagea laivojen sijoittajamiseen ja ampumiseen

import java.util.ArrayList;
import java.util.Random;

public class Opponent {
    private Board oboard;
    private int x;
    private int y;
    private int orientation;
    private Random rng = new Random();


    Opponent(){
        oboard = new Board();
        oboard.formatBoard();
        x = 0; y = 0; orientation = 0;
    }

    public Board getOboard(){
        return oboard;
    }

    //Sijoittaa laivat sattumanvaraisesti
    public void placeShips(){
        x = rng.nextInt(10)+1;
        y = rng.nextInt(10)+1;
        orientation = rng.nextInt(2)+1;
        ArrayList<Ship> ships = new ArrayList<Ship>();
            ships.add(new Carrier());
            ships.add(new Battleship());
            ships.add(new Cruiser());
            ships.add(new Submarine());
            ships.add(new Destroyer());

        for(int i=0; i<5;i++){
            while(!oboard.fitShip(ships.get(i), x, y, orientation)) {
                x = rng.nextInt(10)+1;
                y = rng.nextInt(10)+1;
                orientation = rng.nextInt(2)+1;
            }
            oboard.placeShip(ships.get(i), x, y, orientation);
        }
    }

    //Ampuu sattumanvaraisesti
    public void shootAt(Board board){
        x = rng.nextInt(10)+1;
        y = rng.nextInt(10)+1;
        board.shoot(x, y);
    }
}
