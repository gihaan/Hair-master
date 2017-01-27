package com.example.mm.hair.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by mm on 09/01/2017.
 */

public class DatabaseOperation extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 1;

    public static final String CREATE_QUERY = "CREATE TABLE " + DataTable.TableInfo.TABLE_NAME + "( id INTEGER PRIMARY KEY AUTOINCREMENT , " + DataTable.TableInfo.LIST_TITLE + " TEXT ," +
            DataTable.TableInfo.COMPONENT+ " TEXT ," + DataTable.TableInfo.METHOD+ " TEXT  );";


    public DatabaseOperation(Context context) {
        //**name ==the name of data base
        super(context, DataTable.TableInfo.DATABASE_NAME, null, 1);
        Log.d("database operation", "DATABASE CREATED");

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.d("database operation", "TABLE CREATED ");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void inputInformation( DataVariable dv) {
        String list_title = dv.getTitle();  //1
        String component = dv.getComponent();//2
        String method=dv.getMethod();//3

        SQLiteDatabase SQ = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DataTable.TableInfo.LIST_TITLE, list_title);
        cv.put(DataTable.TableInfo.COMPONENT, component);
        cv.put(DataTable.TableInfo.METHOD, method);

        long k = SQ.insert(DataTable.TableInfo.TABLE_NAME, null, cv);
        Log.d("database operation", "ONE ROW INSERTED ");


    }
    ////////////////////////////////FAVOURITE////////////////////////////

    public Cursor getInformation(DatabaseOperation databaseOperation){

        SQLiteDatabase SQ=databaseOperation.getReadableDatabase();
        String []colums={DataTable.TableInfo.LIST_TITLE,DataTable.TableInfo.COMPONENT,DataTable.TableInfo.METHOD};
        Cursor CR=SQ.query(DataTable.TableInfo.TABLE_NAME,colums,null,null,null,null,null);
        return CR;

    }





/*
/////WITH ME ///
    public Cursor getInformation(DatabaseOperation dop){


        SQLiteDatabase SQ=dop.getReadableDatabase();
        String []Colums={DataTable.TableInfo.ORIGINAL_TITLE,DataTable.TableInfo.POSTER_PATH,DataTable.TableInfo.OVER_VIEW,DataTable.TableInfo.VOTE_AVERAGE,DataTable.TableInfo.RELEASE_DATA};
        Cursor CR=SQ.query(DataTable.TableInfo.TABLE_NAME,Colums,null,null,null,null,null);
        return CR;


    }
*/


/*


public Cursor getInformation(DatabaseOperations dop){

        SQLiteDatabase SQ=dop.getReadableDatabase();
        String []colums={TableData.TableInfo.USER_NAMR, TableData.TableInfo.USER_PASS};
        Cursor CR=SQ.query(TableData.TableInfo.TABLE_NAME,colums,null,null,null,null,null);
        return CR;


        }

public Cursor getUserpass(DatabaseOperations dop,String user){
        SQLiteDatabase SQ=dop.getReadableDatabase();
        String Selection= TableData.TableInfo.USER_NAMR+" like ?";

        String []args={user};

        String []Colums={TableData.TableInfo.USER_PASS};

        Cursor CR=SQ.query(TableData.TableInfo.TABLE_NAME,Colums,Selection,args,null,null,null);
        return CR;

        }
public void delteUser(DatabaseOperations dop,String user,String pass){


        String Selection= TableData.TableInfo.USER_NAMR +" LIKE ? AND "+ TableData.TableInfo.USER_PASS +" LIKE ?";
        String Colum[]={TableData.TableInfo.USER_PASS};
        String args[]={user,pass};
        SQLiteDatabase SQ=dop.getWritableDatabase();
        SQ.delete(TableData.TableInfo.TABLE_NAME,Selection,args);
        }
public void updateInfo(DatabaseOperations dop,String user_name,String password,String new_user_name){
        SQLiteDatabase SQ=dop.getWritableDatabase();
        String Selectoion= TableData.TableInfo.USER_NAMR+" LIKE ? AND "+TableData.TableInfo.USER_PASS+" LIKE ?";
        String args[]={user_name,password};
        ContentValues contentValues=new ContentValues();
        contentValues.put(TableData.TableInfo.USER_NAMR,new_user_name);
        SQ.update(TableData.TableInfo.TABLE_NAME,contentValues,Selectoion,args);




        }
        */



}