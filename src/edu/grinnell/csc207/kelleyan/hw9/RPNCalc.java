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
	    char current = str.charAt(i);
	    if (current == 'p') {
		if (RPNStack.isEmpty()) {
		    pen.println("Nothing in memory");
		} else {
		    pen.println(RPNStack.peek());
		} // else
	    } else if (current == 's') {
		if (RPNStack.isEmpty()) {
		    pen.println("Nothing in memory");
		} else {
		    ArrayBasedStackIterator<Double> it = new ArrayBasedStackIterator<Double>(
			    RPNStack);
		    while (it.hasNext()) {
			pen.println(it.next());
		    } // while
		}// else
	    } else if (current == 'c') {
		while (!this.RPNStack.isEmpty()) {
		    RPNStack.pop();
		} // while
	    } else if (current == 'q') {
		return false;
	    } else if (current == '+') {
		add();
	    } else if (current == '-') {
		subtract();
	    } else if (current == '*') {
		multiply();
	    } else if (current == '/') {
		divide();
	    } else if (current != ' '){
		int index = i;
		while (i < len && str.charAt(i) != ' ' && str.charAt(i) != '\n') {
		    i++;
		} // while
		RPNStack.push(Double.valueOf(str.substring(index, i)));
	    } // if/else
	    i++;
	} // while
	return true;
    }// evaluate

    public void add() throws Exception {
	this.RPNStack.push(this.RPNStack.pop() + this.RPNStack.pop());
    }// add

    public void subtract() throws Exception {
	this.RPNStack.push(-1 * this.RPNStack.pop() + this.RPNStack.pop());
    }// subtract

    public void multiply() throws Exception {
	this.RPNStack.push(this.RPNStack.pop() * this.RPNStack.pop());
    }// multiply

    public void divide() throws Exception {
	this.RPNStack.push((1 / this.RPNStack.pop()) * this.RPNStack.pop());
    }// divide

} // RPNCalc
