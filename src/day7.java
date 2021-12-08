import java.io.IOException;
import java.util.ArrayList;

public class day7
{
    public static void main(String[] args) throws IOException
    {
        part2();
    }

    private static void part1() throws IOException
    {
        ArrayList<String> input = new ArrayList<>(ReadFile.ToStringList("src/inputDay7.txt"));
        String[] temp = input.get(0).split(",");

        int maxValue = 0;
        for (String value : temp)
        {
            if(Integer.valueOf(value) > maxValue)
            {
                maxValue = Integer.valueOf(value);
            }
        }

        int minimumFuel = 1000000; //to be overridden
        int minIndex = 0;
        for (int i = 0; i <= maxValue; i++)
        {
            int fuel = 0;
            for (int a = 0; a < temp.length; a++)
            {
                fuel += Math.abs(Integer.valueOf(temp[a]) - i);
            }

            if (fuel < minimumFuel)
            {
                minimumFuel = fuel;
                minIndex = i;
            }
        }

        System.out.println("Lowest fuel " + minimumFuel + " is achieved at pos " + minIndex);
    }

    private static void part2() throws IOException
    {
        ArrayList<String> input = new ArrayList<>(ReadFile.ToStringList("src/inputDay7.txt"));
        String[] temp = input.get(0).split(",");

        int maxValue = 0;
        for (String value : temp)
        {
            if(Integer.valueOf(value) > maxValue)
            {
                maxValue = Integer.valueOf(value);
            }
        }

        int minimumFuel = 1000000000; //to be overridden
        int minIndex = 0;
        for (int i = 0; i <= maxValue; i++)
        {
            int fuel = 0;
            for (int a = 0; a < temp.length; a++)
            {
                for (int x = 0; x <= Math.abs(i - Integer.valueOf(temp[a])); x++)
                {
                    fuel += x;
                }
            }

            if (fuel < minimumFuel)
            {
                minimumFuel = fuel;
                minIndex = i;
            }
        }

        System.out.println("Lowest fuel " + minimumFuel + " is achieved at pos " + minIndex);
    }
}
