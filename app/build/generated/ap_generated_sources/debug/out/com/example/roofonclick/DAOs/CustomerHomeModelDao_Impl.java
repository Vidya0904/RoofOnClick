package com.example.roofonclick.DAOs;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.roofonclick.DataModels.CustomerHomeModel;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class CustomerHomeModelDao_Impl implements CustomerHomeModelDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfCustomerHomeModel;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfCustomerHomeModel;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfCustomerHomeModel;

  public CustomerHomeModelDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCustomerHomeModel = new EntityInsertionAdapter<CustomerHomeModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `CustomerHomeModel`(`roomid`,`OwnerId`,`RoomType`,`TenantType`,`Address`,`Area`,`City`,`State`,`Image`,`Price`,`Description`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CustomerHomeModel value) {
        stmt.bindLong(1, value.roomid);
        stmt.bindLong(2, value.ownerid);
        if (value.roomtype == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.roomtype);
        }
        if (value.tenanttype == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.tenanttype);
        }
        if (value.address == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.address);
        }
        if (value.area == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.area);
        }
        if (value.city == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.city);
        }
        if (value.state == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.state);
        }
        if (value.img == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindBlob(9, value.img);
        }
        stmt.bindLong(10, value.price);
        if (value.descr == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.descr);
        }
      }
    };
    this.__deletionAdapterOfCustomerHomeModel = new EntityDeletionOrUpdateAdapter<CustomerHomeModel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `CustomerHomeModel` WHERE `roomid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CustomerHomeModel value) {
        stmt.bindLong(1, value.roomid);
      }
    };
    this.__updateAdapterOfCustomerHomeModel = new EntityDeletionOrUpdateAdapter<CustomerHomeModel>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `CustomerHomeModel` SET `roomid` = ?,`OwnerId` = ?,`RoomType` = ?,`TenantType` = ?,`Address` = ?,`Area` = ?,`City` = ?,`State` = ?,`Image` = ?,`Price` = ?,`Description` = ? WHERE `roomid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CustomerHomeModel value) {
        stmt.bindLong(1, value.roomid);
        stmt.bindLong(2, value.ownerid);
        if (value.roomtype == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.roomtype);
        }
        if (value.tenanttype == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.tenanttype);
        }
        if (value.address == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.address);
        }
        if (value.area == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.area);
        }
        if (value.city == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.city);
        }
        if (value.state == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.state);
        }
        if (value.img == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindBlob(9, value.img);
        }
        stmt.bindLong(10, value.price);
        if (value.descr == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.descr);
        }
        stmt.bindLong(12, value.roomid);
      }
    };
  }

  @Override
  public long insetCustomerHomeModel(CustomerHomeModel chm) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfCustomerHomeModel.insertAndReturnId(chm);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteCustomerHomeModel(CustomerHomeModel chm) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfCustomerHomeModel.handle(chm);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateCustomerHomeModel(CustomerHomeModel chm) {
    __db.beginTransaction();
    try {
      __updateAdapterOfCustomerHomeModel.handle(chm);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<CustomerHomeModel> getAllRooms() {
    final String _sql = "SELECT * FROM CustomerHomeModel";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfRoomid = _cursor.getColumnIndexOrThrow("roomid");
      final int _cursorIndexOfOwnerid = _cursor.getColumnIndexOrThrow("OwnerId");
      final int _cursorIndexOfRoomtype = _cursor.getColumnIndexOrThrow("RoomType");
      final int _cursorIndexOfTenanttype = _cursor.getColumnIndexOrThrow("TenantType");
      final int _cursorIndexOfAddress = _cursor.getColumnIndexOrThrow("Address");
      final int _cursorIndexOfArea = _cursor.getColumnIndexOrThrow("Area");
      final int _cursorIndexOfCity = _cursor.getColumnIndexOrThrow("City");
      final int _cursorIndexOfState = _cursor.getColumnIndexOrThrow("State");
      final int _cursorIndexOfImg = _cursor.getColumnIndexOrThrow("Image");
      final int _cursorIndexOfPrice = _cursor.getColumnIndexOrThrow("Price");
      final int _cursorIndexOfDescr = _cursor.getColumnIndexOrThrow("Description");
      final List<CustomerHomeModel> _result = new ArrayList<CustomerHomeModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CustomerHomeModel _item;
        _item = new CustomerHomeModel();
        _item.roomid = _cursor.getInt(_cursorIndexOfRoomid);
        _item.ownerid = _cursor.getInt(_cursorIndexOfOwnerid);
        _item.roomtype = _cursor.getString(_cursorIndexOfRoomtype);
        _item.tenanttype = _cursor.getString(_cursorIndexOfTenanttype);
        _item.address = _cursor.getString(_cursorIndexOfAddress);
        _item.area = _cursor.getString(_cursorIndexOfArea);
        _item.city = _cursor.getString(_cursorIndexOfCity);
        _item.state = _cursor.getString(_cursorIndexOfState);
        _item.img = _cursor.getBlob(_cursorIndexOfImg);
        _item.price = _cursor.getInt(_cursorIndexOfPrice);
        _item.descr = _cursor.getString(_cursorIndexOfDescr);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public CustomerHomeModel getRoomById(long roomid) {
    final String _sql = "Select * from CustomerHomeModel WHERE RoomId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, roomid);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfRoomid = _cursor.getColumnIndexOrThrow("roomid");
      final int _cursorIndexOfOwnerid = _cursor.getColumnIndexOrThrow("OwnerId");
      final int _cursorIndexOfRoomtype = _cursor.getColumnIndexOrThrow("RoomType");
      final int _cursorIndexOfTenanttype = _cursor.getColumnIndexOrThrow("TenantType");
      final int _cursorIndexOfAddress = _cursor.getColumnIndexOrThrow("Address");
      final int _cursorIndexOfArea = _cursor.getColumnIndexOrThrow("Area");
      final int _cursorIndexOfCity = _cursor.getColumnIndexOrThrow("City");
      final int _cursorIndexOfState = _cursor.getColumnIndexOrThrow("State");
      final int _cursorIndexOfImg = _cursor.getColumnIndexOrThrow("Image");
      final int _cursorIndexOfPrice = _cursor.getColumnIndexOrThrow("Price");
      final int _cursorIndexOfDescr = _cursor.getColumnIndexOrThrow("Description");
      final CustomerHomeModel _result;
      if(_cursor.moveToFirst()) {
        _result = new CustomerHomeModel();
        _result.roomid = _cursor.getInt(_cursorIndexOfRoomid);
        _result.ownerid = _cursor.getInt(_cursorIndexOfOwnerid);
        _result.roomtype = _cursor.getString(_cursorIndexOfRoomtype);
        _result.tenanttype = _cursor.getString(_cursorIndexOfTenanttype);
        _result.address = _cursor.getString(_cursorIndexOfAddress);
        _result.area = _cursor.getString(_cursorIndexOfArea);
        _result.city = _cursor.getString(_cursorIndexOfCity);
        _result.state = _cursor.getString(_cursorIndexOfState);
        _result.img = _cursor.getBlob(_cursorIndexOfImg);
        _result.price = _cursor.getInt(_cursorIndexOfPrice);
        _result.descr = _cursor.getString(_cursorIndexOfDescr);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
