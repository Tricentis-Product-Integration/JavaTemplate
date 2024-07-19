package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.DemoItem;
import com.example.service.IDemoService;

@RestController
public class DemoController { 
    
    @Autowired
    private IDemoService demoService;

    @GetMapping("/demos")
    public List<DemoItem> GetDemos() {
        return demoService.GetDemoItems();
    }

    @GetMapping("/demos/{id}")
    public Optional<DemoItem> GetDemoById(@PathVariable int id) {
        return demoService.GetDemoItemById(id);
    }

    @PostMapping("/demos")
    public void AddDemo(@RequestBody DemoItem demoItem) {
        demoService.AddDemoItem(demoItem);
    }

    @PutMapping("demos")
    public void UpdateDemo(@RequestBody DemoItem demoItem) {
        demoService.UpdateDemoItem(demoItem);   
    }

    @DeleteMapping("/demos/{id}") 
    public void DeleteDemo(@PathVariable int id) {
        demoService.DeleteDemoItemById(id);
    }
}

