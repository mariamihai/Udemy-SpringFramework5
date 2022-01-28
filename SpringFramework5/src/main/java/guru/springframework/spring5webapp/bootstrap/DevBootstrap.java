package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;


    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        // Publisher 1
        Publisher publisher1 = new Publisher("NamePublisher1", "AddressPublisher1");
        publisherRepository.save(publisher1);

        // Publisher2
        Publisher publisher2 = new Publisher("NamePublisher2", "AddressPublisher2");
        publisherRepository.save(publisher2);


        // Author 1
        Author author1 = new Author("FirstName1", "LastName1");
        Book book1 = new Book("NameBook1", "12345", publisher1);
        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);

        authorRepository.save(author1);
        bookRepository.save(book1);

        // Author 2
        Author author2 = new Author("FirstName2", "LastName2");
        Book book2 = new Book("NameBook2", "23456", publisher2);
        author2.getBooks().add(book2);

        authorRepository.save(author2);
        bookRepository.save(book2);
    }
}
