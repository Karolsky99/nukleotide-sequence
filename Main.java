import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int f = 0;
        String s = "";
        while (f != 4) {
            System.out.println("Select the appropriate program number:");
            System.out.println("1. Printing RNA sequence");
            System.out.println("2. Printing complementary DNA sequence");
            System.out.println("3. Printing the amount of nucleotides");
            System.out.println("4. EXIT");
            System.out.print(">> ");
            f = scan.nextInt();
            switch (f) {
                case 1:
                    System.out.println("Enter DNA sequence:");
                    System.out.print(">> ");
                    s = scan.next();
                    System.out.println("RNA sequence is:");
                    System.out.println(dnatorna(s));
                    break;
                case 2:
                    System.out.println("Enter DNA sequence:");
                    System.out.print(">> ");
                    s = scan.next();
                    System.out.println("Complementary DNA sequence is:");
                    System.out.println(dnatodna(s));
                    break;
                case 3:
                    System.out.println("Enter DNA sequence:");
                    System.out.print(">> ");
                    s = scan.next();
                    int[] array = nucleotides_counter(s);
                    if (array[0] != -1) { // if sequence is invalid, method will set array[0] value to -1
                        System.out.println("Amount of nitrogenous bases in your sequence [#A,#C,#G,#T]:");
                        System.out.println("[" + array[0] + ", " + array[1] + ", " + array[2] + ", " + array[3] + "]");
                    } else {
                        System.out.println("ERROR - entered invalid DNA sequence!");
                        System.out.println();
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("ERROR - Selected incorrect number!");
                    System.out.println();
            }
            if (f != 4) {
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("Type 'y' if you want to continue or 'n' if you want to exit");
                String wish = scan.next();
                if (wish.equals("n")) {
                    f = 4; // exiting the do loop causing end of the program
                }
            }

        }
        scan.close();
    } // end of a main

    static String dnatorna(String s1) { // creation of complementary RNA sequence as a string
        String s2 = "";
        for (int i = 0; i < s1.length(); i++){
            switch (s1.charAt(i)){
                case 'A':
                    s2 += "A";
                    break;
                case 'C':
                    s2 += "C";
                    break;
                case 'G':
                    s2 += "G";
                    break;
                case 'T':
                    s2 += "U";
                    break;
                default:
                    s2 = "ERROR - Entered invalid DNA sequence!"; // returning ERROR in case of inappropriate sequence format
                    i = s1.length(); // end of a for loop
            }
        }
        return s2;
    } // end of a method

    static String dnatodna(String s1) { // creation of complementary DNA sequence as a string
        String s2 = "";
        for (int i = 0; i < s1.length(); i++){
            switch (s1.charAt(i)){
                case 'A':
                    s2 += "T";
                    break;
                case 'C':
                    s2 += "G";
                    break;
                case 'G':
                    s2 += "C";
                    break;
                case 'T':
                    s2 += "A";
                    break;
                default:
                    s2 = "ERROR - Entered invalid DNA sequence!"; // returning ERROR in case of inappropriate sequence format
                    i = s1.length(); // end of a for loop
            }
        }
        return s2;
    } // end of a method

    static int[] nucleotides_counter(String s1){ // calculation of the amount of nucleotides
        int[] counter = {0, 0, 0, 0};
        for (int i = 0; i < s1.length(); i++){
            switch (s1.charAt(i)){
                case 'A':
                    counter[0]++;
                    break;
                case 'C':
                    counter[1]++;
                    break;
                case 'G':
                    counter[2]++;
                    break;
                case 'T':
                    counter[3]++;
                    break;
                default:
                    counter[0] = -1; // value '-1' means that sequence is invalid and will cause printing ERROR in main
                    i = s1.length(); // end of for loop
            }
        }
        return counter; // returning an array of the amount of nucleotides
    } // end of a method

} // end of a class
