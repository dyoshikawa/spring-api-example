package net.dyosh.springapiexample.controller

import net.dyosh.springapiexample.entity.Task
import net.dyosh.springapiexample.service.TaskService
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/tasks"])
class TasksController(
        private val service: TaskService) {

    /**
     * 一覧取得
     */
    @GetMapping
    fun index(page: Pageable): ResponseEntity<Map<String, List<Task>>> {
        return ResponseEntity.ok(mapOf("data" to service.findAll(page)))
    }

    /**
     * 詳細取得
     */
    @GetMapping(path = ["{id}"])
    fun show(@PathVariable id: Long): ResponseEntity<Task> {
        val task = service.findById(id)
        return if (task != null) {
            ResponseEntity.ok(task)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    /**
     * 登録
     */
    @PostMapping
    fun store(@RequestBody task: Task): ResponseEntity<Map<String, String>> {
        service.store(task)
        return ResponseEntity.ok(mapOf("message" to "success"))
    }

    /**
     * 更新
     */
    @PutMapping(path = ["{id}"])
    fun update(@PathVariable id: Long, @RequestBody task: Task): ResponseEntity<Map<String, String>> {
        task.id = id
        service.store(task)
        return ResponseEntity.ok(mapOf("message" to "success"))
    }

    /**
     * 削除
     */
    @DeleteMapping(path = ["{id}"])
    fun destroy(@PathVariable id: Long): ResponseEntity<Map<String, String>> {
        service.removeById(id)
        return ResponseEntity.ok(mapOf("message" to "success"))
    }

}