package demo.socio.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import demo.socio.entity.ImageEntity;
import demo.socio.repository.ComplaintInformationRepository;
import demo.socio.repository.ImageRepository;
import demo.socio.result.ResultDO;

@RestController
@RequestMapping("/image")
public class ImageController {

	@Autowired
	ImageRepository repo;

	@Autowired
	ComplaintInformationRepository complaintRepo;

	@PostMapping("/insert/{image_type}/{complaint_id}")
	public ResultDO insertImages(@RequestBody MultipartFile myFile, 
			@PathVariable String image_type, 
			@PathVariable long complaint_id) {

		ImageEntity image = new ImageEntity();
		image.setComplaint_id(complaint_id);
		image.setImage_type(image_type);
		try {
			image.setImage(myFile.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		repo.save(image);

		return new ResultDO("OK");
	}

	@GetMapping("/read")
	public List<ImageEntity> getImages()
	{
		List<ImageEntity> list = repo.findAll();
		return list;
	}

	@GetMapping("/readbyid/{image_id}")
	public ImageEntity getByID(@PathVariable long image_id)
	{
		Optional<ImageEntity> opt = repo.findById(image_id);
		return opt.get();
	}

	@DeleteMapping("delete")
	public ResultDO deleteImage(@PathVariable long image_id)
	{
		repo.deleteById(image_id);
		return new ResultDO("OK");
	}

	@PutMapping("/update")
	public ResultDO updateImage(@RequestBody MultipartFile myFile,
			@PathVariable long image_id,
			@PathVariable String image_type, 
			@PathVariable long complaint_id) {

		Optional<ImageEntity> opt = repo.findById(image_id);

		ImageEntity image = opt.get();

		image.setComplaint_id(complaint_id);
		image.setImage_type(image_type);
		try {
			image.setImage(myFile.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		repo.save(image);

		return new ResultDO("OK");
	}

}
