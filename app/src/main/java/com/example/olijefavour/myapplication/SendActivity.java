package com.example.olijefavour.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SendActivity extends AppCompatActivity {

    private EditText mMessage;
    private FirebaseFirestore mFirestore;
    private FirebaseAuth mAuth;
    private Button mSendMessage;
    private TextView send_to;
    String  mCurrentId;
    String userName;
    String user_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        send_to = (TextView) findViewById(R.id.recivers);
        mMessage =(EditText)findViewById(R.id.message);
        mSendMessage=(Button) findViewById(R.id.button_send);
        mFirestore=FirebaseFirestore.getInstance();
        mAuth =FirebaseAuth.getInstance();
        mCurrentId =FirebaseAuth.getInstance().getUid();
       userName =getIntent().getStringExtra("Username");
//       user_id=mAuth.getUid();
        user_id=getIntent().getStringExtra("UserId");
        send_to.setText("Message " + userName);

        mSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message= mMessage.getText().toString();
                if(!TextUtils.isEmpty(message)){
                    Map<String,Object> notificationMessage = new HashMap<>();
                    notificationMessage.put("message",message);
                    notificationMessage.put("from",mCurrentId);

                    mFirestore.collection("Users/" + user_id +"/Notifications").add(notificationMessage).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(SendActivity.this, "Message sent.", Toast.LENGTH_SHORT).show();
                           mMessage.setText("");

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(SendActivity.this, "Error:" +e.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            }
        });
    }


}
