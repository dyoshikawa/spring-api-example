package net.dyosh.springapiexample.entity

import javax.persistence.*
import java.io.Serializable


@Entity
@Table(name = "tasks")
data class Task (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    @Column(name = "name", nullable = false)
    var name: String = ""
) : Serializable