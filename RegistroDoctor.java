package com.carloskowalevicz.pokemon;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.net.Inet6Address;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;

import static com.carloskowalevicz.pokemon.R.id.d;
import static com.carloskowalevicz.pokemon.R.id.e;
import static com.carloskowalevicz.pokemon.R.id.p;

public class RegistroDoctor extends AppCompatActivity {

    EditText username, password;
    public Intent voy;
    private int idpas;
    private int clave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_doctor);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        if (getIntent().getBooleanExtra("EXIT", false))
        {
            finish();
        }
    }

    public String a() {

        // TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        //String imei =tm.getDeviceId(); // Obtiene el imei  or  "352319065579474";//
        //   return imei;
        //   return tm.getDeviceId();
        String getMacAddr;
        {
            try {
                List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
                for (NetworkInterface nif : all) {
                    if (!nif.getName().equalsIgnoreCase("wlan0")) continue;

                    byte[] macBytes = nif.getHardwareAddress();
                    if (macBytes == null) {
                        return "";
                    }

                    StringBuilder res1 = new StringBuilder();
                    for (byte b : macBytes) {
                        res1.append(String.format("%02X:", b));
                    }

                    if (res1.length() > 0) {
                        res1.deleteCharAt(res1.length() - 1);
                    }
                    return res1.toString();
                }
            } catch (Exception ex) {
            }
            return "02:00:00:00:00:00";
        }
    }

    public void onregdoc(View view) {

        String susername = username.getText().toString();
        String spassword = password.getText().toString();

        String ips = "192.168.2.100";
        String tipo = "compruebadoc";
        ServerManager serverManager2 = new ServerManager(this);
        serverManager2.execute(tipo, susername, ips);
        while (serverManager2.getConectionStatus() == null) {
        }
        String imei = a();
        if (serverManager2.getConectionStatus().equals("Usuario no existente")) {
            if (!susername.equals("") && !spassword.equals("")) {
                tipo = "registrodoc";
               // String sidpas = "0";
               // String sclave = "0";
                ServerManager serverManager = new ServerManager(this);
                serverManager.execute(tipo, susername, spassword, ips, imei);
                if (serverManager.result.equals("Registroexitoso")) {
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Doctor registrado", Toast.LENGTH_SHORT);

                    toast1.show();
                } else {
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Doctor no registrado", Toast.LENGTH_SHORT);

                    toast1.show();
                }

            } else {
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Campos incompletos, registro fallido", Toast.LENGTH_SHORT);
                toast1.show();
            }

        } else {
            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            "Doctor ya registrado, registro fallido", Toast.LENGTH_SHORT);
            toast1.show();
          //  voy = new Intent(this, MainActivity.class);
          //  startActivity(voy);
        }
        voy = new Intent(this, MainActivity.class);
        startActivity(voy);
    }

    public void onfinish1(View view) {
        Intent intent = new Intent(this, RegistroDoctor.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        startActivity(intent);
    }
}