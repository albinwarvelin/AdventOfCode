import java.io.IOException;
import java.util.ArrayList;

public class day4
{
    public static void main(String[] args) throws IOException
    {
        part2();
    }

    private static void part1() throws IOException
    {
        ArrayList<String> input = new ArrayList<>(ReadFile.ToStringList("src/inputDay4.txt"));

        String[] pickedValues = input.get(0).split(",");
        ArrayList<BingoBoard> bingoBoards = new ArrayList<>();

        for (int i = 1; i < input.size(); i += 5)
        {
            bingoBoards.add(new BingoBoard(new String[]{input.get(i), input.get(i + 1), input.get(i + 2), input.get(i + 3), input.get(i + 4)}));
        }

        int correctAnswer = 0;
        outerloop:
        for (int i = 0; i < pickedValues.length; i++)
        {
            //Check if bingoboards contains value and mark correct, break if full row
            for (int a = 0; a < bingoBoards.size(); a++)
            {
                if(bingoBoards.get(a).check(pickedValues[i]))
                {
                    correctAnswer = bingoBoards.get(a).getPoints() * Integer.valueOf(pickedValues[i]);
                    break outerloop;
                }
            }
        }

        System.out.println("Correct answer is " + correctAnswer);
    }

    private static void part2() throws IOException
    {
        ArrayList<String> input = new ArrayList<>(ReadFile.ToStringList("src/inputDay4.txt"));

        String[] pickedValues = input.get(0).split(",");
        ArrayList<BingoBoard> bingoBoards = new ArrayList<>();

        for (int i = 1; i < input.size(); i += 5)
        {
            bingoBoards.add(new BingoBoard(new String[]{input.get(i), input.get(i + 1), input.get(i + 2), input.get(i + 3), input.get(i + 4)}));
        }

        int correctBoards = 0;
        int correctAnswer = 0;
        outerloop:
        for (int i = 0; i < pickedValues.length; i++)
        {
            //Check if bingoboards contains value and mark correct, break if full row
            for (int a = 0; a < bingoBoards.size(); a++)
            {
                if (!bingoBoards.get(a).IsCorrect())
                {
                    if(bingoBoards.get(a).check(pickedValues[i]))
                    {
                        if (correctBoards == 99)
                        {
                            correctAnswer = bingoBoards.get(a).getPoints() * Integer.valueOf(pickedValues[i]);
                            break outerloop;
                        }
                        else
                        {
                            correctBoards++;
                        }
                    }
                }
            }
        }

        System.out.println("Correct answer is " + correctAnswer);
    }
}
