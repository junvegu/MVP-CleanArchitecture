package com.kodevian.blackpinktheme.data.source.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class KoreanGirlsDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 3;

    public static final String DATABASE_NAME = "Korean.db";

    private static final String TEXT_TYPE = " TEXT";

    private static final String INTEGER_TYPE = " INTEGER";

    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + KoreanGirlsPersistenceContract.KoreanGirlsEntry.TABLE_NAME + " (" +
                    KoreanGirlsPersistenceContract.KoreanGirlsEntry._ID + INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT," +
                    KoreanGirlsPersistenceContract.KoreanGirlsEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP  +
                    KoreanGirlsPersistenceContract.KoreanGirlsEntry.COLUMN_NAME_FIRST_NAME + TEXT_TYPE + COMMA_SEP +
                    KoreanGirlsPersistenceContract.KoreanGirlsEntry.COLUMN_NAME_LAST_NAME + TEXT_TYPE + COMMA_SEP +
                    KoreanGirlsPersistenceContract.KoreanGirlsEntry.COLUMN_NAME_IMAGE + TEXT_TYPE + COMMA_SEP +
                    KoreanGirlsPersistenceContract.KoreanGirlsEntry.COLUMN_NAME_AGE + INTEGER_TYPE +
            " )";

    public KoreanGirlsDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Not required as at version 1
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Not required as at version 1
    }
}