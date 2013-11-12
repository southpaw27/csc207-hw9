package edu.grinnell.csc207.kelleyan.hw9;

import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Mira Hall
 * @author Matt Dole
 * @author Andrew Kelley
 */

public class RPNCalcInterface {

    /**
     * printOptions prints the options available to the user of the RPN
     * calculator
     * 
     * @param pen
     * @pre pen is a PenWriter
     */
    public static void printOptions(PrintWriter pen) {
	pen.println("Options: ");
	pen.println("p - print the top value on the stack");
	pen.println("s - print the whole stack");
	pen.println("c - clear the stack");
	pen.println("n - find the min of top two values on the stack");
	pen.println("x - find the max of top two values on the stack");
	pen.println("a - find the average of top two values on the stack");
	pen.println("q - quit the calculator program");
    }

    public static void main(String[] args) throws Exception {
	// Create a RPNCalc with a certain size of the stack
	RPNCalc calc = new RPNCalc(30);
	PrintWriter pen = new PrintWriter(System.out, true);
	InputStreamReader istream = new InputStreamReader(System.in);
	BufferedReader eyes = new BufferedReader(istream);
	// Welcome
	pen.println("Welcome to the RPN calculator!");
	// Options to choose from
	printOptions(pen);
	boolean cont = true;
	while (cont) {
	    pen.println("Please type your input and hit enter");
	    // Read input into a String
	    String line = eyes.readLine();
	    // Calculate whether or not to continue loop
	    cont = calc.evaluate(line, pen);
	} // while
	pen.println("Quitting!");
    } // main(String[])4
    
} // RPNCalcInterface