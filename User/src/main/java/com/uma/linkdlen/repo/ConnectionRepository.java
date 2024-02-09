package com.uma.linkdlen.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uma.linkdlen.entity.Connections;

public interface ConnectionRepository extends JpaRepository<Connections, Long> {

	Optional<Connections> findById(Long id);

	void deleteById(Long id);


}
