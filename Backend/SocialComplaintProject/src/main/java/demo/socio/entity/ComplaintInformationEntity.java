package demo.socio.entity;

import java.time.LocalDate; 
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import demo.socio.enums.ComplaintSeverity;
import demo.socio.enums.ComplaintStatus;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
@Table(name = "complaint_information_tbl") 
public class ComplaintInformationEntity {


	@Id
//	@NotNull
	@Column(unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long complaint_id;

//	@NotBlank
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserProfileEntity user_id;

//	@NotBlank
	private String complaint_category;

//	@NotBlank
	private String complaint_subcategory;

//	@NotBlank
	private String complaint_department;

//	@NotBlank
	private String complaint_description;

//	@NotBlank
	private double complaint_latitude;

//	@NotBlank
	private double complaint_longitute;

//	@NotBlank
	private String complaint_landmark;

//	@NotBlank
	@Enumerated(EnumType.STRING)
	private ComplaintSeverity complaint_priority;

//	@NotBlank
	@Enumerated(EnumType.STRING)
	private ComplaintStatus complaint_status;

//	@NotBlank
	@ManyToOne
	@JoinColumn(name = "complaint_official_assignee_id")
	private UserProfileEntity complaint_official_assignee_id;

//	@NotBlank
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate complaint_received_date;

//	@NotBlank
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate complaint_resolved_date;

//	@NotBlank
	private int complaint_worker_assignee_id;

	//	@NotBlank
	//	@OneToMany()
	//	@JoinColumn(name = "image_id")
	//	private Set<ImageEntity> complaint_images;
	//	
	//	@NotBlank
	//	private long resolved_image_id;

	public ComplaintInformationEntity() {
		super();
	}

	public ComplaintInformationEntity(long complaint_id, UserProfileEntity user_id, String complaint_category,
			String complaint_subcategory, String complaint_department, String complaint_description,
			double complaint_latitude, double complaint_longitute, String complaint_landmark,
			ComplaintSeverity complaint_priority, ComplaintStatus complaint_status,
			UserProfileEntity complaint_official_assignee_id, LocalDate complaint_received_date,
			LocalDate complaint_resolved_date, int complaint_worker_assignee_id) {
		super();
		this.complaint_id = complaint_id;
		this.user_id = user_id;
		this.complaint_category = complaint_category;
		this.complaint_subcategory = complaint_subcategory;
		this.complaint_department = complaint_department;
		this.complaint_description = complaint_description;
		this.complaint_latitude = complaint_latitude;
		this.complaint_longitute = complaint_longitute;
		this.complaint_landmark = complaint_landmark;
		this.complaint_priority = complaint_priority;
		this.complaint_status = complaint_status;
		this.complaint_official_assignee_id = complaint_official_assignee_id;
		this.complaint_received_date = complaint_received_date;
		this.complaint_resolved_date = complaint_resolved_date;
		this.complaint_worker_assignee_id = complaint_worker_assignee_id;
	}

	public long getComplaint_id() {
		return complaint_id;
	}

	public void setComplaint_id(long complaint_id) {
		this.complaint_id = complaint_id;
	}

	public UserProfileEntity getUser_id() {
		return user_id;
	}

	public void setUser_id(UserProfileEntity user_id) {
		this.user_id = user_id;
	}

	public String getComplaint_category() {
		return complaint_category;
	}

	public void setComplaint_category(String complaint_category) {
		this.complaint_category = complaint_category;
	}

	public String getComplaint_subcategory() {
		return complaint_subcategory;
	}

	public void setComplaint_subcategory(String complaint_subcategory) {
		this.complaint_subcategory = complaint_subcategory;
	}

	public String getComplaint_department() {
		return complaint_department;
	}

	public void setComplaint_department(String complaint_department) {
		this.complaint_department = complaint_department;
	}

	public String getComplaint_description() {
		return complaint_description;
	}

	public void setComplaint_description(String complaint_description) {
		this.complaint_description = complaint_description;
	}

	public double getComplaint_latitude() {
		return complaint_latitude;
	}

	public void setComplaint_latitude(double complaint_latitude) {
		this.complaint_latitude = complaint_latitude;
	}

	public double getComplaint_longitute() {
		return complaint_longitute;
	}

	public void setComplaint_longitute(double complaint_longitute) {
		this.complaint_longitute = complaint_longitute;
	}

	public String getComplaint_landmark() {
		return complaint_landmark;
	}

	public void setComplaint_landmark(String complaint_landmark) {
		this.complaint_landmark = complaint_landmark;
	}

	public ComplaintSeverity getComplaint_priority() {
		return complaint_priority;
	}

	public void setComplaint_priority(ComplaintSeverity complaint_priority) {
		this.complaint_priority = complaint_priority;
	}

	public ComplaintStatus getComplaint_status() {
		return complaint_status;
	}

	public void setComplaint_status(ComplaintStatus complaint_status) {
		this.complaint_status = complaint_status;
	}

	public UserProfileEntity getComplaint_official_assignee_id() {
		return complaint_official_assignee_id;
	}

	public void setComplaint_official_assignee_id(UserProfileEntity complaint_official_assignee_id) {
		this.complaint_official_assignee_id = complaint_official_assignee_id;
	}

	public LocalDate getComplaint_received_date() {
		return complaint_received_date;
	}

	public void setComplaint_received_date(LocalDate complaint_received_date) {
		this.complaint_received_date = complaint_received_date;
	}

	public LocalDate getComplaint_resolved_date() {
		return complaint_resolved_date;
	}

	public void setComplaint_resolved_date(LocalDate complaint_resolved_date) {
		this.complaint_resolved_date = complaint_resolved_date;
	}

	public int getComplaint_worker_assignee_id() {
		return complaint_worker_assignee_id;
	}

	public void setComplaint_worker_assignee_id(int complaint_worker_assignee_id) {
		this.complaint_worker_assignee_id = complaint_worker_assignee_id;
	}
	
	


}
