package net.dyosh.springapiexample.repository

import net.dyosh.springapiexample.entity.Task
import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepository : JpaRepository<Task, Long>
