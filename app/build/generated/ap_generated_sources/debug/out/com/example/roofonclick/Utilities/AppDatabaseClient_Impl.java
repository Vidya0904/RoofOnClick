package com.example.roofonclick.Utilities;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.example.roofonclick.DAOs.CustomerHomeFavouriteModelDao;
import com.example.roofonclick.DAOs.CustomerHomeFavouriteModelDao_Impl;
import com.example.roofonclick.DAOs.CustomerHomeModelDao;
import com.example.roofonclick.DAOs.CustomerHomeModelDao_Impl;
import com.example.roofonclick.DAOs.CutomerHomeRequestModelDao;
import com.example.roofonclick.DAOs.CutomerHomeRequestModelDao_Impl;
import com.example.roofonclick.DAOs.UserModelDaos;
import com.example.roofonclick.DAOs.UserModelDaos_Impl;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public final class AppDatabaseClient_Impl extends AppDatabaseClient {
  private volatile UserModelDaos _userModelDaos;

  private volatile CustomerHomeModelDao _customerHomeModelDao;

  private volatile CutomerHomeRequestModelDao _cutomerHomeRequestModelDao;

  private volatile CustomerHomeFavouriteModelDao _customerHomeFavouriteModelDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `UserModel` (`ID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `Email` TEXT, `mobno` TEXT, `password` TEXT, `uName` TEXT, `uType` TEXT, `userImage` BLOB, `userAddress` TEXT, `userCity` TEXT, `userState` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `CustomerHomeModel` (`roomid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `OwnerId` INTEGER NOT NULL, `RoomType` TEXT, `TenantType` TEXT, `Address` TEXT, `Area` TEXT, `City` TEXT, `State` TEXT, `Image` BLOB, `Price` INTEGER NOT NULL, `Description` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `CustomerRequestModel` (`reqid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `OwnerId` INTEGER NOT NULL, `Customer Name` TEXT, `Room Type` TEXT, `Tenant Type` TEXT, `Date` TEXT, `reqImage` BLOB, `MobileNo` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `CustomerFavouriteModel` (`Favid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `RoomId` INTEGER NOT NULL, `Price` INTEGER NOT NULL, `RoomType` TEXT, `TenantType` TEXT, `Address` TEXT, `City` TEXT, `State` TEXT, `Image` BLOB)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"6ec742a37c5e7323eebf087b984ef464\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `UserModel`");
        _db.execSQL("DROP TABLE IF EXISTS `CustomerHomeModel`");
        _db.execSQL("DROP TABLE IF EXISTS `CustomerRequestModel`");
        _db.execSQL("DROP TABLE IF EXISTS `CustomerFavouriteModel`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsUserModel = new HashMap<String, TableInfo.Column>(10);
        _columnsUserModel.put("ID", new TableInfo.Column("ID", "INTEGER", true, 1));
        _columnsUserModel.put("Email", new TableInfo.Column("Email", "TEXT", false, 0));
        _columnsUserModel.put("mobno", new TableInfo.Column("mobno", "TEXT", false, 0));
        _columnsUserModel.put("password", new TableInfo.Column("password", "TEXT", false, 0));
        _columnsUserModel.put("uName", new TableInfo.Column("uName", "TEXT", false, 0));
        _columnsUserModel.put("uType", new TableInfo.Column("uType", "TEXT", false, 0));
        _columnsUserModel.put("userImage", new TableInfo.Column("userImage", "BLOB", false, 0));
        _columnsUserModel.put("userAddress", new TableInfo.Column("userAddress", "TEXT", false, 0));
        _columnsUserModel.put("userCity", new TableInfo.Column("userCity", "TEXT", false, 0));
        _columnsUserModel.put("userState", new TableInfo.Column("userState", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUserModel = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUserModel = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUserModel = new TableInfo("UserModel", _columnsUserModel, _foreignKeysUserModel, _indicesUserModel);
        final TableInfo _existingUserModel = TableInfo.read(_db, "UserModel");
        if (! _infoUserModel.equals(_existingUserModel)) {
          throw new IllegalStateException("Migration didn't properly handle UserModel(com.example.roofonclick.DataModels.UserModel).\n"
                  + " Expected:\n" + _infoUserModel + "\n"
                  + " Found:\n" + _existingUserModel);
        }
        final HashMap<String, TableInfo.Column> _columnsCustomerHomeModel = new HashMap<String, TableInfo.Column>(11);
        _columnsCustomerHomeModel.put("roomid", new TableInfo.Column("roomid", "INTEGER", true, 1));
        _columnsCustomerHomeModel.put("OwnerId", new TableInfo.Column("OwnerId", "INTEGER", true, 0));
        _columnsCustomerHomeModel.put("RoomType", new TableInfo.Column("RoomType", "TEXT", false, 0));
        _columnsCustomerHomeModel.put("TenantType", new TableInfo.Column("TenantType", "TEXT", false, 0));
        _columnsCustomerHomeModel.put("Address", new TableInfo.Column("Address", "TEXT", false, 0));
        _columnsCustomerHomeModel.put("Area", new TableInfo.Column("Area", "TEXT", false, 0));
        _columnsCustomerHomeModel.put("City", new TableInfo.Column("City", "TEXT", false, 0));
        _columnsCustomerHomeModel.put("State", new TableInfo.Column("State", "TEXT", false, 0));
        _columnsCustomerHomeModel.put("Image", new TableInfo.Column("Image", "BLOB", false, 0));
        _columnsCustomerHomeModel.put("Price", new TableInfo.Column("Price", "INTEGER", true, 0));
        _columnsCustomerHomeModel.put("Description", new TableInfo.Column("Description", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCustomerHomeModel = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCustomerHomeModel = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCustomerHomeModel = new TableInfo("CustomerHomeModel", _columnsCustomerHomeModel, _foreignKeysCustomerHomeModel, _indicesCustomerHomeModel);
        final TableInfo _existingCustomerHomeModel = TableInfo.read(_db, "CustomerHomeModel");
        if (! _infoCustomerHomeModel.equals(_existingCustomerHomeModel)) {
          throw new IllegalStateException("Migration didn't properly handle CustomerHomeModel(com.example.roofonclick.DataModels.CustomerHomeModel).\n"
                  + " Expected:\n" + _infoCustomerHomeModel + "\n"
                  + " Found:\n" + _existingCustomerHomeModel);
        }
        final HashMap<String, TableInfo.Column> _columnsCustomerRequestModel = new HashMap<String, TableInfo.Column>(8);
        _columnsCustomerRequestModel.put("reqid", new TableInfo.Column("reqid", "INTEGER", true, 1));
        _columnsCustomerRequestModel.put("OwnerId", new TableInfo.Column("OwnerId", "INTEGER", true, 0));
        _columnsCustomerRequestModel.put("Customer Name", new TableInfo.Column("Customer Name", "TEXT", false, 0));
        _columnsCustomerRequestModel.put("Room Type", new TableInfo.Column("Room Type", "TEXT", false, 0));
        _columnsCustomerRequestModel.put("Tenant Type", new TableInfo.Column("Tenant Type", "TEXT", false, 0));
        _columnsCustomerRequestModel.put("Date", new TableInfo.Column("Date", "TEXT", false, 0));
        _columnsCustomerRequestModel.put("reqImage", new TableInfo.Column("reqImage", "BLOB", false, 0));
        _columnsCustomerRequestModel.put("MobileNo", new TableInfo.Column("MobileNo", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCustomerRequestModel = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCustomerRequestModel = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCustomerRequestModel = new TableInfo("CustomerRequestModel", _columnsCustomerRequestModel, _foreignKeysCustomerRequestModel, _indicesCustomerRequestModel);
        final TableInfo _existingCustomerRequestModel = TableInfo.read(_db, "CustomerRequestModel");
        if (! _infoCustomerRequestModel.equals(_existingCustomerRequestModel)) {
          throw new IllegalStateException("Migration didn't properly handle CustomerRequestModel(com.example.roofonclick.DataModels.CustomerRequestModel).\n"
                  + " Expected:\n" + _infoCustomerRequestModel + "\n"
                  + " Found:\n" + _existingCustomerRequestModel);
        }
        final HashMap<String, TableInfo.Column> _columnsCustomerFavouriteModel = new HashMap<String, TableInfo.Column>(9);
        _columnsCustomerFavouriteModel.put("Favid", new TableInfo.Column("Favid", "INTEGER", true, 1));
        _columnsCustomerFavouriteModel.put("RoomId", new TableInfo.Column("RoomId", "INTEGER", true, 0));
        _columnsCustomerFavouriteModel.put("Price", new TableInfo.Column("Price", "INTEGER", true, 0));
        _columnsCustomerFavouriteModel.put("RoomType", new TableInfo.Column("RoomType", "TEXT", false, 0));
        _columnsCustomerFavouriteModel.put("TenantType", new TableInfo.Column("TenantType", "TEXT", false, 0));
        _columnsCustomerFavouriteModel.put("Address", new TableInfo.Column("Address", "TEXT", false, 0));
        _columnsCustomerFavouriteModel.put("City", new TableInfo.Column("City", "TEXT", false, 0));
        _columnsCustomerFavouriteModel.put("State", new TableInfo.Column("State", "TEXT", false, 0));
        _columnsCustomerFavouriteModel.put("Image", new TableInfo.Column("Image", "BLOB", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCustomerFavouriteModel = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCustomerFavouriteModel = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCustomerFavouriteModel = new TableInfo("CustomerFavouriteModel", _columnsCustomerFavouriteModel, _foreignKeysCustomerFavouriteModel, _indicesCustomerFavouriteModel);
        final TableInfo _existingCustomerFavouriteModel = TableInfo.read(_db, "CustomerFavouriteModel");
        if (! _infoCustomerFavouriteModel.equals(_existingCustomerFavouriteModel)) {
          throw new IllegalStateException("Migration didn't properly handle CustomerFavouriteModel(com.example.roofonclick.DataModels.CustomerFavouriteModel).\n"
                  + " Expected:\n" + _infoCustomerFavouriteModel + "\n"
                  + " Found:\n" + _existingCustomerFavouriteModel);
        }
      }
    }, "6ec742a37c5e7323eebf087b984ef464", "483d1c6d983126feb0946ba24af4a07a");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "UserModel","CustomerHomeModel","CustomerRequestModel","CustomerFavouriteModel");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `UserModel`");
      _db.execSQL("DELETE FROM `CustomerHomeModel`");
      _db.execSQL("DELETE FROM `CustomerRequestModel`");
      _db.execSQL("DELETE FROM `CustomerFavouriteModel`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public UserModelDaos userDaos() {
    if (_userModelDaos != null) {
      return _userModelDaos;
    } else {
      synchronized(this) {
        if(_userModelDaos == null) {
          _userModelDaos = new UserModelDaos_Impl(this);
        }
        return _userModelDaos;
      }
    }
  }

  @Override
  public CustomerHomeModelDao customerHomeModelDao() {
    if (_customerHomeModelDao != null) {
      return _customerHomeModelDao;
    } else {
      synchronized(this) {
        if(_customerHomeModelDao == null) {
          _customerHomeModelDao = new CustomerHomeModelDao_Impl(this);
        }
        return _customerHomeModelDao;
      }
    }
  }

  @Override
  public CutomerHomeRequestModelDao customerHomeRequestModelDao() {
    if (_cutomerHomeRequestModelDao != null) {
      return _cutomerHomeRequestModelDao;
    } else {
      synchronized(this) {
        if(_cutomerHomeRequestModelDao == null) {
          _cutomerHomeRequestModelDao = new CutomerHomeRequestModelDao_Impl(this);
        }
        return _cutomerHomeRequestModelDao;
      }
    }
  }

  @Override
  public CustomerHomeFavouriteModelDao customerHomeFavouriteModelDao() {
    if (_customerHomeFavouriteModelDao != null) {
      return _customerHomeFavouriteModelDao;
    } else {
      synchronized(this) {
        if(_customerHomeFavouriteModelDao == null) {
          _customerHomeFavouriteModelDao = new CustomerHomeFavouriteModelDao_Impl(this);
        }
        return _customerHomeFavouriteModelDao;
      }
    }
  }
}
