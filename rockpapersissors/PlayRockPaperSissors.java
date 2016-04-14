package rockpapersissors;

public class PlayRockPaperSissors {

    /**
     * Parses command line arguments, 
     * instantiates the RockPaperSissor class
     * and starts the game
     */
    public static void main(String[] args) {
        RockPaperSissor rockpapersissor;
        Strategy selectedStrategy;
        String options = "Options : favorite, last, unknown ";
        String usage = "Usage : PlayRockPaperSissors favorite";

        if(args.length == 0){
            //select default strategy - unknown
            selectedStrategy = Strategy.UNKNOWN;
            System.out.println("You have not selected any strategy. Continuing with Default");
        }else if(args.length == 1){
            String inputStrategy = args[0].toLowerCase();
            if(inputStrategy.equals("favorite")){
                selectedStrategy = Strategy.FAVORITE_MOVE;
            }else if(inputStrategy.equals("last")){
                selectedStrategy = Strategy.LAST_MOVE;
            }else if(inputStrategy.equals("unknown")){
                selectedStrategy = Strategy.UNKNOWN;
            }else{
                System.out.println("Wrong argument " + options + usage);
                return;
            }
        }else{
            System.out.println("Incorrect number of arguments " + options + usage);
            return;
        }

        rockpapersissor = new RockPaperSissor(selectedStrategy);
        System.out.println("You are playing against strategy : " + selectedStrategy);
        rockpapersissor.play();
    }

}
