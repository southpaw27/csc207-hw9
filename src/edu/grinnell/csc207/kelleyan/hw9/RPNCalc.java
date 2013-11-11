package edu.grinnell.csc207.kelleyan.hw9;

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
     * @param size
     * @throws Exception
     */
    public RPNCalc(int size) throws Exception {
	this.size = size;
	this.RPNStack =  new ArrayBasedStack<Double>(this.size);
    } // RPNCalc(int)
    
    
    // +-------------------------+-----------------------------------------
    // |     RPNCalc Methods     |
    // +-------------------------+
    
    /**
     * evaluate takes a string expression of an RPN calculator entry and parses
     * through the line, adding and popping from the stack as necessary and 
     * evaluating expressions as they appear.
     */
    public Double evaluate(String str) throws Exception {
	int len = str.length();
	// iterator through string
	int i = 0;
	Double temp1;
	while (i < len) {
	    if (str.charAt(i) == ' ') {
		i++;
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
		while (str.charAt(i) != ' ' && str.charAt(i + 1) != '\n') {
		    i++;
		} // while
		String tempStr = str.substring(index, i);
		temp1 = Double.valueOf(tempStr);
		RPNStack.push(temp1);
	    }
	}
	return (double) 0;
    }
    
    public void add() throws Exception {
	Double temp1 = this.RPNStack.pop();
	Double temp2 = this.RPNStack.pop();
	temp1 = temp1 + temp2;
	this.RPNStack.push(temp1);
    }
    
    public void subtract() throws Exception {
	Double temp1 = this.RPNStack.pop();
	Double temp2 = this.RPNStack.pop();
	temp1 = temp1 - temp2;
	this.RPNStack.push(temp1);
    }
    
    public void multiply() throws Exception {
	Double temp1 = this.RPNStack.pop();
	Double temp2 = this.RPNStack.pop();
	temp1 = temp1 * temp2;
	this.RPNStack.push(temp1);
    }
    
    public void divide() throws Exception{
	Double temp1 = this.RPNStack.pop();
	Double temp2 = this.RPNStack.pop();
	temp1 = temp1 / temp2;
	this.RPNStack.push(temp1);
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
    }

}
