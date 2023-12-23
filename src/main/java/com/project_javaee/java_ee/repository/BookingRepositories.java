package com.project_javaee.java_ee.repository;

import com.project_javaee.java_ee.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepositories extends JpaRepository<Booking, Long> {
    List<Booking> findByStartTimeBetweenAndEndTimeBetween(String startTime, String endTime,
                                                          String startTime2, String endTime2);
}
