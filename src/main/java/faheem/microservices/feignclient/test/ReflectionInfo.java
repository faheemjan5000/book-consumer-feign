package faheem.microservices.feignclient.test;

import faheem.microservices.feignclient.controller.BookConsumerController;
import lombok.extern.slf4j.Slf4j;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class ReflectionInfo {



    public static void main(String[] args) throws NoSuchMethodException {
        BookConsumerController b = new BookConsumerController();
       Class cls = b.getClass();
    log.info("class name : {}",cls.getName());
   log.info("class consutructor : {}",cls.getConstructor().getName());

    for(Method method : cls.getMethods()){
        log.info("method name : {} ",method.getName());
    }

    }
}
