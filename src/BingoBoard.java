import java.util.ArrayList;

public class BingoBoard
{
    ArrayList<int[]> rows = new ArrayList<>();
    private boolean isCorrect = false;

    public BingoBoard(String[] inputRows)
    {
        for(String row : inputRows)
        {
            String[] temp = row.split(" ");
            ArrayList<String> tempStringRow = new ArrayList<>();

            int max = 5;
            for (int i = 0; i < max; i++)
            {
                if (!temp[i].equals(""))
                {
                    tempStringRow.add(temp[i]);
                }
                else
                {
                    max++;
                }
            }


            int[] tempIntegerRow = new int[5];

            tempIntegerRow[0] = Integer.valueOf(tempStringRow.get(0));
            tempIntegerRow[1] = Integer.valueOf(tempStringRow.get(1));
            tempIntegerRow[2] = Integer.valueOf(tempStringRow.get(2));
            tempIntegerRow[3] = Integer.valueOf(tempStringRow.get(3));
            tempIntegerRow[4] = Integer.valueOf(tempStringRow.get(4));

            rows.add(tempIntegerRow);
        }
    }

    public boolean check(String temp)
    {
        int pickedValue = Integer.valueOf(temp);

        for (int i = 0; i < 5; i++) //Checks if picked value is in board
        {
            for (int a = 0; a < 5; a++)
            {
                if (rows.get(i)[a] == pickedValue)
                {
                    rows.get(i)[a] = 100;
                }
            }
        }

        boolean correct = false;
        for (int i = 0; i < 5; i++) //Checks if any row is correct
        {
            for (int a = 0; a < 5; a++)
            {
                if (rows.get(i)[a] == 100)
                {
                    if (a == 4)
                    {
                        correct = true;
                    }
                }
                else
                {
                    break;
                }
            }
        }

        for (int i = 0; i < 5; i++) //Checks if any column is correct
        {
            for (int a = 0; a < 5; a++)
            {
                if (rows.get(a)[i] == 100)
                {
                    if (a == 4)
                    {
                        correct = true;
                    }
                }
                else
                {
                    break;
                }
            }
        }

        if (correct)
        {
            isCorrect = true;
            return true;
        }
        else
        {
            return false;
        }
    }

    public int getPoints()
    {
        int points = 0;

        for (int i = 0; i < 5; i++) //Checks if any row is correct
        {
            for (int a = 0; a < 5; a++)
            {
                if (rows.get(i)[a] != 100)
                {
                    points += rows.get(i)[a];
                }
            }
        }

        return points;
    }

    public boolean IsCorrect()
    {
        return isCorrect;
    }
}
