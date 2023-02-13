package com.example.civicissue.payload;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.civicissue.model.User;

public class IssueRequest {

	 @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  @NotBlank
	  @Size(max = 20)
	  private String issueTitle;
	  
	  @NotBlank
	  @Size(max = 500)
	  private String issueDescription;
	  
	  @NotBlank
	  @Size(max = 50)
	  private String location;
	  
	  
	  private String status = "Submitted";
	  
	 
	  private User user;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getIssueTitle() {
		return issueTitle;
	}


	public void setIssueTitle(String issueTitle) {
		this.issueTitle = issueTitle;
	}


	public String getIssueDescription() {
		return issueDescription;
	}


	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	  
	  
	
}
