package server.hibernate.tableClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "student.my_user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="my_user_generator")
	@SequenceGenerator(name="my_user_generator", sequenceName="student.s1_user")
	private Integer user_id;
	@Column(name="uname", columnDefinition = "VARCHAR2(30)")
	private String uname;
	@Column(name="pword", columnDefinition = "VARCHAR2(65)")
	private String pword;
	@Column(name="first_name", columnDefinition = "VARCHAR2(30)")
	private String first_name;
	@Column(name="last_name", columnDefinition = "VARCHAR2(30)")
	private String last_name;
	
	@Column(name="created_by", columnDefinition = "INT")
	private String createdBy;
	@Column(name="creation_date", columnDefinition = "DATE")
	private String creationDate;
	@Column(name="last_updated_by", columnDefinition = "INT")
	private String lastUpdatedBy;
	@Column(name="last_update_date", columnDefinition = "DATE")
	private String lastUpdateDate;
	
	public User(){
		
	}
	
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public User(String username, String password){
		this.uname = username;
		this.pword = password;
	}
	
	public Integer getId() {
		return user_id;
	}

	public void setId(Integer id) {
		this.user_id = id;
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
        return "User [id=" + user_id + ", pword=" + pword + ", uname=" + uname + "]";
    }
}
