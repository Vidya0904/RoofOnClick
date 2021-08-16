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

import com.example.roofonclick.Activities.RegistrationActivity;
import com.example.roofonclick.DataModels.UserModel;
import com.example.roofonclick.R;
import com.example.roofonclick.Utilities.CustomerHomeUtility;
import com.example.roofonclick.Utilities.DatabaseClient;
import com.example.roofonclick.Utilities.EmailMobileValidator;
import com.example.roofonclick.Utilities.Shared_Preference_Manager;

import java.security.PrivateKey;

import de.hdodenhof.circleimageview.CircleImageView;

public class CustomerProfile extends Fragment implements View.OnClickListener {
    private Context con;
    TextView txtcustproname,txtcustproemail,txtcustpromobile,txtcustprocity,txtcustproaddress;
    Button btncustproeditbtn;
    EmailMobileValidator profiledialogemail;
    private CircleImageView custprofileimage;
    private int PICK_IMAGE = 25;
    private Bitmap proimgbit;
    BitmapFactory.Options options;
    UserModel um;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.con = context;
        profiledialogemail= new  EmailMobileValidator();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.customer_profile_layout,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        ActivityCompat.requestPermissions(getActivity(),
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA},44);

        CircleImageView custimgprofile = view.findViewById(R.id.custprofile_image);

        um = DatabaseClient.getInstance(con)
                .getAppDatabaseClient().userDaos()
                .getUserByEmail(Shared_Preference_Manager.getUser_Email(con));

        custimgprofile.setImageBitmap(CustomerHomeUtility.imgConvertFromByteArrayToBitmap(um.getUserImage()));

        txtcustproname=view.findViewById(R.id.custprofilename);
        txtcustproemail=view.findViewById(R.id.custproemailid);
        txtcustpromobile=view.findViewById(R.id.custpromobileno);
        txtcustprocity=view.findViewById(R.id.custprocity);
        txtcustproaddress=view.findViewById(R.id.custproaddress);

        btncustproeditbtn=view.findViewById(R.id.custproeditbutton);
        btncustproeditbtn.setOnClickListener(this);

        txtcustproname.setText(um.getUsername());
        txtcustproemail.setText(um.getEmail());
        txtcustpromobile.setText(um.getMobno());
        txtcustproaddress.setText(um.getUserAddress());
        txtcustprocity.setText(um.getUserCity());

        custprofileimage=view.findViewById(R.id.custprofile_image);
        custprofileimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == (custprofileimage.getId()))
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
        if (v.getId() == btncustproeditbtn.getId()) {
            final View customerprofiledialog = getLayoutInflater()
                    .inflate(R.layout.customer_profile_dialog_layout, null);

            final TextView txtcustproname = customerprofiledialog.findViewById(R.id.prodialogname);
            final EditText edttxtdialogmobile = customerprofiledialog.findViewById(R.id.prodialogmobile);
            final EditText edttxtdialogcity = customerprofiledialog.findViewById(R.id.prodialogcity);
            final EditText edttxtdialogadress = customerprofiledialog.findViewById(R.id.prodialogaddress);

            AlertDialog.Builder builder = new AlertDialog.Builder(con);
            builder.setView(customerprofiledialog);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (!TextUtils.isEmpty(edttxtdialogmobile.getText().toString())) {
                        if (profiledialogemail.mobvalidate(edttxtdialogmobile.getText().toString())) {
                            txtcustproname.setText(txtcustproname.getText().toString());
                            txtcustpromobile.setText(edttxtdialogmobile.getText().toString());
                            txtcustprocity.setText(edttxtdialogcity.getText().toString());
                            txtcustproaddress.setText(edttxtdialogadress.getText().toString());

                            um.setUsername(txtcustproname.getText().toString());
                            um.setMobno(txtcustpromobile.getText().toString());
                            um.setUserAddress(edttxtdialogadress.getText().toString());
                            um.setUserCity(txtcustprocity.getText().toString());

                            DatabaseClient.getInstance(con)
                                    .getAppDatabaseClient().userDaos()
                                    .updateUserModel(um);
                            Toast.makeText(con, "Edited", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(con, "Enter Valid Email or Mobile", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(con, "Please Enter Data", Toast.LENGTH_SHORT).show();
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
                Cursor cursor = con.getContentResolver().query(selectedImage, filePathColumn,
                        null, null,  null);
                if (cursor != null)
                {
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String picturePath = cursor.getString(columnIndex);
                    options = new BitmapFactory.Options();
                    options.inSampleSize = 2;
                    proimgbit = BitmapFactory.decodeFile(picturePath,options);
                    custprofileimage.setImageBitmap(proimgbit);
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
