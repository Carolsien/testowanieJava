package mavenTest.FindMin;

import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
	
	public Integer getMin(List<Integer> array){
		Integer min = Collections.min(array);
		return min;
	}
	
    public static void main( String[] args )
    {
        System.out.println( "min" );
    }
}
