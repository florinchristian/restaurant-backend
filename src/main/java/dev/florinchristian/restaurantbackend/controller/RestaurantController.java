package dev.florinchristian.restaurantbackend.controller;

import dev.florinchristian.restaurantbackend.model.TableModel;
import dev.florinchristian.restaurantbackend.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class RestaurantController {

    @Autowired
    TableRepository tableRepository;

    @GetMapping("/")
    public String index() {
        return "RESTaurant API is running";
    }

    @GetMapping("/tables")
    public List<TableModel> getTables() {
        return tableRepository.findAll();
    }
}
