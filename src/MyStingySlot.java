package szh5;

import java.util.Random;

import stingy.StingySlot;

public class MyStingySlot {	
	protected Random randy; // will be used to generate random numbers
	protected int spinLength=5; // number of numbers that you get when you play 
	protected int[] spin; // array of random numbers that may win
	protected static final int maxToken=60; // the biggest that the random number can get.
	protected double winnings; // the payoff value, when computed
	
	public static void main( String[] args )
	{
		StingySlot ss = new StingySlot();
		
		ss.doSpin();
		ss.payoff();
		ss.report();
	}
	
	// constructor
    public MyStingySlot()
    {
	    randy = new Random();
	    spin = new int[spinLength];	   	   	   
    }
    
    /**
     * Converts an array of ints into a string [ # # # # ... # ]
     *
     * @return the string version of the array
     * @param an array of ints
     */
    public static String drawingToString( int[] m ) {
        assert( m.length == 5 );
        String res = "[ ";
        for ( int n : m ) {
                res += n + " ";
        }
        res += "]";
        return res;
    }
    
    /**
     * converts the spin array to a string, suitable for output
     */
    public String drawingToString() {
    	String res = "[";
    	for ( int i=0; i<spinLength; i++ )
    	{ res += spin[i] + " "; }
    	res += "]";
    	return res;
    }
   
    /**
     * return an array of ints that might win something, a "spin" of the numbers
    */
   public int[] doSpin()
    {	   
	    for ( int i=0; i<spinLength; i++ )
	    {
		   spin[i] = randy.nextInt(maxToken) +1;
	    }
	    return spin;
    }
   
   
    /**
     */
   public int[] getSpin()
   {
	   return spin;
   }
    /* *
     for testing, here's a version of the payoff method that lets the calling program
     put in the array of numbers.
     @param array of ints to be check for money, note length must match 
         luckyLength, as of this writing =5.
     */
   /*
    public double payOff( int[] rig )
    {
    	spinLength = rig.length;
	    for ( int i=0; i<rig.length; i++ )
	    {
		   spin[i] =  rig[i];
	    }
    	
	    return payOff();
    }*/
    
    /**
     * make it at though the argument rig was the random spin
     * Note: rig length needs to be at least spinLength
     *
     * @param rig the array of numbers to set the spin to.  
     * 
     */
    public int[] setSpin( int[] rig )
    {
	    for ( int i=0; i<spinLength; i++ )
	    {
		   spin[i] =  rig[i];
	    }
	    return spin;
    }
    
    // compute and return the payoff value for the current spin
    public double payoff()
    {    	
    	 winnings=0;
    	
    //bubble sort to sort numbers in ascending order
	   for (int m =0; m<=4; m++)
	   {
		for (int n=m+1; n<=4; n++)
		{
		if (spin[m] > spin[n] )
			{
			int temp=spin[m];
			spin[m]=spin[n];
			spin[n]=temp;
			}
		}
	   }
    	
    int a = spin [0];
    int b = spin [1];
    int c = spin [2];
    int d = spin [3];
    int e = spin [4];
    	
	boolean found=false;
	while (!found)
	{
		if (a==e)
		{
			winnings+= 1000000;
    		found=true;
    		break;
    	}
    	if (a==d || b==e)
    	{
    		winnings += 10000;
    		found=true;
    		break;
    	}
    	if (a==c)
    	{
    		if( d==e)
    		{
    			winnings+=500;
    			found=true;
    			break;
    		}
    		else {
    			winnings+=10;
    			found=true;
    			break;
    		}
    	}
    	
    	if (c==e)
    	{
    		if (a==b) {
    		winnings +=500;
    		found=true;
    		break;
    		}
    		else {
    			winnings+=10;
    			found=true;
    			break;
    		}
    	}
    	if (b==d) 
    	{
    		winnings+=10;
    		found=true;
    		break;
    	}
    	if (a==b)
    	{
    		if (c==d || d==e )
    		{
    			winnings+=4;
    			found=true;
    			break;
    		}
    		else {
    			winnings+=2;
    			found=true;
    			break;
    		}
    	}
    	if (b==c ){
    		if (d==e)
    		{
    			winnings+=4;
    			found=true;
    			break;
    		}
    		else {
    			winnings+=2;
    			found=true;
    			break;
    		}
    	}
    		
    	if (c==d || d==e){
    		winnings+=2;
    		found=true;
    		break;
    	}
    	found=true;
	}
    
	for (int m=0; m<=4; m++)
    {
    	if (spin [m] %17==0)
    	{
    		winnings +=.17;
    	}
    	if (spin[m] == 42)
    	{
    		winnings+=.35;
    	}
    	if (spin[m] == 1 || spin[m] == 4 || spin[m] == 9 || 
    		spin[m] == 16 )
    		{
    		winnings+=.10;
    		}
    	if (spin[m] == 25 || spin[m] == 36 || spin[m] == 49) {
    		winnings+=.10;
    	}
    	else {
    		winnings+=0;
    	}
    }
    return winnings;
    }

    	
    	
    	
 
    
    // shows your spin and the payoff for it
    public void report()
    {
    	System.out.print("random numbers :");
	    for ( int i=0; i<spinLength; i++ )
	    {
		   System.out.print(" "+spin[i]);
	    }
	    System.out.println(" pays $"+winnings+".");

    }
    
    /**
     * for debugging purposes, this sets the value of lucky, the array of ints
     * containing the drawing
     */
    public void setLucky( int[] m )
    {
    	spin = new int[m.length ];
    	for ( int i=0; i<m.length; i++ )
    	{
    		spin[i] = m[i];
    	}
    }

}
