import api.StudentApi;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import frame.MainFrame;
import model.Student;
import netscape.javascript.JSObject;

import javax.swing.*;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {

        MainFrame frame = new MainFrame();
        frame.setSize(1200, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);





//        Gson g = new Gson();
//        StudentApi studentApi = new StudentApi();

//        Добавление одного студента
//        Student result = studentApi.addStudent("Станислав", "Бондарев", "Олегович", "bodya1234", "12345", "1", "5");
//        System.out.println(result);

//        Получение всех студентов
//        List<Student> result1 = studentApi.getAllStudents();
//        Student item = result1.get(0);


//        Удаление одного студента
//        Student result = studentApi.delStudent(7L);
//        System.out.println(result.getName());
//        System.out.println(result.getLogin());
/*
        Student result = studentApi.updateStudent(2L, "Назар", "Шатило", "Владимирович", "dzidagor", "12345678", "1", "5");
        System.out.println(result.getName());
        System.out.println(result.getSurname());
        System.out.println(result.getPatronymic());
        System.out.println(result.getLogin());
        System.out.println(result.getMark());*/




    }
}