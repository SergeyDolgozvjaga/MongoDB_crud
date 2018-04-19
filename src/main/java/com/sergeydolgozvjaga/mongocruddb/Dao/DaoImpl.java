package com.sergeydolgozvjaga.mongocruddb.Dao;

import com.mongodb.*;
import com.sergeydolgozvjaga.mongocruddb.Connection.Connection;

import java.net.UnknownHostException;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Class realize CRUD operations, using Mongo database
 * */
public class DaoImpl implements Dao {

    private Connection connection;
    private final Logger logger = Logger.getLogger(String.valueOf(DaoImpl.class));

    /**
     * Method init the connection
     * */
    public void Init(){
        connection = new Connection();
    }

    /**
     * Method get database
     * if database doesn't exists, MongoDB will create it for you
     *
     * @return database "testdb"
     * */
    private DB mongoDB() throws UnknownHostException {
        logger.info("start mongoDB()");
        DB db = connection.mongoClient().getDB("testdb");
        logger.info("exit mongoDB()");
        return db;
    }

    /**
     * Method get collection from database
     * if collection doesn't exists, MongoDB will create it for you
     *
     * @return DBCollection;
     * */
    private DBCollection table() throws UnknownHostException {
        logger.info("start table()");
        DBCollection table = mongoDB().getCollection("user");
        logger.info("exit table()");
        return table;
    }

    /**
     * Method Insert data to database
     * */
    public void insert(String key, Object value) throws UnknownHostException {
        // create a document to store key and value
        logger.info("start insert(..)");
        BasicDBObject document = new BasicDBObject();
        document.put(key, value);
        table().insert(document);
        logger.info("exit insert(..)");
    }

    /**
     * Method find data in database and show it
     * */
    public void findAndShow(String key, Object value) throws UnknownHostException {
        logger.info("start findAndShow(..)");
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put(key, value);

        DBCursor cursor = table().find(searchQuery);

        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
        logger.info("exit findAndShow(..)");
    }

    /**
     * Method update information in database
     * */
    public void update(String key, String value, String newValue) throws UnknownHostException {
            logger.info("start update(..)");
            BasicDBObject query = new BasicDBObject();
            query.put(key, value);

            BasicDBObject newDocument = new BasicDBObject();
            newDocument.put(key, newValue);

            BasicDBObject updateObj = new BasicDBObject();
            updateObj.put("$set", newDocument);
            table().update(query, updateObj);
            logger.info("exit update(..)");
    }

    /**
     * Method find updated data in database and show it
     * */
    public void findAndShowUpdate(String key, Object value) throws UnknownHostException {
        logger.info("start findAndShowUpdate(..)");
        BasicDBObject searchQuery2 = new BasicDBObject().append(key, value);

        DBCursor cursor2 = table().find(searchQuery2);

        while (cursor2.hasNext()) {
            System.out.println(cursor2.next());
        }
        logger.info("exit findAndShowUpdate(..)");

    }

    /**
     * Method delete some information  in database
     * */
    public void delete(String key, Object value) throws UnknownHostException {
        logger.info("start delete(..)");
        DBCollection table = mongoDB().getCollection("user");

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put(key, value);
        table.remove(searchQuery);
        logger.info("exit delete(..)");
    }

    /**
     * Method show all information in database
     * */
    public void getAll() throws UnknownHostException {

        Set<String> tables = mongoDB().getCollectionNames();

        tables.forEach(System.out::println);

        
    }

}
