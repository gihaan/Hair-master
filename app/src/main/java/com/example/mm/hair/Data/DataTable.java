package com.example.mm.hair.Data;

import android.provider.BaseColumns;

/**
 * Created by mm on 09/01/2017.
 */

public class DataTable {

    public DataTable() {

    }


    public static abstract class TableInfo implements BaseColumns {

        //INTIALIZE COLOUM TABLE//

        public static final String LIST_TITLE = "list_title";
        public static final String COMPONENT = "component";
        public static final String METHOD = "method";
        public static final String FAVOURITE = "favourite";



        //INTIALIZE DATABASE NAME//
        public static final String DATABASE_NAME = "hair";
        // Intialize table name //
        public static final String TABLE_NAME = "descrition";
////////////////////////////FAVOURITE/////////////////////////////////
        //INTIALIZE COLOUM TABLE//

        public static final String FAVOURITE_LIST_TITLE = "list_title";
        public static final String FAVOURITE_COMPONENT = "component";
        public static final String FAVOURITE_METHOD = "method";



        //INTIALIZE DATABASE NAME//
        public static final String FAVOURITE_DATABASE_NAME = "favourite";
        // Intialize table name //
        public static final String FAVOURITE_TABLE_NAME = "favouritetable";


    }
}
