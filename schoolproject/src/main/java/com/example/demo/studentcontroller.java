package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class studentcontroller {
	//now create the rest apis
	
	
	@Autowired
	studentrepository studentrepo;
	
	@GetMapping("/students")
	public List<student> getallstudents()
	{
		List<student> students=studentrepo.findAll();
		return students;
	}




//get the student based on id
//localhost:8080/students/1
@GetMapping("/students/{id}")
public student getstudent(@PathVariable int id)
{
	student student1=studentrepo.findById(id).get();
	
	return student1;
}



//create a student
@PostMapping("/students/add")
@ResponseStatus(code=HttpStatus.CREATED)//used for create a new record response will change in 200 ok to 201 created
public void createstudent(@RequestBody student student1)
{
	studentrepo.save(student1);
	
}



//update student
@PutMapping("/students/update/{id}")
public student updatestudent(@PathVariable int id)
{
	student student1 =studentrepo.findById(id).get();
	student1.setName("mahi");
	student1.setPercentage(99);
	studentrepo.save(student1);
	return student1;
}


//delete student
@DeleteMapping("/students/delete/{id}")
@ResponseStatus(code=HttpStatus.GONE)
public void removestudent(@PathVariable int id)
{
	student student1=studentrepo.findById(id).get();
	studentrepo.delete(student1);
}



























}