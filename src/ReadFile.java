import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile
{
    public static ArrayList<Integer> ToIntegerList(String path) throws IOException
    {
        ArrayList<Integer> values = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(path));
        boolean empty = false;

        do
        {
            String temp = reader.readLine();
            if (temp == null)
            {
                empty = true;
            }
            else
            {
                values.add(Integer.valueOf(temp));
            }
        }while (!empty);

        return values;
    }
}
