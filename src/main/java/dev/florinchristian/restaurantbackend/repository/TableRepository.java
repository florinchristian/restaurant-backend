package dev.florinchristian.restaurantbackend.repository;

import dev.florinchristian.restaurantbackend.model.TableModel;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TableRepository extends JpaRepository<TableModel, Integer> {

}
