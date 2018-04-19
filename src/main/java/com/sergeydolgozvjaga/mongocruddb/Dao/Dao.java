package com.sergeydolgozvjaga.mongocruddb.Dao;

import java.net.UnknownHostException;

    public interface Dao {

        void insert(String key, Object value) throws UnknownHostException;

        void update(String key, String value, String newValue) throws UnknownHostException;

        void delete(String key, Object value) throws UnknownHostException;

        void getAll() throws UnknownHostException;

}
