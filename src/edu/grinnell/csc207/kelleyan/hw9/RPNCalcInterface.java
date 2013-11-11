package edu.grinnell.csc207.kelleyan.hw9;

import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RPNCalcInterface {

    public static void printOptions(PrintWriter pen) {
	pen.println("p - print the top value on the stack");
	pen.println("s - print the whole stack");
	pen.println("c - clear the stack");
	pen.println("l - print the entire stack");
	pen.println("h - get help/options menu (this menu)");
	pen.println("q - quit the calculator program");
    }

    public static void main(String[] args) throws Exception {

	RPNCalc calc = new RPNCalc(10);

	PrintWriter pen = new PrintWriter(System.out, true);
	InputStreamReader istream = new InputStreamReader(System.in);
	BufferedReader eyes = new BufferedReader(istream);

	pen.println("Welcome to the RPN calculator!");
	boolean cont = true;
	while (cont) {
	    printOptions(pen);
	    pen.println("Please type your input and hit enter");

	    String line = eyes.readLine();
	    pen.println("Your entry:" + line);

	    String output = "Q";
	    if (output.equals(new String("Q"))) {
		cont = false;
		pen.println("Quitting!");
	    } else {
		pen.println("=  " + output);

	    } // if else
	}// while
    } // main(String[])
} // RPNCalcInterface