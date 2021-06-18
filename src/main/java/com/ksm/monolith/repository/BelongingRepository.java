/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ksm.monolith.repository;

import com.ksm.monolith.model.Belonging;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author loisceka
 */
@Repository
public interface BelongingRepository extends JpaRepository<Belonging, Integer> {
    
}
