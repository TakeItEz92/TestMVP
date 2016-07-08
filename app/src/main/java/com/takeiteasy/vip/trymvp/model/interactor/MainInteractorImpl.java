package com.takeiteasy.vip.trymvp.model.interactor;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.takeiteasy.vip.trymvp.model.FirebaseDataItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VLogachev on 08.07.2016.
 */
public class MainInteractorImpl implements FirebaseApiInteractor<FirebaseDataItem> {

    private FirebaseAuth auth;

    public MainInteractorImpl() {
        auth = FirebaseAuth.getInstance();
    }

    @Override
    public void loadDataItems(final FirebaseCallback<FirebaseDataItem> callback) {
        auth.signInAnonymously().addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isComplete()) {
                    DatabaseReference dbr = FirebaseDatabase.getInstance().getReference();
                    dbr.child("data").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            List<FirebaseDataItem> dataItemList = new ArrayList<>();

                            for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                FirebaseDataItem item = ds.getValue(FirebaseDataItem.class);
                                item.setUid(ds.getKey());
                                dataItemList.add(item);
                            }

                            callback.onLoadFinished(dataItemList);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            callback.onLoadFailed(databaseError.getMessage());
                        }
                    });
                }
            }
        });


    }
}
