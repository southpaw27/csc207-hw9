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

	RPNCalc calc = new RPNCalc(60);

	PrintWriter pen = new PrintWriter(System.out, true);
	InputStreamReader istream = new InputStreamReader(System.in);
	BufferedReader eyes = new BufferedReader(istream);
	// welcome
	pen.println("Welcome to the RPN calculator!");
	// options to choose from
	printOptions(pen);
	boolean cont = true;
	while (cont) {
	    pen.println("Please type your input and hit enter");

	    String line = eyes.readLine();
	    cont = calc.evaluate(line, pen);
	} // while
	pen.println("Quitting!");
    } // main(String[])4
    
} // RPNCalcInterface