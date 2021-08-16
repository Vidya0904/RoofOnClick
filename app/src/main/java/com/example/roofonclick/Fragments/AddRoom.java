package com.example.roofonclick.Fragments;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.example.roofonclick.Activities.Owner_Ativity;
import com.example.roofonclick.DataModels.CustomerHomeModel;
import com.example.roofonclick.R;
import com.example.roofonclick.Utilities.CustomerHomeUtility;
import com.example.roofonclick.Utilities.DatabaseClient;
import com.example.roofonclick.Utilities.Shared_Preference_Manager;
import com.google.android.material.textfield.TextInputEditText;

import java.security.PrivateKey;

public class AddRoom extends Fragment implements View.OnClickListener {
    private int PICK_IMAGE = 25;
    private ImageView imgshow;
    private Context ctx;
    private Bitmap imgBit;
    BitmapFactory.Options options;
    TextView txtselectImg, txtselectRtype, txtselectTtype;
    Button btnSave;
    EditText edtadd, edtarea, edtcity, edtstate, edtprice, edtdescription;
    String strroomtype, strtenanttype;
    String[] strarrRType, strarrTType;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.ctx = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.owner_addroom_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ActivityCompat.requestPermissions(getActivity(),
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA}, 44);

        strarrRType=ctx.getResources().getStringArray(R.array.RoomType);
        strarrTType=ctx.getResources().getStringArray(R.array.TenantType);

        imgshow = view.findViewById(R.id.roomimg);
        txtselectImg = view.findViewById(R.id.selecttxtimg);
        txtselectRtype = view.findViewById(R.id.selectRoomtype);
        txtselectTtype = view.findViewById(R.id.selectTtype);

        edtadd = view.findViewById(R.id.address);
        edtarea = view.findViewById(R.id.area);
        edtcity = view.findViewById(R.id.city);
        edtstate = view.findViewById(R.id.state);
        edtprice = view.findViewById(R.id.price);
        edtdescription = view.findViewById(R.id.description);

        btnSave = view.findViewById(R.id.savebtn);

        btnSave.setOnClickListener(this);
        txtselectImg.setOnClickListener(this);

        txtselectRtype.setOnClickListener(this);
        txtselectTtype.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == txtselectImg.getId()) {
            Intent pickphoto = new Intent(Intent.ACTION_PICK,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(pickphoto, PICK_IMAGE);
        }

        if (v.getId() == btnSave.getId()) {
            if (!TextUtils.isEmpty(edtadd.getText().toString())
                    && !TextUtils.isEmpty(edtarea.getText().toString())
                    && !TextUtils.isEmpty(edtcity.getText().toString())
                    && !TextUtils.isEmpty(edtstate.getText().toString())
                    && !TextUtils.isEmpty(edtprice.getText().toString())
                    && !TextUtils.isEmpty(edtdescription.getText().toString())) {
                CustomerHomeModel custhmmodel = new CustomerHomeModel();

                custhmmodel.setAddress(edtadd.getText().toString());
                custhmmodel.setArea(edtarea.getText().toString());
                custhmmodel.setCity(edtcity.getText().toString());
                custhmmodel.setState(edtstate.getText().toString());
                custhmmodel.setTenanttype(strtenanttype);
                custhmmodel.setRoomtype(strroomtype);
                custhmmodel.setPrice(CustomerHomeUtility.convertStringToInt(edtprice.getText().toString()));
                custhmmodel.setDescr(edtdescription.getText().toString());
                custhmmodel.setImg(CustomerHomeUtility.imgConvertFromBitmapToByteArray(imgBit));
                custhmmodel.setOwnerid(Shared_Preference_Manager.getUser_Id(ctx));

                DatabaseClient.getInstance(ctx).getAppDatabaseClient()
                        .customerHomeModelDao().insetCustomerHomeModel(custhmmodel);

                Toast.makeText(ctx, "Room Added", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(ctx, "Enter Valid Data", Toast.LENGTH_SHORT).show();
            }
        }

        if (v.getId() == txtselectRtype.getId())
        {
            final AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
            builder.setTitle("Room Type");
            builder.setSingleChoiceItems(strarrRType, 0, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    strroomtype = strarrRType[which];
                    txtselectRtype.setText("Room Type : " + strroomtype);
                }
            });

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        if (v.getId() == txtselectTtype.getId()) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
            builder.setTitle("Tenant Type");
            builder.setSingleChoiceItems(strarrTType, 0, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    strtenanttype = strarrTType[which];
                    txtselectTtype.setText("Tenant Type : " + strtenanttype);

                }
            });

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }

        @Override
        public void onActivityResult ( int requestCode, int resultCode, @Nullable Intent data)
        {
            if (requestCode == PICK_IMAGE) {
                Uri selectedImage = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                if (selectedImage != null) {
                    Cursor cursor = ctx.getContentResolver().query(selectedImage, filePathColumn,
                            null, null, null);
                    if (cursor != null) {
                        cursor.moveToFirst();

                        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                        String picturePath = cursor.getString(columnIndex);
                        options = new BitmapFactory.Options();
                        options.inSampleSize = 2;
                        imgBit = BitmapFactory.decodeFile(picturePath, options);
                        imgshow.setImageBitmap(imgBit);
                        cursor.close();
                    }
                }
            }
        }

        @Override
        public void onDetach() { super.onDetach(); }
}
