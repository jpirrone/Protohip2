package com.carloskowalevicz.pokemon;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import static com.carloskowalevicz.pokemon.R.id.e;
import static com.carloskowalevicz.pokemon.R.id.o;
import static com.carloskowalevicz.pokemon.R.id.username;

/**
 * Created by Carlos Kowalevicz on 3/26/2016.
 */
public class ServerManager extends AsyncTask<String,Void,String>{

    public Context context;
    AlertDialog alertDialog;

    ServerManager(Context con) {
    context = con;
    }
    public static String CLASS_TAG=ServerManager.class.getName();
    public static String er="";
    String result = "";
    public Intent voy;
    public static String VALOR_A_PASAR="valor a pasar";
    public String var = null;
    public static String VALOR;
    private String conectionStatus;
    int flag = 0;


     String idResult = "";
    String docIdResult = null;

    static String ip,userId,userIdd, docId,ipdoc,userDoctor,passDoctor;
    static String userDoc,passDoc;


    public String getConectionStatus() {
        return conectionStatus;
    }

    private String login (String... params) {
        try {
            this.ip = params[3];

            String login_url = "http://" + this.ip + "/login2.php";//"http://192.168.1.220/login.php";"http://"+ip+"/login.php"


            String user = params[1];
            String pass = params[2];
            String imei = params[4];
            URL url = new URL(login_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String post_data = URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(user, "UTF-8")+ "&" +
                               URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8")+ "&" +
                               URLEncoder.encode("imei", "UTF-8") + "=" + URLEncoder.encode(imei, "UTF-8");

            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

            String linea = "";

            while ((linea = bufferedReader.readLine()) != null) {
                result += linea;
                this.conectionStatus = result;
            }

            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();

            if (conectionStatus.equals("conecto"))
            {
            }else { flag = 1;}

            return conectionStatus;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
    return null;
    }
    private String comprueba (String... params) {
        try {
            this.ip = params[2];

            String login_url = "http://" + ip + "/comprueba.php";//"http://192.168.1.220/login.php";"http://"+ip+"/login.php"


            String user = params[1];

            URL url = new URL(login_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String post_data = URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(user, "UTF-8") ;

            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

            String linea = "";

            while ((linea = bufferedReader.readLine()) != null) {
                result += linea;
                this.conectionStatus = result;
            }

            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return null;
    }
    private String verDoc (String... params) {
        try {
//Esta rutina verifica que el doctor exista

            String login_url = "http://" + this.ip + "/verDoc.php";


            String iddoc = params[1];

            URL url = new URL(login_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String post_data = URLEncoder.encode("iddoc", "UTF-8") + "=" + URLEncoder.encode(iddoc, "UTF-8") ;

            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

            String id = "";
            String nombreDoc = "";
            while ((id = bufferedReader.readLine()) != null) {
                nombreDoc += id;

            }
            this.idResult = nombreDoc;
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return null;
    }

    private void guardarCodigo (String... params) {
        try {

            String register_url = "http://"+this.ip+"/guardarCodigohp.php" ; // cambiar este al del doctor
            if (this.ip == null){
                register_url = "http://" + this.ipdoc + "/guardarCodigohp.php";
            }
           // String username = params[1];
           // String password = params[2];
            String iddoc = params[1];
            String idpas = params[2];
            String clave = params[3];
           // String imei = params [5];

            URL url = new URL(register_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String post_data =  URLEncoder.encode("iddoc","UTF-8")+"="+URLEncoder.encode(iddoc,"UTF-8")+"&"+
                             //   URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"+
                            //    URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&"+
                                URLEncoder.encode("idpas","UTF-8")+"="+URLEncoder.encode(idpas,"UTF-8")+"&"+
                                URLEncoder.encode("clave","UTF-8")+"="+URLEncoder.encode(clave,"UTF-8")+"&";
                          //      URLEncoder.encode("imei","UTF-8")+"="+URLEncoder.encode(imei,"UTF-8")+"&";

            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));

            String linea = "";

            while((linea = bufferedReader.readLine())!= null) {
                result += linea;
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void userId (String... params) {
        try {


              //  String login_url = "http://" + this.ip + "/userId2.php";//"usaba original userId2 "
            String get_url = "http://" + this.ip + "/userId2.php?username="+params[1]+"&password="+params[2];
            if (this.ip == null){
                get_url = "http://" + this.ipdoc + "/userId2.php?username="+params[1]+"&password="+params[2];
            }if (this.ip == null){
                get_url = "http://" + this.ipdoc + "/userId2.php?username="+params[1]+"&password="+params[2];
                }


            String user = params[1];
            String pass = params[2];
            URL url = new URL(get_url);
            //URL url = new URL(login_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String post_data = URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(user, "UTF-8") + "&" +
                               URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8");

            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

            String id = "";
            userId = "";
            while ((id = bufferedReader.readLine()) != null) {

                userId += id;
                Log.d(CLASS_TAG,""+userId);

            }
            this.idResult=userId;
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }

    }
    private void userIdd (String... params) {
        try {


        //    String login_url = "http://" + this.ipdoc + "/verDoc.php";//"usaba original userId2 "
            String get_url = "http://" + this.ip + "/userIddhp.php?username="+params[1]+"&password="+params[2];
            if (this.ip == null){
                get_url = "http://" + this.ipdoc + "/userIddhp.php?username="+params[1]+"&password="+params[2];
            }if (this.ip == null){
                get_url = "http://" + this.ipdoc + "/userIddhp.php?username="+params[1]+"&password="+params[2];
            }


            String user = params[1];
            String pass = params[2];
            URL url = new URL(get_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String post_data = URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(user, "UTF-8") + "&" +
                    URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8");

            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

            String id = "";
            userId = "";
            while ((id = bufferedReader.readLine()) != null) {

                userId += id;
                Log.d(CLASS_TAG,""+userId);

            }
            this.docIdResult=userId;
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    private void codigoDoc (String... params) {
        try {

            String login_url = "http://" + this.ipdoc + "/codigoDochp.php";//"http://192.168.1.220/login.php";"http://"+ip+"/login.php"

          //  String user = params[1];
          //  String pass = params[2];
          //  String idpas = params[3];
            String iddoc = params[1];
            String idpas = params[2];
            URL url = new URL(login_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
         //   String post_data = URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(user, "UTF-8") + "&" +
         //                      URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8") + "&" +
         //                      URLEncoder.encode("idpas", "UTF-8") + "=" + URLEncoder.encode(idpas, "UTF-8");
            String post_data = URLEncoder.encode("iddoc", "UTF-8") + "=" + URLEncoder.encode(iddoc, "UTF-8") + "&" +
                               URLEncoder.encode("idpas", "UTF-8") + "=" + URLEncoder.encode(idpas, "UTF-8");
            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

            String id = "";
            docIdResult = null;
            docId = null;

            while ((id = bufferedReader.readLine()) != null) {
                docId += id;
                this.docIdResult=docId;
                docIdResult=docIdResult.replace("null", "");
            }

            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    private void getData(String... params) {// se hizo un void
        try {


            params[1] = params[1].replace("null", "");
            String get_url = "http://" + this.ip + "/"+params[2]+".php?idpas="+ params[1];
            if (this.ip == null){
            get_url = "http://" + this.ipdoc +  "/"+params[2]+".php?idpas="+ params[1];
            }
            URL url = new URL(get_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));


           StringBuilder stringBuilder = new StringBuilder();
            String linea = "";
            var = null;

            while ((linea = bufferedReader.readLine()) != null) {
             stringBuilder.append(linea);
            }
            this.var = stringBuilder.toString().trim().replace("null", "");
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();

           //stringBuilder.toString().trim().replace("null", "");

        }
            catch(MalformedURLException e){
                e.printStackTrace();
            }
            catch(IOException e){
                e.printStackTrace();
            }
     //   String user = params[1];
     //   String pass = params[3];
     //   URL url = new URL(get_url);
     //   HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
     //   httpURLConnection.setRequestMethod("GET");
     //   httpURLConnection.setDoOutput(true);
     //   httpURLConnection.setDoInput(true);
     //   OutputStream outputStream = httpURLConnection.getOutputStream();
     //   BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
      //      String post_data = URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(user, "UTF-8");

      //  bufferedWriter.write(post_data);
      //  bufferedWriter.flush();
      //  bufferedWriter.close();
      //  outputStream.close();
     //   InputStream inputStream = httpURLConnection.getInputStream();
     //   BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

    //    String id = "";
     //   userId = "";
     //   while ((id = bufferedReader.readLine()) != null) {

     //       userId += id;
     //       Log.d(CLASS_TAG,""+userId);

     //   }
     //   this.docIdResult=userId;
     //   bufferedReader.close();
     //   inputStream.close();
     //   httpURLConnection.disconnect();



   // } catch (MalformedURLException e) {
    //    e.printStackTrace();
   // } catch (IOException e) {
    //    e.printStackTrace();

   // }

    }


    private void editarCodigo (String... params) {
        try {



            String get_url = "http://" + this.ip + "/"+params[3]+".php";
            if (this.ip == null){
                get_url = "http://" + this.ipdoc + "/"+params[3]+".php";
            }
            String username = params[1];
            String idpas = params[2];
            String valor = params[4];



            URL url = new URL(get_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);


            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String post_data =  URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"+
                                URLEncoder.encode("idpas","UTF-8")+"="+URLEncoder.encode(idpas,"UTF-8")+"&"+
                                URLEncoder.encode("valor","UTF-8")+"="+URLEncoder.encode(valor,"UTF-8");

            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));

            String linea = "";
            String var="";
            while((linea = bufferedReader.readLine())!= null) {
                result += linea;
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            this.var=result;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }




    }



    private void editarCodigoDoc (String... params) {
        try {

            String get_url = "http://" + this.ip + "/updateDochp.php";
            if (this.ip == null){
                get_url = "http://" + this.ipdoc + "/updateDochp.php";
            }
            String iddoc = params[1];
            String clave = params[2];
            String idpas = params[3];



            URL url = new URL(get_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);


            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String post_data =
                    URLEncoder.encode("iddoc","UTF-8")+"="+URLEncoder.encode(iddoc,"UTF-8")+"&"+
                    URLEncoder.encode("idpas","UTF-8")+"="+URLEncoder.encode(idpas,"UTF-8")+"&"+
                    URLEncoder.encode("clave","UTF-8")+"="+URLEncoder.encode(clave,"UTF-8");

            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));

            String linea = "";
            String var ="";
            while((linea = bufferedReader.readLine())!= null) {
                result += linea;
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            this.var = result;


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();


        }



    }
    @Override
    protected String doInBackground(String... params) {
        String tipo = params[0];

        if(tipo.equals("login")) {
            return login(params);
        }else if(tipo.equals("userId")) {
            userId(params);
        }else if(tipo.equals("userIdd")) {
            userIdd(params);
        }else if(tipo.equals("comprueba")) {
            comprueba(params);
        }else if(tipo.equals("guardarCodigo")) {
            guardarCodigo(params);
        } else if(tipo.equals("editarCodigo")) {
            editarCodigo(params);
        } else if(tipo.equals("verDoc")) {
            verDoc(params);
        }  else if(tipo.equals("editarCodigoDoc")) {
                editarCodigoDoc(params);
        }  else if(tipo.equals("registro")) {
            try {
                String ip = params[3];
                String register_url = "http://"+ip+"/register2.php" ;

               // flag = 1;
                String user = params[1];
                String pass = params[2];
                String a = params[4];
                String b = params[5];
                String c = params[6];
                String d = params[7];
                String e = params[8];
                String f = params[9];
                String g = params[10];
                String h = params[11];
                String i = params[12];
                String j = params[13];
                String k = params[14];
                String l = params[15];
                String m = params[16];
                String n = params[17];
                String o = params[18];
                String p = params[19];
                String q = params[20];
                String imei = params [21];



                URL url = new URL(register_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data =  URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(user,"UTF-8")+"&"+
                                    URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(pass,"UTF-8")+"&"+

                        URLEncoder.encode("a","UTF-8")+"="+URLEncoder.encode(a,"UTF-8")+"&"+
                        URLEncoder.encode("b","UTF-8")+"="+URLEncoder.encode(b,"UTF-8")+"&"+
                        URLEncoder.encode("c","UTF-8")+"="+URLEncoder.encode(c,"UTF-8")+"&"+
                        URLEncoder.encode("d","UTF-8")+"="+URLEncoder.encode(d,"UTF-8")+"&"+
                        URLEncoder.encode("e","UTF-8")+"="+URLEncoder.encode(e,"UTF-8")+"&"+
                        URLEncoder.encode("f","UTF-8")+"="+URLEncoder.encode(f,"UTF-8")+"&"+
                        URLEncoder.encode("g","UTF-8")+"="+URLEncoder.encode(g,"UTF-8")+"&"+
                        URLEncoder.encode("h","UTF-8")+"="+URLEncoder.encode(h,"UTF-8")+"&"+
                        URLEncoder.encode("i","UTF-8")+"="+URLEncoder.encode(i,"UTF-8")+"&"+
                        URLEncoder.encode("j","UTF-8")+"="+URLEncoder.encode(j,"UTF-8")+"&"+
                        URLEncoder.encode("k","UTF-8")+"="+URLEncoder.encode(k,"UTF-8")+"&"+
                        URLEncoder.encode("l","UTF-8")+"="+URLEncoder.encode(l,"UTF-8")+"&"+
                        URLEncoder.encode("m","UTF-8")+"="+URLEncoder.encode(m,"UTF-8")+"&"+
                        URLEncoder.encode("n","UTF-8")+"="+URLEncoder.encode(n,"UTF-8")+"&"+
                        URLEncoder.encode("o","UTF-8")+"="+URLEncoder.encode(o,"UTF-8")+"&"+
                        URLEncoder.encode("p","UTF-8")+"="+URLEncoder.encode(p,"UTF-8")+"&"+
                        URLEncoder.encode("q","UTF-8")+"="+URLEncoder.encode(q,"UTF-8")+"&"+
                        URLEncoder.encode("imei","UTF-8")+"="+URLEncoder.encode(imei,"UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));

                String linea = "";

                while((linea = bufferedReader.readLine())!= null) {
                    result += linea;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;


            } catch (MalformedURLException e) {
                e.printStackTrace();
                } catch (IOException e) {
                e.printStackTrace();
                }
        } else if (tipo.equals("compruebadoc")) {

            try {

                this.ipdoc = params[2];
                String logindoc_url = "http://" + ipdoc + "/compruebadoc.php";//"http://192.168.1.220/logindoc.php";"http://"+ip+"/login.php"
                Log.i(CLASS_TAG, "http://" + ipdoc + "/compruebadoc.php");

                this.userDoctor = params[1];


                URL url = new URL(logindoc_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(userDoctor, "UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

                String linea = "";

                while ((linea = bufferedReader.readLine()) != null) {
                    result += linea;
                    this.conectionStatus = result;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        else if (tipo.equals("logindoc")) {

            try {

                this.ipdoc = params[3];
                String logindoc_url = "http://" + ipdoc + "/logindoc.php";//"http://192.168.1.220/logindoc.php";"http://"+ip+"/login.php"
                Log.i(CLASS_TAG, "http://" + ipdoc + "/logindoc.php");

                this.userDoctor = params[1];
                this.passDoctor = params[2];
                String imei = params [4];




                URL url = new URL(logindoc_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(userDoctor, "UTF-8") + "&" +
                                   URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(passDoctor, "UTF-8")+ "&" +
                                   URLEncoder.encode("imei", "UTF-8") + "=" + URLEncoder.encode(imei, "UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

                String linea = "";

                while ((linea = bufferedReader.readLine()) != null) {
                       result += linea;
                    this.conectionStatus = result;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();


                if (conectionStatus.equals("conecto doc"))
                {
                }else { flag = 1;}

                return result;

            }   catch (MalformedURLException e) {
                e.printStackTrace();
                } catch (IOException e) {
                e.printStackTrace();
                }
                return null;
        } else if(tipo.equals("getData")){
            getData(params);

        }else if(tipo.equals("codigDoc")) {
            codigoDoc(params);

        }else if(tipo.equals("registrodoc")) {
            try {
                String ip = params[3];
                String register_url = "http://"+ip+"/registerdochp.php" ;


                String user = params[1];
                String pass = params[2];
            //    String idpas = params[4];
             //   String clave = params[5];
                String imei = params[4];
                URL url = new URL(register_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data =
                                URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(user,"UTF-8")+"&"+
                                URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(pass,"UTF-8")+"&"+
                 //               URLEncoder.encode("idpas","UTF-8")+"="+URLEncoder.encode(idpas,"UTF-8")+"&"+
                 //               URLEncoder.encode("clave","UTF-8")+"="+URLEncoder.encode(clave,"UTF-8")+"&"+
                                URLEncoder.encode("imei","UTF-8")+"="+URLEncoder.encode(imei,"UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));

                String linea = "";

                while((linea = bufferedReader.readLine())!= null) {
                    result += linea;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();




            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;

        }




         return null;

    }







    @Override
    protected void onPreExecute() {
     //   alertDialog = new AlertDialog.Builder(context).create();
     //   alertDialog.setTitle("Login Status");
    }

    @Override
    protected void onPostExecute(String result) {
        this.conectionStatus = null;
        if (flag==1) {
            alertDialog = new AlertDialog.Builder(context).create();
            alertDialog.setTitle("Status");
            alertDialog.setMessage(result);

            alertDialog.show();
            this.er = result;
        }
        flag =0;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }



}
