package com.example.roofonclick.DAOs;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.roofonclick.DataModels.CustomerRequestModel;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class CutomerHomeRequestModelDao_Impl implements CutomerHomeRequestModelDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfCustomerRequestModel;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfCustomerRequestModel;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfCustomerRequestModel;

  public CutomerHomeRequestModelDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCustomerRequestModel = new EntityInsertionAdapter<CustomerRequestModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `CustomerRequestModel`(`reqid`,`OwnerId`,`Customer Name`,`Room Type`,`Tenant Type`,`Date`,`reqImage`,`MobileNo`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CustomerRequestModel value) {
        stmt.bindLong(1, value.reqid);
        stmt.bindLong(2, value.ownerid);
        if (value.reqcustname == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.reqcustname);
        }
        if (value.reqroomtype == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.reqroomtype);
        }
        if (value.reqtenanttype == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.reqtenanttype);
        }
        if (value.reqdate == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.reqdate);
        }
        if (value.reqImage == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindBlob(7, value.reqImage);
        }
        if (value.reqMobNo == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.reqMobNo);
        }
      }
    };
    this.__deletionAdapterOfCustomerRequestModel = new EntityDeletionOrUpdateAdapter<CustomerRequestModel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `CustomerRequestModel` WHERE `reqid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CustomerRequestModel value) {
        stmt.bindLong(1, value.reqid);
      }
    };
    this.__updateAdapterOfCustomerRequestModel = new EntityDeletionOrUpdateAdapter<CustomerRequestModel>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `CustomerRequestModel` SET `reqid` = ?,`OwnerId` = ?,`Customer Name` = ?,`Room Type` = ?,`Tenant Type` = ?,`Date` = ?,`reqImage` = ?,`MobileNo` = ? WHERE `reqid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CustomerRequestModel value) {
        stmt.bindLong(1, value.reqid);
        stmt.bindLong(2, value.ownerid);
        if (value.reqcustname == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.reqcustname);
        }
        if (value.reqroomtype == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.reqroomtype);
        }
        if (value.reqtenanttype == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.reqtenanttype);
        }
        if (value.reqdate == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.reqdate);
        }
        if (value.reqImage == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindBlob(7, value.reqImage);
        }
        if (value.reqMobNo == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.reqMobNo);
        }
        stmt.bindLong(9, value.reqid);
      }
    };
  }

  @Override
  public long insetCustomerHomeRequestModel(CustomerRequestModel chrm) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfCustomerRequestModel.insertAndReturnId(chrm);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteCustomerHomeRequestModel(CustomerRequestModel chrm) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfCustomerRequestModel.handle(chrm);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateCustomerHomeRequestModel(CustomerRequestModel chrm) {
    __db.beginTransaction();
    try {
      __updateAdapterOfCustomerRequestModel.handle(chrm);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<CustomerRequestModel> getAllRequest() {
    final String _sql = "SELECT * FROM CustomerRequestModel";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfReqid = _cursor.getColumnIndexOrThrow("reqid");
      final int _cursorIndexOfOwnerid = _cursor.getColumnIndexOrThrow("OwnerId");
      final int _cursorIndexOfReqcustname = _cursor.getColumnIndexOrThrow("Customer Name");
      final int _cursorIndexOfReqroomtype = _cursor.getColumnIndexOrThrow("Room Type");
      final int _cursorIndexOfReqtenanttype = _cursor.getColumnIndexOrThrow("Tenant Type");
      final int _cursorIndexOfReqdate = _cursor.getColumnIndexOrThrow("Date");
      final int _cursorIndexOfReqImage = _cursor.getColumnIndexOrThrow("reqImage");
      final int _cursorIndexOfReqMobNo = _cursor.getColumnIndexOrThrow("MobileNo");
      final List<CustomerRequestModel> _result = new ArrayList<CustomerRequestModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CustomerRequestModel _item;
        _item = new CustomerRequestModel();
        _item.reqid = _cursor.getInt(_cursorIndexOfReqid);
        _item.ownerid = _cursor.getInt(_cursorIndexOfOwnerid);
        _item.reqcustname = _cursor.getString(_cursorIndexOfReqcustname);
        _item.reqroomtype = _cursor.getString(_cursorIndexOfReqroomtype);
        _item.reqtenanttype = _cursor.getString(_cursorIndexOfReqtenanttype);
        _item.reqdate = _cursor.getString(_cursorIndexOfReqdate);
        _item.reqImage = _cursor.getBlob(_cursorIndexOfReqImage);
        _item.reqMobNo = _cursor.getString(_cursorIndexOfReqMobNo);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<CustomerRequestModel> getAllRequestByOwnerId(int ownerId) {
    final String _sql = "SELECT * FROM CustomerRequestModel WHERE OwnerId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, ownerId);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfReqid = _cursor.getColumnIndexOrThrow("reqid");
      final int _cursorIndexOfOwnerid = _cursor.getColumnIndexOrThrow("OwnerId");
      final int _cursorIndexOfReqcustname = _cursor.getColumnIndexOrThrow("Customer Name");
      final int _cursorIndexOfReqroomtype = _cursor.getColumnIndexOrThrow("Room Type");
      final int _cursorIndexOfReqtenanttype = _cursor.getColumnIndexOrThrow("Tenant Type");
      final int _cursorIndexOfReqdate = _cursor.getColumnIndexOrThrow("Date");
      final int _cursorIndexOfReqImage = _cursor.getColumnIndexOrThrow("reqImage");
      final int _cursorIndexOfReqMobNo = _cursor.getColumnIndexOrThrow("MobileNo");
      final List<CustomerRequestModel> _result = new ArrayList<CustomerRequestModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CustomerRequestModel _item;
        _item = new CustomerRequestModel();
        _item.reqid = _cursor.getInt(_cursorIndexOfReqid);
        _item.ownerid = _cursor.getInt(_cursorIndexOfOwnerid);
        _item.reqcustname = _cursor.getString(_cursorIndexOfReqcustname);
        _item.reqroomtype = _cursor.getString(_cursorIndexOfReqroomtype);
        _item.reqtenanttype = _cursor.getString(_cursorIndexOfReqtenanttype);
        _item.reqdate = _cursor.getString(_cursorIndexOfReqdate);
        _item.reqImage = _cursor.getBlob(_cursorIndexOfReqImage);
        _item.reqMobNo = _cursor.getString(_cursorIndexOfReqMobNo);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
