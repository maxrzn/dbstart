package de.hbrs.ia.code;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import de.hbrs.ia.model.SalesMan;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Arrays;

import static com.mongodb.client.model.Filters.eq;

public class ManagePersonal implements ManagePersonalIF {
    @Override
    public String createSalesMan(SalesMan record) {
        String uri = "mongodb+srv://mziege2s:Max21.11.@cluster0.wqctpff.mongodb.net/?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("personal");
            MongoCollection<Document> collection = database.getCollection("info");
            try {
                InsertOneResult result = collection.insertOne(new Document()
                        .append("_id", new ObjectId())
                        .append("firstname", record.getFirstname())
                        .append("lastname", record.getLastname())
                        .append("id", record.getId()));
                return "Success! Inserted document id: " + result.getInsertedId();
            } catch (MongoException me) {
                return "Unable to insert due to an error: " + me;
            }
        }
    }


    public String readSalesMan(int sid) {
        String out;
        String uri = "mongodb+srv://mziege2s:Max21.11.@cluster0.wqctpff.mongodb.net/?retryWrites=true&w=majority";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("personal");
            MongoCollection<Document> collection = database.getCollection("info");

            Document doc = collection.find(eq("id", sid)).first();
            if (doc != null) {
                out = doc.toJson();
            } else {
                out = "No matching documents found.";
            }
        }
        return out;
    }

}

