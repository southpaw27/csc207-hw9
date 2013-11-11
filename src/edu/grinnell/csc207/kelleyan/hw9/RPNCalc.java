package edu.grinnell.csc207.kelleyan.hw9;

import java.io.PrintWriter;

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
	// iterator through string
	int i = 0;
	while (i < len && RPNStack.size >= 0) {
	    if (str.charAt(i) == ' ') {
		i++;
	    } else if (str.charAt(i) == 'p') {
		pen.println(RPNStack.peek());
	    } else if (str.charAt(i) == 's') {
		ArrayBasedStackIterator<Double> it = new ArrayBasedStackIterator<Double>(RPNStack);
		while(it.hasNext()) {
		    pen.println(it.next());
		}
	    } else if (str.charAt(i) == 'c') { //needs fixing
		for (int j = 0; j < len; j++) {
		    RPNStack.pop();
		} // for
		RPNStack.size = 0;
	    } else if (str.charAt(i) == 'q') {
		return false;
	    } else if (str.charAt(i) == '+') {
		add();
	    } else if (str.charAt(i) == '-') {
		subtract();
	    } else if (str.charAt(i) == '*') {
		multiply();
	    } else if (str.charAt(i) == '/') {
		divide();
	    } else {
		int index = i;
		while (i < len && str.charAt(i) != ' ' && str.charAt(i) != '\n') {
		    i++;
		} // while
		RPNStack.push(Double.valueOf(str.substring(index, i)));
	    } // if/else
	    i++;
	} // while
	return true;
    }

    public void add() throws Exception {
	this.RPNStack.push(this.RPNStack.pop() + this.RPNStack.pop());
    }

    public void subtract() throws Exception {
	this.RPNStack.push(-this.RPNStack.pop() + this.RPNStack.pop());
    }

    public void multiply() throws Exception {
	this.RPNStack.push(this.RPNStack.pop() * this.RPNStack.pop());
    }

    public void divide() throws Exception {
	this.RPNStack.push((1 / this.RPNStack.pop()) * this.RPNStack.pop());
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
    }

}
