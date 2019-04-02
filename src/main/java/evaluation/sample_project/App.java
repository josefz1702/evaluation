package evaluation.sample_project;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        String result = concatenate("Hello","World! ");
        System.out.println(result+ sumar(5,8) + " times.");
    }
    
    public static String concatenate(String one, String two){
        return one + two;
    }
    
    public static int sumar(int num1, int num2) {
    		return num1+num2;
    }
}
