package com.example.demodistrict.repository;

import com.example.demodistrict.entity.Street;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface StreetRepository extends JpaRepository<Street, Integer> {
    @Query("select s from Street s where  s.name like %:name% and s.districtId = :district")
    List<Street> filterStreet(@Param(value = "name") String name, @Param(value = "district") int district);

}
