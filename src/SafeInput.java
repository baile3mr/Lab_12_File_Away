import java.util.Scanner;

public class SafeInput
{
    /**
     *
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";

        do
        {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        }
        while (retString.length() == 0);

        return retString;
    }

    public static int getInt(Scanner pipe, String prompt) {
        int value = 0;
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + ": ");

            if (pipe.hasNextInt())
            {
                value = pipe.nextInt();
                pipe.nextLine();      // clear the newline
                done = true;
            }
            else
            {
                String trash = pipe.nextLine();   // read the bad input
                System.out.println("You entered: " + trash + ". Please enter a valid integer.");
            }

        }
        while (!done);

        return value;
    }

    public static double getDouble(Scanner pipe, String prompt)
    {
        double value = 0;
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + ": ");

            if(pipe.hasNextDouble())
            {
                value = pipe.nextDouble();
                pipe.nextLine(); // newline fix
                done = true;
            }
            else
            {
                String trash = pipe.nextLine();
                System.out.println("You entered: " + trash + ". Please enter a valid double.");
            }

        } while(!done);

        return value;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int value = 0;
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");

            if(pipe.hasNextInt())
            {
                value = pipe.nextInt();
                pipe.nextLine(); // newline fix

                if(value >= low && value <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("You must enter a value between " + low + " and " + high + ".");
                }
            }
            else
            {
                String trash = pipe.nextLine();
                System.out.println("You entered: " + trash + ". Please enter a valid integer.");
            }

        } while(!done);

        return value;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double value = 0;
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");

            if(pipe.hasNextDouble())
            {
                value = pipe.nextDouble();
                pipe.nextLine(); // newline fix

                if(value >= low && value <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("You must enter a value between " + low + " and " + high + ".");
                }
            }
            else
            {
                String trash = pipe.nextLine();
                System.out.println("You entered: " + trash + ". Please enter a valid double.");
            }

        }
        while(!done);

        return value;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String response;

        do
        {
            System.out.print("\n" + prompt + " [Y/N]: ");
            response = pipe.nextLine();

            if(response.equalsIgnoreCase("Y"))
            {
                return true;
            }
            else if(response.equalsIgnoreCase("N"))
            {
                return false;
            }
            else
            {
                System.out.println("Please enter Y or N.");
            }

        } while(true);
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String value = "";

        do
        {
            System.out.print("\n" + prompt + ": ");
            value = pipe.nextLine();

            if(value.matches(regEx))
            {
                return value;
            }
            else
            {
                System.out.println("Invalid input. Please try again.");
            }

        } while(true);
    }

    public static void prettyHeader(String msg)
    {
        int width = 60;
        int spaces = width - 6 - msg.length();
        int leftSpaces = spaces / 2;
        int rightSpaces = spaces - leftSpaces;

        // Top line
        for(int i = 0; i < width; i++)
        {
            System.out.print("*");
        }
        System.out.println();

        // Middle line
        System.out.print("***");

        for(int i = 0; i < leftSpaces; i++)
        {
            System.out.print(" ");
        }

        System.out.print(msg);

        for(int i = 0; i < rightSpaces; i++)
        {
            System.out.print(" ");
        }

        System.out.println("***");

        // Bottom line
        for(int i = 0; i < width; i++)
        {
            System.out.print("*");
        }
        System.out.println();
    }
}