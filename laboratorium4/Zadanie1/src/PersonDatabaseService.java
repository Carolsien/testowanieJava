import java.sql.SQLException;

public interface PersonDatabaseService {
	int addPerson(Person person) throws SQLException;
	int remove(int id) throws SQLException;
	Person read(int id) throws SQLException;
	int update(int id) throws SQLException;
}
