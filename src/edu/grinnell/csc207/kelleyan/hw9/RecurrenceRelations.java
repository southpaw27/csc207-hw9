package edu.grinnell.csc207.kelleyan.hw9;

public class RecurrenceRelations {

    /*
     * f6(n) = c + 2 * f6(n-1)
     * 
     * f6(1) = 1
     * f6(2) = c + 2*(1) = c + 2
     * f6(3) = c + 2*(c + 2) = 3c + 4
     * f6(4) = c + 2*(3c + 4) = 7c + 8
     * f6(5) = c + 2(7c + 8) = 15c + 16
     * 
     * f6(n) = 2^n + c(2^n - 1)
     * 
     */
    
    /*
     * f5(n) = c + 2(f5(n/2))
     * 
     * f5(1) = 1
     * 
     * f5(n) = c + 2(f5(n/2))
     * f5(n) = c + 2(c + 2(f5(n/4))) = 3c + 4(f5(n/8))
     * f5(n) = 3c + 4(c + 2(f5(n/16))) = 7c + 8(f5(n/32))
     * 
     * f5(n) = (2^k - 1)c + 2^k * ( f5(n/(2^k+1)))
     * 
     * if n = 2^k+1
     * then
     * f5(n) = (2^k - 1)c + 2^k *(f5(n/n)) = (2^k - 1)c + 2^k(f5(1))
     * f5(n) = (2^k - 1)c + 2^k
     *
     * furthermore, n * 2^-1 = 2^k+1 * 2^-1
     * n/2 = 2^k
     * 
     * so
     * f5(n) = (n/2 - 1) c + n/2
     * f5(n) = c * n/2 - c + n/2
     * f5(n) = (c + 1) n/2 - c
     * 
     * can we assume the n's dominate???? how big is c???
     * 
     */
    public RecurrenceRelations() {
	// TODO Auto-generated constructor stub
    }

}
