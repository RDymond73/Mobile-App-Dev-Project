package rick.edu.g2_project;
//**NOTES**
/*This Explorecontract Java Class can be thought as a place holder for
constant variable names regarding to SQL operation.

BaseColumns will automatically create _ID & _Count
To see press control+click on BaseColumns

This allows you to refer to these names instead of manually typing them each time...

From here you can add more tables but youll need an additional setter/getter and add more methods
to the DBHelper class*/

import android.provider.BaseColumns;

public class ExploreContract implements BaseColumns {

/*    this is intentionally as to prevent accidental object creation
    as this class is only made to hold contants in one location*/
    private ExploreContract(){}

    //these will be the names of the db table and columns
    public static class PcPartsTable implements BaseColumns {
        public static final String TABLE_NAME = "cpu";
        public static final String COLUMN_CPU = "cpu_model";
        public static final String COLUMN_CPU_PRICE = "cpu_price";
    }
}
