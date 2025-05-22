package estudos.kotlin.Objects.callisthenics.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
class Book {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private var id : Long? = null;
    private val title : String;
    private val author : String;
    private val year : Int;

    constructor(title: String, author: String, year: Int) {

        this.title = title
        this.author = author
        this.year = year
    }
}
