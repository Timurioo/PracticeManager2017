package com.netcracker.pmbackend.impl.test;

import com.netcracker.pmbackend.impl.entities.StudentsEntity;
import com.netcracker.pmbackend.interfaces.StudentsService;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

/**
 * Created by dima on 10/23/2017.
 */
public class SpringDataTest {

    public void testMethod(){
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring-backend-config.xml"); //move from src.main.java to src.main.resources
        ctx.refresh();

        StudentsService service = ctx.getBean("jpaStudentsService", StudentsService.class);
        List<StudentsEntity> students = service.findAll();
        printAll(students);

        students = service.findByName("Dima");
        printAll(students);

        students = service.findByGroup("551002");
        printAll(students);
    }

    private static void printAll(List<StudentsEntity> students) {
        System.out.println("printAll: ");
        for (StudentsEntity student : students) {
            System.out.println(student.getName()+" "+student.getSurname()+" "+student.getGroup()+ "" + student.getUsersByUserId().getLogin());
        }
    }
}
