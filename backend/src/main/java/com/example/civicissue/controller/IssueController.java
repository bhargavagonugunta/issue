package com.example.civicissue.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.civicissue.model.CivicIssue;
import com.example.civicissue.model.User;
import com.example.civicissue.payload.IssueRequest;
import com.example.civicissue.payload.MessageResponse;
import com.example.civicissue.repository.IssueRepository;

@RestController
@RequestMapping("/api/issue")
public class IssueController {

	@Autowired
	 IssueRepository issueRepository;
	@PostMapping("/add")
	  public ResponseEntity<?> addIssue(@Valid @RequestBody IssueRequest  issueRequest) {

	    CivicIssue civicIssue= new CivicIssue (issueRequest.getIssueTitle(),issueRequest.getIssueDescription(),issueRequest.getLocation(),issueRequest.getUser(),issueRequest.getStatus());
	    
	    issueRepository.save(civicIssue);
	    return ResponseEntity.ok(new MessageResponse("Issue submitted successfully!"));
	    
	  }
	
	@PutMapping("/update")
	  public ResponseEntity<?> updateIssue(@Valid @RequestBody IssueRequest  issueRequest) {
	

	    CivicIssue civicIssue= new CivicIssue (issueRequest.getId(),issueRequest.getIssueTitle(),issueRequest.getIssueDescription(),issueRequest.getLocation(),issueRequest.getUser(),issueRequest.getStatus());
	    issueRepository.save(civicIssue);
	    return ResponseEntity.ok(new MessageResponse("Issue updated successfully!"));
	    
	  }
	
	@GetMapping("/get")
	  public ResponseEntity<?> getIssues( ) {

	    List<CivicIssue> issues = issueRepository.findAll();
	     return ResponseEntity.ok().body(issues);
	    
	  }
	@GetMapping("/get/user")
	  public ResponseEntity<?> getIssues(User user ) {

	    Optional<CivicIssue> issues = issueRepository.findByUser(user);
	     return ResponseEntity.ok().body(issues);
	    
	  }

}
