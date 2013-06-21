package test.HQL_Test;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "student.my_user")
public class MyUser {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="my_user_generator")
	@SequenceGenerator(name="my_user_generator", sequenceName="s1_user")
	private Integer id;
	private String uname;
	private String pword;
	private String first_name;
	private String last_name;
	
	public MyUser(){
		
	}
	
	public MyUser(String username, String password){
		this.uname = username;
		this.pword = password;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPword() {
		return pword;
	}

	public void setPword(String pword) {
		this.pword = pword;
	}

	public String toString() {
        return "User [id=" + id + ", pword=" + pword + ", uname=" + uname + ", phoneNumbers]";
    }
}
