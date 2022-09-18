package demo.socio.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.socio.entity.GovernmentDepartmentEntity;
import demo.socio.repository.GovernmentDepartmentRepository;
import demo.socio.result.ResultDO;
@CrossOrigin("*")
@RestController
@RequestMapping("/govdept")
public class GovernmentDepartmentController {

	@Autowired
	private GovernmentDepartmentRepository repo;
	
	@PostMapping("/insert{governmment_department_name}")
	public String insertGovDept(@PathVariable GovernmentDepartmentEntity governmment_department_name ) {
		
		repo.save(governmment_department_name);
		return "Insert Done";
	}
	
	@GetMapping("/getid{governmment_department_id}")
	public List<Integer>findByIdDepartment(@PathVariable long  governmment_department_id)
	{
		List<GovernmentDepartmentEntity>list=repo.findAll();
		List<Integer> allids=new ArrayList<Integer>();
	for (GovernmentDepartmentEntity id : list) {
		
		allids.add(id.getGovernmment_department_id());
	}
		return allids;
	
	}
	
	@GetMapping("/getall")
	public List<GovernmentDepartmentEntity>findByIdDepartment()
	{
		return repo.findAll();
	
	}
	
	@DeleteMapping("/deletebyid//{governmment_department_id}")
	public ResultDO deleteDepartment(@PathVariable long id)
	{
		try
		{
			repo.deleteById(governmment_department_id);
			return new ResultDO("Delete Successfully");
		}
		catch(Exception e)
		{
			return new ResultDO("Governmment department id is invalid");

		}
	}

	@PutMapping("/changedeptname/{governmment_department_id}/{governmment_department_name}")
	public ResultDO updateName(@PathVariable long governmment_department_id,@PathVariable String  governmment_department_name )
	{
		Optional<GovernmentDepartmentEntity> gov=repo.findById(governmment_department_id);
		try {
			GovernmentDepartmentEntity dept=	gov.get();
			dept.setGovernmment_department_name( governmment_department_name);
			return new ResultDO("update");
		}
		catch(Exception e)
		{
			return new ResultDO("Governmment department id not found");
		}
	
		
	}
	
	
}
