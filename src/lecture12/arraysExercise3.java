package lecture12;

public class arraysExercise3
{
    public static void main(String[] args)
    {
        try
        {
            String name = null;
            System.out.println(name.toLowerCase());
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

}
