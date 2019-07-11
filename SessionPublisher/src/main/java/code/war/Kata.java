package code.war;

public class Kata
{
    public static char findMissingLetter(char[] array)
    {
        for (int index = 0; index < array.length; index++) {
            if (array[index+1] - array[index] != 1) {
                return (char) (array[index] + 1);
            }
        }
        return ' ';
    }
}
