package szh5;

import static org.junit.Assert.*;
import org.junit.*;
//import stingy.*;

import stingy.StingySlot;



public class TestStingySlot {
	StingySlot myStingySlot;
	MyStingySlot mss;
	
	@Before
	public void initialize() {
		myStingySlot = new StingySlot();
		mss = new MyStingySlot();
	}
	
	@Test
	public void TestMax() {
		int[] myArray = {42,42, 42, 42, 42};
		myStingySlot.setSpin(myArray);
		mss.setSpin(myArray);
		System.out.println("Max payoff: " +myStingySlot.payoff() + " Should be: " +mss.payoff());
		assertEquals(mss.payoff(), myStingySlot.payoff(), .01);
	}

	@Test
	public void TestZero() {
		int[] myArray = {5, 3, 2, 6, 10};
		myStingySlot.setSpin(myArray);
		mss.setSpin(myArray);
		System.out.println("Zero Test: " +myStingySlot.payoff() + " Should be: " +mss.payoff());
		assertEquals(mss.payoff(), myStingySlot.payoff(), .01);	
	}
	
	@Test
	public void TestRule1(){
		for (int i=2; i<=60; i++)
		{
		if (i==4 || i==9 || i==16 || i==25 || i==36|| i==49 || i%17==0 || i==41)	
		{
			break;
		}
		int[] myArray = {i, i, i, i, i};
		myStingySlot.setSpin(myArray);
		mss.setSpin(myArray);
		System.out.println("Testing 1: " +myStingySlot.payoff() + " Should be: " +mss.payoff());
		assertEquals(mss.payoff(), myStingySlot.payoff(), .01);		
		}
	}
	
	
	
	@Test
	public void TestRule2(){
			int[] myArray = {2, 2, 59, 2, 2};
			myStingySlot.setSpin(myArray);
			mss.setSpin(myArray);
			System.out.println("Testing 2: " +myStingySlot.payoff() + " Should be: " +mss.payoff());
			assertEquals(mss.payoff(), myStingySlot.payoff(), .01);
			
	}
		
	
	
	@Test
	public void TestRule3() {
		int[] myArray = {3, 3, 2, 3, 2};
		myStingySlot.setSpin(myArray);
		mss.setSpin(myArray);
		System.out.println("Testing 3: " +myStingySlot.payoff() + " Should be: " +mss.payoff());
		assertEquals(myStingySlot.payoff(), mss.payoff(), .01);
	}
	
	@Test
	public void TestRule4() {
		int[] myArray = {43, 43, 5, 43, 2};
		myStingySlot.setSpin(myArray);
		mss.setSpin(myArray);
		System.out.println("Testing 4: " +myStingySlot.payoff() + " Should be: " +mss.payoff());
		assertEquals(myStingySlot.payoff(), mss.payoff(), .01);
	}
	
	
	@Test
	public void TestRule5() {
		int[] myArray = {3, 5, 3, 5, 43};
		myStingySlot.setSpin(myArray);
		mss.setSpin(myArray);
		System.out.println("Testing 5: " +myStingySlot.payoff() + " Should be: " +mss.payoff());
		assertEquals(myStingySlot.payoff(), mss.payoff(), .01);
		
	}
	
	@Test
	public void TestRule6() {
		int[] myArray = {36, 3, 2, 9, 41};
		myStingySlot.setSpin(myArray);
		mss.setSpin(myArray);
		System.out.println("Testing 6: " +myStingySlot.payoff() + " Should be: " +mss.payoff());
		assertEquals(myStingySlot.payoff(), mss.payoff(), .01);
		
	}
	
	@Test
	public void TestRule7() {
		int[] myArray = {11, 3, 2, 42, 27};
		myStingySlot.setSpin(myArray);
		mss.setSpin(myArray);
		System.out.println("Testing 7: " +myStingySlot.payoff() + " Should be: " +mss.payoff());
		assertEquals(myStingySlot.payoff(), mss.payoff(), .01);
		
	}
	
	@Test
	public void TestRule8() {
		int[] myArray = {17, 2, 34, 30, 51};
		myStingySlot.setSpin(myArray);
		mss.setSpin(myArray);
		System.out.println("Testing 8: " +myStingySlot.payoff() + " Should be: " +mss.payoff());
		assertEquals(myStingySlot.payoff(), mss.payoff(), .01);
	}
	
	@Test
	public void TestAverage() {
		double totalaverages=0;
		for (int i=0; i<60*60*60*60; i++) {
			 myStingySlot.doSpin();
			 mss.doSpin();
			totalaverages+=myStingySlot.payoff();
		}
		double average=totalaverages/60*60*60*60;
		System.out.println(average);
		assertTrue (average<=2.0);
		
	}
	
	@Test
	public void TestRule4n6() {
		int[] myArray = {36, 4, 60, 36, 36};
		myStingySlot.setSpin(myArray);
		mss.setSpin(myArray);
		System.out.println("Testing 4n6: " +myStingySlot.payoff() + " Should be: " +mss.payoff());
		assertEquals(myStingySlot.payoff(), mss.payoff(), .01);
	}
	
	@Test
	public void TestRule4n7() {
		int[] myArray = {60, 42, 60, 5, 60};
		myStingySlot.setSpin(myArray);
		mss.setSpin(myArray);
		System.out.println("Testing 4n7: " +myStingySlot.payoff() + " Should be: " +mss.payoff());
		assertEquals(myStingySlot.payoff(), mss.payoff(), .01);
	}
	
	@Test
	public void TestRule6n7() {
		int[] myArray = {36, 42, 22, 5, 1};
		myStingySlot.setSpin(myArray);
		mss.setSpin(myArray);
		System.out.println("Testing 6n7: " +myStingySlot.payoff() + " Should be: " +mss.payoff());
		assertEquals(myStingySlot.payoff(), mss.payoff(), .01);	
	}
	
	

}
