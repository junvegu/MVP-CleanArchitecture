package com.kodevian.blackpinktheme.data.source.local;

import android.provider.BaseColumns;

/**
 * The contract used for the db to save the tasks locally.
 */
public final class KoreanGirlsPersistenceContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private KoreanGirlsPersistenceContract() {}

    /* Inner class that defines the table contents */
    public static abstract class KoreanGirlsEntry implements BaseColumns {
        public static final String TABLE_NAME = "koreans";
        public static final String COLUMN_NAME_ENTRY_ID = "entry_id";
        public static final String COLUMN_NAME_FIRST_NAME = "first_name";
        public static final String COLUMN_NAME_LAST_NAME = "last_name";
        public static final String COLUMN_NAME_IMAGE = "photo";
        public static final String COLUMN_NAME_AGE = "age";
    }
}