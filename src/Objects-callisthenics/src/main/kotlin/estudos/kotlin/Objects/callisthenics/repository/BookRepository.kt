package estudos.kotlin.Objects.callisthenics.repository
import org.springframework.data.jpa.repository.JpaRepository;
import estudos.kotlin.Objects.callisthenics.domain.Book

import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<Book, Long> {
}
