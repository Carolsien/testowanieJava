

public class Person {
  private String firstName;
  private String lastName;
  private int price;
  private int id;
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public Person(int id, String firstName, String lastName, int price){
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.price = price;
}

public Person(){
	
}

}
