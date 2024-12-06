package vttp.ssf.day19practice.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp.ssf.day19practice.models.Task;
import vttp.ssf.day19practice.service.TodoService;

@Controller
@RequestMapping
public class TodoController {

    @Autowired
    TodoService todoSvc;
    
    @GetMapping("/tasks")
    public String getTaskList(Model model) throws ParseException{

        List<Task> taskList = todoSvc.getTaskList();
        
        model.addAttribute("tasklist", taskList);
        
        return "pagelisting";
    }

    
    
}
