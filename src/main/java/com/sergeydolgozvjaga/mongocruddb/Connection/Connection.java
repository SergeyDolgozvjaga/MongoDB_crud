package com.sergeydolgozvjaga.mongocruddb.Connection;

import com.mongodb.MongoClient;

import java.net.UnknownHostException;
import java.util.logging.Logger;

/**
 * Class using for connect to database
 * */
public class Connection {

    //using logging
    private final Logger logger = Logger.getLogger(String.valueOf(Connection.class));

    /**
     * Connect to MongoDB
     * Since ver.2.10.0, uses MongoClient
     * */
    public MongoClient mongoClient() throws UnknownHostException {
        logger.info("start mongoClient()");
        MongoClient mongo = new MongoClient("localhost", 27017);
        logger.info("exit mongoClient()");
        return mongo;
    }

}
