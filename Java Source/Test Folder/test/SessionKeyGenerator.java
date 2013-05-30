package test;

import java.util.UUID;

public class SessionKeyGenerator {
	UUID session ;
	
	SessionKeyGenerator()
	{
		session = new UUID(3,9);
		System.out.println(session.toString());
	}
}
