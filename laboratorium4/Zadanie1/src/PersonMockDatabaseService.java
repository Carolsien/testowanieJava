public interface PersonMockDatabaseService {
  boolean addPerson(Person person) throws PersonException;
  boolean remove(int id) throws PersonException;
  boolean read(int id) throws PersonException;
  boolean update(int id) throws PersonException;
}

