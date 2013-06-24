package test.HQL_Test;

import test.HQL_Test.*;

public class Hibernate_test {
	
	public static void main(String[] args){
		Hibernate hibernate = new Hibernate();
		hibernate.createUser("Craig","asdlkfj", "Craig", "sdfjlk");
		hibernate.showAllUsers();
	}
}
