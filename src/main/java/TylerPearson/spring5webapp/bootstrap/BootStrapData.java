package TylerPearson.spring5webapp.bootstrap;

import TylerPearson.spring5webapp.domain.Book;
import TylerPearson.spring5webapp.domain.Author;
import TylerPearson.spring5webapp.domain.Publisher;
import TylerPearson.spring5webapp.repositories.AuthorRepository;
import TylerPearson.spring5webapp.repositories.BookRepository;
import TylerPearson.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "53459345");

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());

        Publisher randomHouse = new Publisher("Random House", "7220 Tartan Curve", "Eden Prairie",
                                                "MN", "55346");

        ddd.setPublisher(randomHouse);
        randomHouse.getBooks().add(ddd);
        noEJB.setPublisher(randomHouse);
        randomHouse.getBooks().add(noEJB);

        publisherRepository.save(randomHouse);

        System.out.println("Publishers: " + publisherRepository.count());
        System.out.println("RandomHouse number of Books: " + randomHouse.getBooks().size());


    }
}
