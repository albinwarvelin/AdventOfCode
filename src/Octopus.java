public class Octopus
{
    private int energyLevel = 0;
    private boolean flashed = false;

    //Surrounding octopuses
    Octopus[] neighbors = new Octopus[8];

    public Octopus(int energyLevel)
    {
        this.energyLevel = energyLevel;
    }

    public void flash()
    {
        day11.timesFlashedPart1++;
        flashed = true;
        for(Octopus octopus : neighbors)
        {
            if (octopus != null)
            {
                if (!octopus.hasFlashed())
                {
                    octopus.setEnergyLevel(octopus.getEnergyLevel() + 1);

                    if (octopus.getEnergyLevel() > 9)
                    {
                        octopus.flash();
                    }
                }
            }
        }
    }

    public void setNeighbors(Octopus[] octopuses)
    {
        this.neighbors[0] = octopuses[0];
        this.neighbors[1] = octopuses[1];
        this.neighbors[2] = octopuses[2];
        this.neighbors[3] = octopuses[3];
        this.neighbors[4] = octopuses[4];
        this.neighbors[5] = octopuses[5];
        this.neighbors[6] = octopuses[6];
        this.neighbors[7] = octopuses[7];
    }

    public int getEnergyLevel()
    {
        return energyLevel;
    }

    public void setEnergyLevel(int energyLevel)
    {
        this.energyLevel = energyLevel;
    }

    public boolean hasFlashed()
    {
        return flashed;
    }

    public void setFlashed(boolean flashed)
    {
        this.flashed = flashed;
    }
}
