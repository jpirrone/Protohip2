package com.carloskowalevicz.pokemon;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;

public class registro extends AppCompatActivity {

    EditText username, password,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q;
    public Intent voy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        if (getIntent().getBooleanExtra("EXIT", false))
        {
            finish();
        }

        a = (EditText)findViewById(R.id.a);
        b = (EditText)findViewById(R.id.b);
        c = (EditText)findViewById(R.id.c);
        d = (EditText)findViewById(R.id.d);
        e = (EditText)findViewById(R.id.e);
        f = (EditText)findViewById(R.id.f);
        g = (EditText)findViewById(R.id.g);
        h = (EditText)findViewById(R.id.h);
        i = (EditText)findViewById(R.id.i);
        j = (EditText)findViewById(R.id.j);
        k = (EditText)findViewById(R.id.k);
        l = (EditText)findViewById(R.id.l);
        m = (EditText)findViewById(R.id.m);
        n = (EditText)findViewById(R.id.n);
        o = (EditText)findViewById(R.id.o);
        p = (EditText)findViewById(R.id.p);
        q = (EditText)findViewById(R.id.q);

        a.setVisibility(View.INVISIBLE);
        b.setVisibility(View.INVISIBLE);
        c.setVisibility(View.INVISIBLE);
        d.setVisibility(View.INVISIBLE);
        e.setVisibility(View.INVISIBLE);
        f.setVisibility(View.INVISIBLE);
        g.setVisibility(View.INVISIBLE);
        h.setVisibility(View.INVISIBLE);
        i.setVisibility(View.INVISIBLE);
        j.setVisibility(View.INVISIBLE);
        k.setVisibility(View.INVISIBLE);
        l.setVisibility(View.INVISIBLE);
        m.setVisibility(View.INVISIBLE);
        n.setVisibility(View.INVISIBLE);
        o.setVisibility(View.INVISIBLE);
        p.setVisibility(View.INVISIBLE);
        q.setVisibility(View.INVISIBLE);

        username = (EditText)findViewById(R.id.pusername);
        password = (EditText)findViewById(R.id.ppassword);

            }
    public void click1(View view){//show
        a.setVisibility(View.VISIBLE);
    }
    public void click20(View view){//hide
        a.setVisibility(View.INVISIBLE);
    }
    public void click2(View view){//show
        b.setVisibility(View.VISIBLE);
    }
    public void click21(View view){//hide
        b.setVisibility(View.INVISIBLE);
    }
    public void click3(View view){//show
        c.setVisibility(View.VISIBLE);
    }
    public void click22(View view) {//hide
        c.setVisibility(View.INVISIBLE);
    }
    public void click4(View view){//show
        d.setVisibility(View.VISIBLE);
    }
    public void click23(View view) {//hide
        d.setVisibility(View.INVISIBLE);
    }

    public void click5(View view){//show
        e.setVisibility(View.VISIBLE);
    }
    public void click24(View view) {//hide
        e.setVisibility(View.INVISIBLE);
    }

    public void click6(View view){//show
        f.setVisibility(View.VISIBLE);
    }
    public void click25(View view) {//hide
        f.setVisibility(View.INVISIBLE);
    }

    public void click7(View view){//show
        g.setVisibility(View.VISIBLE);
    }
    public void click26(View view) {//hide
        g.setVisibility(View.INVISIBLE);
    }

    public void click8(View view){//show
        h.setVisibility(View.VISIBLE);
    }
    public void click27(View view) {//hide
        h.setVisibility(View.INVISIBLE);
    }

    public void click9(View view){//show
        i.setVisibility(View.VISIBLE);
    }
    public void click28(View view) {//hide
        i.setVisibility(View.INVISIBLE);
    }

    public void click10(View view){//show
        j.setVisibility(View.VISIBLE);
    }
    public void click29(View view) {//hide
        j.setVisibility(View.INVISIBLE);
    }

    public void click11(View view){//show
        k.setVisibility(View.VISIBLE);
    }
    public void click30(View view) {//hide
        k.setVisibility(View.INVISIBLE);
    }

    public void click12(View view){//show
        l.setVisibility(View.VISIBLE);
    }
    public void click31(View view) {//hide
        l.setVisibility(View.INVISIBLE);
    }

    public void click13(View view){//show
        m.setVisibility(View.VISIBLE);
    }
    public void click32(View view) {//hide
        m.setVisibility(View.INVISIBLE);
    }

    public void click14(View view){//show
        n.setVisibility(View.VISIBLE);
    }
    public void click33(View view) {//hide
        n.setVisibility(View.INVISIBLE);
    }

    public void click15(View view){//show
        o.setVisibility(View.VISIBLE);
    }
    public void click34(View view) {//hide
        o.setVisibility(View.INVISIBLE);
    }

    public void click16(View view){//show
        p.setVisibility(View.VISIBLE);
    }
    public void click35(View view) {//hide
        p.setVisibility(View.INVISIBLE);
    }

    public void click17(View view){//show
        q.setVisibility(View.VISIBLE);
    }
    public void click36(View view) {//hide
        q.setVisibility(View.INVISIBLE);
    }


    public String a() {

        //TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        //String imei =tm.getDeviceId(); // Obtiene el imei  or  "352319065579474";
       // return imei;
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

    public void onreg(View view){

        String susername = username.getText().toString();
        String spassword = password.getText().toString();

        String sa = a.getText().toString();
        if (sa.equals("")){
            sa = "No presenta";
        }
        String sb = b.getText().toString();
        if (sb.equals("")){
            sb = "No presenta";
        }
        String sc = c.getText().toString();
        if (sc.equals("")){
            sc = "No presenta";
        }
        String sd = d.getText().toString();
        if (sd.equals("")){
            sd = "No presenta";
        }
        String se = e.getText().toString();
        if (se.equals("")){
            se = "No presenta";
        }
        String sf = f.getText().toString();
        if (sf.equals("")){
            sf = "No presenta";
        }
        String sg = g.getText().toString();
        if (sg.equals("")){
            sg = "No presenta";
        }
        String sh = h.getText().toString();
        if (sh.equals("")){
            sh = "No presenta";
        }
        String si = i.getText().toString();
        if (si.equals("")){
            si = "No presenta";
        }
        String sj = j.getText().toString();
        if (sj.equals("")){
            sj = "No presenta";
        }
        String sk = k.getText().toString();
        if (sk.equals("")){
            sk = "No presenta";
        }
        String sl = l.getText().toString();
        if (sl.equals("")){
            sl = "No presenta";
        }
        String sm = m.getText().toString();
        if (sm.equals("")){
            sm = "No presenta";
        }
        String sn = n.getText().toString();
        if (sn.equals("")){
            sn = "No presenta";
        }
        String so = o.getText().toString();
        if (so.equals("")){
            so = "No presenta";
        }
        String sp = p.getText().toString();
        if (sp.equals("")){
            sp = "No presenta";
        }
        String sq = q.getText().toString();
        if (sq.equals("")){
            sq = "No presenta";
        }
        String ips = "192.168.2.100";
        String tipo = "comprueba";

        ServerManager serverManager2 = new ServerManager(this);
        serverManager2.execute(tipo, susername, ips);
       while (serverManager2.getConectionStatus() == null)
       {}
        String imei= a();
        if (serverManager2.getConectionStatus().equals("usuario no existente")) {
            if (!susername.equals("") && !spassword.equals("")) {
               tipo = "registro";


                ServerManager serverManager = new ServerManager(this);
                serverManager.execute(tipo, susername, spassword, ips, sa, sb, sc, sd, se, sf, sg, sh, si, sj, sk, sl, sm, sn, so, sp, sq, imei);

                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Paciente registrado", Toast.LENGTH_SHORT);


                toast1.show();
            } else {
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Ingrese clave y usuario para poder registrarse", Toast.LENGTH_SHORT);
                toast1.show();
            }
        }else { Toast toast1 =
                Toast.makeText(getApplicationContext(),
                        "Paciente ya registrado, registro fallido", Toast.LENGTH_SHORT);
            toast1.show();
            voy=new Intent(this,MainActivity.class);
            startActivity(voy);}
    }

    public void onfinish3 (View view) {
        Intent intent = new Intent(this, registro.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        startActivity(intent);
    }


    }


