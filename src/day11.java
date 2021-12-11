import java.io.IOException;
import java.util.ArrayList;

public class day11
{
    public static void main(String[] args) throws IOException
    {
        part2();
    }

    static int timesFlashedPart1 = 0;

    private static void part1() throws IOException
    {
        ArrayList<String> input = new ArrayList<>(ReadFile.ToStringList("src/inputDay11.txt"));

        Octopus[][] octopuses = new Octopus[12][12]; //Y, X
        for (int y = 0; y < 12; y++) //Assign values
        {
            for (int x = 0; x < 12; x++)
            {
                if (input.get(y).charAt(x) != 'x')
                {
                    octopuses[y][x] = new Octopus(Integer.valueOf(input.get(y).substring(x, x + 1)));
                }
                else
                {
                    octopuses[y][x] = null;
                }
            }
        }

        for (int y = 1; y < 11; y++) //Assign neighbors
        {
            for (int x = 1; x < 11; x++)
            {
                Octopus[] neighbors = new Octopus[8];

                if (octopuses[y - 1][x - 1] != null)
                {
                    neighbors[0] = octopuses[y - 1][x - 1];
                }
                if (octopuses[y - 1][x] != null)
                {
                    neighbors[1] = octopuses[y - 1][x];
                }
                if (octopuses[y - 1][x + 1] != null)
                {
                    neighbors[2] = octopuses[y - 1][x + 1];
                }
                if (octopuses[y][x - 1] != null)
                {
                    neighbors[3] = octopuses[y][x - 1];
                }
                if (octopuses[y][x + 1] != null)
                {
                    neighbors[4] = octopuses[y][x + 1];
                }
                if (octopuses[y + 1][x - 1] != null)
                {
                    neighbors[5] = octopuses[y + 1][x - 1];
                }
                if (octopuses[y + 1][x] != null)
                {
                    neighbors[6] = octopuses[y + 1][x];
                }
                if (octopuses[y + 1][x + 1] != null)
                {
                    neighbors[7] = octopuses[y + 1][x + 1];
                }

                octopuses[y][x].setNeighbors(neighbors);
            }
        }

        for(int i = 0; i < 100; i++)
        {
            for (int y = 1; y < 11; y++) //Flash
            {
                for (int x = 1; x < 11; x++)
                {
                    if (!octopuses[y][x].hasFlashed())
                    {
                        octopuses[y][x].setEnergyLevel(octopuses[y][x].getEnergyLevel() + 1);

                        if (octopuses[y][x].getEnergyLevel() > 9)
                        {
                            octopuses[y][x].flash();
                        }
                    }
                }
            }

            for (int y = 1; y < 11; y++) //Reset
            {
                for (int x = 1; x < 11; x++)
                {
                    if (octopuses[y][x].hasFlashed())
                    {
                        octopuses[y][x].setEnergyLevel(0);
                        System.out.print("\u001B[32m" + octopuses[y][x].getEnergyLevel() + "\u001B[0m");
                    }
                    else
                    {
                        System.out.print(octopuses[y][x].getEnergyLevel());
                    }
                    octopuses[y][x].setFlashed(false);
                }
                System.out.println();
            }
            System.out.println();

        }

        System.out.println("Times flashed: " + timesFlashedPart1);
    }

    private static void part2() throws IOException
    {
        ArrayList<String> input = new ArrayList<>(ReadFile.ToStringList("src/inputDay11.txt"));

        Octopus[][] octopuses = new Octopus[12][12]; //Y, X
        for (int y = 0; y < 12; y++) //Assign values
        {
            for (int x = 0; x < 12; x++)
            {
                if (input.get(y).charAt(x) != 'x')
                {
                    octopuses[y][x] = new Octopus(Integer.valueOf(input.get(y).substring(x, x + 1)));
                }
                else
                {
                    octopuses[y][x] = null;
                }
            }
        }

        for (int y = 1; y < 11; y++) //Assign neighbors
        {
            for (int x = 1; x < 11; x++)
            {
                Octopus[] neighbors = new Octopus[8];

                if (octopuses[y - 1][x - 1] != null)
                {
                    neighbors[0] = octopuses[y - 1][x - 1];
                }
                if (octopuses[y - 1][x] != null)
                {
                    neighbors[1] = octopuses[y - 1][x];
                }
                if (octopuses[y - 1][x + 1] != null)
                {
                    neighbors[2] = octopuses[y - 1][x + 1];
                }
                if (octopuses[y][x - 1] != null)
                {
                    neighbors[3] = octopuses[y][x - 1];
                }
                if (octopuses[y][x + 1] != null)
                {
                    neighbors[4] = octopuses[y][x + 1];
                }
                if (octopuses[y + 1][x - 1] != null)
                {
                    neighbors[5] = octopuses[y + 1][x - 1];
                }
                if (octopuses[y + 1][x] != null)
                {
                    neighbors[6] = octopuses[y + 1][x];
                }
                if (octopuses[y + 1][x + 1] != null)
                {
                    neighbors[7] = octopuses[y + 1][x + 1];
                }

                octopuses[y][x].setNeighbors(neighbors);
            }
        }

        boolean simultaneousFlash = false;
        int i = 0;

        while(!simultaneousFlash)
        {
            for (int y = 1; y < 11; y++) //Flash
            {
                for (int x = 1; x < 11; x++)
                {
                    if (!octopuses[y][x].hasFlashed())
                    {
                        octopuses[y][x].setEnergyLevel(octopuses[y][x].getEnergyLevel() + 1);

                        if (octopuses[y][x].getEnergyLevel() > 9)
                        {
                            octopuses[y][x].flash();
                        }
                    }
                }
            }

            int flashes = 0;

            for (int y = 1; y < 11; y++) //Reset
            {
                for (int x = 1; x < 11; x++)
                {
                    if (octopuses[y][x].hasFlashed())
                    {
                        octopuses[y][x].setEnergyLevel(0);
                        System.out.print("\u001B[32m" + octopuses[y][x].getEnergyLevel() + "\u001B[0m");
                        flashes++;
                    }
                    else
                    {
                        System.out.print(octopuses[y][x].getEnergyLevel());
                    }
                    octopuses[y][x].setFlashed(false);
                }
                System.out.println();
            }
            System.out.println();

            i++;

            if(flashes == 100)
            {
                simultaneousFlash = true;
            }
        }

        System.out.println("Simultaneous flash after: " + i + " steps.");
    }
}
