package com.example.fragmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragmentapp.Data.UserDatabase;
import com.example.fragmentapp.Data.UserModelDAO;
import com.example.fragmentapp.Model.UserModel;

import org.w3c.dom.Text;

import java.util.List;

import static java.security.AccessController.getContext;

public class EditData extends AppCompatActivity {
    TextView idEdit;
    Button btnChange;
    EditText dataEdit;
    UserModelDAO db;
    UserDatabase database;
    String idEmail;
    private List<UserModel> userModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);
        Intent intent = getIntent();

        idEmail=intent.getStringExtra("IDedit");
        idEdit= findViewById(R.id.IDEmailAccount);
       btnChange =findViewById(R.id.changeEmailAccount);
       dataEdit= findViewById(R.id.newDataEmail);

        idEdit.setText(idEmail);

        database = Room.databaseBuilder(EditData.this, UserDatabase.class, "UserModel")
                .allowMainThreadQueries()
                .build();
        db = database.getUserDao();

        updateData();

    }

    public void updateData(){
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.updateUsername(dataEdit.getText().toString(),idEmail);
                Toast.makeText(EditData.this,"Date schimbate cu succes!",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(EditData.this,MainActivity.class));
                finish();
            }
        });
    }
}