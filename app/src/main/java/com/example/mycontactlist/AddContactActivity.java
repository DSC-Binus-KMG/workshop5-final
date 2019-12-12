package com.example.mycontactlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddContactActivity extends AppCompatActivity {

    private EditText inputName;
    private EditText inputPhoneNumber;
    private Button buttonAddContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        inputName = findViewById(R.id.input_contact_name);
        inputPhoneNumber = findViewById(R.id.input_contact_phone_number);
        buttonAddContact = findViewById(R.id.button_add_contact);

        buttonAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = inputName.getText().toString();
                String phoneNumber = inputPhoneNumber.getText().toString();
                
            }
        });
    }

    public static Intent getInstance(Context context) {
        return new Intent(context, AddContactActivity.class);
    }
}
