package com.abc.demo.controller;

import com.abc.demo.model.PageModel;
import com.abc.demo.model.TodoModel;
import com.abc.demo.service.TodoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
public class TodoController {

    @Autowired
    private MessageSource messageSource;

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
            model.addAttribute("error", getErrorEmptyMessage());
            return "add";
        }
        todoService.add(desc);
        return "redirect:/todolist";
    }

    @PostMapping(value= "/todolist/delete")
    public String delete(@RequestParam long id) {
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
            TodoModel todoModel = todoService.getById(id);
            model.addAttribute("id", todoModel.getId());
            model.addAttribute("desc", todoModel.getDesc());
            model.addAttribute("error", getErrorEmptyMessage());
            return "update";
        }
        todoService.update(id, desc);
        return "redirect:/todolist";
    }

    private String getErrorEmptyMessage() {
        return messageSource.getMessage("error.empty",
                new String[]{messageSource.getMessage("todolist.desc", null, LocaleContextHolder.getLocale())},
                LocaleContextHolder.getLocale());
    }

    @GetMapping("/todolist/about")
    public String about() {
        return "about";
    }
}
