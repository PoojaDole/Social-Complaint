package demo.socio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.socio.repository.ComplaintCategoryRepository;
import demo.socio.repository.GovernmentDepartmentRepository;

@RestController
@RequestMapping("/complaintcategory")
public class ComplaintCategoryController {

	@Autowired
	ComplaintCategoryRepository compCateRepo;
	
	@Autowired
	GovernmentDepartmentRepository govDeptRepo;
	
	@PostMapping("/insert")
	public ComplaintCategoryEntity insertCategory(@RequestBody ComplaintCategoryEntity newComplaint  ) {
		
		return compCateRepo.save(newComplaint);
	}
	
	@GetMapping("/complaincat")
	 public List<ComplaintCategoryEntity> allComplaintCategory() {
	    return compCateRepo.findAll();
	  }
	
	@DeleteMapping("complaints/{id}")
	public ResultDO deleteComplaint(@PathVariable  Long id)
	{
	  compCateRepo.deleteById(id);
	  return new ResultDO("OK");
	}
	
	
}
