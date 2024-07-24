package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.DemoItem;

public interface IDemoService{
    public List<DemoItem> GetDemoItems();
    public Optional<DemoItem> GetDemoItemById(int id);
    public void AddDemoItem(DemoItem item);
    public void DeleteDemoItemById(int id);
    public void UpdateDemoItem(DemoItem item);
}