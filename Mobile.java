public class Mobile extends Gadget
{
    private int credit;

    public Mobile(String model, double price, int weight, String size, int credit)
    {
        super(model, price, weight, size);
        this.credit = credit;
    }

    public int getCredit()
    {
        return credit;
    }

    public void addCredit(int amount)
    {
        if(amount > 0)
        {
            credit = credit + amount;
            System.out.println("Credit added successfully.");
        }
        else
        {
            System.out.println("Please enter a positive amount of credit.");
        }
    }

    public void makeACall(String phoneNumber, int duration)
    {
        if(duration <= 0)
        {
            System.out.println("Please enter a valid call duration.");
        }
        else if(credit >= duration)
        {
            System.out.println("Calling " + phoneNumber + " for " + duration + " minutes.");
            credit = credit - duration;
            System.out.println("Remaining credit: " + credit + " minutes.");
        }
        else
        {
            System.out.println("Insufficient credit to make the call.");
        }
    }

    public void display()
    {
        super.display();
        System.out.println("Calling credit remaining: " + credit + " minutes");
    }
}