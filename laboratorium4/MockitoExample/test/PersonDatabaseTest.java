import static org.junit.Assert.*;

import java.sql.SQLException;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class PersonDatabaseTest {

	
	@Mock
	PersonDatabaseService service;
	private PersonMockServiceImpl serv;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		serv = new PersonMockServiceImpl();
		serv.setService(service);
	}

	@After
	public void tearDown() throws Exception {
		service=null;
		serv=null;		
	}

	@Test
	public void CorrectTest() throws SQLException, PersonException {
		Person person = new Person(1,"Adam","Nowak",2500);
		when(service.addPerson(person)).thenReturn(new Integer(1));
		boolean result = serv.addPerson(person);
		assertTrue(result);
		verify(service).addPerson(person);
	}
	
	@Test(expected=PersonException.class)
	public void ExceptionTest() throws SQLException, PersonException{
		Person person = new Person();
		when(service.addPerson(person)).thenThrow(new SQLException());
		boolean result = serv.addPerson(person);
		assertFalse(result);
		verify(service).addPerson(person);
	}

}
