package de.hbrs.ia.code;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Quickstart {
    public static void main( String[] args ) {

        // Replace the placeholder with your MongoDB deployment's connection string
        String uri = "mongodb+srv://mziege2s:Max21.11.@cluster0.wqctpff.mongodb.net/?retryWrites=true&w=majority";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("personal");
            MongoCollection<Document> collection = database.getCollection("info");

            Document doc = collection.find(eq("id", "90125")).first();
            if (doc != null) {
                System.out.println(doc.toJson());
            } else {
                System.out.println("No matching documents found.");
            }
        }




        //Error Logger (dont know if needed)
        Logger logger = LoggerFactory.getLogger("MyApp");
        logger.error("Logging an Error");
    }



}