package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.ropositories.AuthorRepository;
import guru.springframework.spring5webapp.ropositories.BookRepository;
import guru.springframework.spring5webapp.ropositories.PublisherRepository;
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
        Book ddd = new Book("Domain Driven Designe", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE", "24342434");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());

        Publisher john = new Publisher("John Wiley & Sons", "Gdzieś, Tam, 80-809");
        publisherRepository.save(john);
        System.out.println("Number of Publishers: " + publisherRepository.count());


    }
}
