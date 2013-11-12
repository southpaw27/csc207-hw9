package edu.grinnell.csc207.kelleyan.hw9;

import java.io.PrintWriter;

/**
 * @author Mira Hall
 * @author Matt Dole
 * @author Andrew Kelley
 */

public class RPNCalc {

    // +--------+----------------------------------------------------------
    // | Fields |
    // +--------+

    /**
     * An ArrayBasedStack field
     */
    ArrayBasedStack<Double> RPNStack;

    /**
     * Size of the ArrayBasedStack field
     */
    int size;

    /**
     * A string used to compare input with possible operands
     */
    String checker = "+-/*nxa";

    // +--------------+----------------------------------------------------
    // | Constructors |
    // +--------------+

    /**
     * RPNCalc creates a new RPN calculator
     * 
     * @param size
     * @throws Exception
     */
    public RPNCalc(int size) throws Exception {
	this.size = size;
	this.RPNStack = new ArrayBasedStack<Double>(this.size);
    } // RPNCalc(int)

    // +-------------------------+-----------------------------------------
    // | RPNCalc Methods |
    // +-------------------------+

    /**
     * evaluate takes a string expression of an RPN calculator entry and parses
     * through the line, adding and popping from the stack as necessary and
     * evaluating expressions as they appear.
     */
    public boolean evaluate(String str, PrintWriter pen) throws Exception {
	int len = str.length();
	// Iterator to iterate through string
	int i = 0;
	while (i < len && RPNStack.size >= 0) {
	    char current = str.charAt(i);
	    if (current == 'p') {
		if (RPNStack.isEmpty()) {
		    pen.println("Nothing on the stack!");
		} else {
		    pen.println(RPNStack.peek());
		} // else
	    } else if (current == 's') {
		if (RPNStack.isEmpty()) {
		    pen.println("Nothing on the stack!");
		} else {
		    ArrayBasedStackIterator<Double> it = new ArrayBasedStackIterator<Double>(
			    RPNStack);
		    while (it.hasNext()) {
			pen.println(it.next());
		    } // while
		} // else
	    } else if (current == 'c') {
		clear();
	    } else if (current == 'q') {
		return false;
	    } else if (checker.indexOf(current) != -1) {
		performOperation(i, current, pen);
	    } else if (current != ' ') {
		int index = i;
		while (i < len && str.charAt(i) != ' ' && str.charAt(i) != '\n') {
		    i++;
		} // while
		RPNStack.push(Double.valueOf(str.substring(index, i)));
	    } // if/else
	    i++;
	} // while
	return true;
    } // evaluate(str, PrintWriter)

    /**
     * performOperation performs the given operation on the stack
     * 
     * @param i
     * @param c
     * @param pen
     * @pre i is 0 <= int < size, c is a character, pen is a PrintWriter
     * @throws Exception
     */
    public void performOperation(int i, char c, PrintWriter pen)
	    throws Exception {
	ArrayBasedStackIterator<Double> it = new ArrayBasedStackIterator<Double>(
		RPNStack);
	if (it.hasNext()) {
	    it.next();
	    if (it.hasNext()) {
		if (c == '+') {
		    add();
		} else if (c == '-') {
		    subtract();
		} else if (c == '*') {
		    multiply();
		} else if (c == '/') {
		    divide();
		} else if (c == 'n') {
		    min();
		} else if (c == 'x') {
		    max();
		} else if (c == 'a') {
		    avg();
		}
		return;
	    } // if
	} // if
	pen.println("Invalid entry!");
	pen.println("Clearing stack...");
	clear();
    } // performOperation(int, char, PrintWriter)

    /**
     * add pops the top two items off the stack and adds them, pushing the
     * result back onto the stack
     * 
     * @throws Exception
     */
    public void add() throws Exception {
	this.RPNStack.push(this.RPNStack.pop() + this.RPNStack.pop());
    } // add()

    /**
     * subtract pops the top two items off the stack and subtracts them, pushing
     * the result back onto the stack
     * 
     * @throws Exception
     */
    public void subtract() throws Exception {
	this.RPNStack.push(-1 * this.RPNStack.pop() + this.RPNStack.pop());
    } // subtract()

    /**
     * multiply pops the top two items off the stack and multiplies them,
     * pushing the result back onto the stack
     * 
     * @throws Exception
     */
    public void multiply() throws Exception {
	this.RPNStack.push(this.RPNStack.pop() * this.RPNStack.pop());
    } // multiply()

    /**
     * divide pops the top two items off the stack and divides the second by the
     * first, pushing the result back onto the stack
     * 
     * @throws Exception
     */
    public void divide() throws Exception {
	this.RPNStack.push((1 / this.RPNStack.pop()) * this.RPNStack.pop());
    } // divide()

    /**
     * min pops the top two items off the stack and finds the minimum of the
     * two, pushing the result back onto the stack
     * 
     * @throws Exception
     */
    public void min() throws Exception {
	this.RPNStack.push(Math.min(this.RPNStack.pop(), this.RPNStack.pop()));
    } // min()

    /**
     * max pops the top two items off the stack and finds the maximum of the
     * two, pushing the result back onto the stack
     * 
     * @throws Exception
     */
    public void max() throws Exception {
	this.RPNStack.push(Math.max(this.RPNStack.pop(), this.RPNStack.pop()));
    } // min()

    /**
     * average pops the top two items off the stack and finds their average,
     * pushing the result back onto the stack
     * 
     * @throws Exception
     */
    public void avg() throws Exception {
	this.RPNStack.push((this.RPNStack.pop() / 2)
		+ (this.RPNStack.pop() / 2));
    } // avg()

    /**
     * clear clears the stack of all values
     * 
     * @throws Exception
     */
    public void clear() throws Exception {
	while (!this.RPNStack.isEmpty()) {
	    RPNStack.pop();
	} // while
    } // clear()
} // RPNCalc
