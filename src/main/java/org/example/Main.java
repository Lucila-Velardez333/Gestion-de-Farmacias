package org.example;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.InsertManyResult;
import org.bson.types.ObjectId;

import java.util.Arrays;

import static com.mongodb.client.model.Filters.eq;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String uri = "mongodb://localhost:27017";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("gestion_farmacia");

            MongoCollection<Document> collection = database.getCollection("Personas");

            InsertOneResult result = collection.insertOne(new Document()
                    .append("_id", new ObjectId())
                    .append("nombre", "Lucila"));
            InsertOneResult result1 = collection.insertOne(new Document()
                    .append("_id", new ObjectId())
                    .append("nombre", "Dylan"));
            System.out.println(collection);

            System.out.println("Inserted document id - insert one: " + result.getInsertedId());
            System.out.println("Inserted document id - insert two: " + result1.getInsertedId());
            System.out.println("****************************");
            System.out.println(" Mostramos todas las personas registradas:");
            for (Document persona : collection.find()) {
                System.out.println(persona.toJson());
            }

            System.out.println(" Buscamos un documento en la coleccion Personas");
            Document doc = collection.find(eq("nombre", "Dylan")).first();
            if (doc != null) {
                System.out.println(doc.toJson());
            } else {
                System.out.println("No se.");
            }



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