package dev.florinchristian.restaurantbackend.repository;

import dev.florinchristian.restaurantbackend.model.Table;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface TableRepository extends JpaRepository<Table, Integer> {
    @Query(value = "select count(*) as FreeTables from tables where start_time is null", nativeQuery = true)
    Integer getFreeTablesCount();

    @Query(value = "select count(*) from tables where ((?1 >= start_time and ?1 <= end_time) or (?2 >= start_time and ?2 <= end_time))", nativeQuery = true)
    Integer getConflictTables(String startTime, String endTime);

    @Transactional
    @Modifying
    @Query(value = "update tables set start_time = ?1, end_time = ?2 where start_time is null limit 1", nativeQuery = true)
    void bookFirstTableAvailable(String startTime, String endTime);
}
