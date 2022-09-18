package demo.socio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
@Table(name = "complaint_category_information_tbl")
public class ComplaintCategoryEntity {

	@Id
//	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long comaplaint_category_id;
	
//	@NotBlank
	private String complaint_category_name;
	
//	@NotBlank
//	private String complaint_sub_category;
	
//	@NotBlank
	private int complaint_parent_category_id;
	
	@ManyToOne
	@JoinColumn(name = "governmment_department_id")
	private GovernmentDepartmentEntity governmment_department_id;
	
	public ComplaintCategoryEntity() {
		super();
	}

	public ComplaintCategoryEntity(
			/* @NotNull */long comaplaint_category_id,
			/* @NotBlank */String complaint_category_name,
			/* @NotBlank */ int complaint_parent_category_id, GovernmentDepartmentEntity department_id) {
		super();
		this.comaplaint_category_id = comaplaint_category_id;
		this.complaint_category_name = complaint_category_name;
		this.complaint_parent_category_id = complaint_parent_category_id;
		this.governmment_department_id = department_id;
	}

	public long getComaplaint_category_id() {
		return comaplaint_category_id;
	}

	public void setComaplaint_category_id(long comaplaint_category_id) {
		this.comaplaint_category_id = comaplaint_category_id;
	}

	public String getComplaint_category_name() {
		return complaint_category_name;
	}

	public void setComplaint_category_name(String complaint_category_name) {
		this.complaint_category_name = complaint_category_name;
	}

	public int getComplaint_parent_category_id() {
		return complaint_parent_category_id;
	}

	public void setComplaint_parent_category_id(int complaint_parent_category_id) {
		this.complaint_parent_category_id = complaint_parent_category_id;
	}

	public GovernmentDepartmentEntity getDepartment_id() {
		return governmment_department_id;
	}

	public void setDepartment_id(GovernmentDepartmentEntity department_id) {
		this.governmment_department_id = department_id;
	}
	
	
	
}
