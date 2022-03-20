package com.example.avaliacao;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ementa extends AppCompatActivity {

    TextView t1,t2,t3,t4,t5;
    FirebaseDatabase database;
    DatabaseReference reference;
    Query check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ementa);

        t1=findViewById(R.id.seg);
        t2=findViewById(R.id.ter);
        t3=findViewById(R.id.qua);
        t4=findViewById(R.id.qui);
        t5=findViewById(R.id.sex);

        database = FirebaseDatabase.getInstance();

        reference=database.getReference("ementa");

        check=reference;
        check.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                t1.setText(
                        "Sopa: "+snapshot.child("2a feira").child("sopa").getValue(String.class)+
                        "\nPrato principal: "+snapshot.child("2a feira").child("prato principal").getValue(String.class)+
                                "\nSobremesa: "+snapshot.child("2a feira").child("sobremesa").getValue(String.class)
                );
                t2.setText(
                        "Sopa: "+snapshot.child("3a feira").child("sopa").getValue(String.class)+
                                "\nPrato principal: "+snapshot.child("3a feira").child("prato principal").getValue(String.class)+
                                "\nSobremesa: "+snapshot.child("3a feira").child("sobremesa").getValue(String.class)
                );
                t3.setText(
                        "Sopa: "+snapshot.child("4a feira").child("sopa").getValue(String.class)+
                                "\nPrato principal: "+snapshot.child("4a feira").child("prato principal").getValue(String.class)+
                                "\nSobremesa: "+snapshot.child("4a feira").child("sobremesa").getValue(String.class)
                );
                t4.setText(
                        "Sopa: "+snapshot.child("5a feira").child("sopa").getValue(String.class)+
                                "\nPrato principal: "+snapshot.child("5a feira").child("prato principal").getValue(String.class)+
                                "\nSobremesa: "+snapshot.child("5a feira").child("sobremesa").getValue(String.class)
                );
                t5.setText(
                        "Sopa: "+snapshot.child("6a feira").child("sopa").getValue(String.class)+
                                "\nPrato principal: "+snapshot.child("6a feira").child("prato principal").getValue(String.class)+
                                "\nSobremesa: "+snapshot.child("6a feira").child("sobremesa").getValue(String.class)
                );
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void tras(View view)
    {
        Intent i= new Intent(ementa.this, opcao.class);
        startActivity(i);
    }
}