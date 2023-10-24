package test;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import de.hbrs.ia.model.SalesMan;
import org.bson.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.mongodb.client.model.Filters.eq;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ControllerTest {

    private MongoClient mongoClient;
    private MongoDatabase personal;
    private MongoCollection<Document> info;

    /**
     * Attention: You might update the version of the Driver
     * for newer version of MongoDB!
     * This tests run with MongoDB 4.2.17 Community
     */
    @BeforeEach
    void setUp() {
        String uri = "mongodb+srv://mziege2s:Max21.11.@cluster0.wqctpff.mongodb.net/?retryWrites=true&w=majority";
        mongoClient = MongoClients.create(uri);
        personal = mongoClient.getDatabase("personal");
        info = personal.getCollection("test");
    }

    @Test
    void insertSalesMan() {
        // CREATE (Storing) the salesman object
        Document document = new Document();
        document.append("firstname" , "Sascha");
        document.append("lastname" , "Alda");
        document.append("id" , 90133);

        // ... now storing the object
        info.insertOne(document);

        // READ (Finding) the stored Documnent
        //Document newDocument = info.find(eq("id", "90133")).first();
        Document newDocument = this.info.find().first();
        if (newDocument != null) {
            System.out.println(newDocument.toJson());
            // Assertion
            Integer id = (Integer) newDocument.get("id");
            assertEquals( 90133 , id );
        } else {
            System.out.println("No matching documents found.");
        }
        // Deletion
        info.drop();
    }

    @Test
    void insertSalesManMoreObjectOriented() {
        // CREATE (Storing) the salesman business object
        // Using setter instead
        SalesMan salesMan = new SalesMan( "Leslie" , "Malton" , 90444 );

        // ... now storing the object
        info.insertOne(salesMan.toDocument());

        // READ (Finding) the stored Documnent
        // Mapping Document to business object would be fine...
        Document newDocument = this.info.find().first();
        System.out.println("Printing the object (JSON): " + newDocument );

        // Assertion
        Integer id = (Integer) newDocument.get("id");
        assertEquals( 90444 , id );

        // Deletion
        info.drop();
    }
}