package api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Specimen;
import model.Student;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

public class SpecimenApi {
    String urlAddress = "http://localhost:8080/specimens";
    URL url;
    HttpURLConnection connection;
    DataOutputStream outputStream = null;
    InputStreamReader inputStreamReader = null;
    BufferedReader bufferedReader = null;

    Gson g = new Gson();

    public Specimen addSpecimen(String texture, String structure, String composition, String area, String paleo) {
        try {
            Specimen specimen = new Specimen();
            specimen.setTexture(texture);
            specimen.setStructure(structure);
            specimen.setComposition(composition);
            specimen.setArea(area);
            specimen.setPaleo(paleo);
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
                outputStream = new DataOutputStream(connection.getOutputStream());
                outputStream.writeChars(g.toJson(specimen));
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
                Specimen read = g.fromJson(String.valueOf(content), Specimen.class);
                return read;

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
        }


    }

    public List<Specimen> getAllSpecimens() {
        try {
            String urlAddressLocal;
            urlAddressLocal = urlAddress + "/all";
            url = new URL(urlAddressLocal);
            connection = (HttpURLConnection) url.openConnection();
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

                Type type = new TypeToken<List<Specimen>>(){}.getType();
                List<Specimen> read = g.fromJson(String.valueOf(content), type);


                return read;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public Specimen delpecimen(Long id) {
        try {
            String urlAddressLocal;
            urlAddressLocal = urlAddress + "/" + id.toString();
            url = new URL(urlAddressLocal);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setConnectTimeout(1000);
            connection.setReadTimeout(1000);

            try (final BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
                String inputLine;
                final StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }

                Specimen read = g.fromJson(String.valueOf(content), Specimen.class);

                return read;
            }



        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Specimen updateSpecimen(Long id, String texture, String structure, String composition, String area, String paleo) {
        try {
            Specimen specimen = new Specimen();
            specimen.setTexture(texture);
            specimen.setStructure(structure);
            specimen.setComposition(composition);
            specimen.setArea(area);
            specimen.setPaleo(paleo);
            String urlAddressLocal = urlAddress + "?id=" + id.toString();

            url = new URL(urlAddressLocal);

            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setDoOutput(true);
            connection.setDoInput(true);

            connection.setRequestProperty("Content-type", "application/json");
            connection.setConnectTimeout(1000);
            connection.setReadTimeout(1000);
            connection.connect();

            try {
                outputStream = new DataOutputStream(connection.getOutputStream());
                outputStream.writeChars(g.toJson(specimen));
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

                Specimen read = g.fromJson(String.valueOf(content), Specimen.class);

                return read;

            }


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
