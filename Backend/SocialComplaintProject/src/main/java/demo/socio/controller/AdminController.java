package demo.socio.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import antlr.StringUtils;
import demo.socio.entity.Admin;
import demo.socio.repository.AdminRepository;
import demo.socio.result.ResultDO;


//import demo.socio.entity.Admin;
//import demo.socio.repository.AdminRepository;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

	@Autowired
	AdminRepository repo;



	@PostMapping("/create/{admin_username}/{admin_password}")
	public ResultDO addAdmin(@RequestBody  MultipartFile myFile,  
			@PathVariable String admin_username, @PathVariable String admin_password) {

		Admin admin;
		try {
			admin = new Admin(admin_username, admin_password, myFile.getBytes() );
			repo.save(admin); 
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return new ResultDO("OK");
	}

	@GetMapping("/read")
	public List<Admin> get()
	{
		List<Admin> list = repo.findAll();
		return list;
	}

	@GetMapping("/readbyid/{id}")
	public Admin getById(@PathVariable int id)
	{
		Optional<Admin> opt = repo.findById(id);
		return opt.get();
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id)
	{
		repo.deleteById(id);
		return "OK";
	}


}
