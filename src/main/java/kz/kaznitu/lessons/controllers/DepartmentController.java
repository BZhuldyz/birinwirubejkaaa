package kz.kaznitu.lessons.controllers;

import kz.kaznitu.lessons.models.Author;
import kz.kaznitu.lessons.models.Departments;
import kz.kaznitu.lessons.reposotories.AuthorRepository;
import kz.kaznitu.lessons.reposotories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/dept")
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;
    private long a;


    @RequestMapping("/add")
    public String showForm(Model model){
        model.addAttribute("dept",new Departments());
        return "dept_add_form";
    }

    @RequestMapping("/addd")
    public String showFormm(Model model){
        model.addAttribute("deptt",new Departments());
        return "dept_update";
    }
    @PostMapping("/add")
    public String addAuthor(@ModelAttribute Departments departments){
        departmentRepository.save(departments);


        return "redirect:/dept/all" ;
    }

/////////
    @GetMapping("/all2")
    public @ResponseBody
    Iterable<Departments> allAuthors(){
        return departmentRepository.findAll() ;
    }

    @GetMapping("/all")
    public String allAuthors2(Model model){
        List<Departments> departmentss = (List<Departments>) departmentRepository.findAll() ;
        model.addAttribute("deptss", departmentss) ;
        return "depts" ;
    }

    @PostMapping("/adds")
    public String addsAuthor(@ModelAttribute Departments departments){
        Author author1 = new Author();
        Departments departments1 = new Departments();
        departments1.setId(a);
        departments1.setDepartment_name(departments.getDepartment_name());
        departments1.setNachalnik(departments.getNachalnik());
        departmentRepository.save(departments1) ;

        return "redirect:/dept/all" ;
    }

    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public ModelAndView updateAuthors(Model model, @RequestParam("id") long id){
        a=id;
        Optional<Departments> departments = (Optional<Departments> )  departmentRepository.findById(id);
        model.addAttribute("deptt",departments);
        return new ModelAndView("dept_update");
    }
    @RequestMapping(value = "/deleteContact",method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam("id") long idd){
        departmentRepository.deleteById(idd);
        return new ModelAndView("redirect:/dept/all2");
    }

}
