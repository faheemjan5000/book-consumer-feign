package faheem.microservices.feignclient.controller;

import faheem.microservices.feignclient.beans.Book;
import faheem.microservices.feignclient.consumers.BookConsumer;
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

    @PostMapping("/add")
    public Book insertBook(@RequestBody Book book){
        return bookConsumer.insertBook(book);
    }

}
