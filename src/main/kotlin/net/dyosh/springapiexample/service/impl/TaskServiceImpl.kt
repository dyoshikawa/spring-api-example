package net.dyosh.springapiexample.service.impl

import net.dyosh.springapiexample.entity.Task
import net.dyosh.springapiexample.service.TaskService
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import net.dyosh.springapiexample.repository.TaskRepository

@Service
class TaskServiceImpl(
    private val repository: TaskRepository): TaskService {

    @Transactional(readOnly = true)
    override fun findById(id: Long): Task? {
        return repository.findById(id).orElse(null)
    }

    @Transactional(readOnly = true)
    override fun findAll(page: Pageable): List<Task> {
        return repository.findAll(page).content
    }

    @Transactional(timeout = 10)
    override fun store(task: Task) {
        repository.save(task)
    }

    @Transactional(timeout = 10)
    override fun removeById(id: Long) {
        repository.deleteById(id)
    }

}