package com.example.roofonclick.DAOs;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.roofonclick.DataModels.CustomerFavouriteModel;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class CustomerHomeFavouriteModelDao_Impl implements CustomerHomeFavouriteModelDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfCustomerFavouriteModel;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfCustomerFavouriteModel;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfCustomerFavouriteModel;

  public CustomerHomeFavouriteModelDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCustomerFavouriteModel = new EntityInsertionAdapter<CustomerFavouriteModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `CustomerFavouriteModel`(`Favid`,`RoomId`,`Price`,`RoomType`,`TenantType`,`Address`,`City`,`State`,`Image`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CustomerFavouriteModel value) {
        stmt.bindLong(1, value.Favid);
        stmt.bindLong(2, value.froomid);
        stmt.bindLong(3, value.fprice);
        if (value.froomtype == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.froomtype);
        }
        if (value.ftenanttype == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.ftenanttype);
        }
        if (value.faddress == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.faddress);
        }
        if (value.fcity == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.fcity);
        }
        if (value.fstate == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.fstate);
        }
        if (value.fimg == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindBlob(9, value.fimg);
        }
      }
    };
    this.__deletionAdapterOfCustomerFavouriteModel = new EntityDeletionOrUpdateAdapter<CustomerFavouriteModel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `CustomerFavouriteModel` WHERE `Favid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CustomerFavouriteModel value) {
        stmt.bindLong(1, value.Favid);
      }
    };
    this.__updateAdapterOfCustomerFavouriteModel = new EntityDeletionOrUpdateAdapter<CustomerFavouriteModel>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `CustomerFavouriteModel` SET `Favid` = ?,`RoomId` = ?,`Price` = ?,`RoomType` = ?,`TenantType` = ?,`Address` = ?,`City` = ?,`State` = ?,`Image` = ? WHERE `Favid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CustomerFavouriteModel value) {
        stmt.bindLong(1, value.Favid);
        stmt.bindLong(2, value.froomid);
        stmt.bindLong(3, value.fprice);
        if (value.froomtype == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.froomtype);
        }
        if (value.ftenanttype == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.ftenanttype);
        }
        if (value.faddress == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.faddress);
        }
        if (value.fcity == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.fcity);
        }
        if (value.fstate == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.fstate);
        }
        if (value.fimg == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindBlob(9, value.fimg);
        }
        stmt.bindLong(10, value.Favid);
      }
    };
  }

  @Override
  public long insertCustomerFavouriteModel(CustomerFavouriteModel cfm) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfCustomerFavouriteModel.insertAndReturnId(cfm);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteCustomerFavouriteModel(CustomerFavouriteModel cfm) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfCustomerFavouriteModel.handle(cfm);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateCustomerFavouriteModel(CustomerFavouriteModel cfm) {
    __db.beginTransaction();
    try {
      __updateAdapterOfCustomerFavouriteModel.handle(cfm);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<CustomerFavouriteModel> getAllFavourite() {
    final String _sql = "SELECT * FROM CustomerFavouriteModel";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfFavid = _cursor.getColumnIndexOrThrow("Favid");
      final int _cursorIndexOfFroomid = _cursor.getColumnIndexOrThrow("RoomId");
      final int _cursorIndexOfFprice = _cursor.getColumnIndexOrThrow("Price");
      final int _cursorIndexOfFroomtype = _cursor.getColumnIndexOrThrow("RoomType");
      final int _cursorIndexOfFtenanttype = _cursor.getColumnIndexOrThrow("TenantType");
      final int _cursorIndexOfFaddress = _cursor.getColumnIndexOrThrow("Address");
      final int _cursorIndexOfFcity = _cursor.getColumnIndexOrThrow("City");
      final int _cursorIndexOfFstate = _cursor.getColumnIndexOrThrow("State");
      final int _cursorIndexOfFimg = _cursor.getColumnIndexOrThrow("Image");
      final List<CustomerFavouriteModel> _result = new ArrayList<CustomerFavouriteModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CustomerFavouriteModel _item;
        _item = new CustomerFavouriteModel();
        _item.Favid = _cursor.getInt(_cursorIndexOfFavid);
        _item.froomid = _cursor.getInt(_cursorIndexOfFroomid);
        _item.fprice = _cursor.getInt(_cursorIndexOfFprice);
        _item.froomtype = _cursor.getString(_cursorIndexOfFroomtype);
        _item.ftenanttype = _cursor.getString(_cursorIndexOfFtenanttype);
        _item.faddress = _cursor.getString(_cursorIndexOfFaddress);
        _item.fcity = _cursor.getString(_cursorIndexOfFcity);
        _item.fstate = _cursor.getString(_cursorIndexOfFstate);
        _item.fimg = _cursor.getBlob(_cursorIndexOfFimg);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
