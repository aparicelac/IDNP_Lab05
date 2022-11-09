package com.example.idnp_lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {
    private static final String TAG = "Activity_PostulanteInfo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        EditText buscarDNI = findViewById(R.id.edtBuscarDNI);
        Button btnBuscar = findViewById(R.id.btnBuscar);
        TextView resultado = findViewById(R.id.txtResultado);

        Intent intent = getIntent();
        Bundle bndl = intent.getBundleExtra("bundle");
        ArrayList pst = (ArrayList<Postulante>)bndl.getSerializable("array");

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dni = buscarDNI.getText().toString();
                for(int i = 0; i < pst.size(); i++) {
                    //Log.d(TAG, "postulante:"+pst.get(i).toString());
                    if(pst.get(i).equals(null)) {
                        Log.d(TAG, "Postulante no registrado");
                        resultado.setText("Postulante no registrado");
                    }
                    else {
                        Log.d(TAG, pst.toString());
                        resultado.setText(pst.toString());
                    }
                }
            }
        });
    }
}