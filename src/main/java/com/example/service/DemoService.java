package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.DemoItem;
import com.example.repository.DemoRepository;


@Service
public class DemoService implements IDemoService{

    private Logger logger = Logger.getLogger(DemoService.class.getName());

    @Autowired
    private DemoRepository demoRepository;

    @Override
    public List<DemoItem> GetDemoItems() {
        return (List<DemoItem>) demoRepository.findAll();
    }

    @Override
    public Optional<DemoItem> GetDemoItemById(int id) {
        if (demoRepository.findById(id).orElse(null) == null) {
            logger.log(Level.WARNING, "Item with this ID does not exist");
            return null;
        }
        return demoRepository.findById(id);
    }

    @Override
    public void AddDemoItem(DemoItem item) {
        demoRepository.save(item);
    }

    @Override
    public void DeleteDemoItemById(int id) {
        DemoItem item = demoRepository.findById(id).orElse(null);

        if (item == null) {
            logger.log(Level.WARNING, "Item with this ID does not exist");
            return;
        }
        demoRepository.deleteById(id);
    }

    @Override
    public void UpdateDemoItem(DemoItem item) {
        DemoItem tempItem = demoRepository.findById(item.getId()).orElse(null);

        if (tempItem == null) {
            logger.log(Level.WARNING, "Item with this ID does not exist");
            return;
        }  
        demoRepository.save(item);
    }
}