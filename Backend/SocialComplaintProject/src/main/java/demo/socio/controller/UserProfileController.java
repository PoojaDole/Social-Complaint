package demo.socio.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import demo.socio.entity.UserProfileEntity;
import demo.socio.repository.UserProfileRepository;
import demo.socio.result.ResultDO;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserProfileController {

	@Autowired
	UserProfileRepository userRepo;
	
	@PostMapping("/insert")
	public ResultDO insertUser(@RequestBody MultipartFile myFile, 
			 @PathVariable long user_aadhar_number ,
				@PathVariable String user_first_name ,
				@PathVariable String user_middle_name ,
				@PathVariable String user_last_name ,
				@PathVariable String user_username ,
				@PathVariable String user_password ,
				@PathVariable long user_contact_number ,
				@PathVariable String user_email ,
				@PathVariable String user_role ,
				@PathVariable String user_address_city ,
				@PathVariable String user_address_state ,
				@PathVariable int user_pincode ) 
	{
		
		
		UserProfileEntity user = new UserProfileEntity();
		 user.setUser_aadhar_number( user_aadhar_number );
			user.setUser_first_name( user_first_name );
			user.setUser_middle_name( user_middle_name );
			user.setUser_last_name( user_last_name );
			try {
				user.setUser_profile_image( myFile.getBytes() );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			user.setUser_username( user_username );
			user.setUser_password( user_password );
			user.setUser_contact_number( user_contact_number );
			user.setUser_email( user_email );
			user.setUser_role( user_role );
			user.setUser_address_city( user_address_city );
			user.setUser_address_state( user_address_state );
			user.setUser_pincode( user_pincode );
			
		return new ResultDO("OK");
	}
	
	
	
}
