import api.StudentApi;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import model.Student;
import netscape.javascript.JSObject;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {

        /*try {
            final URL url = new URL("http://localhost:8080/students/all");
            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setConnectTimeout(1000);
            connection.setReadTimeout(1000);


            try (final BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
                String inputLine;
                final StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                System.out.println(content);

            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/



        /*String urlAddress = "http://localhost:8080/students";
        URL url;
        HttpURLConnection connection;
        DataOutputStream outputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;




        try {
            final Map< String, String> parameters = new HashMap<>();
            parameters.put("name", "Имя4");
            parameters.put("surname", "Фамилия4");
            parameters.put("patronymic", "Отчество4");
            parameters.put("login", "loginclient2");
            parameters.put("password", "pass4");
            parameters.put("workplace", "2");
            parameters.put("mark", "0");

//            String jsonString = "{\"name\": \"Имя4\", \"surname\": \"Фамилия4\", \"patronymic\": \"Отчество4\", \"login\": \"login5\", \"password\": \"pass4\", \"workplace\": \"2\", \"mark\": \"0\"}";
//            String jsonString = "{'"'name'"': '"'Имя4'"', '"'surname'"': '"'Фамилия4'"', '"'patronymic'"': '"'Отчество4'"', '"'login'"': '"'login5'"', '"'password'"': '"'pass4'"', '"'workplace'"': '"'2'"', '"'mark'"': '"'0'"'}";


            url = new URL(urlAddress);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);

            connection.setRequestProperty("Content-type", "application/json");
            connection.setConnectTimeout(1000);
            connection.setReadTimeout(1000);
            connection.connect();


            try {
                Gson g = new Gson();
                outputStream = new DataOutputStream(connection.getOutputStream());
                outputStream.writeChars(g.toJson(parameters));
                outputStream.flush();
                outputStream.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            try (final BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                final StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                System.out.println(content);

            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }*/


        Gson g = new Gson();
        StudentApi studentApi = new StudentApi();

//        Добавление одного студента
//        String result = studentApi.add_student("Богдан", "Бондарев", "Олегович", "bodya1234", "12345", "1", "5");
//        System.out.println(result);

//        Получение всех студентов
        List<Student> result1 = studentApi.getAllStudents();
        Student item = result1.get(0);


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