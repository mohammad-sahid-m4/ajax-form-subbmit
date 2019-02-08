package com.metafour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.metafour.model.Student;
import com.metafour.repo.StudentRepository;
import com.metafour.service.StudentService;

@Controller
public class MainController {

	@Autowired
	StudentService ss;
	@Autowired
	StudentRepository sr;

	@GetMapping(value = { "/", "/index" })
	public String index(Model model) {
		model.addAttribute("Messege");
		return "index";
	}

	@GetMapping(value = "/form")
	public String studentform(Model model) {
		model.addAttribute("student", new Student());
		return "form";
	}

	@GetMapping(value = "/all")
	public String allData(Model model) {
		model.addAttribute("student", ss.getAllStudentData());
		return "all";
	}

	@GetMapping(value = "/delete")
	public String delete_method(@RequestParam(name = "id") Long id, Model model, RedirectAttributes redirect) {
		Long i = ss.deleteOne(id);
		if (i > 0) {
			redirect.addFlashAttribute("delete", "ID " + i + " Deleted Successfully");
		} else {
			redirect.addFlashAttribute("not_delete", "Data is not deleted");
		}
		return "redirect:/all";
	}

	@GetMapping(value = "/edit")
	public String EditStudentForm(@ModelAttribute Student student, @RequestParam(name = "id") Long id, Model model) {
		model.addAttribute("student", ss.findOne(id));
		return "edit_form";
	}

	@PostMapping(value = "/edit_form")
	public String student_update(@ModelAttribute Student student, @RequestParam(name = "id") Long id, Model model) {
		Student get_update_id = ss.update(student);
		if (student.getFirstname() == null || student.getFirstname().length() <= 0
				|| student.getLastname().length() <= 0) {
			model.addAttribute("error1", "Please fill up all the fields correctly");
			return "edit_form";
		} else {
			if (get_update_id.getId() > 0) {
				model.addAttribute("update", "ID " + get_update_id.getId() + " is Updated Successfully");
			} else {
				model.addAttribute("error2", "Data not Updated");
			}
		}
		model.addAttribute("student", new Student());
		return "edit_form";
	}
	//
//	@RequestMapping(value = "/form", method = RequestMethod.POST)
//	public String studentsubmit(@ModelAttribute Student student, Model model) {
//		model.addAttribute("student", student);
//		model.addAttribute("student", new Student());
//		if (student.getEmail() == null || student.getEmail().length() <= 0 ||student.getPassword().length() <= 0) {
//			model.addAttribute("error1", "Please fill up all the fields correctly");
//		} else {
//			Student getresponseid = sr.save(student);
//			if (getresponseid.getId() > 0) {
//				model.addAttribute("success", "Data is Inserted Successfully");
//			} else {
//				model.addAttribute("error2", "Data not inserted");
//			}
//		}
//		return "form";
//	}

}
