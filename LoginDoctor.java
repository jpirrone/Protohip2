package com.carloskowalevicz.pokemon;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import java.io.IOException;
import java.net.NetworkInterface;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentFilter.MalformedMimeTypeException;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.nfc.tech.NdefFormatable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import static com.carloskowalevicz.pokemon.R.id.a;
import static com.carloskowalevicz.pokemon.R.id.b;
import static com.carloskowalevicz.pokemon.R.id.c;
import static com.carloskowalevicz.pokemon.R.id.d;
import static com.carloskowalevicz.pokemon.R.id.e;
import static com.carloskowalevicz.pokemon.R.id.f;
import static com.carloskowalevicz.pokemon.R.id.g;
import static com.carloskowalevicz.pokemon.R.id.h;
import static com.carloskowalevicz.pokemon.R.id.i;
import static com.carloskowalevicz.pokemon.R.id.j;
import static com.carloskowalevicz.pokemon.R.id.k;
import static com.carloskowalevicz.pokemon.R.id.l;
import static com.carloskowalevicz.pokemon.R.id.m;
import static com.carloskowalevicz.pokemon.R.id.n;
import static com.carloskowalevicz.pokemon.R.id.o;
import static com.carloskowalevicz.pokemon.R.id.p;
import static com.carloskowalevicz.pokemon.R.id.q;

public class LoginDoctor extends Activity {

    private static final String TAG = "stickynotes";
    private boolean mResumed = false;
    NfcAdapter mNfcAdapter;
    EditText tupass,nombreDoc,passDoc,idUsuario,IDdoc;
    EditText text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12,text13,text14,text15,text16,text17,text18;
    String tipo,id,sNombreDoc,sPassDoc,sidd;

    PendingIntent mNfcPendingIntent;
    IntentFilter[] mNdefExchangeFilters;

    public String a() {
        //Rutina que lee MAC Address del dispositivo:

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
        setContentView(R.layout.activity_login_doctor);
        if (getIntent().getBooleanExtra("EXIT", false))
        {
            finish();
        }

        nombreDoc = ((EditText) findViewById(R.id.userDoc));
        passDoc = ((EditText) findViewById(R.id.passDoc));
        idUsuario = ((EditText) findViewById(R.id.idUsuario));
        IDdoc= ((EditText) findViewById(R.id.IDdoc));
        text1 = ((EditText) findViewById(R.id.textView9));
        text2 = ((EditText) findViewById(R.id.textView11));
        text3 = ((EditText) findViewById(R.id.textView13));
        text4 = ((EditText) findViewById(R.id.textView15));
        text5 = ((EditText) findViewById(R.id.textView17));
        text6 = ((EditText) findViewById(R.id.textView19));
        text7 = ((EditText) findViewById(R.id.textView21));
        text8 = ((EditText) findViewById(R.id.textView23));
        text9 = ((EditText) findViewById(R.id.textView25));
        text10 = ((EditText) findViewById(R.id.textView27));
        text11 = ((EditText) findViewById(R.id.textView29));
        text12 = ((EditText) findViewById(R.id.textView31));
        text13 = ((EditText) findViewById(R.id.textView33));
        text14 = ((EditText) findViewById(R.id.textView35));
        text15 = ((EditText) findViewById(R.id.textView37));
        text16 = ((EditText) findViewById(R.id.textView39));
        text17 = ((EditText) findViewById(R.id.textView41));
        text18 = ((EditText) findViewById(R.id.textView43));
        text1.setVisibility(View.INVISIBLE);
        text2.setVisibility(View.INVISIBLE);
        text3.setVisibility(View.INVISIBLE);
        text4.setVisibility(View.INVISIBLE);
        text5.setVisibility(View.INVISIBLE);
        text6.setVisibility(View.INVISIBLE);
        text7.setVisibility(View.INVISIBLE);
        text8.setVisibility(View.INVISIBLE);
        text9.setVisibility(View.INVISIBLE);
        text10.setVisibility(View.INVISIBLE);
        text11.setVisibility(View.INVISIBLE);
        text12.setVisibility(View.INVISIBLE);
        text13.setVisibility(View.INVISIBLE);
        text14.setVisibility(View.INVISIBLE);
        text15.setVisibility(View.INVISIBLE);
        text16.setVisibility(View.INVISIBLE);
        text17.setVisibility(View.INVISIBLE);
        text18.setVisibility(View.INVISIBLE);

        tupass = ((EditText) findViewById(R.id.pass));
        tupass.addTextChangedListener(mTextWatcher);
        nombreDoc.setText(ServerManager.userDoctor);
        nombreDoc.setFocusable(false);
        passDoc.setText(ServerManager.passDoctor);
        passDoc.setFocusable(false);

        sNombreDoc = nombreDoc.getText().toString();
        sPassDoc = passDoc.getText().toString();
        tipo ="userIdd";
        ServerManager serverManager4 = new ServerManager(this);
        serverManager4.execute(tipo,sNombreDoc,sPassDoc);
        while(serverManager4.docIdResult == null){
        }
        IDdoc.setText(serverManager4.docIdResult);
        IDdoc.setFocusable(false);

        mNfcPendingIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);

        IntentFilter ndefDetected = new IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED);
        try {
            ndefDetected.addDataType("text/plain");
        } catch (MalformedMimeTypeException e) { }
        mNdefExchangeFilters = new IntentFilter[] { ndefDetected };


    }


    public void onDataFill(View View) {
        text1.setVisibility(View.INVISIBLE);
        text2.setVisibility(View.INVISIBLE);
        text3.setVisibility(View.INVISIBLE);
        text4.setVisibility(View.INVISIBLE);
        text5.setVisibility(View.INVISIBLE);
        text6.setVisibility(View.INVISIBLE);
        text7.setVisibility(View.INVISIBLE);
        text8.setVisibility(View.INVISIBLE);
        text9.setVisibility(View.INVISIBLE);
        text10.setVisibility(View.INVISIBLE);
        text11.setVisibility(View.INVISIBLE);
        text12.setVisibility(View.INVISIBLE);
        text13.setVisibility(View.INVISIBLE);
        text14.setVisibility(View.INVISIBLE);
        text15.setVisibility(View.INVISIBLE);
        text16.setVisibility(View.INVISIBLE);
        text17.setVisibility(View.INVISIBLE);
        text18.setVisibility(View.INVISIBLE);



        id = idUsuario.getText().toString();
        tupass.setText(null);

        sNombreDoc = nombreDoc.getText().toString();
        sPassDoc = passDoc.getText().toString();
        tipo ="userIdd";
        ServerManager serverManager4 = new ServerManager(this);
        serverManager4.execute(tipo,sNombreDoc,sPassDoc);
        while(serverManager4.docIdResult == null){
        }
        sidd= serverManager4.docIdResult.replace("null", "");
        IDdoc.setText(sidd);

        tipo = "codigDoc";
        ServerManager serverManager3 = new ServerManager(this);

        serverManager3.execute(tipo,sidd,id);
        while(serverManager3.docIdResult == null){

        }


        tupass.setText(serverManager3.docIdResult.replace("null", ""));

        if (tupass.getText().toString() != null){
            String codigo = tupass.getText().toString();
            if (codigo != null)
            {
           // int value1 = Integer.parseInt(codigo.replace("null", ""));


                while (tupass == null)
                {

                }
                String [] arrayCodigo = codigo.trim().replace("null", "").split("");
                if (codigo.equals("0")) {
                    codigo="no conecto";
                }
                if( !codigo.equals("no conecto")) {


                    tipo = "getData";
                    String ids = idUsuario.getText().toString();


                    if (arrayCodigo[19].equals("1")) { //si esto se cumple quiere decir que el valor es 0 por tanto no se le otorga visibilidad
                        text1.setVisibility(View.VISIBLE);
                        String prue="getdata19";
                        ServerManager serverManager19 = new ServerManager(this);
                        serverManager19.execute(tipo, ids, prue);
                        while(serverManager19.var == null){
                        }
                      text1.setText(serverManager19.var.replace("null",""));
                    }

                    if (arrayCodigo[18].equals("1")) {
                        text2.setVisibility(View.VISIBLE);
                        String prue="getdata18";
                        ServerManager serverManager18 = new ServerManager(this);
                        serverManager18.execute(tipo, ids, prue);
                        while(serverManager18.var == null){
                        }
                        text2.setText(serverManager18.var.replace("null",""));
                    }

                    if (arrayCodigo[17].equals("1")) {
                        text3.setVisibility(View.VISIBLE);
                        String prue="getdata17";
                        ServerManager serverManager17 = new ServerManager(this);
                        serverManager17.execute(tipo, ids, prue);
                        while(serverManager17.var == null){
                        }
                        text3.setText(serverManager17.var.replace("null",""));
                    }

                    if (arrayCodigo[16].equals("1")) {
                        text4.setVisibility(View.VISIBLE);
                        String prue="getdata16";
                        ServerManager serverManager16 = new ServerManager(this);
                        serverManager16.execute(tipo, ids, prue);
                        while(serverManager16.var == null){
                        }
                        text4.setText(serverManager16.var.replace("null",""));
                    }

                    if (arrayCodigo[15].equals("1")) {
                        text5.setVisibility(View.VISIBLE);
                        String prue="getdata15";
                        ServerManager serverManager15 = new ServerManager(this);
                        serverManager15.execute(tipo, ids, prue);
                        while(serverManager15.var == null){
                        }
                        text5.setText(serverManager15.var.replace("null",""));
                    }

                    if (arrayCodigo[14].equals("1")) {
                        text6.setVisibility(View.VISIBLE);
                        String prue="getdata14";
                        ServerManager serverManager14 = new ServerManager(this);
                        serverManager14.execute(tipo, ids, prue);
                        while(serverManager14.var == null){
                        }
                        text6.setText(serverManager14.var.replace("null",""));
                    }

                    if (arrayCodigo[13].equals("1")) {
                        text7.setVisibility(View.VISIBLE);
                        String prue="getdata13";
                        ServerManager serverManager13 = new ServerManager(this);
                        serverManager13.execute(tipo, ids, prue);
                        while(serverManager13.var == null){
                        }
                        text7.setText(serverManager13.var.replace("null",""));
                    }

                    if (arrayCodigo[12].equals("1")) {
                        text8.setVisibility(View.VISIBLE);
                        String prue="getdata12";
                        ServerManager serverManager12 = new ServerManager(this);
                        serverManager12.execute(tipo, ids, prue);
                        while(serverManager12.var == null){
                        }
                        text8.setText(serverManager12.var.replace("null",""));
                    }

                    if (arrayCodigo[11].equals("1")) {
                        text9.setVisibility(View.VISIBLE);
                        String prue="getdata11";
                        ServerManager serverManager11 = new ServerManager(this);
                        serverManager11.execute(tipo, ids, prue);
                        while(serverManager11.var == null){
                        }
                        text9.setText(serverManager11.var.replace("null",""));
                    }

                    if (arrayCodigo[10].equals("1")) {
                        text10.setVisibility(View.VISIBLE);
                        String prue="getdata10";
                        ServerManager serverManager20 = new ServerManager(this);
                        serverManager20.execute(tipo, ids, prue);
                        while(serverManager20.var == null){
                        }
                        text10.setText(serverManager20.var.replace("null",""));
                    }

                    if (arrayCodigo[9].equals("1")) {
                        text11.setVisibility(View.VISIBLE);
                        String prue="getdata9";
                        ServerManager serverManager21 = new ServerManager(this);
                        serverManager21.execute(tipo, ids, prue);
                        while(serverManager21.var == null){
                        }
                        text11.setText(serverManager21.var.replace("null",""));
                    }

                    if (arrayCodigo[8].equals("1")) {
                        text12.setVisibility(View.VISIBLE);
                        String prue="getdata8";
                        ServerManager serverManager22 = new ServerManager(this);
                        serverManager22.execute(tipo, ids, prue);
                        while(serverManager22.var == null){
                        }
                        text12.setText(serverManager22.var.replace("null",""));
                    }

                    if (arrayCodigo[7].equals("1")) {
                        text13.setVisibility(View.VISIBLE);
                        String prue="getdata7";
                        ServerManager serverManager23 = new ServerManager(this);
                        serverManager23.execute(tipo, ids, prue);
                        while(serverManager23.var == null){
                        }
                        text13.setText(serverManager23.var.replace("null",""));
                    }

                    if (arrayCodigo[6].equals("1")) {
                        text14.setVisibility(View.VISIBLE);
                        String prue="getdata6";
                        ServerManager serverManager24 = new ServerManager(this);
                        serverManager24.execute(tipo, ids, prue);
                        while(serverManager24.var == null){
                        }
                        text14.setText(serverManager24.var.replace("null",""));
                    }

                    if (arrayCodigo[5].equals("1")) {
                        text15.setVisibility(View.VISIBLE);
                        String prue="getdata5";
                        ServerManager serverManager25 = new ServerManager(this);
                        serverManager25.execute(tipo, ids, prue);
                        while(serverManager25.var == null){
                        }
                        text15.setText(serverManager25.var.replace("null",""));
                    }

                    if (arrayCodigo[4].equals("1")) {
                        text16.setVisibility(View.VISIBLE);
                        String prue="getdata4";
                        ServerManager serverManager26 = new ServerManager(this);
                        serverManager26.execute(tipo, ids, prue);
                        while(serverManager26.var == null){
                        }
                        text16.setText(serverManager26.var.replace("null",""));
                    }

                    if (arrayCodigo[3].equals("1")) {
                        text17.setVisibility(View.VISIBLE);
                        String prue="getdata3";
                        ServerManager serverManager27 = new ServerManager(this);
                        serverManager27.execute(tipo, ids, prue);
                        while(serverManager27.var == null){
                        }
                        text17.setText(serverManager27.var.replace("null",""));
                    }

                    if (arrayCodigo[2].equals("1")) {
                        text18.setVisibility(View.VISIBLE);
                        String prue="getdata2a";
                        ServerManager serverManager28 = new ServerManager(this);
                        serverManager28.execute(tipo, ids, prue);
                        while(serverManager28.var == null){
                        }
                        text18.setText(serverManager28.var.replace("null",""));
                    }


                }

                    if (codigo.equals("no conecto")){
                        Toast toast1 =
                                Toast.makeText(getApplicationContext(),
                                        "No se encontro el codigo del paciente", Toast.LENGTH_SHORT);


                        toast1.show();
                    }else {
           //
                        Toast toast1 =
                                Toast.makeText(getApplicationContext(),
                                        "Codigo del paciente encontrado", Toast.LENGTH_SHORT);


                        toast1.show();
                    }
             }
             }

 }
    public void onEdit (View View) {

        id = idUsuario.getText().toString();
        tupass.setText(null);

        sNombreDoc = nombreDoc.getText().toString();
        sPassDoc = passDoc.getText().toString();
        tipo = "userIdd";
        ServerManager serverManager4 = new ServerManager(this);
        serverManager4.execute(tipo, sNombreDoc, sPassDoc);
        while (serverManager4.docIdResult == null) {
        }
        sidd = serverManager4.docIdResult.replace("null", "");


        tipo = "codigDoc";
        ServerManager serverManager3 = new ServerManager(this);

        serverManager3.execute(tipo, sidd, id);
        while (serverManager3.docIdResult == null) {

        }
        tupass.setText(serverManager3.docIdResult.replace("null", ""));

        if (tupass.getText().toString() != null) {
            String codigo = tupass.getText().toString();
            if (codigo != null) {

                while (tupass == null) {
                }
                String[] arrayCodigo = codigo.trim().replace("null", "").split("");
                if (codigo.equals("0")) {
                    codigo = "no conecto";
                }
                if (!codigo.equals("no conecto")) {
                    tipo = "editarCodigo";
                    String ids = idUsuario.getText().toString();
                    String nombre = text1.getText().toString();
                    String var = "";


                    if (arrayCodigo[18].equals("1")) {
                        text2.setVisibility(View.VISIBLE);
                        String valor = text2.getText().toString();
                        String prue = "update18";
                        ServerManager serverManager18 = new ServerManager(this);//si esto se cumple quiere decir que el valor es 0 por tanto no se le otorga visibilidad
                        serverManager18.execute(tipo, nombre, ids, prue, valor);
                        while (serverManager18.var == null) {
                        }
                    }

                    if (arrayCodigo[17].equals("1")) {
                        text3.setVisibility(View.VISIBLE);
                        String valor = text3.getText().toString();
                        String prue = "update17";
                        ServerManager serverManager17 = new ServerManager(this);
                        serverManager17.execute(tipo, nombre, ids, prue, valor);
                        while (serverManager17.var == null) {
                        }
                    }

                    if (arrayCodigo[16].equals("1")) {
                        text4.setVisibility(View.VISIBLE);
                        String valor = text4.getText().toString();
                        String prue = "update16";
                        ServerManager serverManager16 = new ServerManager(this);
                        serverManager16.execute(tipo, nombre, ids, prue, valor);
                        while (serverManager16.var == null) {
                        }
                    }

                    if (arrayCodigo[15].equals("1")) {
                        text5.setVisibility(View.VISIBLE);
                        String valor = text5.getText().toString();
                        String prue = "update15";
                        ServerManager serverManager15 = new ServerManager(this);
                        serverManager15.execute(tipo, nombre, ids, prue, valor);
                        while (serverManager15.var == null) {
                        }
                    }

                    if (arrayCodigo[14].equals("1")) {
                        text6.setVisibility(View.VISIBLE);
                        String valor = text6.getText().toString();
                        String prue = "update14";
                        ServerManager serverManager14 = new ServerManager(this);
                        serverManager14.execute(tipo, nombre, ids, prue, valor);
                        while (serverManager14.var == null) {
                        }
                    }

                    if (arrayCodigo[13].equals("1")) {
                        text7.setVisibility(View.VISIBLE);
                        String valor = text7.getText().toString();
                        String prue = "update13";
                        ServerManager serverManager13 = new ServerManager(this);
                        serverManager13.execute(tipo, nombre, ids, prue, valor);
                        while (serverManager13.var == null) {
                        }

                    }

                    if (arrayCodigo[12].equals("1")) {
                        text8.setVisibility(View.VISIBLE);
                        String valor = text8.getText().toString();
                        String prue = "update12";
                        ServerManager serverManager12 = new ServerManager(this);
                        serverManager12.execute(tipo, nombre, ids, prue, valor);
                        while (serverManager12.var == null) {
                        }
                    }

                    if (arrayCodigo[11].equals("1")) {
                        text9.setVisibility(View.VISIBLE);
                        String valor = text9.getText().toString();
                        String prue = "update11";
                        ServerManager serverManager11 = new ServerManager(this);
                        serverManager11.execute(tipo, nombre, ids, prue, valor);
                        while (serverManager11.var == null) {
                        }
                    }

                    if (arrayCodigo[10].equals("1")) {
                        text10.setVisibility(View.VISIBLE);
                        String valor = text10.getText().toString();
                        String prue = "update20";
                        ServerManager serverManager20 = new ServerManager(this);
                        serverManager20.execute(tipo, nombre, ids, prue, valor);
                        while (serverManager20.var == null) {
                        }
                    }

                    if (arrayCodigo[9].equals("1")) {
                        text11.setVisibility(View.VISIBLE);
                        String valor = text11.getText().toString();
                        String prue = "update21";
                        ServerManager serverManager21 = new ServerManager(this);
                        serverManager21.execute(tipo, nombre, ids, prue, valor);
                        while (serverManager21.var == null) {
                        }
                    }

                    if (arrayCodigo[8].equals("1")) {
                        text12.setVisibility(View.VISIBLE);
                        String valor = text12.getText().toString();
                        String prue = "update22";
                        ServerManager serverManager22 = new ServerManager(this);
                        serverManager22.execute(tipo, nombre, ids, prue, valor);
                        while (serverManager22.var == null) {
                        }
                    }

                    if (arrayCodigo[7].equals("1")) {
                        text13.setVisibility(View.VISIBLE);
                        String valor = text13.getText().toString();
                        String prue = "update23";
                        ServerManager serverManager23 = new ServerManager(this);
                        serverManager23.execute(tipo, nombre, ids, prue, valor);
                        while (serverManager23.var == null) {
                        }
                    }

                    if (arrayCodigo[6].equals("1")) {
                        text14.setVisibility(View.VISIBLE);
                        String valor = text14.getText().toString();
                        String prue = "update24";
                        ServerManager serverManager24 = new ServerManager(this);
                        serverManager24.execute(tipo, nombre, ids, prue, valor);
                        while (serverManager24.var == null) {
                        }
                    }

                    if (arrayCodigo[5].equals("1")) {
                        text15.setVisibility(View.VISIBLE);
                        String valor = text15.getText().toString();
                        String prue = "update25";
                        ServerManager serverManager25 = new ServerManager(this);
                        serverManager25.execute(tipo, nombre, ids, prue, valor);
                        while (serverManager25.var == null) {
                        }
                    }

                    if (arrayCodigo[4].equals("1")) {
                        text16.setVisibility(View.VISIBLE);
                        String valor = text16.getText().toString();
                        String prue = "update26";
                        ServerManager serverManager26 = new ServerManager(this);
                        serverManager26.execute(tipo, nombre, ids, prue, valor);
                        while (serverManager26.var == null) {
                        }
                    }

                    if (arrayCodigo[3].equals("1")) {
                        text17.setVisibility(View.VISIBLE);
                        String valor = text17.getText().toString();
                        String prue = "update27";
                        ServerManager serverManager27 = new ServerManager(this);
                        serverManager27.execute(tipo, nombre, ids, prue, valor);
                        while (serverManager27.var == null) {
                        }
                    }

                    if (arrayCodigo[2].equals("1")) {
                        text18.setVisibility(View.VISIBLE);
                        String valor = text18.getText().toString();
                        String prue = "update28";
                        ServerManager serverManager28 = new ServerManager(this);
                        serverManager28.execute(tipo, nombre, ids, prue, valor);
                        while (serverManager28.var == null) {
                        }

                    }



                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Registros editados", Toast.LENGTH_SHORT);


                    toast1.show();


                }
            }
        }
    }

    public void onStore (View View) {



        ServerManager serverManager = new ServerManager(this);

        tipo = "userIdd";
        sNombreDoc = nombreDoc.getText().toString();
        sPassDoc = passDoc.getText().toString();
        serverManager.execute(tipo,sNombreDoc,sPassDoc);
        while(serverManager.docIdResult == null){
        }
        String idd=serverManager.docIdResult.replace("null","");

        String id = idUsuario.getText().toString();
        String b = tupass.getText().toString();
        Encriptacion encriptacion = new Encriptacion();
        try {
            String description = encriptacion.desencriptar(b);
            tupass.setText(description.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        String clave= tupass.getText().toString();
             String imei =a();
        tipo = "guardarCodigo";

        ServerManager serverManager1 = new ServerManager(this);
        serverManager1.execute(tipo,idd,id,clave);

        Toast toast1 =
                Toast.makeText(getApplicationContext(),
                        "Validacion registrada, codigo guardado", Toast.LENGTH_SHORT);


        toast1.show();

    }

    public void onfinish2 (View View) {
        Intent intent = new Intent(this, LoginDoctor.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mResumed = true;
        // Sticky notes received from Android
        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(getIntent().getAction())) {
            NdefMessage[] messages = getNdefMessages(getIntent());
            byte[] payload = messages[0].getRecords()[0].getPayload();
            setNoteBody(new String(payload));
            setIntent(new Intent()); // Consume this intent.
        }
        enableNdefExchangeMode();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mResumed = false;
        mNfcAdapter.disableForegroundNdefPush(this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        // NDEF exchange mode
        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(intent.getAction())) {
            NdefMessage[] msgs = getNdefMessages(intent);
            promptForContent(msgs[0]);
        }
    }
    private TextWatcher mTextWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {

        }

        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {

        }

        @Override
        public void afterTextChanged(Editable arg0) {
            if (mResumed) {
                mNfcAdapter.enableForegroundNdefPush(LoginDoctor.this, getPassAsNdef());
            }
        }
    };

    private void promptForContent(final NdefMessage msg) {
        new AlertDialog.Builder(this).setTitle("Aceptar el codigo a pasar?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        String body = new String(msg.getRecords()[0].getPayload());
                        setNoteBody(body);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                }).show();
    }


    private void setNoteBody(String body) {
        Editable text = tupass.getText();
        text.clear();
        text.append(body);
    }



    private NdefMessage getPassAsNdef() {
        byte[] textBytes =tupass.getText().toString().getBytes();
        NdefRecord textRecord = new NdefRecord(NdefRecord.TNF_MIME_MEDIA, "text/plain".getBytes(),
                new byte[] {}, textBytes);
        return new NdefMessage(new NdefRecord[] {
                textRecord
        });
    }


    NdefMessage[] getNdefMessages(Intent intent) {
        // Parse the intent
        NdefMessage[] msgs = null;
        String action = intent.getAction();
        if (NfcAdapter.ACTION_TAG_DISCOVERED.equals(action)
                || NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action)) {
            Parcelable[] rawMsgs = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
            if (rawMsgs != null) {
                msgs = new NdefMessage[rawMsgs.length];
                for (int i = 0; i < rawMsgs.length; i++) {
                    msgs[i] = (NdefMessage) rawMsgs[i];
                }
            } else {
                // Unknown tag type
                byte[] empty = new byte[] {};
                NdefRecord record = new NdefRecord(NdefRecord.TNF_UNKNOWN, empty, empty, empty);
                NdefMessage msg = new NdefMessage(new NdefRecord[] {
                        record
                });
                msgs = new NdefMessage[] {
                        msg
                };
            }
        } else {
            Log.d(TAG, "Unknown intent.");
            finish();
        }
        return msgs;
    }

    private void enableNdefExchangeMode() {
        mNfcAdapter.enableForegroundNdefPush(LoginDoctor.this, getPassAsNdef());
        mNfcAdapter.enableForegroundDispatch(this, mNfcPendingIntent, mNdefExchangeFilters, null);
    }

    private void disableNdefExchangeMode() {
        mNfcAdapter.disableForegroundNdefPush(this);
        mNfcAdapter.disableForegroundDispatch(this);
    }








}