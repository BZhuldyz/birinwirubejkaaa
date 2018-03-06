package kz.kaznitu.lessons.controllers;

import kz.kaznitu.lessons.models.Author;
import kz.kaznitu.lessons.models.Workers;
import kz.kaznitu.lessons.reposotories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

import static org.apache.coyote.http11.Constants.a;

@Controller
@RequestMapping(path = "/work")
public class WorkerController {
    @Autowired
    private WorkerRepository workerRepository;
    private long a;


    @RequestMapping("/add")
    public String showForm(Model model){
        model.addAttribute("worker",new Workers());
        return "work_add_form";
    }

    @RequestMapping("/addd")
    public String showFormm(Model model){
        model.addAttribute("workerr",new Workers());
        return "work_update";
    }
    @PostMapping("/add")
    public String addAuthor(@ModelAttribute Workers workers){
        workerRepository.save(workers) ;

        return "redirect:/work/all" ;
    }


    @GetMapping("/all2")
    public @ResponseBody
    Iterable<Workers> allAuthors(){
        return workerRepository.findAll() ;
    }

    @GetMapping("/all")
    public String allAuthors2(Model model){
        List<Workers> workerss = (List<Workers>) workerRepository.findAll() ;
        model.addAttribute("workerss", workerss) ;
        return "workers" ;
    }

    @PostMapping("/adds")
    public String addsAuthor(@ModelAttribute Workers workers){
        Workers workers1 = new Workers();
        workers1.setId(a);
        workers1.setFirst_name(workers.getFirst_name());
        workers1.setLast_name(workers.getLast_name());
        workers1.setJob(workers.getJob());
        workerRepository.save(workers1) ;

        return "redirect:/work/all" ;
    }

    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public ModelAndView updateAuthors(Model model, @RequestParam("id") long id){
        a=id;
        Optional<Workers> workers = (Optional <Workers> ) workerRepository.findById(id);
        model.addAttribute("workerss",workers);
        return new ModelAndView("work_update");
    }
    @RequestMapping(value = "/deleteContact",method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam("id") long idd){
        workerRepository.deleteById(idd);
        return new ModelAndView("redirect:/work/all2");
    }



}
