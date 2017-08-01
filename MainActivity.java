package com.carloskowalevicz.pokemon;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.CheckBox;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.List;

import static com.carloskowalevicz.pokemon.ServerManager.*;

public class MainActivity extends AppCompatActivity {

    EditText user, pass, ip;
    public CheckBox pa,doc;
    AlertDialog alertDialog;
    public Intent voy;
    //alertDialog = new AlertDialog.Builder

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);
        if (getIntent().getBooleanExtra("EXIT", false))
        {
            finish();
        }



    }
    public String a() {

       // TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
       // String imei =tm.getDeviceId(); // Obtiene el imei  or  "352319065579474";
      //  return imei;
        String getMacAddr; {
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
                        res1.append(String.format("%02X:",b));
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

   public void OnLog(View view) {

       String username = user.getText().toString();
       String password = pass.getText().toString();
       String ips = "192.168.2.100";
       String tipo = "login"; // parte de la segunda
       String imei = a();

       ServerManager serverManager = new ServerManager(this);
       serverManager.execute(tipo, username, password, ips, imei); // segunda
       //   if(!doc.isChecked() && !pa.isChecked())
       //   { tipo = "nada";}
       //   else {
       //       serverManager.execute(tipo, username, password, ips);
       while (serverManager.getConectionStatus() == null) {
       }
       String er = serverManager.getConectionStatus();
       ServerManager serverManager1 = new ServerManager(this);
       tipo = "userId";

       serverManager1.execute(tipo, username, password, ips, imei);

       while (serverManager.userId == null) {
       };
       if (er.equals("conecto")) {
           Log.i(CLASS_TAG, "sip lo logro");
           voy = new Intent(MainActivity.this, LoginPaciente.class);
           startActivity(voy);
           er = "";
           user.setText("");
           pass.setText("");
       }
   }

    public void OnLogDoc(View view) { //segunda
        String username = user.getText().toString();
        String password = pass.getText().toString();
        String ips = "192.168.2.100";
        String  tipo = "logindoc";
        String imei= a();
        ServerManager serverManager = new ServerManager(this);
        serverManager.execute(tipo, username, password, ips, imei);

        while (serverManager.getConectionStatus() == null){
        }
        String er = serverManager.getConectionStatus();
        ServerManager serverManager1 = new ServerManager(this);
        tipo = "userId";
        userId = null;
        serverManager1.execute(tipo, username, password, ips, imei);
        tipo="";


        while(ServerManager.userId =="" ){
        //condicion
        };

        if (er.equals("conecto doc")){
            Log.i(CLASS_TAG, "sip lo logro Doc");
            voy=new Intent(MainActivity.this,LoginDoctor.class);
            startActivity(voy);
            er="";

            user.setText("");
            pass.setText("");

        }
    }

    //Clase para registrar Paciente
    public void irreg(View view){

    startActivity(new Intent(this, registro.class));}

    //Clase para registrar Doctor
        public void irregdoc(View view) {

      startActivity(new Intent(this, RegistroDoctor.class));

    }

    public void onfinish (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        startActivity(intent);
    }
    }
