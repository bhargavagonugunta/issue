package com.example.civicissue.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Issues")

public class CivicIssue {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	
	  private String issueTitle;
	  
	 
	  private String issueDescription;
	  
	  
	  private String location;
	  
	  
	  private String status = "Submitted";
	  
	  @ManyToOne(fetch = FetchType.LAZY)
	  @JoinTable(name = "user_issues", 
	             joinColumns = @JoinColumn(name = "issue_id"),
	             inverseJoinColumns = @JoinColumn(name = "user_id"))
	  private User user;

	  public CivicIssue() {
		  
	  }
	  public CivicIssue(String issueTitle2, String issueDescription2, String location2, User user2, String status2) {
		this.issueTitle = issueTitle2;
		this.issueDescription = issueDescription2;
		this.status = status2;
		this.location = location;
		this.user = user2;
	}


	public CivicIssue(Long id2, String issueTitle2, String issueDescription2, String location2, User user2,
			String status2) {
		this.issueTitle = issueTitle2;
		this.issueDescription = issueDescription2;
		this.status = status2;
		this.location = location;
		this.user = user2;
		this.id = id2;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	
}
