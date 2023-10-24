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
    public void createSalesMan(SalesMan record) {
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
            } catch (MongoException me) {
                System.out.println("Unable to insert due to an error: " + me);
            }
        }
    }

    @Override
    public SalesMan readSalesMan(int sid) {
        SalesMan out = null;
        String uri = "mongodb+srv://mziege2s:Max21.11.@cluster0.wqctpff.mongodb.net/?retryWrites=true&w=majority";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("personal");
            MongoCollection<Document> collection = database.getCollection("info");

            Document doc = collection.find(eq("id", sid)).first();
            if (doc != null) {
                out = new SalesMan((String) doc.get("firstname"), (String) doc.get("lastname"), (Integer) doc.get("id"));
            }
            return out;
        }
    }

    @Override
    public EvaluationRecord readEvaluationRecords(int sid) {
        //TODO
        return null;
    }

}

