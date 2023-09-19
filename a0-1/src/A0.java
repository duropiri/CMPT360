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
        //System.out.println("Enter N, number of computer sites: ");
        int N = Integer.parseInt(scanner.nextLine().trim());
        if(N < 1 || N > 10000){
            System.err.println("N failed range: 1 <= N <= 10000");
            System.exit(1);
        }

        /* Second, the set T of previously-chosen high-speed lines, consisting of N - 1 lines, each describing a high-speed line by three numbers: 
            siteA siteB cost
        All monthly costs are integers */
        HighSpeedLine[] nHighSpeedLine = new HighSpeedLine[N - 1];

        if(N > 1) {
            //System.out.println("Enter the set T, describing a high-speed line by three numbers (siteA siteB cost): ");
            for(int i = 0; i < N - 1; i++) {
                try {
                    String[] lineInfo = scanner.nextLine().split(" ");
                    int siteA = Integer.parseInt(lineInfo[0]);
                    int siteB = Integer.parseInt(lineInfo[1]);
                    int cost = Integer.parseInt(lineInfo[2]);
                    nHighSpeedLine[i] = new HighSpeedLine(siteA, siteB, cost);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.err.println("N Needs 3 arguments: siteA siteB cost");
                    System.exit(1);
                }
            }
            // for(int i = 0; i < nHighSpeedLine.length; i++){
            //     System.out.println("T" + (i+1) + ": "+ nHighSpeedLine[i]);
            // }
        }

        //scanner.close();

        

        //Third, a line containing the number K of new additional lines, with 1 <= K <= 10.
        //System.out.println("Enter K, number of additional lines: ");
        int K = Integer.parseInt(scanner.nextLine().trim());
        if(K < 1 || K > 10){
            System.err.println("K failed range: 1 <= K <= 10");
            System.exit(1);
        }

        //Fourth, K lines, each describing a new high-speed line, in the same format as the existing lines
        HighSpeedLine[] kHighSpeedLine = new HighSpeedLine[K];

        if(K > 0 && K <= 10){
            //System.out.println("Enter the set T, describing a high-speed line by three numbers (siteA siteB cost): ");
            for(int i = 0; i < K; i++) {
                try {
                    String[] lineInfo = scanner.nextLine().split(" ");
                    int siteA = Integer.parseInt(lineInfo[0]);
                    int siteB = Integer.parseInt(lineInfo[1]);
                    int cost = Integer.parseInt(lineInfo[2]);
                    kHighSpeedLine[i] = new HighSpeedLine(siteA, siteB, cost);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.err.println("K Needs 3 arguments: siteA siteB cost");
                    System.exit(1);
                }
            }

            // for(int i = 0; i < kHighSpeedLine.length; i++){
            //     System.out.println("T" + (i+1) + ": "+ kHighSpeedLine[i]);
            // }
        }else{
            System.err.println("K failed range: 1 <= K <= 10");
            System.exit(1);
        }

        //Fifth, A line containing the number M of originally available high-speed lines, with N - 1 <= M <= N (N - 1)/2
        //System.out.println("Enter M, originally available high-speed lines: ");
        int M = Integer.parseInt(scanner.nextLine().trim());
        if(M < (N - 1) || M > ((N*(N - 1))/2)){
            System.err.println("M failed range: N - 1 <= M <= N (N - 1)/2");
            System.exit(1);
        }

        //Last, M lines, each describing an originally-available high-speed lines in the same format as before.
        
        HighSpeedLine[] mHighSpeedLine = new HighSpeedLine[M];

        //System.out.println("Enter the set T, describing a high-speed line by three numbers (siteA siteB cost): ");
        for(int i = 0; i < M; i++) {
            try {
                String[] lineInfo = scanner.nextLine().split(" ");
                int siteA = Integer.parseInt(lineInfo[0]);
                int siteB = Integer.parseInt(lineInfo[1]);
                int cost = Integer.parseInt(lineInfo[2]);
                mHighSpeedLine[i] = new HighSpeedLine(siteA, siteB, cost);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("M Needs 3 arguments: siteA siteB cost");
                System.exit(1);
            }
        }

        scanner.close();
        // for(int i = 0; i < mHighSpeedLine.length; i++){
        //     System.out.println("T" + (i+1) + ": "+ mHighSpeedLine[i]);
        // }

        /* 
        Output
        You must write to standard output two lines:
            • the cost of the original network of chosen lines
            • the cost of the best new network of lines found among the M + K available lines. 
        */
        
        // the cost of the original network of chosen lines
        int originalCost = 0;
        for(HighSpeedLine line : nHighSpeedLine) {
            originalCost += line.cost;
        }
        System.out.println(originalCost);
    }
}