
public class MP3 extends Gadget
{
    private int memory;

    public MP3(String model, double price, int weight, String size, int memory)
    {
        super(model, price, weight, size);
        this.memory = memory;
    }

    public int getMemory()
    {
        return memory;
    }

    public void downloadMusic(int size)
    {
        if(size <= 0)
        {
            System.out.println("Please enter a valid download size.");
        }
        else if(memory >= size)
        {
            memory = memory - size;
            System.out.println("Music downloaded successfully.");
            System.out.println("Available memory: " + memory);
        }
        else
        {
            System.out.println("Not enough available memory.");
        }
        
    }   
}
    

   
    
        
        