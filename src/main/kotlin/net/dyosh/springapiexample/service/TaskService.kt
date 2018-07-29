package net.dyosh.springapiexample.service

import net.dyosh.springapiexample.entity.Task
import org.springframework.data.domain.Pageable

interface TaskService {
    fun findById(id: Long): Task?
    fun findAll(page: Pageable): List<Task>
    fun store(task: Task)
    fun removeById(id: Long)
}