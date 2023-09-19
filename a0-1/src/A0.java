import java.util.Scanner;

class HighSpeedLine {
    int siteA, siteB, cost;

    public HighSpeedLine(int siteA, int siteB, int cost){
        this.siteA = siteA;
        this.siteB = siteB;
        this.cost = cost;
    }

    @Override
    public String toString(){
        return "SiteA: " + siteA + ", SiteB: " + siteB + ", Cost: " + cost;
    }
}

public class A0 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        //First, a line containing the number N of computer sites, with 1 <= N <= 10000, and where each computer site is referred to by its number i, 1 <= i <= N
        System.out.println("Enter N, number of computer sites: ");
        int N = Integer.parseInt(scanner.nextLine().trim());
        if(N < 1 || N > 10000){
            System.err.println("N failed range: 1 <= N <= 10000");
            System.exit(1);
        }

        //int[] i = new int[N];

        /* Second, the set T of previously-chosen high-speed lines, consisting of N - 1 lines, each describing a high-speed line by three numbers: 
            siteA siteB cost
        All monthly costs are integers */
        if(N > 1) {
            HighSpeedLine[] highSpeedLine = new HighSpeedLine[N - 1];

            
            System.out.println("Enter the set T, describing a high-speed line by three numbers (siteA siteB cost): ");
            for(int i = 0; i < N - 1; i++) {
                try {
                    String[] lineInfo = scanner.nextLine().split(" ");
                    int siteA = Integer.parseInt(lineInfo[0]);
                    int siteB = Integer.parseInt(lineInfo[1]);
                    int cost = Integer.parseInt(lineInfo[2]);
                    highSpeedLine[i] = new HighSpeedLine(siteA, siteB, cost);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.err.println("Needs 3 arguments: siteA siteB cost");
                    System.exit(1);
                }
            }
            for(int i = 0; i < highSpeedLine.length; i++){
                System.out.println("T" + (i+1) + ": "+ highSpeedLine[i]);
            }
        }

        //scanner.close();

        

        //Third, a line containing the number K of new additional lines, with 1 <= K <= 10.
        System.out.println("Enter K, number of additional lines: ");
        int K = Integer.parseInt(scanner.nextLine().trim());
        if(K > 0 && K <= 10){
            //Fourth, K lines, each describing a new high-speed line, in the same format as the existing lines
            HighSpeedLine[] newHighSpeedLine = new HighSpeedLine[K];

            System.out.println("Enter the set T, describing a high-speed line by three numbers (siteA siteB cost): ");
            for(int i = 0; i < K; i++) {
                try {
                    String[] lineInfo = scanner.nextLine().split(" ");
                    int siteA = Integer.parseInt(lineInfo[0]);
                    int siteB = Integer.parseInt(lineInfo[1]);
                    int cost = Integer.parseInt(lineInfo[2]);
                    newHighSpeedLine[i] = new HighSpeedLine(siteA, siteB, cost);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.err.println("Needs 3 arguments: siteA siteB cost");
                    System.exit(1);
                }
            }

            for(int i = 0; i < newHighSpeedLine.length; i++){
                System.out.println("T" + (i+1) + ": "+ newHighSpeedLine[i]);
            }
        }else{
            System.err.println("K failed range: 1 <= K <= 10");
            System.exit(1);
        }
        scanner.close();
    }
}