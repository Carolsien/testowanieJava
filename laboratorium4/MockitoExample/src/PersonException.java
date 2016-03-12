

import java.sql.SQLException;

public class PersonException extends Exception {

	private static final long serialVersionUID = 1L;

public PersonException(SQLException e){
	  super(e);
  }
}
