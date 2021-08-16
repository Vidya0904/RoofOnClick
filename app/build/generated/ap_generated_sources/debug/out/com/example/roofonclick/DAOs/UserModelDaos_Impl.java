package com.example.roofonclick.DAOs;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.roofonclick.DataModels.UserModel;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class UserModelDaos_Impl implements UserModelDaos {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfUserModel;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfUserModel;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfUserModel;

  public UserModelDaos_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUserModel = new EntityInsertionAdapter<UserModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `UserModel`(`ID`,`Email`,`mobno`,`password`,`uName`,`uType`,`userImage`,`userAddress`,`userCity`,`userState`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UserModel value) {
        stmt.bindLong(1, value.getID());
        if (value.getEmail() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getEmail());
        }
        if (value.getMobno() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getMobno());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPassword());
        }
        if (value.getUsername() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getUsername());
        }
        if (value.getUsertype() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getUsertype());
        }
        if (value.getUserImage() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindBlob(7, value.getUserImage());
        }
        if (value.getUserAddress() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getUserAddress());
        }
        if (value.getUserCity() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getUserCity());
        }
        if (value.getUserState() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getUserState());
        }
      }
    };
    this.__deletionAdapterOfUserModel = new EntityDeletionOrUpdateAdapter<UserModel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `UserModel` WHERE `ID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UserModel value) {
        stmt.bindLong(1, value.getID());
      }
    };
    this.__updateAdapterOfUserModel = new EntityDeletionOrUpdateAdapter<UserModel>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `UserModel` SET `ID` = ?,`Email` = ?,`mobno` = ?,`password` = ?,`uName` = ?,`uType` = ?,`userImage` = ?,`userAddress` = ?,`userCity` = ?,`userState` = ? WHERE `ID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UserModel value) {
        stmt.bindLong(1, value.getID());
        if (value.getEmail() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getEmail());
        }
        if (value.getMobno() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getMobno());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPassword());
        }
        if (value.getUsername() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getUsername());
        }
        if (value.getUsertype() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getUsertype());
        }
        if (value.getUserImage() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindBlob(7, value.getUserImage());
        }
        if (value.getUserAddress() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getUserAddress());
        }
        if (value.getUserCity() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getUserCity());
        }
        if (value.getUserState() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getUserState());
        }
        stmt.bindLong(11, value.getID());
      }
    };
  }

  @Override
  public long insertUserModel(UserModel U) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfUserModel.insertAndReturnId(U);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteUserModel(UserModel U) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfUserModel.handle(U);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateUserModel(UserModel U) {
    __db.beginTransaction();
    try {
      __updateAdapterOfUserModel.handle(U);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<UserModel> getAllUsers() {
    final String _sql = "SELECT * FROM UserModel";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfID = _cursor.getColumnIndexOrThrow("ID");
      final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("Email");
      final int _cursorIndexOfMobno = _cursor.getColumnIndexOrThrow("mobno");
      final int _cursorIndexOfPassword = _cursor.getColumnIndexOrThrow("password");
      final int _cursorIndexOfUsername = _cursor.getColumnIndexOrThrow("uName");
      final int _cursorIndexOfUsertype = _cursor.getColumnIndexOrThrow("uType");
      final int _cursorIndexOfUserImage = _cursor.getColumnIndexOrThrow("userImage");
      final int _cursorIndexOfUserAddress = _cursor.getColumnIndexOrThrow("userAddress");
      final int _cursorIndexOfUserCity = _cursor.getColumnIndexOrThrow("userCity");
      final int _cursorIndexOfUserState = _cursor.getColumnIndexOrThrow("userState");
      final List<UserModel> _result = new ArrayList<UserModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final UserModel _item;
        _item = new UserModel();
        final int _tmpID;
        _tmpID = _cursor.getInt(_cursorIndexOfID);
        _item.setID(_tmpID);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        _item.setEmail(_tmpEmail);
        final String _tmpMobno;
        _tmpMobno = _cursor.getString(_cursorIndexOfMobno);
        _item.setMobno(_tmpMobno);
        final String _tmpPassword;
        _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        _item.setPassword(_tmpPassword);
        final String _tmpUsername;
        _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        _item.setUsername(_tmpUsername);
        final String _tmpUsertype;
        _tmpUsertype = _cursor.getString(_cursorIndexOfUsertype);
        _item.setUsertype(_tmpUsertype);
        final byte[] _tmpUserImage;
        _tmpUserImage = _cursor.getBlob(_cursorIndexOfUserImage);
        _item.setUserImage(_tmpUserImage);
        final String _tmpUserAddress;
        _tmpUserAddress = _cursor.getString(_cursorIndexOfUserAddress);
        _item.setUserAddress(_tmpUserAddress);
        final String _tmpUserCity;
        _tmpUserCity = _cursor.getString(_cursorIndexOfUserCity);
        _item.setUserCity(_tmpUserCity);
        final String _tmpUserState;
        _tmpUserState = _cursor.getString(_cursorIndexOfUserState);
        _item.setUserState(_tmpUserState);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public UserModel userLogin(String email, String pass) {
    final String _sql = "Select * from UserModel WHERE Email=? and password=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (email == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, email);
    }
    _argIndex = 2;
    if (pass == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, pass);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfID = _cursor.getColumnIndexOrThrow("ID");
      final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("Email");
      final int _cursorIndexOfMobno = _cursor.getColumnIndexOrThrow("mobno");
      final int _cursorIndexOfPassword = _cursor.getColumnIndexOrThrow("password");
      final int _cursorIndexOfUsername = _cursor.getColumnIndexOrThrow("uName");
      final int _cursorIndexOfUsertype = _cursor.getColumnIndexOrThrow("uType");
      final int _cursorIndexOfUserImage = _cursor.getColumnIndexOrThrow("userImage");
      final int _cursorIndexOfUserAddress = _cursor.getColumnIndexOrThrow("userAddress");
      final int _cursorIndexOfUserCity = _cursor.getColumnIndexOrThrow("userCity");
      final int _cursorIndexOfUserState = _cursor.getColumnIndexOrThrow("userState");
      final UserModel _result;
      if(_cursor.moveToFirst()) {
        _result = new UserModel();
        final int _tmpID;
        _tmpID = _cursor.getInt(_cursorIndexOfID);
        _result.setID(_tmpID);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        _result.setEmail(_tmpEmail);
        final String _tmpMobno;
        _tmpMobno = _cursor.getString(_cursorIndexOfMobno);
        _result.setMobno(_tmpMobno);
        final String _tmpPassword;
        _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        _result.setPassword(_tmpPassword);
        final String _tmpUsername;
        _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        _result.setUsername(_tmpUsername);
        final String _tmpUsertype;
        _tmpUsertype = _cursor.getString(_cursorIndexOfUsertype);
        _result.setUsertype(_tmpUsertype);
        final byte[] _tmpUserImage;
        _tmpUserImage = _cursor.getBlob(_cursorIndexOfUserImage);
        _result.setUserImage(_tmpUserImage);
        final String _tmpUserAddress;
        _tmpUserAddress = _cursor.getString(_cursorIndexOfUserAddress);
        _result.setUserAddress(_tmpUserAddress);
        final String _tmpUserCity;
        _tmpUserCity = _cursor.getString(_cursorIndexOfUserCity);
        _result.setUserCity(_tmpUserCity);
        final String _tmpUserState;
        _tmpUserState = _cursor.getString(_cursorIndexOfUserState);
        _result.setUserState(_tmpUserState);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<UserModel> getAllUserByType(String uType) {
    final String _sql = "Select * from UserModel WHERE uType=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (uType == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uType);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfID = _cursor.getColumnIndexOrThrow("ID");
      final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("Email");
      final int _cursorIndexOfMobno = _cursor.getColumnIndexOrThrow("mobno");
      final int _cursorIndexOfPassword = _cursor.getColumnIndexOrThrow("password");
      final int _cursorIndexOfUsername = _cursor.getColumnIndexOrThrow("uName");
      final int _cursorIndexOfUsertype = _cursor.getColumnIndexOrThrow("uType");
      final int _cursorIndexOfUserImage = _cursor.getColumnIndexOrThrow("userImage");
      final int _cursorIndexOfUserAddress = _cursor.getColumnIndexOrThrow("userAddress");
      final int _cursorIndexOfUserCity = _cursor.getColumnIndexOrThrow("userCity");
      final int _cursorIndexOfUserState = _cursor.getColumnIndexOrThrow("userState");
      final List<UserModel> _result = new ArrayList<UserModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final UserModel _item;
        _item = new UserModel();
        final int _tmpID;
        _tmpID = _cursor.getInt(_cursorIndexOfID);
        _item.setID(_tmpID);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        _item.setEmail(_tmpEmail);
        final String _tmpMobno;
        _tmpMobno = _cursor.getString(_cursorIndexOfMobno);
        _item.setMobno(_tmpMobno);
        final String _tmpPassword;
        _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        _item.setPassword(_tmpPassword);
        final String _tmpUsername;
        _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        _item.setUsername(_tmpUsername);
        final String _tmpUsertype;
        _tmpUsertype = _cursor.getString(_cursorIndexOfUsertype);
        _item.setUsertype(_tmpUsertype);
        final byte[] _tmpUserImage;
        _tmpUserImage = _cursor.getBlob(_cursorIndexOfUserImage);
        _item.setUserImage(_tmpUserImage);
        final String _tmpUserAddress;
        _tmpUserAddress = _cursor.getString(_cursorIndexOfUserAddress);
        _item.setUserAddress(_tmpUserAddress);
        final String _tmpUserCity;
        _tmpUserCity = _cursor.getString(_cursorIndexOfUserCity);
        _item.setUserCity(_tmpUserCity);
        final String _tmpUserState;
        _tmpUserState = _cursor.getString(_cursorIndexOfUserState);
        _item.setUserState(_tmpUserState);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public UserModel getUserByEmail(String proemail) {
    final String _sql = "Select * from UserModel WHERE Email=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (proemail == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, proemail);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfID = _cursor.getColumnIndexOrThrow("ID");
      final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("Email");
      final int _cursorIndexOfMobno = _cursor.getColumnIndexOrThrow("mobno");
      final int _cursorIndexOfPassword = _cursor.getColumnIndexOrThrow("password");
      final int _cursorIndexOfUsername = _cursor.getColumnIndexOrThrow("uName");
      final int _cursorIndexOfUsertype = _cursor.getColumnIndexOrThrow("uType");
      final int _cursorIndexOfUserImage = _cursor.getColumnIndexOrThrow("userImage");
      final int _cursorIndexOfUserAddress = _cursor.getColumnIndexOrThrow("userAddress");
      final int _cursorIndexOfUserCity = _cursor.getColumnIndexOrThrow("userCity");
      final int _cursorIndexOfUserState = _cursor.getColumnIndexOrThrow("userState");
      final UserModel _result;
      if(_cursor.moveToFirst()) {
        _result = new UserModel();
        final int _tmpID;
        _tmpID = _cursor.getInt(_cursorIndexOfID);
        _result.setID(_tmpID);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        _result.setEmail(_tmpEmail);
        final String _tmpMobno;
        _tmpMobno = _cursor.getString(_cursorIndexOfMobno);
        _result.setMobno(_tmpMobno);
        final String _tmpPassword;
        _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        _result.setPassword(_tmpPassword);
        final String _tmpUsername;
        _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        _result.setUsername(_tmpUsername);
        final String _tmpUsertype;
        _tmpUsertype = _cursor.getString(_cursorIndexOfUsertype);
        _result.setUsertype(_tmpUsertype);
        final byte[] _tmpUserImage;
        _tmpUserImage = _cursor.getBlob(_cursorIndexOfUserImage);
        _result.setUserImage(_tmpUserImage);
        final String _tmpUserAddress;
        _tmpUserAddress = _cursor.getString(_cursorIndexOfUserAddress);
        _result.setUserAddress(_tmpUserAddress);
        final String _tmpUserCity;
        _tmpUserCity = _cursor.getString(_cursorIndexOfUserCity);
        _result.setUserCity(_tmpUserCity);
        final String _tmpUserState;
        _tmpUserState = _cursor.getString(_cursorIndexOfUserState);
        _result.setUserState(_tmpUserState);
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
