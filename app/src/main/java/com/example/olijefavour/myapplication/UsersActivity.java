package com.example.olijefavour.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class UsersActivity extends AppCompatActivity {
  private UsersRecyclersAdapter usersRecyclersAdapter;
  FirebaseFirestore mFirestore;

  RecyclerView okRv;
    public List<Users> usersList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFirestore=FirebaseFirestore.getInstance();
        setContentView(R.layout.activity_users);

        usersList = new ArrayList<>();
        okRv= (RecyclerView) findViewById(R.id.ok_rv);
        usersRecyclersAdapter= new UsersRecyclersAdapter(getBaseContext(), usersList);


        okRv.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        okRv.setHasFixedSize(true);
        okRv.setAdapter(usersRecyclersAdapter);

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
//      mFirestore.collection("Users").addSnapshotListener( this, new EventListener<QuerySnapshot>() {
//          @Override
//          public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
//              for(DocumentChange doc: documentSnapshots.getDocumentChanges()){
//                  if (doc.getType() ==DocumentChange.Type.ADDED){
//                      Users users=doc.getDocument().toObject(Users.class);
//                      usersList.add(users);
//                      usersRecyclersAdapter.notifyDataSetChanged();
//                  }
//                  else{
//                      Toast.makeText(UsersActivity.this, "List Retrieval failed." +  e.getMessage(), Toast.LENGTH_SHORT).show();
//
//                  }
//          }
//      }
//        });
    }
}

