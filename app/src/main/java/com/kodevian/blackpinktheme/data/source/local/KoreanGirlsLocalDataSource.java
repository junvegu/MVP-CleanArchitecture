package com.kodevian.blackpinktheme.data.source.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.kodevian.blackpinktheme.data.entities.KoreanGirlEntity;
import com.kodevian.blackpinktheme.data.source.KoreanGirlDataSource;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by junior on 13/10/17.
 */

public class KoreanGirlsLocalDataSource implements KoreanGirlDataSource {

    private static KoreanGirlsLocalDataSource INSTANCE;

    private KoreanGirlsDbHelper mDbHelper;

    // Prevent direct instantiation.
    private KoreanGirlsLocalDataSource(@NonNull Context context) {
        checkNotNull(context);
        mDbHelper = new KoreanGirlsDbHelper(context);
    }

    public static KoreanGirlsLocalDataSource getInstance(@NonNull Context context) {
        if (INSTANCE == null) {
            INSTANCE = new KoreanGirlsLocalDataSource(context);
        }
        return INSTANCE;
    }

    @Override
    public void getKoreanGirls(@NonNull LoadKoreanGirlsCallback callback) {
        List<KoreanGirlEntity> koreanGirlEntities = new ArrayList<>();
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                KoreanGirlsPersistenceContract.KoreanGirlsEntry.COLUMN_NAME_ENTRY_ID,
                KoreanGirlsPersistenceContract.KoreanGirlsEntry.COLUMN_NAME_FIRST_NAME,
                KoreanGirlsPersistenceContract.KoreanGirlsEntry.COLUMN_NAME_LAST_NAME,
                KoreanGirlsPersistenceContract.KoreanGirlsEntry.COLUMN_NAME_IMAGE,
                KoreanGirlsPersistenceContract.KoreanGirlsEntry.COLUMN_NAME_AGE
        };

        Cursor c = db.query(
                KoreanGirlsPersistenceContract.KoreanGirlsEntry.TABLE_NAME,
                projection, null, null, null, null, null);

        if (c != null && c.getCount() > 0) {
            while (c.moveToNext()) {
                String itemId = c.getString(c.getColumnIndexOrThrow(KoreanGirlsPersistenceContract.KoreanGirlsEntry.COLUMN_NAME_ENTRY_ID));
                String firstName = c.getString(c.getColumnIndexOrThrow(KoreanGirlsPersistenceContract.KoreanGirlsEntry.COLUMN_NAME_FIRST_NAME));
                String lastName = c.getString(c.getColumnIndexOrThrow(KoreanGirlsPersistenceContract.KoreanGirlsEntry.COLUMN_NAME_LAST_NAME));
                String image = c.getString(c.getColumnIndexOrThrow(KoreanGirlsPersistenceContract.KoreanGirlsEntry.COLUMN_NAME_IMAGE));
                int age = c.getInt(c.getColumnIndexOrThrow(KoreanGirlsPersistenceContract.KoreanGirlsEntry.COLUMN_NAME_AGE));

                KoreanGirlEntity koreanGirlEntity = new KoreanGirlEntity(itemId, firstName, lastName, image,age);
                koreanGirlEntities.add(koreanGirlEntity);
            }
        }
        if (c != null) {
            c.close();
        }

        db.close();

        if (koreanGirlEntities.isEmpty()) {
            // This will be called if the table is new or just empty.
            callback.onDataNotAvailable();
        } else {
            callback.onKoreanGirlsLoaded(koreanGirlEntities);
        }
    }




    @Override
    public void saveKoreanGirl(@NonNull KoreanGirlEntity koreanGirlEntity) {
        checkNotNull(koreanGirlEntity);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KoreanGirlsPersistenceContract.KoreanGirlsEntry.COLUMN_NAME_ENTRY_ID, koreanGirlEntity.getId());
        values.put(KoreanGirlsPersistenceContract.KoreanGirlsEntry.COLUMN_NAME_FIRST_NAME, koreanGirlEntity.getFirst_name());
        values.put(KoreanGirlsPersistenceContract.KoreanGirlsEntry.COLUMN_NAME_LAST_NAME, koreanGirlEntity.getLast_name());
        values.put(KoreanGirlsPersistenceContract.KoreanGirlsEntry.COLUMN_NAME_IMAGE, koreanGirlEntity.getImage());
        values.put(KoreanGirlsPersistenceContract.KoreanGirlsEntry.COLUMN_NAME_AGE, koreanGirlEntity.getAge());

        db.insert(KoreanGirlsPersistenceContract.KoreanGirlsEntry.TABLE_NAME, null, values);

        db.close();
    }

    @Override
    public void refreshKoreanGirls() {

    }

    @Override
    public void deleteAllKoreanGirls() {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        db.delete(KoreanGirlsPersistenceContract.KoreanGirlsEntry.TABLE_NAME, null, null);

        db.close();
    }
}
