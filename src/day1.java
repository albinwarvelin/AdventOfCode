import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class day1
{
    public static void main(String[] args) throws IOException
    {
        part2();
    }

    public static void part1() throws IOException
    {
        ArrayList<Integer> values = new ArrayList<>();
        values = ReadFile.ToIntegerList("src/inputDay1.txt");

        int sum = 0;

        int previousValue = values.get(0);
        for(int value : values)
        {
            if (value > previousValue)
            {
                sum++;
            }

            previousValue = value;
        }

        System.out.println("Sum: " + sum);
    }

    public static void part2() throws IOException
    {
        ArrayList<Integer> values;
        values = ReadFile.ToIntegerList("src/inputDay1.txt");

        int sum = 0;

        int previousValue = values.get(2) + values.get(1) + values.get(0);
        for (int i = 2; i < values.size(); i++)
        {
            int value = values.get(i - 2) + values.get(i - 1) + values.get(i);

            if (value > previousValue)
            {
                sum++;
            }

            previousValue = value;
        }

        System.out.println("Sum: " + sum);
    }
}
