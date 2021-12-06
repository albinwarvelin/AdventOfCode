import java.io.IOException;
import java.util.ArrayList;

public class day6
{
    public static void main(String[] args) throws IOException
    {
        part1();
        part2();
    }

    private static void part1() throws IOException
    {
        ArrayList<String> tempA = new ArrayList<>(ReadFile.ToStringList("src/inputDay6.txt"));
        String[] tempB = tempA.get(0).split(",");

        ArrayList<Integer> school = new ArrayList<>();
        for (String value : tempB) //Add values to arraylist
        {
            school.add(Integer.valueOf(value));
        }

        for (int i = 0; i < 80; i++) //days
        {
            int sizeAtDayStart = school.size();
            for (int a = 0; a < sizeAtDayStart; a++)
            {
                if (school.get(a) == 0)
                {
                    school.set(a, 6);
                    school.add(8);
                }
                else
                {
                    school.set(a, school.get(a) - 1);
                }
            }
        }

        System.out.println("School size after 80 days: " + school.size() + ".");
    }

    private static void part2() throws IOException
    {
        ArrayList<String> tempA = new ArrayList<>(ReadFile.ToStringList("src/inputDay6.txt"));
        String[] tempB = tempA.get(0).split(",");

        long toMove = 0;

        long zeros = 0;
        long ones = 0;
        long twos = 0;
        long threes = 0;
        long fours = 0;
        long fives = 0;
        long sixes = 0;
        long sevens = 0;
        long eights = 0;

        for (String value : tempB)
        {
            switch (Integer.valueOf(value)) //Input contains only 1,2,3,4 and 5s
            {
                case 1 -> {ones++;}
                case 2 -> {twos++;}
                case 3 -> {threes++;}
                case 4 -> {fours++;}
                case 5 -> {fives++;}
            }
        }

        for (int i = 0; i < 256; i++)
        {
            toMove = zeros;
            zeros = ones;
            ones = twos;
            twos = threes;
            threes = fours;
            fours = fives;
            fives = sixes;
            sixes = toMove;

            sixes += sevens;
            sevens = eights;
            eights = toMove;
        }

        long schoolSize = zeros + ones + twos + threes + fours + fives + sixes + sevens + eights;

        System.out.println("School size after 256 days: " + schoolSize + ".");
    }
}
