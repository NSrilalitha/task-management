package com.sample.web.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sample.web.app.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

	public Task findByName(String name);

	@Modifying
	@Query(value = "update Task u set u.description = :description where u.name = :name")
	@Transactional
	public void updateTaskByName(@Param("name") String name, @Param("description") String description);
	
}
