package com.Him.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Him.Model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
