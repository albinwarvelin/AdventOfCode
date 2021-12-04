import java.io.IOException;
import java.util.ArrayList;

public class day3
{
    public static void main(String[] args) throws IOException
    {
        part2();
    }

    private static void part1() throws IOException
    {
        ArrayList<String> values = new ArrayList<>(ReadFile.ToStringList("src/inputDay3.txt"));

        int[]positive = new int[12];
        int[]zero = new int[12];

        for (String value : values)
        {
            for(int i = 0; i < 12; i++)
            {
               if (value.charAt(i) == '0')
               {
                   zero[i]++;
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
            if (positive[i] > zero[i])
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

    private static void part2() throws IOException
    {
        ArrayList<String> values = new ArrayList<>(ReadFile.ToStringList("src/inputDay3.txt"));

        String oxygenGenRating = "";

        /** Oxygen generator rating **/
        for (int i = 0; i < 12; i++)
        {
            ArrayList<String> positiveValues = new ArrayList<>();
            ArrayList<String> zeroValues = new ArrayList<>();

            for (String value : values)
            {
                if (value.charAt(i) == '1')
                {
                    positiveValues.add(value);
                }
                else
                {
                    zeroValues.add(value);
                }
            }

            if (positiveValues.size() > zeroValues.size())
            {
                values = positiveValues;
            }
            else if (positiveValues.size() < zeroValues.size())
            {
                values = zeroValues;
            }
            else
            {
                values = positiveValues;
            }

            if (values.size() == 1)
            {
                oxygenGenRating = values.get(0);
                break;
            }
        }

        /** CO2 scrubber rating **/
        values = new ArrayList<>(ReadFile.ToStringList("src/inputDay3.txt"));

        String CO2ScrubberRating = "";

        for (int i = 0; i < 12; i++)
        {
            ArrayList<String> positiveValues = new ArrayList<>();
            ArrayList<String> zeroValues = new ArrayList<>();

            for (String value : values)
            {
                if (value.charAt(i) == '1')
                {
                    positiveValues.add(value);
                }
                else
                {
                    zeroValues.add(value);
                }
            }

            if (positiveValues.size() > zeroValues.size())
            {
                values = zeroValues;
            }
            else if (positiveValues.size() < zeroValues.size())
            {
                values = positiveValues;
            }
            else
            {
                values = zeroValues;
            }

            if (values.size() == 1)
            {
                CO2ScrubberRating = values.get(0);
                break;
            }
        }

        /** Conversion **/
        int CO2ScrRatingDecimal = 0;
        int oxygenGenRatingDecimal = 0;

        for (int i = 0; i < CO2ScrubberRating.length(); i++)
        {
            if (CO2ScrubberRating.charAt(i) == '1')
            {
                CO2ScrRatingDecimal += Math.pow(2, (11 - i));
            }
        }

        for (int i = 0; i < oxygenGenRating.length(); i++)
        {
            if (oxygenGenRating.charAt(i) == '1')
            {
                oxygenGenRatingDecimal += Math.pow(2, (11 - i));
            }
        }

        System.out.println("Oxygen generator rating: " + oxygenGenRatingDecimal + ". CO2 scrubber rating: " + CO2ScrRatingDecimal + ". Life support rating: " + oxygenGenRatingDecimal * CO2ScrRatingDecimal);
    }
}
