package evaluation.sample_project;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
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
    
    @Test
    public void givenUserExists_whenUserInfoIsRetrieved_then200IsReceived()
      throws ClientProtocolException, IOException {
      
       // Given
       String name = "jotecasve";
       HttpUriRequest request = new HttpGet( "https://api.github.com/users/" + name );
     
       // When
       HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
     
       // Then
       assertEquals(
    		     httpResponse.getStatusLine().getStatusCode(),
    		     200);
    }
}
