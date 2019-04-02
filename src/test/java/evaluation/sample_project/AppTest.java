package evaluation.sample_project;

import static org.junit.Assert.*;
import org.junit.Test;

public class AppTest {

    @Test
    public void testConcatenate() {
        App app = new App();
        String result = app.concatenate("one", "two");
        assertEquals("onetwo", result);
    }
    
    @Test
    public void testSumar() {
    		App app = new App();
    		int a=3,b=5;
    		int result = app.sumar(a, b);
    		assertEquals(8, result);
    }
}
