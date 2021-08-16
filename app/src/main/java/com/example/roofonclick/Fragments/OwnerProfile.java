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
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.example.roofonclick.DataModels.UserModel;
import com.example.roofonclick.R;
import com.example.roofonclick.Utilities.CustomerHomeUtility;
import com.example.roofonclick.Utilities.DatabaseClient;
import com.example.roofonclick.Utilities.EmailMobileValidator;
import com.example.roofonclick.Utilities.Shared_Preference_Manager;

import de.hdodenhof.circleimageview.CircleImageView;

public class OwnerProfile extends Fragment implements View.OnClickListener {
    private Context ownprofilecon;
    TextView txtownproname, txtownproemail, txtownpromobile, txtownproaddress, txtownprocity, txtownprostate;
    Button btnownprofileupdate;
    EmailMobileValidator ownproemailmbvalidator;
    private CircleImageView profileimage;
    private int PICK_IMAGE = 25;
    private Bitmap imgbit;
    BitmapFactory.Options options;
    UserModel um;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.ownprofilecon = context;
        ownproemailmbvalidator = new EmailMobileValidator();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.owner_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        ActivityCompat.requestPermissions(getActivity(),
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA},44);

        CircleImageView imgprofile = view.findViewById(R.id.profile_image);


        um = DatabaseClient.getInstance(ownprofilecon)
                .getAppDatabaseClient().userDaos()
                .getUserByEmail(Shared_Preference_Manager.getUser_Email(ownprofilecon));

        imgprofile.setImageBitmap(CustomerHomeUtility.imgConvertFromByteArrayToBitmap(um.getUserImage()));

        txtownproname = view.findViewById(R.id.ownername);
        txtownproemail = view.findViewById(R.id.owneremail);
        txtownpromobile = view.findViewById(R.id.ownermobile);
        txtownproaddress = view.findViewById(R.id.owneraddress);
        txtownprocity = view.findViewById(R.id.ownercity);
        txtownprostate = view.findViewById(R.id.ownerstate);

        txtownproname.setText(um.getUsername());
        txtownproemail.setText(um.getEmail());
        txtownpromobile.setText(um.getMobno());
        txtownproaddress.setText(um.getUserAddress());
        txtownprocity.setText(um.getUserCity());
        txtownprostate.setText(um.getUserState());

        btnownprofileupdate = view.findViewById(R.id.ownerupdatebtn);

        btnownprofileupdate.setOnClickListener(this);

        profileimage = view.findViewById(R.id.profile_image);
        profileimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (v.getId() == profileimage.getId())
                {
                    Intent pickphoto = new Intent(Intent.ACTION_PICK,
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(pickphoto,PICK_IMAGE);
                }

            }
        });
    }

    @Override
    public void onClick(View v) {

        if (v.getId()==btnownprofileupdate.getId()){

        final View ownerprofiledialog = getLayoutInflater()
                .inflate(R.layout.owner_profile_dialog_layout, null);

        final EditText ownedttxtdialogname = ownerprofiledialog.findViewById(R.id.ownerprofileName);
        final EditText ownedttxtdialogmobile = ownerprofiledialog.findViewById(R.id.ownerprofileMobileno);
        final EditText ownedttxtdialogaddress = ownerprofiledialog.findViewById(R.id.ownerprofileaddress);
        final EditText ownedttxtdialogcity = ownerprofiledialog.findViewById(R.id.ownerprofilecity);
        final EditText ownedttxtdialogstate = ownerprofiledialog.findViewById(R.id.ownerprofilestate);

        AlertDialog.Builder builder = new AlertDialog.Builder(ownprofilecon);
        builder.setView(ownerprofiledialog);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if ( !TextUtils.isEmpty(ownedttxtdialogmobile.getText().toString())) {
                    if (ownproemailmbvalidator.mobvalidate(ownedttxtdialogmobile.getText().toString())) {

                        txtownproname.setText(ownedttxtdialogname.getText().toString());
                        txtownpromobile.setText(ownedttxtdialogmobile.getText().toString());
                        txtownproaddress.setText(ownedttxtdialogaddress.getText().toString());
                        txtownprocity.setText(ownedttxtdialogcity.getText().toString());
                        txtownprostate.setText(ownedttxtdialogstate.getText().toString());

                        um.setMobno(ownedttxtdialogmobile.getText().toString());
                        um.setUsername(ownedttxtdialogname.getText().toString());
                        um.setUserAddress(ownedttxtdialogaddress.getText().toString());
                        um.setUserCity(ownedttxtdialogcity.getText().toString());
                        um.setUserState(ownedttxtdialogstate.getText().toString());

                        DatabaseClient.getInstance(ownprofilecon)
                                .getAppDatabaseClient().userDaos()
                                .updateUserModel(um);
                        Toast.makeText(ownprofilecon, "Updated", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(ownprofilecon, "Enter Valid Email or Mobile", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ownprofilecon, "Please Enter Data", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.create().show();
        }

}
    @Override
    public void onActivityResult(int requestCode, int resultCode,@Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && data != null)
        {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            if (selectedImage != null)
            {
                Cursor cursor = ownprofilecon.getContentResolver().query(selectedImage, filePathColumn,
                        null, null,  null);
                if (cursor != null)
                {
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String picturePath = cursor.getString(columnIndex);
                    options = new BitmapFactory.Options();
                    options.inSampleSize = 2;
                    imgbit = BitmapFactory.decodeFile(picturePath,options);
                    profileimage.setImageBitmap(imgbit);
                    cursor.close();

                     }
            }

        }
    }



    @Override
    public void onDetach() {
        super.onDetach();
    }

   }
