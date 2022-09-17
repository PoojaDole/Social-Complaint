package demo.socio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import javax.validation.constraints.NotBlank;

import demo.socio.enums.ImageType;


@Entity
@Table(name = "image_information_tbl")
public class ImageEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long image_id;
	
	@Lob
	private byte[] image;
	

//	@Enumerated(EnumType.STRING)
	private String image_type;
	
	@ManyToOne
	@Column(columnDefinition = "FOREIGN KEY (complaint_id) REFERENCES (id)")
	@JoinColumn(name = "complaint_id")
	private long complaint_id;

	public ImageEntity() {
		super();
	}

	public ImageEntity(byte[] image, String image_type, long complaint_id) {
		super();
		this.image = image;
		this.image_type = image_type;
		this.complaint_id = complaint_id;
	}

	public long getImage_id() {
		return image_id;
	}

	public void setImage_id(long image_id) {
		this.image_id = image_id;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getImage_type() {
		return image_type;
	}

	public void setImage_type(String image_type) {
		this.image_type = image_type;
	}

	public long getComplaint_id() {
		return complaint_id;
	}

	public void setComplaint_id(long complaint_id) {
		this.complaint_id = complaint_id;
	}

	
	
}
