package dev.florinchristian.restaurantbackend.controller;

import dev.florinchristian.restaurantbackend.model.Table;
import dev.florinchristian.restaurantbackend.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(value = "http://localhost:3000/")
public class RestaurantController {

    @Autowired
    TableRepository tableRepository;

    @GetMapping("/")
    public String index() {
        return "RESTaurant API is running";
    }

    @GetMapping("/tables")
    public List<Table> getTables() {
        return tableRepository.findAll();
    }

    @GetMapping("/freeTables")
    public Integer getFreeTablesCount() {
        return tableRepository.getFreeTablesCount();
    }

    @GetMapping("/tableAvailable")
    public boolean isTableAvailable(@RequestParam(name = "startTime") String startTime, @RequestParam(name = "endTime") String endTime) {
        return tableRepository.getConflictTables(startTime, endTime) == 0;
    }

    @PostMapping("/tables")
    public void createTable() {
        tableRepository.saveAndFlush(new Table());
    }

    @PutMapping("/tables")
    public void bookTable(@RequestBody Table table) {
        tableRepository.bookFirstTableAvailable(table.getStartTime(), table.getEndTime());
    }
}
