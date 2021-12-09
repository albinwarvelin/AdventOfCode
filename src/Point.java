public class Point
{


    private boolean checked = false;
    private int x_Coordinate = 0;
    private int y_Coordinate = 0;

    private Point north = null;
    private Point south = null;
    private Point east = null;
    private Point west = null;

    private int value = -1;

    public Point (int x_Coordinate, int y_Coordinate, int value)
    {
        this.x_Coordinate = x_Coordinate;
        this.y_Coordinate = y_Coordinate;
        this.value = value;
    }

    public boolean isChecked()
    {
        return checked;
    }

    public void setChecked(boolean checked)
    {
        this.checked = checked;
    }

    public Point getNorth()
    {
        return north;
    }

    public void setNorth(Point north)
    {
        this.north = north;
    }

    public Point getSouth()
    {
        return south;
    }

    public void setSouth(Point south)
    {
        this.south = south;
    }

    public Point getEast()
    {
        return east;
    }

    public void setEast(Point east)
    {
        this.east = east;
    }

    public Point getWest()
    {
        return west;
    }

    public void setWest(Point west)
    {
        this.west = west;
    }

    public int getValue()
    {
        return value;
    }
}
