package com.example.mm.hair.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by mm on 26/01/2017.
 */

public class FavouriteOperation  extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;

    public static final String CREATE_QUERY = "CREATE TABLE " + DataTable.TableInfo.FAVOURITE_TABLE_NAME + "( id INTEGER PRIMARY KEY AUTOINCREMENT , " + DataTable.TableInfo.FAVOURITE_LIST_TITLE + " TEXT ," +
            DataTable.TableInfo.FAVOURITE_COMPONENT+ " TEXT ," + DataTable.TableInfo.FAVOURITE_METHOD+ " TEXT  );";

    public FavouriteOperation(Context context) {
        //**name ==the name of data base
        super(context, DataTable.TableInfo.FAVOURITE_DATABASE_NAME, null, 1);
        Log.d("database operation", "FAVOURITE DATABASE CREATED");

    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL(CREATE_QUERY);
        Log.d("database operation", "TABLE CREATED ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }





    public void inputInformation( DataVariable dv) {
        String list_title = dv.getTitle();  //1
        String component = dv.getComponent();//2
        String method=dv.getMethod();//3

        SQLiteDatabase SQ = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DataTable.TableInfo.FAVOURITE_LIST_TITLE, list_title);
        cv.put(DataTable.TableInfo.FAVOURITE_COMPONENT, component);
        cv.put(DataTable.TableInfo.FAVOURITE_METHOD, method);

        long k = SQ.insert(DataTable.TableInfo.FAVOURITE_TABLE_NAME, null, cv);
        Log.d("database operation", "ONE ROW INSERTED ");


    }


    public Cursor getInformation(FavouriteOperation databaseOperation){

        SQLiteDatabase SQ=databaseOperation.getReadableDatabase();
        String []colums={DataTable.TableInfo.FAVOURITE_LIST_TITLE,DataTable.TableInfo.FAVOURITE_COMPONENT,DataTable.TableInfo.FAVOURITE_METHOD};
        Cursor CR=SQ.query(DataTable.TableInfo.FAVOURITE_TABLE_NAME,colums,null,null,null,null,null);
        return CR;

    }

}
