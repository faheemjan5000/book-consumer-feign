package faheem.microservices.feignclient.consumers;

import faheem.microservices.feignclient.beans.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@FeignClient(name="book-service",url="localhost:9000/book")
public interface BookConsumer {

    @GetMapping("/data")
     String getBookData();


    @GetMapping("/entity")
     ResponseEntity<String> getEntityData();

    @GetMapping("/{id}")
     Book getBookById(@PathVariable Integer id);

    @GetMapping("/all")
     List<Book> getAllBooks();

    @GetMapping("/name")
    Book getBookByName(@RequestParam("name") String name);

    @PostMapping("/add")
    public Book insertBook(@RequestBody Book book);


}
