package main;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import org.bson.Document;

/**
 * Created by milos on 24/01/2017.
 */
public class Main {

    public static void main(String args[]){

        MongoClient client = new MongoClient("94.102.159.10");

        MongoDatabase database = client.getDatabase("test");

        MongoCollection<Document> kolekce = database.getCollection("Collections");


        Document document = new Document();

        document.put("database", "mkyongDB");
        document.put("table", "hosting");

        Document documentDetail = new Document();

        documentDetail.put("records", 99);
        documentDetail.put("index", "vps_index1");
        documentDetail.put("active", "true");

        document.put("detail", documentDetail);


        Document dokument2 = Document.parse ("{'name':'mkyong', 'age':30}");

        kolekce.insertOne(document);

        kolekce.insertOne(dokument2);

        System.out.println(kolekce.count());


   }
}
