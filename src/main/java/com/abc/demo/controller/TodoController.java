package com.abc.demo.controller;

import com.abc.demo.model.PageModel;
import com.abc.demo.model.TodoModel;
import com.abc.demo.service.TodoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping(value = {"/todolist/{page}", "/todolist"})
    public String todolist(
            @PathVariable(required = false) Integer page,
            Model model) {
        if (page == null || page < 1) {
            page = 1;
        }

        PageModel<TodoModel> pageModel = todoService.getPagedTodoList(page, 3);
        model.addAttribute("todolist", pageModel.getData());
        model.addAttribute("totalItems", pageModel.getTotalItems());
        model.addAttribute("totalPages", pageModel.getTotalPages());
        model.addAttribute("page", page);

        return "todolist";
    }

    @GetMapping(value = "/todolist/add")
    public String add() {
        return "add";
    }

    @PostMapping(value = "/todolist/add")
    public String add(@RequestParam String desc, Model model) {
        if (StringUtils.isEmpty(desc)) {
            model.addAttribute("error", "內容不可為空");
            return "add";
        }
        todoService.add(desc);
        return "redirect:/todolist";
    }

    @GetMapping(value= "/todolist/delete/{id}")
    public String delete(@PathVariable long id) {
        todoService.delete(id);
        return "redirect:/todolist";
    }

    @GetMapping(value= "/todolist/update/{id}")
    public String update(@PathVariable long id, Model model) {
        TodoModel todoModel = todoService.getById(id);
        model.addAttribute("id", todoModel.getId());
        model.addAttribute("desc", todoModel.getDesc());
        return "update";
    }

    @PostMapping(value = "/todolist/update")
    public String update(@RequestParam long id, @RequestParam String desc, Model model) {
        if (StringUtils.isEmpty(desc)) {
            return "redirect:/todolist/update/" + id;
        }
        todoService.update(id, desc);
        return "redirect:/todolist";
    }

    @GetMapping("todolist/about")
    public String about() {
        return "about";
    }
}
