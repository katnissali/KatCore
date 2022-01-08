package com.katnissali.katcore.Database;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

public class MongoDBDatabase {

    private final String cluster;
    private final String name;
    private final String username;
    private final String password;

    private final MongoDatabase database;

    public MongoDBDatabase(String cluster, String name, String username, String password){
        this.cluster = cluster;
        this.name = name;
        this.username = username;
        this.password = password;

        this.database = MongoDBUtil.getDatabase(cluster, name, username, password);
    }

    //  GETTERS
    public String getCluster() {
        return cluster;
    }
    public String getName() {
        return name;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public MongoDatabase getDatabase() {
        return database;
    }

    //  GETTERS
    public MongoCollection<Document> getCollection(String collection){
        return database.getCollection(collection);
    }
    public Document getValue(MongoCollection<Document> collection, Document value){
        return collection.find(value).first();
    }
    public ConnectionString getConnectionString() {
        return MongoDBUtil.createConnectionString(username, password, cluster, name);
    }
    public MongoClientSettings getClientSettings(){
        return MongoDBUtil.createClientSettings(getConnectionString());
    }

    //  SETTERS
    public ObjectId insertValue(MongoCollection<Document> collection, Document value){
        return collection.insertOne(value).getInsertedId().asObjectId().getValue();
    }
    public ObjectId insertValue(String collection, Document value){
        return insertValue(getCollection(collection), value);
    }
}
