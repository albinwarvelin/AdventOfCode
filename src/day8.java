import java.io.IOException;
import java.util.ArrayList;

public class day8
{
    public static void main(String[] args) throws IOException
    {
        part2();
    }

    private static void part1() throws IOException
    {
        ArrayList<String> input = new ArrayList<>(ReadFile.ToStringList("src/inputDay8.txt"));

        int[] digits = new int[4]; //1, 4, 7 and 8


        for (String value : input)
        {
            String[] temp = value.split(" \\| ");
            String[] outputValues = temp[1].split(" ");

            for (String outputValue : outputValues)
            {
                if (outputValue.length() == 2)
                {
                    digits[0]++; //1
                }
                if (outputValue.length() == 3)
                {
                    digits[2]++; //7
                }
                if (outputValue.length() == 4)
                {
                    digits[1]++; //4
                }
                if (outputValue.length() == 7)
                {
                    digits[3]++; //8
                }
            }
        }

        System.out.println("Output values contain: 1: " + digits[0] + " 4: " + digits[1] + " 7: " + digits[2] + " 8: " + digits[3]);
        int total = Integer.valueOf(digits[0]) + Integer.valueOf(digits[1]) + Integer.valueOf(digits[2]) + Integer.valueOf(digits[3]);
        System.out.println("Total: " + total);
    }

    private static void part2() throws IOException
    {
        ArrayList<String> input = new ArrayList<>(ReadFile.ToStringList("src/inputDay8.txt"));

        int totalValue = 0;

        for (String line : input)
        {
            String[] temp = line.split(" \\| ");
            String[] inputDefinitions = temp[0].split(" ");

            String[] codes = new String[10];
            String[] letterPositions = new String[7];

            /** Determines codes for 1, 4, 7 and 8**/
            for (String combination : inputDefinitions)
            {
                if (combination.length() == 2)
                {
                    codes[1] = combination; //1
                }
                if (combination.length() == 3)
                {
                    codes[7] = combination; //7
                }
                if (combination.length() == 4)
                {
                    codes[4] = combination; //4
                }
                if (combination.length() == 7)
                {
                    codes[8] = combination; //8
                }
            }

            /** Determines letter at top position **/
            if (!codes[1].contains(codes[7].substring(0,1)))
            {
                letterPositions[0] = codes[7].substring(0,1);
            }
            else if (!codes[1].contains(codes[7].substring(1,2)))
            {
                letterPositions[0] = codes[7].substring(1,2);
            }
            else if (!codes[1].contains(codes[7].substring(2,3)))
            {
                letterPositions[0] = codes[7].substring(2,3);
            }

            /** Determines code for 6 and right letter position **/
            ArrayList<String> code069 = new ArrayList<>();
            for (String combination : inputDefinitions)
            {
                if (combination.length() == 6)
                {
                    code069.add(combination);
                }
            }

            for (String combination : code069)
            {
                if (!combination.contains(codes[1].substring(0,1)))
                {
                    codes[6] = combination; //6
                    letterPositions[2] = codes[1].substring(0,1);
                    letterPositions[5] = codes[1].substring(1,2);

                    code069.remove(combination); //Removes 6 from list
                    break;
                }
                else if (!combination.contains(codes[1].substring(1,2)))
                {
                    codes[6] = combination; //6
                    letterPositions[2] = codes[1].substring(1,2);
                    letterPositions[5] = codes[1].substring(0,1);

                    code069.remove(combination); //Removes 6 from list
                    break;
                }
            }

            /** Determines code for 0, 9 and mid letter position **/
            for (String combination : code069)
            {
                if (combination.contains(codes[4].substring(0,1)) && combination.contains(codes[4].substring(1,2)) && combination.contains(codes[4].substring(2,3)) && combination.contains(codes[4].substring(3,4)))
                {
                    codes[9] = combination; //9

                    if (code069.get(0) == codes[9]) //0
                    {
                        codes[0] = code069.get(1);
                    }
                    else
                    {
                        codes[0] = code069.get(0);
                    }
                }
            }

            for (int i = 0; i < 4; i++) //Determines letter at mid position
            {
                if (!codes[0].contains(codes[4].substring(i, i + 1)))
                {
                    letterPositions[3] = codes[4].substring(i, i + 1);
                }
            }

            /** Determines code for 3 **/
            ArrayList<String> code235 = new ArrayList<>();
            for (String combination : inputDefinitions)
            {
                if (combination.length() == 5)
                {
                    code235.add(combination);
                }
            }

            for (String combination : code235)
            {
                if (combination.contains(letterPositions[0]) && combination.contains(letterPositions[2]) && combination.contains(letterPositions[3]) && combination.contains(letterPositions[5]))
                {
                    codes[3] = combination;
                }

                else if (combination.contains(letterPositions[0]) && combination.contains(letterPositions[2]) && combination.contains(letterPositions[3]))
                {
                    codes[2] = combination;
                }

                else if (combination.contains(letterPositions[0]) && combination.contains(letterPositions[3]) && combination.contains(letterPositions[5]))
                {
                    codes[5] = combination;
                }
            }

            /** Calculates value of output **/
            String[] outputDefinitions = temp[1].split(" ");
            String outputValue = "";

            for (String combination : outputDefinitions)
            {
                if (combination.contains(codes[8].substring(0, 1)) && combination.contains(codes[8].substring(1, 2)) && combination.contains(codes[8].substring(2, 3)) && combination.contains(codes[8].substring(3, 4)) && combination.contains(codes[8].substring(4, 5)) && combination.contains(codes[8].substring(5, 6)) && combination.contains(codes[8].substring(6, 7)))
                {
                    outputValue += 8;
                }
                else if (combination.contains(codes[9].substring(0, 1)) && combination.contains(codes[9].substring(1, 2)) && combination.contains(codes[9].substring(2, 3)) && combination.contains(codes[9].substring(3, 4)) && combination.contains(codes[9].substring(4, 5)) && combination.contains(codes[9].substring(5, 6)))
                {
                    outputValue += 9;
                }
                else if (combination.contains(codes[6].substring(0, 1)) && combination.contains(codes[6].substring(1, 2)) && combination.contains(codes[6].substring(2, 3)) && combination.contains(codes[6].substring(3, 4)) && combination.contains(codes[6].substring(4, 5)) && combination.contains(codes[6].substring(5, 6)))
                {
                    outputValue += 6;
                }
                else if (combination.contains(codes[0].substring(0, 1)) && combination.contains(codes[0].substring(1, 2)) && combination.contains(codes[0].substring(2, 3)) && combination.contains(codes[0].substring(3, 4)) && combination.contains(codes[0].substring(4, 5)) && combination.contains(codes[0].substring(5, 6)))
                {
                    outputValue += 0;
                }
                else if (combination.contains(codes[2].substring(0, 1)) && combination.contains(codes[2].substring(1, 2)) && combination.contains(codes[2].substring(2, 3)) && combination.contains(codes[2].substring(3, 4)) && combination.contains(codes[2].substring(4, 5)))
                {
                    outputValue += 2;
                }
                else if (combination.contains(codes[3].substring(0, 1)) && combination.contains(codes[3].substring(1, 2)) && combination.contains(codes[3].substring(2, 3)) && combination.contains(codes[3].substring(3, 4)) && combination.contains(codes[3].substring(4, 5)))
                {
                    outputValue += 3;
                }
                else if (combination.contains(codes[5].substring(0, 1)) && combination.contains(codes[5].substring(1, 2)) && combination.contains(codes[5].substring(2, 3)) && combination.contains(codes[5].substring(3, 4)) && combination.contains(codes[5].substring(4, 5)))
                {
                    outputValue += 5;
                }
                else if (combination.contains(codes[4].substring(0, 1)) && combination.contains(codes[4].substring(1, 2)) && combination.contains(codes[4].substring(2, 3)) && combination.contains(codes[4].substring(3, 4)))
                {
                    outputValue += 4;
                }
                else if (combination.contains(codes[7].substring(0, 1)) && combination.contains(codes[7].substring(1, 2)) && combination.contains(codes[7].substring(2, 3)))
                {
                    outputValue += 7;
                }
                else if (combination.contains(codes[1].substring(0, 1)) && combination.contains(codes[1].substring(1, 2)))
                {
                    outputValue += 1;
                }
            }


            totalValue += Integer.valueOf(outputValue);
        }

        System.out.println("Total value is: " + totalValue);
    }
}
