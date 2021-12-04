import java.io.IOException;
import java.util.ArrayList;

public class day2
{
    public static void main(String[] args) throws IOException
    {
        part2();
    }

    private static void part1() throws IOException
    {
        int horizontalPos = 0;
        int depth = 0;

        ArrayList<String> values = ReadFile.ToStringList("src/inputDay2.txt");

        for (String value : values)
        {
            String[] temp = value.split(" ");

            int modifier = Integer.valueOf(temp[1]);

            switch (temp[0])
            {
                case "forward" -> horizontalPos += modifier;
                case "down" -> depth += modifier;
                case "up" -> depth -= modifier;
            }
        }

        System.out.println("Position: " + horizontalPos + ". Depth: " + depth + ". Combined: " + (depth * horizontalPos) + ".");
    }

    private static void part2() throws IOException
    {
        int horizontalPos = 0;
        int depth = 0;
        int aim = 0;

        ArrayList<String> values = ReadFile.ToStringList("src/inputDay2.txt");

        for (String value : values)
        {
            String[] temp = value.split(" ");

            int modifier = Integer.valueOf(temp[1]);

            switch (temp[0])
            {
                case "forward" -> {
                    horizontalPos += modifier;
                    depth += aim * modifier;
                }
                case "down" -> aim += modifier;
                case "up" -> aim -= modifier;
            }
        }

        System.out.println("Position: " + horizontalPos + ". Depth: " + depth + ". Combined: " + (depth * horizontalPos) + ".");
    }
}
