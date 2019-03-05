package com.beanfactory.yp.ibms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RequirementForm extends AppCompatActivity {

    EditText bloodGroupText, quantityText, nameText;
    Button requestButton;

    String pName = "";
    String bgroup = "";
    int quant = 0;


    FirebaseDatabase database = FirebaseDatabase.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requirement_form);





        bloodGroupText = (EditText) findViewById(R.id.bloodgroup);
        quantityText = (EditText) findViewById(R.id.quantity);
        nameText = (EditText) findViewById(R.id.nametext);

        requestButton = (Button) findViewById(R.id.request_button);

        requestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bgroup = bloodGroupText.getText().toString();
                quant = Integer.parseInt(quantityText.getText().toString());
                pName = nameText.getText().toString();
                Form form = new Form(pName, bgroup, quant);
                DatabaseReference myRef = database.getReference(pName);
                myRef.setValue(form);
                Toast.makeText(getApplicationContext(), "Submitting Form", Toast.LENGTH_SHORT).show();



            }
        });

    }
}
