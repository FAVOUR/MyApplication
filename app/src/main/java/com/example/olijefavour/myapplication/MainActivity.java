package com.example.olijefavour.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  private RecyclerView mMainlist;
  private FirebaseFirestore mFirestore;
  public FirebaseAuth mAuth;
  private UsersListAdapter usersListAdapter;

  private List<Users> usersList;

    @Override
    public void onStart() {
        super.onStart();
        usersList.clear();
       final String currentUser = mAuth.getCurrentUser().getUid();
        mFirestore.collection("Users").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                if(e != null){
                    Toast.makeText( MainActivity.this, "List Retrieval failed." +  e.getMessage(), Toast.LENGTH_SHORT).show();
                }

                for(DocumentChange doc:documentSnapshots.getDocumentChanges()){
                    if(doc.getType() == DocumentChange.Type.ADDED);
                    String userId=doc.getDocument().getId();


                    Users users = doc.getDocument().toObject(Users.class).withId(userId);
                    if (currentUser == userId){
                        usersList.clear();
                    }
                    usersList.add(users);
                    usersListAdapter.notifyDataSetChanged();
//                     String name = doc.getDocument().getString("name");
                }
            }
        });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usersList= new ArrayList<>();
        mMainlist=(RecyclerView) findViewById(R.id.main_list);
        mAuth=FirebaseAuth.getInstance();
        mFirestore=FirebaseFirestore.getInstance();
        usersListAdapter=new UsersListAdapter(usersList);

        mMainlist.setHasFixedSize(true);
        mMainlist.setLayoutManager(new LinearLayoutManager(this));
        mMainlist.setAdapter(usersListAdapter);
//        mFirestore.collection("Users").addSnapshotListener(new EventListener<QuerySnapshot>() {
//            @Override
//            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
//                 if(e != null){
//                     Toast.makeText( MainActivity.this, "List Retrieval failed." +  e.getMessage(), Toast.LENGTH_SHORT).show();
//                 }
//
//                 for(DocumentChange doc:documentSnapshots.getDocumentChanges()){
//                     if(doc.getType() == DocumentChange.Type.ADDED);
//                       Users users = doc.getDocument().toObject(Users.class);
//                     usersList.add(users);
//                     usersListAdapter.notifyDataSetChanged();
////                     String name = doc.getDocument().getString("name");
//                 }
//            }
//        });
    }



}
