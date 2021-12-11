import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class day10
{
    public static void main(String[] args) throws IOException
    {
        part2();
    }

    private static ArrayList<String> part1() throws IOException
    {
        ArrayList<String> input = new ArrayList<>(ReadFile.ToStringList("src/inputDay10.txt"));

        ArrayList<String> output = new ArrayList<>();

        int score = 0;

        for (String value : input)
        {
            ArrayList<Character> chars = new ArrayList<>();

            loop:
            for (int i = 0; i < value.length(); i++)
            {
                switch (value.charAt(i))
                {
                    case '(':
                    {
                        chars.add('(');
                        break;
                    }
                    case '[':
                    {
                        chars.add('[');
                        break;
                    }
                    case '{':
                    {
                        chars.add('{');
                        break;
                    }
                    case '<':
                    {
                        chars.add('<');
                        break;
                    }
                    case ')':
                    {
                        if (chars.get(chars.size() - 1) == '(')
                        {
                            chars.remove(chars.size() - 1);
                        }
                        else
                        {
                            output.add(value);
                            score += 3;
                            break loop;
                        }
                        break;
                    }
                    case ']':
                    {
                        if (chars.get(chars.size() - 1) == '[')
                        {
                            chars.remove(chars.size() - 1);
                        }
                        else
                        {
                            output.add(value);
                            score += 57;
                            break loop;
                        }
                        break;
                    }
                    case '}':
                    {
                        if (chars.get(chars.size() - 1) == '{')
                        {
                            chars.remove(chars.size() - 1);
                        }
                        else
                        {
                            output.add(value);
                            score += 1197;
                            break loop;
                        }
                        break;
                    }
                    case '>':
                    {
                        if (chars.get(chars.size() - 1) == '<')
                        {
                            chars.remove(chars.size() - 1);
                        }
                        else
                        {
                            output.add(value);
                            score += 25137;
                            break loop;
                        }
                        break;
                    }
                }
            }
        }

        System.out.println("Score: " + score);
        return output;
    }

    private static void part2() throws IOException
    {
        ArrayList<String> input = new ArrayList<>(ReadFile.ToStringList("src/inputDay10.txt"));


        for (int a = 0; a < input.size(); a++) //Remove corrupted values
        {
            ArrayList<Character> chars = new ArrayList<>();

            boolean corrupted = false;

            loop:
            for (int i = 0; i < input.get(a).length(); i++)
            {
                switch (input.get(a).charAt(i))
                {
                    case '(':
                    {
                        chars.add('(');
                        break;
                    }
                    case '[':
                    {
                        chars.add('[');
                        break;
                    }
                    case '{':
                    {
                        chars.add('{');
                        break;
                    }
                    case '<':
                    {
                        chars.add('<');
                        break;
                    }
                    case ')':
                    {
                        if (chars.get(chars.size() - 1) == '(')
                        {
                            chars.remove(chars.size() - 1);
                        }
                        else
                        {
                            corrupted = true;
                            break loop;
                        }
                        break;
                    }
                    case ']':
                    {
                        if (chars.get(chars.size() - 1) == '[')
                        {
                            chars.remove(chars.size() - 1);
                        }
                        else
                        {
                            corrupted = true;
                            break loop;
                        }
                        break;
                    }
                    case '}':
                    {
                        if (chars.get(chars.size() - 1) == '{')
                        {
                            chars.remove(chars.size() - 1);
                        }
                        else
                        {
                            corrupted = true;
                            break loop;
                        }
                        break;
                    }
                    case '>':
                    {
                        if (chars.get(chars.size() - 1) == '<')
                        {
                            chars.remove(chars.size() - 1);
                        }
                        else
                        {
                            corrupted = true;
                            break loop;
                        }
                        break;
                    }
                }
            }

            if (corrupted)
            {
                input.remove(input.get(a));
                a--;
            }
        }


        ArrayList<Long> scores = new ArrayList<>();

        for (String value : input) //Determine scores
        {
            ArrayList<Character> chars = new ArrayList<>();

            for (int i = 0; i < value.length(); i++)
            {
                switch (value.charAt(i))
                {
                    case '(':
                    {
                        chars.add('(');
                        break;
                    }
                    case '[':
                    {
                        chars.add('[');
                        break;
                    }
                    case '{':
                    {
                        chars.add('{');
                        break;
                    }
                    case '<':
                    {
                        chars.add('<');
                        break;
                    }
                    case ')':
                    case ']':
                    case '}':
                    case '>':
                    {
                        chars.remove(chars.size() - 1);
                        break;
                    }
                }
            }

            long score = 0;

            Collections.reverse(chars);

            for(char character : chars)
            {
                score *= 5;
                switch (character)
                {
                    case '(' -> score += 1;
                    case '[' -> score += 2;
                    case '{' -> score += 3;
                    case '<' -> score += 4;
                }
            }

            scores.add(score);
        }

        Collections.sort(scores);

        System.out.println("Middle score: " + scores.get(scores.size() / 2));
    }
}
