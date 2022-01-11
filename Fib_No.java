import javax.swing.*;

public class Fib_No {
    public static void main(String[] args){
        // Key steps are represented in attached flowchart.

        /*
        * .--------.
        * | Step 1 |
        * .________.
        * */
        // The Fibonacci numeration consists of a number that is the sum of two previous ones in a succession, which normally starts with the values: 0 and 1, the variables are defined here.
        int n1 = 0;
        int n2 = 1;
        int rn = n1 + n2;
        String result_succession = "";

        // Just practising a little of GUIs, this isn't a perfect implementation, but it works.
        JFrame no_conf = new JFrame();
        JFrame result = new JFrame();
        /*
         * .--------.
         * | Step 2 |
         * .________.
         * */
        // Dialogue to enter how long you want the succession to be.
        String loops = JOptionPane.showInputDialog("Enter how much times you want to advance through Fibonacci numeration (starts from F1),\nthe result will be printed in a new window (from 5 to 20).");
        int loops_n = 10;
        // If the user wrote any non-numeric character on the input dialogue, use a default value.
        try{
            loops_n = Integer.valueOf(loops);
        }
        catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(no_conf,"Invalid value, using default = 10.","Invalid value",JOptionPane.ERROR_MESSAGE);
            loops_n = 10;
        }

        // Just to prevent the window grows too big, but also set a minimum.
        if(loops_n < 5) loops_n = 5;
        else if(loops_n > 20) loops_n = 20;

        /*
         * .--------.
         * | Step 3 |
         * .________.
         * */
        // The core of this program is to recreate the succession through a [for] loop, the user defined in the previous dialogue box, how many times did they want to advance in the succession before stopping.
        for(int x=0;x<loops_n;x++){
            // The sums and results will first be stored on a variable.
            result_succession += "\n" + n1 + " + " + n2 + " = ";

            /*
            * [rn] stores the current result of the succession, while [n1] and [n2] first store the initial values for the sum, but their main usage is to be the sum of the previous two numbers to get the new one in the succession. This is how it works:
            *
            * 1) Sum the initial values which are "0" and "1".
            * 2) Turn the first of the two previous numbers of the sum into the second one.
            * 3) Make of the result the first of the two.
            * */
            rn = n1 + n2;
            n1 = n2;
            n2 = rn;

            // Adds the result here because otherwise the output will not make sense (i.e. the result doesn't match the sum).
            result_succession += rn;
        }

        /*
         * .--------.
         * | Step 4 |
         * .________.
         * */
        // Prints the string created in the loop.
        JOptionPane.showMessageDialog(result,result_succession,"Resulting Fibonacci succession.", JOptionPane.WARNING_MESSAGE);

        System.exit(0);
    }
}