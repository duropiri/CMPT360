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
        HighSpeedLine[] highSpeedLine = new HighSpeedLine[N -1];

        System.out.println("Enter the set T, describing a high-speed line by three numbers (siteA siteB cost): ");
        for(int i = 0; i < N - 1; i++) {
            String[] lineInfo = scanner.nextLine().split(" ");
            int siteA = Integer.parseInt(lineInfo[0]);
            int siteB = Integer.parseInt(lineInfo[1]);
            int cost = Integer.parseInt(lineInfo[2]);
            highSpeedLine[i] = new HighSpeedLine(siteA, siteB, cost);
        }

        scanner.close();

        for(int i = 0; i < highSpeedLine.length; i++){
            System.out.println("T" + (i+1) + ": "+ highSpeedLine[i]);
        }
    }
}