package demo.socio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import demo.socio.entity.ComplaintInformationEntity;

import demo.socio.repository.ComplaintInformationRepository;
import demo.socio.repository.UserProfileRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/complaintinfo")
public class ComplaintInformationController {

	@Autowired
	ComplaintInformationRepository complaintRepo;

	@Autowired
	UserProfileRepository userRepo;

	
	@PostMapping("/insert")
	public ComplaintInformationEntity insertAdmin(@RequestBody ComplaintInformationEntity cInfo)
	{
		return complaintRepo.save(cInfo);
	}

	// get all complaint
	@GetMapping("/complaint")
	public List<ComplaintInformationEntity> getAllComplaint(){
		return complaintRepo.findAll();
	}		

	// get complaint by id rest api
	@GetMapping("/complaint/{id}")
	public ComplaintInformationEntity getComplaintById(@PathVariable Long id) {
		Optional<ComplaintInformationEntity> complaint = complaintRepo.findById(id);
		return complaint.get();
	}


	// update complaint rest api

	@PutMapping("/complaint/{id}")
	public ComplaintInformationEntity  updateComplaint(@PathVariable Long id, @RequestBody ComplaintInformationEntity complaintDetails){
		Optional<ComplaintInformationEntity> complaint = complaintRepo.findById(id);

		ComplaintInformationEntity comp = complaint.get();

		comp.setComplaint_category(complaintDetails.getComplaint_category());
		comp.setComplaint_department(complaintDetails.getComplaint_department());
		comp.setComplaint_description(complaintDetails.getComplaint_description());
		comp.setComplaint_landmark(complaintDetails.getComplaint_landmark());
		comp.setComplaint_latitude(complaintDetails.getComplaint_latitude());
		comp.setComplaint_longitute(complaintDetails.getComplaint_longitute());
		comp.setComplaint_official_assignee_id(complaintDetails.getComplaint_official_assignee_id());
		comp.setComplaint_priority(complaintDetails.getComplaint_priority());
		comp.setComplaint_received_date(complaintDetails.getComplaint_received_date());
		comp.setComplaint_resolved_date(complaintDetails.getComplaint_resolved_date());
		comp.setComplaint_status(complaintDetails.getComplaint_status());
		comp.setComplaint_subcategory(complaintDetails.getComplaint_subcategory());
		comp.setComplaint_worker_assignee_id(complaintDetails.getComplaint_worker_assignee_id());
		comp.setUser_id(complaintDetails.getUser_id());

		ComplaintInformationEntity updatedComplaint = complaintRepo.save(comp);
		return updatedComplaint;
	}
}
