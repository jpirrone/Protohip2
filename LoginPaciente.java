package com.carloskowalevicz.pokemon;
import android.os.Bundle;
import android.view.View;

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
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.carloskowalevicz.pokemon.R.id.a;
import static com.carloskowalevicz.pokemon.R.id.b;
import static com.carloskowalevicz.pokemon.R.id.c;
import static com.carloskowalevicz.pokemon.R.id.d;
import static com.carloskowalevicz.pokemon.R.id.idUsuario;

public class LoginPaciente extends Activity {

    private static final String TAG = "stickynotes";
    private boolean mResumed = false;
    NfcAdapter mNfcAdapter;
    EditText tupass,id;
    public long codigo = 0;
    public String propiedadCodigo;
    public CheckBox check1,check2,check3,check4,check5,check6,check7,check8,check9,check10,check11,check12,check13,check14,check15,check16,check17,check18;
    public Button generarCodig;
    EditText text,text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12,text13,text14,text15,text16,text17,text18,idDoctor,idUsuario;


    public String tipo,variables;
    PendingIntent mNfcPendingIntent;
    IntentFilter[] mNdefExchangeFilters;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
        setContentView(R.layout.activity_login_paciente);

        if (getIntent().getBooleanExtra("EXIT", false))
        {
            finish();
        }

        tupass = (EditText) findViewById(R.id.pass);
        tupass.addTextChangedListener(mTextWatcher);
        id = (EditText)findViewById(R.id.id);
        mNfcPendingIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);

        IntentFilter ndefDetected = new IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED);
        try {
            ndefDetected.addDataType("text/plain");
        } catch (MalformedMimeTypeException e) { }
        mNdefExchangeFilters = new IntentFilter[] { ndefDetected };

        check1 =(CheckBox)findViewById(R.id.checkBox1);
        check2 =(CheckBox)findViewById(R.id.checkBox2);
        check3 =(CheckBox)findViewById(R.id.checkBox3);
        check4 =(CheckBox)findViewById(R.id.checkBox4);
        check5 =(CheckBox)findViewById(R.id.checkBox5);
        check6 =(CheckBox)findViewById(R.id.checkBox6);
        check7 =(CheckBox)findViewById(R.id.checkBox7);
        check8 =(CheckBox)findViewById(R.id.checkBox8);
        check9 =(CheckBox)findViewById(R.id.checkBox9);
        check10 =(CheckBox)findViewById(R.id.checkBox10);
        check11 =(CheckBox)findViewById(R.id.checkBox11);
        check12 =(CheckBox)findViewById(R.id.checkBox12);
        check13 =(CheckBox)findViewById(R.id.checkBox13);
        check14 =(CheckBox)findViewById(R.id.checkBox14);
        check15 =(CheckBox)findViewById(R.id.checkBox15);
        check16 =(CheckBox)findViewById(R.id.checkBox16);
        check17 =(CheckBox)findViewById(R.id.checkBox17);
        check18 =(CheckBox)findViewById(R.id.checkBox18);


        text1 = (EditText)findViewById(R.id.textView2);
        text2 = (EditText)findViewById(R.id.textView3);
        text3 = (EditText)findViewById(R.id.textView4);
        text4 = (EditText)findViewById(R.id.textView5);
        text5 = (EditText)findViewById(R.id.textView6);
        text6 = (EditText)findViewById(R.id.textView7);
        text7 = (EditText)findViewById(R.id.textView8);
        text8 = (EditText)findViewById(R.id.textView9);
        text9 = (EditText)findViewById(R.id.textView10);
        text10 = (EditText)findViewById(R.id.textView11);
        text11 = (EditText)findViewById(R.id.textView12);
        text12 = (EditText)findViewById(R.id.textView13);
        text13 = (EditText)findViewById(R.id.textView14);
        text14 = (EditText)findViewById(R.id.textView15);
        text15 = (EditText)findViewById(R.id.textView16);
        text16 = (EditText)findViewById(R.id.textView17);
        text17 = (EditText)findViewById(R.id.textView18);
        text18 = (EditText)findViewById(R.id.textView19);
        idDoctor= (EditText)findViewById(R.id.editdoc);
        tipo = "getData";
        String idpas="";
        String prue = "getData2";

        while (ServerManager.userId == null){
        }

        idpas = ServerManager.userId.replace("null", "");
        ServerManager serverManager = new ServerManager(this);

        serverManager.execute(tipo ,idpas, prue);

        while (serverManager.var == null ){
        }

        variables = serverManager.var.replace("null", "");
        variables = variables.replace("[", "");
        variables = variables.replace("]", "");
        variables = variables.replace("\"", "");
      // variables = variables.trim(); no se si hacerlo por que va a alterar a ls array
       String[] variablesArray = variables.split(",");
if (variablesArray[1] != null) {
    text1.setText(variablesArray[0]);
    text2.setText(variablesArray[1]);
    text3.setText(variablesArray[2]);
    text4.setText(variablesArray[3]);
    text5.setText(variablesArray[4]);
    text6.setText(variablesArray[5]);
    text7.setText(variablesArray[6]);
    text8.setText(variablesArray[7]);
    text9.setText(variablesArray[8]);
    text10.setText(variablesArray[9]);
    text11.setText(variablesArray[10]);
    text12.setText(variablesArray[11]);
    text13.setText(variablesArray[12]);
    text14.setText(variablesArray[13]);
    text15.setText(variablesArray[14]);
    text16.setText(variablesArray[15]);
    text17.setText(variablesArray[16]);
    text18.setText(variablesArray[17]);
}
       id.setText(idpas);
        id.setFocusable(false);
    }

public void verDoctor(View View){
    String idDoc = idDoctor.getText().toString();
    ServerManager serverManager3 = new ServerManager(this);
    tipo = "verDoc";
    serverManager3.execute(tipo, idDoc);

while(serverManager3.idResult.equals("")){}
    Toast toast1 =
            Toast.makeText(getApplicationContext(),
                    serverManager3.idResult, Toast.LENGTH_SHORT);


    toast1.show();
}
    public void onEditarDoc(View View){

        String idDoc = idDoctor.getText().toString();
        String idpas = id.getText().toString();
        if (idDoc.equals("") || idDoc.equals(null))
        {
            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            "genere primero un codigo para enviarlo al doctor", Toast.LENGTH_SHORT);
            toast1.show();
        }
        String b = tupass.getText().toString();
        Encriptacion encriptacion = new Encriptacion();
        try {
            String description = encriptacion.desencriptar(b);
            tupass.setText(description.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String pass = tupass.getText().toString();

        if (!pass.equals("")) {
             if (!idDoc.equals("")) {
                 tipo = "editarCodigoDoc";
                 ServerManager serverManager2 = new ServerManager(this);
                 serverManager2.execute(tipo, idDoc, pass,idpas);
                 while (serverManager2.var==null){
                 };
                 if (serverManager2.var.equals("Clave no Actualizada")) {
                     Toast toast1 =
                             Toast.makeText(getApplicationContext(),
                                     "Relación inexistente, intercambie código directamente con el Doctor para crearla", Toast.LENGTH_SHORT);
                     toast1.show();

                 } else {
                     Toast toast1 =
                             Toast.makeText(getApplicationContext(),
                                     "Clave Actualizada", Toast.LENGTH_SHORT);
                      toast1.show();
                    }


             }
        }
    }

    public void onGen(View View) {
      String v = ServerManager.userId.replace("null", "");

        codigo=  1000000000000000000l;

        if (check1.isChecked()) {
            codigo = codigo + 1l;
        }if (check2.isChecked()) {
            codigo = codigo + 10l;
        }if (check3.isChecked()) {
            codigo = codigo + 100l;
        }if (check4.isChecked()) {
            codigo = codigo + 1000l;
        }if (check5.isChecked()) {
            codigo = codigo + 10000l;
        }if (check6.isChecked()) {
            codigo = codigo + 100000l;
        }if (check7.isChecked()) {
            codigo = codigo + 1000000l;
        }if (check8.isChecked()) {
            codigo = codigo + 10000000l;
        }if (check9.isChecked()) {
            codigo = codigo + 100000000l;
        }if (check10.isChecked()) {
            codigo = codigo + 1000000000l;
        }if (check11.isChecked()) {
            codigo = codigo + 10000000000l;
        }if (check12.isChecked()) {
            codigo = codigo + 100000000000l;
        }if (check13.isChecked()) {
            codigo = codigo + 1000000000000l;
        }if (check14.isChecked()) {
            codigo = codigo + 10000000000000l;
        }if (check15.isChecked()) {
            codigo = codigo + 100000000000000l;
        }if (check16.isChecked()) {
            codigo = codigo + 1000000000000000l;
        }if (check17.isChecked()) {
            codigo = codigo + 10000000000000000l;
        }if (check18.isChecked()) {
            codigo = codigo + 100000000000000000l;
        }

        this.propiedadCodigo = Long.toString(codigo);
       // propiedadCodigo= propiedadCodigo + v;
        Encriptacion encriptacion = new Encriptacion();
        try {
            String description = encriptacion.encriptar(propiedadCodigo);
            tupass.setText(description.toString().replace("\n", ""));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Toast toast1 =
                Toast.makeText(getApplicationContext(),
                        "Codigo generado ya se puede enviar por nfc", Toast.LENGTH_SHORT);


        toast1.show();
     //   tupass.setText(propiedadCodigo);



    }
    public void onEdit (View View){

        tipo = "editarCodigo";

        String ids = id.getText().toString();
        String nombre = text1.getText().toString();
        text1.setVisibility(View.VISIBLE);
        String var = "";

            text2.setVisibility(View.VISIBLE);
            String valor2 = text2.getText().toString();
            String prue2 = "update18";
            ServerManager serverManager18 = new ServerManager(this);//si esto se cumple quiere decir que el valor es 0 por tanto no se le otorga visibilidad
            serverManager18.execute(tipo, nombre, ids, prue2, valor2);
            while (serverManager18.var == null) {
            }

            text3.setVisibility(View.VISIBLE);
            String valor3 = text3.getText().toString();
            String prue3 = "update17";
            ServerManager serverManager17 = new ServerManager(this);
            serverManager17.execute(tipo, nombre, ids, prue3, valor3);
            while (serverManager17.var == null) {
            }

            text4.setVisibility(View.VISIBLE);
            String valor4 = text4.getText().toString();
            String prue4 = "update16";
            ServerManager serverManager16 = new ServerManager(this);
            serverManager16.execute(tipo, nombre, ids, prue4, valor4);
            while (serverManager16.var == null) {
            }

            text5.setVisibility(View.VISIBLE);
            String valor5 = text5.getText().toString();
            String prue5 = "update15";
            ServerManager serverManager15 = new ServerManager(this);
            serverManager15.execute(tipo, nombre, ids, prue5, valor5);
            while (serverManager15.var == null) {
            }

            text6.setVisibility(View.VISIBLE);
            String valor6 = text6.getText().toString();
            String prue6 = "update14";
            ServerManager serverManager14 = new ServerManager(this);
            serverManager14.execute(tipo, nombre, ids, prue6, valor6);
            while (serverManager14.var == null) {
            }

            text7.setVisibility(View.VISIBLE);
            String valor7 = text7.getText().toString();
            String prue7 = "update13";
            ServerManager serverManager13 = new ServerManager(this);
            serverManager13.execute(tipo, nombre, ids, prue7, valor7);
            while (serverManager13.var == null) {
            }

            text8.setVisibility(View.VISIBLE);
            String valor8 = text8.getText().toString();
            String prue8 = "update12";
            ServerManager serverManager12 = new ServerManager(this);
            serverManager12.execute(tipo, nombre, ids, prue8, valor8);
           while (serverManager12.var == null) {
            }

            text9.setVisibility(View.VISIBLE);
            String valor9 = text9.getText().toString();
            String prue9 = "update11";
            ServerManager serverManager11 = new ServerManager(this);
            serverManager11.execute(tipo, nombre, ids, prue9, valor9);
            while (serverManager11.var == null) {
            }

            text10.setVisibility(View.VISIBLE);
            String valor10 = text10.getText().toString();
            String prue10 = "update20";
            ServerManager serverManager20 = new ServerManager(this);
            serverManager20.execute(tipo, nombre, ids, prue10, valor10);
            while (serverManager20.var == null) {
            }

            text11.setVisibility(View.VISIBLE);
            String valor11 = text11.getText().toString();
            String prue11 = "update21";
            ServerManager serverManager21 = new ServerManager(this);
            serverManager21.execute(tipo, nombre, ids, prue11, valor11);
            while (serverManager21.var == null) {
            }

            text12.setVisibility(View.VISIBLE);
            String valor12 = text12.getText().toString();
            String prue12 = "update22";
            ServerManager serverManager22 = new ServerManager(this);
            serverManager22.execute(tipo, nombre, ids, prue12, valor12);
            while (serverManager22.var == null) {
            }

            text13.setVisibility(View.VISIBLE);
            String valor13 = text13.getText().toString();
            String prue13 = "update23";
            ServerManager serverManager23 = new ServerManager(this);
            serverManager23.execute(tipo, nombre, ids, prue13, valor13);
            while (serverManager23.var == null) {
            }

            text14.setVisibility(View.VISIBLE);
            String valor14 = text14.getText().toString();
            String prue14 = "update24";
            ServerManager serverManager24 = new ServerManager(this);
            serverManager24.execute(tipo, nombre, ids, prue14, valor14);
            while (serverManager24.var == null) {
            }


            text15.setVisibility(View.VISIBLE);
            String valor15 = text15.getText().toString();
            String prue15 = "update25";
            ServerManager serverManager25 = new ServerManager(this);
            serverManager25.execute(tipo, nombre, ids, prue15, valor15);
            while (serverManager25.var == null) {
            }

            text16.setVisibility(View.VISIBLE);
            String valor16 = text16.getText().toString();
            String prue16 = "update26";
            ServerManager serverManager26 = new ServerManager(this);
            serverManager26.execute(tipo, nombre, ids, prue16, valor16);
            while (serverManager26.var == null) {
            }

            text17.setVisibility(View.VISIBLE);
            String valor17 = text17.getText().toString();
            String prue17 = "update27";
            ServerManager serverManager27 = new ServerManager(this);
            serverManager27.execute(tipo, nombre, ids, prue17, valor17);
            while (serverManager27.var == null) {
            }

            text18.setVisibility(View.VISIBLE);
            String valor18 = text18.getText().toString();
            String prue18 = "update28";
            ServerManager serverManager28 = new ServerManager(this);
            serverManager28.execute(tipo, nombre, ids, prue18, valor18);
            while (serverManager28.var == null) {
            }

        Toast toast1;
        toast1 = Toast.makeText(getApplicationContext(),
                "Registros editados", Toast.LENGTH_SHORT);


        toast1.show();

     //   ServerManager serverManager1 = new ServerManager(this);
     //   tipo = "editarCodigo";
    //    String nombre = text1.getText().toString();
    //    String a = text2.getText().toString();
    //    String b = text3.getText().toString();
     //   String c = text4.getText().toString();
     //   String d = text5.getText().toString();
     //   String e = text6.getText().toString();
    //    String f = text7.getText().toString();
    //    String g = text8.getText().toString();
    //    String h = text9.getText().toString();
    //    String i = text10.getText().toString();
    //    String j = text11.getText().toString();
    //    String k = text12.getText().toString();
    //    String l = text13.getText().toString();
     //   String m = text14.getText().toString();
     //   String n = text15.getText().toString();
     //   String o = text16.getText().toString();
     //   String p = text17.getText().toString();
     //   String q = text18.getText().toString();

     //   String ids = ServerManager.userId.replace("null", "");

     //   serverManager1.execute(tipo, nombre, a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, ids);
    //    while(serverManager1.result.equals("")){
    //    }

    //    if (serverManager1.result.equals("Actualizacionexitosa")) {

     //       Toast toast10 = Toast.makeText(getApplicationContext(),
     //               "Actualizacion Exitosa", Toast.LENGTH_SHORT);

    //        toast10.show();
    //    } else {
    //        Toast toast10;
    //        toast10= Toast.makeText(getApplicationContext(),
      //              "Actualizacion no exitosa", Toast.LENGTH_SHORT);
//
       //     toast10.show();

    }

    public void onfinish4 (View View) {
        Intent intent = new Intent(this, LoginPaciente.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mResumed = true;

        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(getIntent().getAction())) {
            NdefMessage[] messages = getNdefMessages(getIntent());
            byte[] payload = messages[0].getRecords()[0].getPayload();
            setNoteBody(new String(payload));
            setIntent(new Intent());
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


        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(intent.getAction())) {
            NdefMessage[] msgs = getNdefMessages(intent);
            promptForContent(msgs[0]);
        }
    }
    private final TextWatcher mTextWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {

        }

        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {

        }

        @Override
        public void afterTextChanged(Editable arg0) {
            if (mResumed) {
                mNfcAdapter.enableForegroundNdefPush(LoginPaciente.this, getPassAsNdef());
            }
        }
    };

    private void promptForContent(final NdefMessage msg) {
        new AlertDialog.Builder(this).setTitle("Replace current content?")
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
        // Parse el intent
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
        mNfcAdapter.enableForegroundNdefPush(LoginPaciente.this, getPassAsNdef());
        mNfcAdapter.enableForegroundDispatch(this, mNfcPendingIntent, mNdefExchangeFilters, null);
    }

    private void disableNdefExchangeMode() {
        mNfcAdapter.disableForegroundNdefPush(this);
        mNfcAdapter.disableForegroundDispatch(this);
    }








}