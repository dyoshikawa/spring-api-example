package net.dyosh.springapiexample.service

import net.dyosh.springapiexample.entity.Task
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import net.dyosh.springapiexample.repository.TaskRepository

@Service
class TaskService(private val repository: TaskRepository) {

    @Transactional(readOnly = true)
    fun findById(id: Long): Task? {
        return repository.findById(id).orElse(null)
    }

    @Transactional(readOnly = true)
    fun findAll(page: Pageable): List<Task> {
        return repository.findAll(page).content
    }

    @Transactional(timeout = 10)
    fun store(task: Task) {
        repository.save(task)
    }

    @Transactional(timeout = 10)
    fun removeById(id: Long) {
        repository.deleteById(id)
    }

}