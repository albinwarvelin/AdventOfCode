import java.io.IOException;
import java.util.ArrayList;

public class day5
{
    private static int[][] coordinates = new int[1000][1000]; // X, Y

    public static void main(String[] args) throws IOException
    {
        part2();
    }

    private static void part1() throws IOException
    {
        ArrayList<String> input = new ArrayList<>(ReadFile.ToStringList("src/inputDay5.txt"));

        for (String value : input)
        {
            String[] temp = value.split(" -> ");

            String[] point1String = temp[0].split(",");
            String[] point2String = temp[1].split(",");

            int[] point1 = new int[2]; //X1, Y1
            int[] point2 = new int[2]; //X2, Y2

            point1[0] = Integer.valueOf(point1String[0]); //X1
            point1[1] = Integer.valueOf(point1String[1]); //Y1

            point2[0] = Integer.valueOf(point2String[0]); //X2
            point2[1] = Integer.valueOf(point2String[1]); //Y2

            if(point1[0] == point2[0]) //X1 == X2, Vertical line
            {
                if (point1[1] < point2[1])
                {
                    for (int i = point1[1]; i <= point2[1]; i++)
                    {
                        coordinates[point1[0]][i]++;
                    }
                }
                else
                {
                    for (int i = point2[1]; i <= point1[1]; i++)
                    {
                        coordinates[point1[0]][i]++;
                    }
                }
            }
            else if (point1[1] == point2[1]) //Y1 == Y2, Horizontal line
            {
                if (point1[0] < point2[0])
                {
                    for (int i = point1[0]; i <= point2[0]; i++)
                    {
                        coordinates[i][point1[1]]++;
                    }
                }
                else
                {
                    for (int i = point2[0]; i <= point1[0]; i++)
                    {
                        coordinates[i][point1[1]]++;
                    }
                }
            }
        }

        int totalOverlap = 0;
        int total2 = 0;
        int total3 = 0;
        int total4 = 0;
        int total5 = 0;

        for (int i = 0; i < 1000; i++)
        {
            for (int a = 0; a < 1000; a++)
            {
                if (coordinates[i][a] > 1)
                {
                    totalOverlap++;

                    switch (coordinates[i][a])
                    {
                        case 2:
                        {
                            total2++;
                            break;
                        }
                        case 3:
                        {
                            total3++;
                            break;
                        }
                        case 4:
                        {
                            total4++;
                            break;
                        }
                        case 5:
                        {
                            total5++;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println("Total overlapping points: " + totalOverlap);
        System.out.println("Total 2s: " + total2);
        System.out.println("Total 3s: " + total3);
        System.out.println("Total 4s: " + total4);
        System.out.println("Total 5s: " + total5);
    }

    private static void part2() throws IOException
    {
        ArrayList<String> input = new ArrayList<>(ReadFile.ToStringList("src/inputDay5.txt"));

        for (String value : input)
        {
            String[] temp = value.split(" -> ");

            String[] point1String = temp[0].split(",");
            String[] point2String = temp[1].split(",");

            int[] point1 = new int[2]; //X1, Y1
            int[] point2 = new int[2]; //X2, Y2

            point1[0] = Integer.valueOf(point1String[0]); //X1
            point1[1] = Integer.valueOf(point1String[1]); //Y1

            point2[0] = Integer.valueOf(point2String[0]); //X2
            point2[1] = Integer.valueOf(point2String[1]); //Y2

            if(point1[0] == point2[0]) //X1 == X2, Vertical line
            {
                if (point1[1] < point2[1])
                {
                    for (int i = point1[1]; i <= point2[1]; i++)
                    {
                        coordinates[point1[0]][i]++;
                    }
                }
                else
                {
                    for (int i = point2[1]; i <= point1[1]; i++)
                    {
                        coordinates[point1[0]][i]++;
                    }
                }
            }
            else if (point1[1] == point2[1]) //Y1 == Y2, Horizontal line
            {
                if (point1[0] < point2[0])
                {
                    for (int i = point1[0]; i <= point2[0]; i++)
                    {
                        coordinates[i][point1[1]]++;
                    }
                }
                else
                {
                    for (int i = point2[0]; i <= point1[0]; i++)
                    {
                        coordinates[i][point1[1]]++;
                    }
                }
            }
            else //Diagonal line
            {
                if (point1[0] > point2[0]) //Set highest X value to point2 for easier code later
                {
                    int tempX = point1[0];
                    point1[0] = point2[0];
                    point2[0] = tempX;

                    int tempY = point1[1];
                    point1[1] = point2[1];
                    point2[1] = tempY;
                }

                if (point2[1] > point1[1]) //Sloping down
                {
                    for (int i = point1[0]; i <= point2[0]; i++)
                    {
                        coordinates[i][point1[1] + (i - point1[0])]++;
                    }
                }
                else //Sloping up
                {
                    for (int i = point1[0]; i <= point2[0]; i++)
                    {
                        coordinates[i][point1[1] - (i - point1[0])]++;
                    }
                }
            }
        }

        int totalOverlap = 0;
        int total2 = 0;
        int total3 = 0;
        int total4 = 0;
        int total5 = 0;

        for (int i = 0; i < 1000; i++)
        {
            for (int a = 0; a < 1000; a++)
            {
                if (coordinates[i][a] > 1)
                {
                    totalOverlap++;

                    switch (coordinates[i][a])
                    {
                        case 2:
                        {
                            total2++;
                            break;
                        }
                        case 3:
                        {
                            total3++;
                            break;
                        }
                        case 4:
                        {
                            total4++;
                            break;
                        }
                        case 5:
                        {
                            total5++;
                            break;
                        }
                    }
                }
            }
        }

        /** For test and visualizing purposes **/
        for (int i = 0; i < 1000; i++)
        {
            for (int a = 0; a < 1000; a++)
            {
                System.out.print(coordinates[i][a] + "");
            }

            System.out.println("");
        }

        /****/

        System.out.println("Total overlapping points: " + totalOverlap);
        System.out.println("Total 2s: " + total2);
        System.out.println("Total 3s: " + total3);
        System.out.println("Total 4s: " + total4);
        System.out.println("Total 5s: " + total5);
    }
}
