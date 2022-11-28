package rick.edu.g2_project;

//                                          !!!***NOTE***!!!
//If any changes are made to the database either increase the DB_VERSION number, or uninstall the app within the emulator
//so that the onUpgrade method is called to create a new database
//if you do not do this the app will either crash or not work as intended because the db is still contain the previous tables and columns

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    //db name
    public static final String DB_NAME = "MyDbName.db";
    //db version
    public static final int DB_VERSION = 3;

    private SQLiteDatabase db;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String CREATE_PC_PART_TABLE = "CREATE TABLE " +
                ExploreContract.PcPartsTable.TABLE_NAME + " ( " +
                ExploreContract.PcPartsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + //_ID is from BaseColumns
                ExploreContract.PcPartsTable.COLUMN_CPU + " TEXT, " +
                ExploreContract.PcPartsTable.COLUMN_CPU_PRICE + " TEXT" +
                ")";

        db.execSQL(CREATE_PC_PART_TABLE);
        fillPcPartsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ExploreContract.PcPartsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillPcPartsTable() {
        Explore p1 = new Explore("i9", 400);
        addPcPart(p1);

        Explore p2 = new Explore("i7", 300);
        addPcPart(p2);

        Explore p3 = new Explore("i5", 200);
        addPcPart(p3);

        Explore p4 = new Explore("i3", 100);
        addPcPart(p4);

        Explore p5 = new Explore("Ryzen 7", 350);
        addPcPart(p5);

        Explore p6 = new Explore("Ryzen 5", 200);
        addPcPart(p6);

        Explore p7 = new Explore("Ryzen 3", 100);
        addPcPart(p7);

        Explore p8 = new Explore("RTX 3090", 1000);
        addPcPart(p8);

        Explore p9 = new Explore("RTX 2070", 500);
        addPcPart(p9);

        Explore p10 = new Explore("GTX 1080", 300);
        addPcPart(p10);

        Explore p11 = new Explore("RTX 3070", 900);
        addPcPart(p11);

        Explore p12 = new Explore("RTX 3060", 900);
        addPcPart(p12);

        Explore p13 = new Explore("RTX 2060", 500);
        addPcPart(p13);

        Explore p14 = new Explore("RTX 2060 Super", 550);
        addPcPart(p14);

        Explore p15 = new Explore("RX 6700", 380);
        addPcPart(p15);

        Explore p16 = new Explore("RTX 3050", 349);
        addPcPart(p16);

        Explore p17 = new Explore("RX 580", 150);
        addPcPart(p17);

        Explore p18 = new Explore("RTX 3070 Ti", 749);
        addPcPart(p18);

        Explore p19 = new Explore("RTX 2080", 499);
        addPcPart(p19);

        Explore p20 = new Explore("RTX 2080 Super", 599);
        addPcPart(p20);
    }

    private void addPcPart(Explore explore) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(ExploreContract.PcPartsTable.COLUMN_CPU, explore.getCpu());
        contentValues.put(ExploreContract.PcPartsTable.COLUMN_CPU_PRICE, explore.getCpu_price());

        db.insert(ExploreContract.PcPartsTable.TABLE_NAME, null, contentValues);
    }

    @SuppressLint("Range")
    public ArrayList<Explore> getAllParts() {
        ArrayList<Explore> arrayList = new ArrayList<>();
        db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM "
                        + ExploreContract.PcPartsTable.TABLE_NAME,
                null);

        if (cursor.moveToFirst()) {
            do {
                Explore explore = new Explore();

                explore.setId(cursor.getInt(cursor.getColumnIndex(ExploreContract.PcPartsTable._ID)));
                explore.setCpu(cursor.getString(cursor.getColumnIndex(ExploreContract.PcPartsTable.COLUMN_CPU)));
                explore.setCpu_price(cursor.getInt(cursor.getColumnIndex(ExploreContract.PcPartsTable.COLUMN_CPU_PRICE)));

                arrayList.add(explore);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return arrayList;
    }
}
