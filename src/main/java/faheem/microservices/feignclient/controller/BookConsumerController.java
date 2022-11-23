package faheem.microservices.feignclient.controller;

import faheem.microservices.feignclient.beans.Book;
import faheem.microservices.feignclient.beans.BookJDBC;
import faheem.microservices.feignclient.consumers.BookConsumer;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/consumer")
public class BookConsumerController {

    @Autowired
    private BookConsumer bookConsumer;

    //This annotation is used to describe the exposed REST API
    @ApiOperation(value = "get-all-bookss" , notes = "getting all books",nickname = "all-books")
    @GetMapping("/allBooks")

    public List<Book> getAllBooks(){
        return bookConsumer.getAllBooks();
    }


    @GetMapping("/name")
    public Book getBookByBookName(@RequestParam("name") String name){
        log.info("inside getBookByBookName() method...");
        return bookConsumer.getBookByName(name);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Integer id){
        log.info("inside getBookById() method...");
        Book book = bookConsumer.getBookById(id);
        log.info("Book found and is : {}",book);
        return book;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable Integer id){
        bookConsumer.deleteBook(id);
    }

    @PostMapping("/add")
    public Book insertBook( @ApiParam(
            name =  "insertBookk",
            type = "Book",
            value = "book infoo",
            example = "Vatsal",
            required = true)  @RequestBody Book book){
        return bookConsumer.insertBook(book);
    }


    // ************************ in the following endpoints JDBC template is called ******************************

    @GetMapping("/consumerBookNamesJDBC")
    public List<String> consumerGetAllBookNamesJDBC(){
        log.info("consumerGetAllBookNamesJDBC() method is called....");
        return bookConsumer.getAllBookNamesJDBC();
    }

    @GetMapping("/consumerBooksJDBC")
    public List<BookJDBC> consumerGetAllBooksJDBC(){

        log.info("consumerGetAllBooksJDBC() method is called....");
        return bookConsumer.getAllBooksJDBC();
    }

    @PostMapping("/consumerInsertBookJDBC")
    public BookJDBC insertBook(@RequestBody BookJDBC book){
        log.info("BookConsumerController.insertBook() method is called...");
        log.info("book to be inserted is : {}",book);
        return bookConsumer.insertBook(book);
    }
}


