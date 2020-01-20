import java.util.Scanner;

/**
 * 
 */

/**
 * @author jodielaurenson
 *
 */
public class Tester {

	private int change = 677;
	private int[] coins = {1,2,5,10,20,50,100,200};
	private int[] count = {0,0,0,0,0,0,0,0};
	private int[] stock = {59,399,782,24,134};
	

	/**
	 * 
	 */
	public Tester() {
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tester myTester = new Tester();
		myTester.displayMenu();
		int[] cart = myTester.orderItem();
		int total = myTester.calculateTotal(cart, myTester.getStock());
		int change = myTester.getChangeFromUser(total);
		myTester.calculateChange(7,myTester.getCoins(),myTester.getCount(),change);
		myTester.displayChange(myTester.getCount(),myTester.getCoins());

	}
	
	
	

	public void displayMenu()
	{
		System.out.println("Stock ");
		System.out.println("Item1: \t \t \t59p");
		System.out.println("Item2: \t \t \t£3.99");
		System.out.println("Item3: \t \t \t£7.82");
		System.out.println("Item4: \t \t \t24p");
		System.out.println("Item5: \t \t \t£1.34");
		System.out.println();
	}
	
	public int[] orderItem()
	{
		int[] cart = {0,0,0,0,0};
		int choice = -1;
		System.out.println("Please enter an item to add to cart: (enter 0 when you've finished shopping)");
		Scanner s1 = new Scanner(System.in);
		do
		{
			
			choice = s1.nextInt();
			if(choice>0 && choice<cart.length+1)
			{
				cart[choice-1]++;
				System.out.println("Item "+choice+" added to list");
			}
			else if(choice!=0)
			{
				System.out.println("Error: enter a number of item on the list");
			}
			
		}
		while(choice!=0);
		
		return cart;
	}
	
	public int calculateTotal(int[] cart,int[] stock)
	{
		int total = 0;
		for(int i=0;i<cart.length;i++)//go through every item in cart
		{
			for(int j=0;j<cart[i];j++)//go through every quantity of item
			{
				total+=stock[i];
			}
		}
		System.out.println("Total: "+total+"p");
		return total;
	}
	
	public int getChangeFromUser(int total)
	{
		int payment = -1;
		while(payment<total)
		{
			System.out.println("Enter payment amount in pounds");
			Scanner s1 = new Scanner(System.in);
			payment = (s1.nextInt())*100;
			if (payment<total)
			{
				System.out.println("Error: unsufficient funds");
			}
		}
		return payment-total;
	}

	public int[] calculateChange(int index, int[] coins, int[] count,int change)
	{
		if(index>=0)
		{
			if(change>=coins[index])
			{
				count[index]+=1;
				count = calculateChange(index,coins,count,change-coins[index]);
			}
			else
			{
				index--;
				count = calculateChange(index,coins,count,change);
			}
			
		}
		
		return count;
	}
	
	public void displayChange(int[] count,int[] change)
	{
		System.out.println();
		System.out.println("Your change:");
		for(int i = 7;i>=0;i--)
		{
			if(count[i]!=0)
			{
				if(change[i]>50)
				{
					System.out.println(count[i]+": £"+(change[i]/100));
				}
				else
				{
					System.out.println(count[i]+": "+change[i]+"p");
				}
				
			}
		}
	}
	
	public int[] getStock() {
		return stock;
	}

	public void setStock(int[] stock) {
		this.stock = stock;
	}
	
	public int getChange() {
		return change;
	}

	public void setChange(int change) {
		this.change = change;
	}

	public int[] getCoins() {
		return coins;
	}

	public void setCoins(int[] coins) {
		this.coins = coins;
	}

	public int[] getCount() {
		return count;
	}

	public void setCount(int[] count) {
		this.count = count;
	}
}
