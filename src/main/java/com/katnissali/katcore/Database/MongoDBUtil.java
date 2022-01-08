package com.katnissali.katcore.Database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.types.ObjectId;

import com.mongodb.*;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.*;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;

public class MongoDBUtil {

    //  GETTERS
    public static MongoDatabase getDatabase(String cluster, String database, String username, String password){
        return getClient(createClientSettings(createConnectionString(cluster, database, username, password))).getDatabase(database);
    }
    public static MongoDatabase getDatabase(MongoClient client, String database){
        return client.getDatabase(database);
    }
    public static MongoClient getClient(MongoClientSettings settings){
        return MongoClients.create(settings);
    }

    //  GENERATORS
    public static ConnectionString createConnectionString(String cluster, String database, String username, String password){
        return new ConnectionString("mongodb+srv://" + username + ":<" + password + ">@" + cluster + ".njdmv.mongodb.net/" + database + "?retryWrites=true&w=majority");
    }
    public static MongoClientSettings createClientSettings(ConnectionString connectionString){
        return MongoClientSettings.builder().applyConnectionString(connectionString).build();
    }
}
