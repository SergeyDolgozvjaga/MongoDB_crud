package com.sergeydolgozvjaga.mongocruddb;

import com.sergeydolgozvjaga.mongocruddb.Dao.DaoImpl;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.logging.Logger;

/**
 * Author Sergey Dolgozvjaga
 * */
public class Main {

    private static final Logger logger = Logger.getLogger(String.valueOf(Main.class));

    public static void main(String[] args) throws UnknownHostException {

        logger.info("application start");

        DaoImpl impl = new DaoImpl();
        impl.Init();

        impl.insert("name", "Sergio");
        impl.insert("age", 29);
        impl.insert("createdDate", new Date());

        impl.insert("name2", "Ann");
        impl.insert("age", 31);
        impl.insert("createdDate", new Date());

        impl.findAndShow("name", "Sergio");
        impl.findAndShow("name2", "Ann");

        impl.update("name", "Sergio", "Sergio-updated");
        impl.findAndShowUpdate("name", "Sergio-updated");
        impl.delete("name2", "Ann");

        impl.getAll();

        logger.info("application exit");

    }

}
