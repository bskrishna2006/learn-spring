package dev.learn.something;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/todo")
public class TodoController {
    @GetMapping("/gettask")
    public String getTask(){
        return "Task";
    }
    //Path variable
    // @PathVariable extracts the 'id' value from the URL path and passes it as a method parameter.
    @GetMapping("/{id}")
    public String getTaskByID(@PathVariable long id){
        return "Task "+id;
    }

//    @GetMapping
//    public String getTaskParams(@RequestParam long id){
//        return "Task id with " + id + " returned";
//    } here the id(parameter) is same as in the url, to change the parameter name use it as in the below
    @GetMapping
    public String getTaskParams(@RequestParam(name="todoId") long id){
        return "Task id with " + id + " returned";
    }
    @PostMapping("/create")
    String createTask(@RequestBody String task){
        return task;
    }

    @PutMapping("/update/{id}")
    String updateTask(@PathVariable long id, @RequestBody String task){
        return " task with id " + id + " updated";
    }
    @DeleteMapping("/delete/{id}")
    String deleteTask(@PathVariable long id){
        return "task with id " + id + " deleted";
    }


    //Getmapping to illustrate Autowiring from todoservice class
    @Autowired
    private TodoService todoService;
    @GetMapping("/get")
    public String getTasks(){
        todoService.printTodo();
        return "Tasks returned from autowired method";
    }
}