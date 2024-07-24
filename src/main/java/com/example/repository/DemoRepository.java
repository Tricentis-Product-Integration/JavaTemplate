package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.DemoItem;

@Repository
public interface DemoRepository extends CrudRepository<DemoItem, Integer> {
}
