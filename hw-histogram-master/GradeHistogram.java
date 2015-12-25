import java.util.Scanner;
import java.io.File;

public class GradeHistogram {
    public static void main(String[] args) throws Exception {
        String fileName = args[0];
        double bucketSize;
        if (args.length == 2) {
            bucketSize = Double.parseDouble(args[1]);
        } else {
            Scanner keyword = new Scanner(System.in);
            System.out.println("What bucket size would you like?");
            bucketSize = keyword.nextDouble();
        }
        int row = 101;
        //int row = (int) Math.ceil(100 / bucketSize);
        int[] arr = new int[row];
        File inFile = new File(fileName);
        Scanner filescan = new Scanner(inFile);
        String name;
        String subName;
        int score;
        double scoreCal;
        //double sum;
        while (filescan.hasNextLine()) {
            name = filescan.nextLine();

            int ind = name.indexOf(',');
            subName = name.substring(ind + 1);
            subName = subName.trim();
            score = Integer.parseInt(subName);
            arr[score] = arr[score] + 1;
        }

        int row1 = (int) Math.ceil(101 / bucketSize);
        row1 = row1 - 1;
        int lastEnd = 0;
        int start = 100;

        for (int i = 0; i < row1; i++) {
            int end = start - (int) bucketSize + 1;
            int sum = 0;
            if (end == 0) {
                break;
            }
            for (int j = start; j >= end; j--) {
                sum = sum + arr[j];
            }
            System.out.printf("%3d - %3d | ", start, end);
            for (int k = 0; k < sum; k++) {
                System.out.print("[]");
            }
            System.out.println();
            start = end - 1;
        }
        int sum = 0;
        for (int j = start; j >= lastEnd; j--) {
            sum = sum + arr[j];
        }
        System.out.printf("%3d - %3d | ", start, lastEnd);
        for (int k = 0; k < sum; k++) {
            System.out.print("[]");
        }
    }
}