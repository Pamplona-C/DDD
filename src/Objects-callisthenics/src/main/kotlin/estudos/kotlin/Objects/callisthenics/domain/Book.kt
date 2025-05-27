package estudos.kotlin.Objects.callisthenics.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
data class Book(
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    val id: Long? = null,
    val title: String,
    val author: String,
    val year: Int
)
