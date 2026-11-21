package dev.learn.something;

import org.springframework.cglib.core.SpringNamingPolicy;

public class TodoService {
    TodoRepository todoRepository;

    public TodoService(){
        todoRepository = new TodoRepository();
    }
    public void printTodo(){
        System.out.print(todoRepository.getAllTodos());
    }
}
