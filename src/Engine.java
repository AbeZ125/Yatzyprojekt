import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Home on 2015-11-12.
 */
public class Engine {
    public static HashMap<Integer, Player2> playerMap2 = new HashMap<>();
    public static ArrayList<ArrayList<Integer>> scoreboard = new ArrayList<>();
    private static ArrayList<Integer> scoreCard = new ArrayList<>();
    public static ArrayList<Integer> tempScoreBox = new ArrayList<>();

    static Scanner keyboard = new Scanner(System.in);

    public static ArrayList<Dice> handOfDice = new ArrayList<>();
    private int diceNrToThrow;
    public static boolean lock=false;
    private static int retry = 2;
    static int dicePairValue=0;
    static int diceThreeValue=0;
    static int pointSum=0;
    static int pairCheck=0;
    static int checkHouseValue=0;
    static int housePoints=0;
    static int playerSize;
    static int baton=1;
    static int nrOfPlayers;
    static boolean running;
    static int upperPoint;
    static int lowerPoint;
    static int twoPairPoint;
    static boolean houseTrue=false;
    static boolean pair=false;
    static boolean triss=false;
    static boolean fyrtal=false;

    public static void runGame(){
        System.out.println("How many players?");
        nrOfPlayers = keyboard.nextInt();
        playerSetup(nrOfPlayers);

        while(running){

            for(int i=0; i<= nrOfPlayers; i++){

            }
        }
    }

    public static void switchPlayer(){
        playerMap2.get(baton).gatherPoints();
        baton++;
        unlockAll();
        if(baton==playerSize+1){
            baton=1;

        }
    }

    public static void playerSetup(int numOfPlayers) {
        for (int i = 1; i <= numOfPlayers; i++) {
            System.out.printf("Enter your name, player %d: ", i);
            String playerName = keyboard.nextLine();
            playerMap2.put(i, new Player2(playerName));
            // scoreBoard.add(playerMap.get(i));

           playerSize=numOfPlayers;
            //baton=playerSize/playerSize;
        }
    }

    // GÖR SEN!!!!!!!!!

    /*public static void setScoreboard(int PlayerNr){

        scoreboard.add(playerMap2.get(PlayerNr).evaluatePoints2());
        System.out.println("THE SCORE");
        System.out.println(scoreboard);


    } */

    public static void getDice() {
        System.out.println("So you want some dice, eh?");
        for(int i=1; i <= 5; i++) {
            Dice diceChosen = new Dice();
            handOfDice.add(diceChosen);
        }
        System.out.println(handOfDice);
    }



    public static void useLock(int LockOnDiceNr){
        handOfDice.get(LockOnDiceNr).lockADie(LockOnDiceNr);
    }

    public static void unlockAll(){
        for(int i=0; i<=4; i++) {
            handOfDice.get(i).unlockAll();
        }
    }


    public static void lockandRoll(){


        System.out.println("Lock the ones you want to keep.");

        while(retry!=0) {

            System.out.println("Inne i lockandROLL");

            for (int i = 0; i <= 4; i++) {

                handOfDice.get(i).roll();
                //reroll2(i);
                // System.out.println("Yoyoyo looks like you could reroll "+i);
                System.out.println(handOfDice);

                //lock=false;
            }

            retry--;
            System.out.println(retry + " retries left.");
            // lockADie(1);

        }

        System.out.println("Sorry, you're out of retries.");
        System.out.println(handOfDice);
        retry=2;

    }

    public static void evaluatePoints2(){

        int pointComparison=0;
        int test=0;
        int pointsPair=0;
        int pointsTwoPair=0;
        int pointsTriss=0;
        int pointsFour=0;
        int currentDiceChecked=0;



        for (int i=0; i < handOfDice.size(); i++) {
            //Gå igenom spelares hand och få fram int-värdet på varje tärning i handen.
            pointComparison = handOfDice.get(i).getDiceValue();
            lowerPoint = handOfDice.get(i).getDiceValue();
        }
        for(int k=1; k<=6; k++) {
            test = countOccurence(handOfDice, k);
            if(test==2 && houseTrue==false) {

                System.out.println("TJEEENA!");

                currentDiceChecked = k*2;
                pointsPair=15;
                checkHouseValue+=currentDiceChecked;
                pairCheck++;
               /* if(pairCheck==2){
                    System.out.println("DU HAR TVÅPAR!");
                    pointsTwoPair=20-pointsPair;
                    lowerPoint=currentDiceChecked;
                    System.out.println(lowerPoint);
                } */
              //  else{
                    System.out.println("DU HAR PAR!!");
                    pointsPair=15;
                    lowerPoint=currentDiceChecked;
                    System.out.println(lowerPoint);

                    pair=true;
               // }
            }
            else if(test==3 && houseTrue==false){
                System.out.println("DU HAR TRISS");
                lowerPoint = k*3;
                System.out.println(lowerPoint);

                triss=true;
                //checkHouseValue+=currentDiceChecked;

            }
            else if(test==4){
                System.out.println("DU HAR FYRTTAL");
                lowerPoint = k*4;
                System.out.println(lowerPoint);

                fyrtal=true;
                //checkHouseValue+=currentDiceChecked;

            }



        }




    }

    //takes an array and a nr, then it checks how often that nr is found in the array. Say, how often a six occurs among rolled dice.
    public static int countOccurence(ArrayList<Dice> diceArray, int nr){
        int nrOccur=0;
        for(Dice i : diceArray){
            if(i.getDiceValue()==nr) {
                nrOccur++;

            }
        }
        upperPoint=nrOccur*nr;
        int OccurReturn=nrOccur;
        //pointSum+=nrOccur*nr;
       // return nrOccur;
        return OccurReturn;
    }

    //Se till att denna körs före vanlig par- och triss-kontroll, för om det är house så kan den returnera en boolean,
    //om house, printa inte du har PAR och du har TRISS.
    public static void houseCheck(){

        for(int k=1; k<=6; k++) {
            int toast = countOccurence(handOfDice, k);
            if (toast == 2) {
                dicePairValue = k*2;


               for(int j=1; j<=6; j++) {
                   int toast2 = countOccurence(handOfDice, j);
                   if (toast2 == 3 && k!=j) {

                       diceThreeValue = j * 3;
                       lowerPoint=dicePairValue+diceThreeValue;
                       System.out.println("YO DAS A HOUSE " + lowerPoint);
                       houseTrue=true;

                   }

                   else if (toast2 == 2 && k!=j) {

                       twoPairPoint = j * 2;
                       lowerPoint=dicePairValue+twoPairPoint;
                       System.out.println("YO DAS TWO PAIRS " + lowerPoint);
                       houseTrue=true;

                   }

               }
            }


        }


    }

    public static void straightCheck(){

        int smallStraight[]={1,2,3,4,5};
        int bigStraight[]={2,3,4,5,6};
        int sortedDice[] = new int[5];
        int straightPoint=0;

        for (int i=0; i<=4;i++){
            sortedDice[i]=handOfDice.get(i).getDiceValue();
        }

        Arrays.sort(sortedDice);

        if(Arrays.equals(sortedDice,smallStraight)){
            System.out.println("Small straight");
            straightPoint=15;
            pointSum=15;
            lowerPoint=15;
        }

        else if(Arrays.equals(sortedDice,bigStraight)){
            System.out.println("Big straight");
            straightPoint=20;
            pointSum=20;
            lowerPoint=20;
        }

    }

    public static void fiveOfAKind(){

        int fiveKindCheck = handOfDice.get(0).getDiceValue();
        int fiveKindOccur=0;
        int fiveKindPoint=0;
        for(int i=0; i<5;i++){

            if(fiveKindCheck==handOfDice.get(i).getDiceValue())
            {
                fiveKindOccur++;
            }

        }
        if(fiveKindOccur==5){
            System.out.println("Five of a kind!");
            lowerPoint=50;
        }
    }

    //Check a specific die value and multiply by its occurence in the hand, add points to pointSum.
    public static void onesSixCheck(){

        int onesSixes[]= new int [5];
        for(int i=0; i<5; i++){

            onesSixes[i]=(handOfDice.get(i).getDiceValue() * countOccurence(handOfDice, i));
        }

        for(int i=0; i<5; i++){

            pointSum+=onesSixes[i];
        }
    }






}
