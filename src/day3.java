import java.io.IOException;
import java.util.ArrayList;

public class day3
{
    public static void main(String[] args) throws IOException
    {
        part1();
    }

    private static void part1() throws IOException
    {
        ArrayList<String> values = new ArrayList<>(ReadFile.ToStringList("src/inputDay3.txt"));

        int[]positive = new int[12];
        int[]negative = new int[12];

        for (String value : values)
        {
            for(int i = 0; i < 12; i++)
            {
               if (value.charAt(i) == '0')
               {
                   negative[i]++;
               }
               else
               {
                   positive[i]++;
               }
            }
        }

        String gammaRate = "";
        String epsilonRate = "";
        int gammaValue = 0;
        int epsilonValue = 0;

        for(int i = 0; i < 12; i++)
        {
            if (positive[i] > negative[i])
            {
                gammaRate += "1";
                epsilonRate += "0";

                gammaValue += 1 * Math.pow(2, 11 - i);
            }
            else
            {
                gammaRate += "0";
                epsilonRate += "1";

                epsilonValue += 1 * Math.pow(2, 11 - i);
            }
        }

        System.out.println("Gamma rate: " + gammaRate + ". Epsilon rate: " + epsilonRate + ". Multiplied: " + gammaValue * epsilonValue);
    }
}
