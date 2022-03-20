package com.example.avaliacao;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class opcao extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference ref1,ref2,ref3,ref4,ref5;
    Query ch1,ch2,ch3,ch4,ch5;

    boolean a=false;

    int v1,v2,v3,v4,v5,t=10000,f=1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opcao);
        database = FirebaseDatabase.getInstance();

        new CountDownTimer(t, f) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish()
            {
                a=true;
                Toast.makeText(opcao.this, "Pode avaliar", Toast.LENGTH_SHORT).show();
            }
        }.start();

        //referencia 1
        ref1= database.getReference("Não gostei");
        ch1=ref1;
        ch1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                v1=snapshot.getValue(Integer.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //referencia 2
        ref2= database.getReference("Gostei pouco");
        ch2=ref2;
        ch2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                v2=snapshot.getValue(Integer.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //referencia 3
        ref3= database.getReference("Gostei");
        ch3=ref3;
        ch3.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                v3=snapshot.getValue(Integer.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //referencia 4
        ref4= database.getReference("Gostei muito");
        ch4=ref4;
        ch4.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                        v4=snapshot.getValue(Integer.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //referencia 5
        ref5= database.getReference("Adorei");
        ch5=ref5;
        ch5.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                        v5=snapshot.getValue(Integer.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void b1(View view)
    {
        if(a==true)
        {
            v1++;
            ref1.setValue(v1);
        }
        else
        {
            Toast.makeText(this, "Espere", Toast.LENGTH_SHORT).show();
        }

    }

    public void b2(View view)
    {
        if(a==true)
        {
            v2++;
            ref2.setValue(v2);
        }
        else
        {
            Toast.makeText(this, "Espere", Toast.LENGTH_SHORT).show();
        }
    }

    public void b3(View view)
    {
        if(a==true)
        {
            v3++;
            ref3.setValue(v3);
        }
        else
        {
            Toast.makeText(this, "Espere", Toast.LENGTH_SHORT).show();
        }
    }

    public void b4(View view)
    {
        if(a==true)
        {
            v4++;
            ref4.setValue(v4);
        }
        else
        {
            Toast.makeText(this, "Espere", Toast.LENGTH_SHORT).show();
        }
    }

    public void b5(View view)
    {
        if(a==true)
        {
            v5++;
            ref5.setValue(v5);
        }
        else
        {
            Toast.makeText(this, "Espere", Toast.LENGTH_SHORT).show();
        }
    }

    public void ementa(View view)
    {
        Intent i= new Intent(opcao.this, ementa.class);
        startActivity(i);
    }
}