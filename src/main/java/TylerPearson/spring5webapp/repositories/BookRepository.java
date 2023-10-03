package TylerPearson.spring5webapp.repositories;

import TylerPearson.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
