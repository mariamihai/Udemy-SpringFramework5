package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import guru.springframework.spring5webapp.transactionAppRelatedCode.model.*;
import guru.springframework.spring5webapp.transactionAppRelatedCode.repositories.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Locale;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;
    private UserRepository userRepository;
    private CategoryRepository categoryRepository;
    private AccountRepository accountRepository;
    private RecurrenceRepository recurrenceRepository;
    private TransactionRepository transactionRepository;


    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository,
                        UserRepository userRepository, CategoryRepository categoryRepository, AccountRepository accountRepository,
                        RecurrenceRepository recurrenceRepository, TransactionRepository transactionRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.accountRepository = accountRepository;
        this.recurrenceRepository = recurrenceRepository;
        this.transactionRepository = transactionRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
        initTransactionAppData();
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

    private void initTransactionAppData() {
        // Users
        User user1 = new User("username1", "password1", "ro_RO");
        User user2 = new User("username2", "password2", "dk_DK");
        userRepository.save(user1);
        userRepository.save(user2);


        // Categories for both users
        Category category1 = new Category("User1_Salary", CategoryTypeEnum.Income, true);
        category1.setUser(user1);
        Category category2 = new Category("User1_Utilities", CategoryTypeEnum.Payment, true);
        category2.setUser(user1);
        Category category3 = new Category("User2_Salary", CategoryTypeEnum.Income, true);
        category3.setUser(user2);
        Category category4 = new Category("User2_Utilities", CategoryTypeEnum.Payment, true);
        category4.setUser(user2);

        user1.getCategories().add(category1);
        user1.getCategories().add(category2);
        user2.getCategories().add(category1);
        user2.getCategories().add(category2);

        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);
        categoryRepository.save(category4);


        // Accounts
        Account account1 = new Account("User1_Account1", 0.00, "123", false, user1);
        Account account2 = new Account("User1_Account2", 0.00, "124", false, user1);
        Account account3 = new Account("User1_Account3", 0.00, "125", false, user1);
        Account account4 = new Account("User2_Account1", 0.00, "126", false, user2);
        Account account5 = new Account("User2_Account2", 0.00, "127", false, user2);
        user1.getAccounts().add(account1);
        user1.getAccounts().add(account2);
        user1.getAccounts().add(account3);
        user2.getAccounts().add(account4);
        user2.getAccounts().add(account5);

        accountRepository.save(account1);
        accountRepository.save(account2);
        accountRepository.save(account3);
        accountRepository.save(account4);
        accountRepository.save(account5);


        // Recurrence
        Recurrence recurrence1 = new Recurrence(1, 1, 1, null);
        Recurrence recurrence2 = new Recurrence(1, 2, 1, null);
        Recurrence recurrence3 = new Recurrence(1, 2, 3, null);

        recurrenceRepository.save(recurrence1);
        recurrenceRepository.save(recurrence2);
        recurrenceRepository.save(recurrence3);


        // Transactions
        LocalDate todayLocalDate = LocalDate.now( ZoneId.of( "America/Montreal" ) );
        Date date = Date.valueOf(todayLocalDate);
        Transaction transaction1 = new Transaction("User1_Transaction1", 1.00, date, false);
        transaction1.setCategory(category1);
        transaction1.setAccount(account1);
        transaction1.setRecurrence(null);
        Transaction transaction2 = new Transaction("User1_Transaction2", 2.00, date, false);
        transaction2.setCategory(category2);
        transaction2.setAccount(account1);
        transaction2.setRecurrence(recurrence1);
        Transaction transaction3 = new Transaction("User2_Transaction1", 3.00, date, false);
        transaction3.setCategory(category3);
        transaction3.setAccount(account3);
        transaction3.setRecurrence(recurrence2);
        Transaction transaction4 = new Transaction("User2_Transaction2", 4.00, date, false);
        transaction4.setCategory(category4);
        transaction4.setAccount(account4);
        transaction4.setRecurrence(recurrence3);

        transactionRepository.save(transaction1);
        transactionRepository.save(transaction2);
        transactionRepository.save(transaction3);
        transactionRepository.save(transaction4);

//        System.out.println(user1.toString());
//        System.out.println(user2.toString());
    }
}
