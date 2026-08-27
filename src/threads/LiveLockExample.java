package threads;

public class LiveLockExample {
   static boolean aMoves = true;
   static boolean bMoves = true;

    static void main() {
        while(true){

            if(aMoves && bMoves) {
                System.out.println("A says: you go first");
                System.out.println("B says: no, you go first");

                //both back off
                aMoves = false;
                bMoves = false;
            }
            if(!aMoves && !bMoves){
                System.out.println("Both are stuck being polite");
                break;
            }

        }
    }
}
