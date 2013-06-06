package test.HQL_Test;

@Entity
@Table(name = "USER_TABLE")
public class User {
	
	@Id
	@GeneratedValue
	private int user_id;
	private String username;
	private String password;
	
	User(int user_id, String username, String password){
		this.user_id = user_id;
		this.username = username;
		this.password = password;
	}
	
	public int getId(){
		return user_id;
	}
	public String getUsername(){
		return username;
	}
	public String getPassword(){
		return password;
	}
	public void setId(int user_id){
		this.user_id = user_id;
	}
	public void setUsername(String username){
		this.username = username;
	}
	public void setPassword(String password){
		this.password = password;
	}
}
