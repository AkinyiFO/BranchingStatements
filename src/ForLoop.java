//Source - https://docs.oracle.com/javase/tutorial/java/nutsandbolts/branch.html

public class ForLoop {

    void checkFor(){
        for(int i=1; i<11; i++){
            System.out.println("Count is: " + i);
        }

//         infinite loop
//        for ( ; ; ) {
//            System.out.println("Infinity!");
//        }

//         Designed for iteration with Collections or Arrays
//              enhanced for statement
//              saw it in switch example - prev session
        int[] numbers = {1,2,3,4,5,6};

        for (int item : numbers) {
            System.out.println("Count is: " + item);
        }
    }

    void breakStatementUnlabeled(){
        int[] arrayOfInts = { 32, 87, 3, 589, 12, 1076, 2000, 8, 622, 127 };

        int searchFor = 12; // index = 4 (i = 4)

        int i;
        boolean foundIt = false;

        for (i = 0; i < arrayOfInts.length; i++) {
//            System.out.println("Tracking i: " + i); // test with output
//            System.out.println("searchFor is 12, while arrayOfInts[i] is now: " + arrayOfInts[i]);  // test with output
            if (arrayOfInts[i] == searchFor) {
                foundIt = true;
                break; // unlabeled break statement terminates the innermost switch, for, while, or do-while statement
            }
        }

        if (foundIt) {
            System.out.println("Found " + searchFor + " at index " + i);
        } else {
            System.out.println(searchFor + " not in the array");
        }
    }

    void breakStatementLabeled() {
        int[][] arrayOfInts = {
                { 32, 87, 3, 589 },
                { 12, 1076, 2000, 8 },
                { 622, 127, 77, 955 }
        };

        int searchFor = 12; // index = 4 (i = 4)

        int i; // initialized within the outer for loop, so if the loop executes (even partially), i will always have a value.
        int j = 0; // If a variable is declared outside the loop but used inside the loop, it must be explicitly initialized before use.
                   //       To ensure that j has a valid value even if the loops do not execute,
                   //       it is explicitly initialized to 0 when declared.
        boolean foundIt = false;

        search:
        for (i = 0; i < arrayOfInts.length; i++) {
//            System.out.println("Tracking i: " + i); // test with output
            for (j = 0; j < arrayOfInts[i].length; j++) {
//                System.out.println("Tracking j: " + j); // test with output
//                System.out.println("searchFor is 12, while arrayOfInts[i][j] is now: " + arrayOfInts[i][j]);  // test with output
                if (arrayOfInts[i][j] == searchFor) {
                    foundIt = true;
                    break search;
                }
            }
        }

        if (foundIt) {
            System.out.println("Found " + searchFor + " at " + i + ", " + j);
        } else {
            System.out.println(searchFor + " not in the array");
        }
    }

    void continueStatementUnlabeled(){
        String searchMe = "peter piper picked a " + "peck of pickled peppers";
        int numPs = 0;

        for (int i = 0; i < searchMe.length(); i++) {
//            System.out.println("Tracking p count: " + numPs); // test with output
//            System.out.println("Tracking i: " + i); // test with output
//            System.out.println("Is this a p: " + searchMe.charAt(i)); // test with output

            // interested only in p's
            if (searchMe.charAt(i) != 'p')
                continue; // skips to the end of the innermost loop's body and evaluates the boolean expression that controls the loop: i < searchMe.length()

            // process p's
            numPs++;
        }
        System.out.println("Found " + numPs + " p's in the string.");
    }

    void continueStatementLabeled() {
        String searchMe = "Look for a subString in me";
        String subString = "sub";
        boolean foundIt = false;

        int max = searchMe.length() - subString.length();

        // test with output
//        System.out.println("searchMe length is: " + searchMe.length() + " subString length is: " + subString.length() +
//                " length difference is: " + (searchMe.length() - subString.length()));

        test:
        for (int i = 0; i <= max; i++) {
            int n = subString.length();
            int j = i;
            int k = 0;
//            System.out.println("Before while loop values of i:" + i + ", n:" + n + ", j:" + j + ", k:" + k); // test with output
            while (n-- != 0) {
//                System.out.println("After while loop values of i:" + i + " n:" + n + " j:" + j + " k:" + k); // test with output
//                System.out.println("j++:" + (j+1) + ", k++:" + (k+1)); // test with output
                if (searchMe.charAt(j++) != subString.charAt(k++)) {
                    // test with output
//                    System.out.println("Last checked searchMe " + searchMe.charAt(j++) +
//                            " is != subString: " + subString.charAt(k++));
                    continue test; // skips the current iteration of an outer loop marked with the given label
                }
            }
            foundIt = true;
            break; // unlabeled break statement terminates the innermost switch, for, while, or do-while statement
        }
        System.out.println(foundIt ? "Found it" : "Didn't find it");
    }

    public static void main(String[] args) {
        ForLoop forLoop = new ForLoop();

//        forLoop.checkFor();

        forLoop.breakStatementUnlabeled();

//        forLoop.breakStatementLabeled();

//        forLoop.continueStatementUnlabeled();

//        forLoop.continueStatementLabeled();
    }

}
