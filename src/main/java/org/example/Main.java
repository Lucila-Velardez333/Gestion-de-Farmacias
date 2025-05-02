package org.example;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String uri = "mongodb://localhost:27017";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("gestion_farmacia");

            System.out.println("Bases de datos disponibles:");
            for (String name : mongoClient.listDatabaseNames()) {
                System.out.println("- " + name);
            }

            System.out.println("Conectado a: " + database.getName());
        }catch (Exception e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }




    }
}