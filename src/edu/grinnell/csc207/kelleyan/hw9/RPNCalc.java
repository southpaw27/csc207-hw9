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
    public static Double evaluate(String str) {
	// STUB
	return (double) 0;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
    }

}
