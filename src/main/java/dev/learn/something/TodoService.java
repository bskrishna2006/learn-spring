package dev.learn.something;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;

    public void printTodo(){
        System.out.print(todoRepository.getAllTodos());
    }
}
