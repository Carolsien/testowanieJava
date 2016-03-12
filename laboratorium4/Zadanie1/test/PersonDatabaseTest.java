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
	public void addPersonCorrectTest() throws SQLException, PersonException {
		Person person = new Person(1,"Adam","Nowak",2500);
		when(service.addPerson(person)).thenReturn(new Integer(1));
		boolean result = serv.addPerson(person);
		assertTrue(result);
		verify(service).addPerson(person);
	}
	
	@Test
	public void addPersonZeroTest() throws SQLException, PersonException {
		Person person = new Person(1,"Adam","Nowak",2500);
		when(service.addPerson(person)).thenReturn(new Integer(0));
		boolean result = serv.addPerson(person);
		assertFalse(result);
		verify(service).addPerson(person);
	}
	
	@Test(expected=PersonException.class)
	public void addPersonExceptionTest() throws SQLException, PersonException{
		Person person = new Person();
		when(service.addPerson(person)).thenThrow(new SQLException());
		boolean result = serv.addPerson(person);
		assertFalse(result);
		verify(service).addPerson(person);
	}
	
	@Test
	public void removePersonCorrectTest() throws SQLException, PersonException {
		int id = 1;
		when(service.remove(id)).thenReturn(new Integer(1));
		boolean result = serv.remove(id);
		assertTrue(result);
		verify(service).remove(id);
	}
	
	@Test
	public void removePersonZeroTest() throws SQLException, PersonException {
		int id = 1;
		when(service.remove(id)).thenReturn(new Integer(0));
		boolean result = serv.remove(id);
		assertFalse(result);
		verify(service).remove(id);
	}
	
	@Test(expected=PersonException.class)
	public void removePersonExceptionTest() throws SQLException, PersonException{
		int id = 1;
		when(service.remove(id)).thenThrow(new SQLException());
		boolean result = serv.remove(id);
		assertFalse(result);
		verify(service).remove(id);
	}
	
	@Test
	public void readPersonCorrectTest() throws SQLException, PersonException {
		int id = 1;
		when(service.read(id)).thenReturn(new Person(1, "asd", "aaa", 10));
		boolean result = serv.read(id);
		assertTrue(result);
		verify(service).read(id);
	}
	
	@Test(expected=PersonException.class)
	public void readPersonExceptionTest() throws SQLException, PersonException{
		int id = 1;
		when(service.read(id)).thenThrow(new SQLException());
		boolean result = serv.read(id);
		assertFalse(result);
		verify(service).read(id);
	}
	
	@Test
	public void readPersonNullTest() throws SQLException, PersonException {
		int id = 1;
		when(service.read(id)).thenReturn(null);
		boolean result = serv.read(id);
		assertFalse(result);
		verify(service).read(id);
	}
	
	@Test
	public void updatePersonCorrectTest() throws SQLException, PersonException {
		int id = 1;
		when(service.update(id)).thenReturn(new Integer(1));
		boolean result = serv.update(id);
		assertTrue(result);
		verify(service).update(id);
	}
	
	@Test
	public void updatePersonZeroTest() throws SQLException, PersonException {
		int id = 1;
		when(service.update(id)).thenReturn(new Integer(0));
		boolean result = serv.update(id);
		assertFalse(result);
		verify(service).update(id);
	}
	
	@Test(expected=PersonException.class)
	public void updatePersonExceptionTest() throws SQLException, PersonException{
		int id = 1;
		when(service.update(id)).thenThrow(new SQLException());
		boolean result = serv.update(id);
		assertFalse(result);
		verify(service).update(id);
	}

}
