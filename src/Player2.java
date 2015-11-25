import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Player2 {

    //public ArrayList<Dice> handOfDice = new ArrayList<>();
    public ArrayList<Dice> temporaryDiceList = new ArrayList<>();
    public ArrayList<Integer> playerTempScore = new ArrayList<>();
    public ArrayList<Integer> myUpperScore = new ArrayList<>();
    public ArrayList<Integer> myLowerScore = new ArrayList<>();
    public int[] upperTest= new int[6];
    public int[] SUPERTESTVECTOR = {10,20,30,40,50};
    public int[] lowerTest= new int[6];
    int points=0;

    Scanner keyboard = new Scanner(System.in);
    String name ="";


    public Player2(String name){
        this.name=name;
    }

    public void gatherPoints(){

        //    myLowerScore.add(Engine.lowerPoint);

       // Engine.lowerPoint=0;

      //  System.out.println(name+"s  lower score is " + myLowerScore);
        if(Engine.pair==true){
            lowerTest[0]+=Engine.lowerPoint;
            Engine.pair=false;
            System.out.println(name+"s lower score is " + Arrays.toString(lowerTest));
        }

        else if(Engine.triss==true){
            lowerTest[1]+=Engine.lowerPoint;
            Engine.triss=false;
            System.out.println(name+"s lower score is " + Arrays.toString(lowerTest));
        }

        else if(Engine.fyrtal==true){
            lowerTest[2]+=Engine.lowerPoint;
            Engine.fyrtal=false;
            System.out.println(name+"s lower score is " + Arrays.toString(lowerTest));
        }

    }

    public void gatherUpperPoints(int nrToScore){

            //Spara undan hur många förekomster av viss siffra.
           // myUpperScore.add(Engine.countOccurence(Engine.handOfDice,nrToScore));
            Engine.countOccurence(Engine.handOfDice,nrToScore);
            myUpperScore.add(Engine.upperPoint);
          //  int positionToPut = Engine.upperPoint/nrToScore;
            //System.out.println(name+"s  upper score is " + myUpperScore);
        for(int i=1; i<=6;i++){
            if(i==nrToScore)
            upperTest[i-1]=Engine.upperPoint;
        }
        System.out.println( name + "s upper score is " + Arrays.toString(upperTest));

    }


    public String toString() { // ALLTID MED (mer eller mindre standard f?r objekt).
       // return " the player now has BLALBA";
        return name;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    /**
     * Adds {@code points} to the amount of points the player currently has
     *
     * @param points the amount of points to add
     */
    public void addPoints(int points) {
        this.points += points;
    }

}








