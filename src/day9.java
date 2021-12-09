import java.io.IOException;
import java.util.ArrayList;

public class day9
{
    public static void main(String[] args) throws IOException
    {
        part2();
    }

    private static void part1() throws IOException
    {
        ArrayList<String> inputs = new ArrayList<>(ReadFile.ToStringList("src/inputDay9.txt"));

        int[][] heightMap = new int[102][102];

        for(int y = 0; y < 102; y++) //X
        {
            for (int x = 0; x < 102; x++) //Y
            {
                heightMap[y][x] = Integer.valueOf(inputs.get(y).substring(x, x + 1));
            }
        }

        int riskLevel = 0;

        for (int y = 1; y < 101; y++)
        {
            for (int x = 1; x < 101; x++)
            {
                if (heightMap[y][x] < heightMap[y - 1][x] && heightMap[y][x] < heightMap[y][x - 1] && heightMap[y][x] < heightMap[y][x + 1] && heightMap[y][x] < heightMap[y + 1][x])
                {
                    riskLevel += heightMap[y][x] + 1;
                }
            }
        }

        System.out.println("Sum of all risklevels of lowpoints is: " + riskLevel);
    }

    private static void part2() throws IOException
    {
        ArrayList<String> inputs = new ArrayList<>(ReadFile.ToStringList("src/inputDay9.txt"));

        Point[][] heightMap = new Point[102][102];

        for(int y = 0; y < 102; y++) //X
        {
            for (int x = 0; x < 102; x++) //Y
            {
                heightMap[x][y] = new Point(x, y, Integer.valueOf(inputs.get(y).substring(x, x + 1)));
            }
        }

        /**=========================================**/

        for(int y = 0; y < 102; y++) //X
        {
            for (int x = 0; x < 102; x++) //Y
            {
                if (heightMap[x][y].getValue() != 9)
                {
                    System.out.print("\u001B[32m" + heightMap[x][y].getValue() + "\u001B[0m");
                }
                else
                {
                    System.out.print(heightMap[x][y].getValue());
                }
            }

            System.out.println();
        }

        /**=========================================**/

        ArrayList<Integer> basinSizes = new ArrayList<>();

        for (int y = 1; y < 101; y++) //Assigns n,s,w,e references to all points that are not 9s
        {
            for (int x = 1; x < 101; x++)
            {
                if (heightMap[x][y].getValue() != 9)
                {
                    if (heightMap[x][y - 1].getValue() != 9)
                    {
                        heightMap[x][y].setNorth(heightMap[x][y - 1]);
                    }
                    if (heightMap[x - 1][y].getValue() != 9)
                    {
                        heightMap[x][y].setWest(heightMap[x - 1][y]);
                    }
                    if (heightMap[x + 1][y].getValue() != 9)
                    {
                        heightMap[x][y].setEast(heightMap[x + 1][y]);
                    }
                    if (heightMap[x][y + 1].getValue() != 9)
                    {
                        heightMap[x][y].setSouth(heightMap[x][y + 1]);
                    }
                }
            }
        }

        for (int y = 1; y < 101; y++)
        {
            for (int x = 1; x < 101; x++)
            {
                if (heightMap[x][y].getValue() != 9 && !heightMap[x][y].isChecked())
                {
                    ArrayList<Point> basin = new ArrayList<>();

                    basin.add(heightMap[x][y]);
                    heightMap[x][y].setChecked(true);


                    for (int i = 0; i < basin.size(); i++)
                    {
                        if (basin.get(i).getNorth() != null && !basin.get(i).getNorth().isChecked())
                        {
                            basin.add(basin.get(i).getNorth());
                            basin.get(i).getNorth().setChecked(true);
                        }
                        if (basin.get(i).getEast() != null && !basin.get(i).getEast().isChecked())
                        {
                            basin.add(basin.get(i).getEast());
                            basin.get(i).getEast().setChecked(true);
                        }
                        if (basin.get(i).getWest() != null && !basin.get(i).getWest().isChecked())
                        {
                            basin.add(basin.get(i).getWest());
                            basin.get(i).getWest().setChecked(true);
                        }
                        if (basin.get(i).getSouth() != null && !basin.get(i).getSouth().isChecked())
                        {
                            basin.add(basin.get(i).getSouth());
                            basin.get(i).getSouth().setChecked(true);
                        }

                        basin.get(i).setChecked(true);
                    }

                    System.out.println("Basin size: " + basin.size());
                    basinSizes.add(basin.size());
                }
            }
        }

        ArrayList<Integer> top = new ArrayList<>();
        top.add(0);
        top.add(0);
        top.add(0);
        for (int basinSize : basinSizes)
        {
            if (basinSize > top.get(0))
            {
                top.add(0, basinSize);
            }
            else if (basinSize > top.get(1))
            {
                top.add(1, basinSize);
            }
            else if (basinSize > top.get(2))
            {
                top.add(2, basinSize);
            }
        }

        System.out.println("Top 3 largest basin sizes: " + top.get(0) + ", " + top.get(1) + ", " + top.get(2) + ".");
    }
}
