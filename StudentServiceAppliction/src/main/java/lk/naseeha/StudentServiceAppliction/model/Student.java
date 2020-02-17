package lk.naseeha.StudentServiceAppliction.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String firstName;
	String lastName;
	
	@OneToOne(cascade = CascadeType.ALL)
	Address address;
	
	@OneToMany(mappedBy = "Student" , cascade = CascadeType.ALL)
	List<Telephone> telephone;
	

	Allocation[] allocations;
	
	public Allocation[] getAllocations() {
		return allocations;
	}

	public void setAllocations(Allocation[] allocations) {
		this.allocations = allocations;
	}

	public Student() {}
	/////conweb?sessionVariables=sql_mode='NO_ENGINE_SUBSTITUTION'&jdbcCompliantTruncation=false
	public Student(Integer id,String firstname,String lastname,Address address,List<Telephone> tp) {
		
		this.id = id;
		this.firstName = firstname;
		this.lastName = lastname;
		this.address = address;
		this.telephone = tp;
		this.allocations = allocations;
		
	}

    public List<Telephone> getTelephone() {
	return telephone;
    }

    public void setTelephone(List<Telephone> telephone) {
	this.telephone = telephone;
    }


	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	

}
