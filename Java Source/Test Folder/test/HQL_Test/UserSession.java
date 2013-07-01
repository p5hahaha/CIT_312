package test.HQL_Test;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "student.user_session")
public class UserSession {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="my_user_session_generator")
	@SequenceGenerator(name="my_user_session_generator", sequenceName="student.s1_user_session")
	private int session_id;

	@GeneratedValue(generator="my_user_session_number_generator")
	@GenericGenerator(name="my_user_session_number_generator", strategy = "uuid")
	@Column (name = "session_number", columnDefinition = "VARCHAR2(32)", unique = true)
	private String sessionNumber;
	@Column (name = "user_id", columnDefinition = "INT")
	private int userId;
	@Column (name = "android_id", columnDefinition = "VARCHAR2(16)")
	private String androidId;

	@Column (name = "created_by", columnDefinition = "INT")
	private int createdBy;
	@Column (name = "creation_date", columnDefinition = "DATE")
	private Date creationDate ;

	@Column (name = "last_updated_by", columnDefinition = "INT")	
	private int lastUpdatedBy;
	@Column (name = "last_update_date", columnDefinition = "DATE")
	private Date lastUpdateDate ;
	@Column (name = "ended_by", columnDefinition = "INT")
	private int endedBy;
	@Column (name = "end_date", columnDefinition = "DATE")
	private Date endDate ;

	public UserSession(){
		Date tempDate = new Date(System.currentTimeMillis());
		this.creationDate = tempDate;
		this.lastUpdateDate = tempDate;
	}
	public void updateUserSession(int userId){
		this.lastUpdateDate = new Date(System.currentTimeMillis());
		this.lastUpdatedBy = userId;
	}

	public int getSession_id() {
		return session_id;
	}
	private void setSession_id(int session_id) {
		this.session_id = session_id;
	}
	public String getSessionNumber() {
		return sessionNumber;
	}
	public void setSessionNumber(String sessionNumber) {
		this.sessionNumber = sessionNumber;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAndroidId() {
		return androidId;
	}
	public void setAndroidId(String androidId) {
		this.androidId = androidId;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public int getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(int lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	public int getEndedBy() {
		return endedBy;
	}
	public void setEndedBy(int endedBy) {
		this.endedBy = endedBy;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
