package com.carloskowalevicz.pokemon;

import android.util.Base64;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/**
 * Created by Carlos Kowalevicz on 12/10/2016.
 */

public class Encriptacion { private static final String ALGORITMO = "AES";

    private static final byte[] valor_clave = "TESISDETUCLAVE01".getBytes();


    public String encriptar (String a) throws Exception
    {

        Key key = new SecretKeySpec(valor_clave, "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key );

        byte[] encrypted = cipher.doFinal(a.getBytes("UTF-8"));
        String texto_encriptado = Base64.encodeToString(encrypted, Base64.DEFAULT);//new String(encrypted, "UTF-8");

        return texto_encriptado;


    }

    public String desencriptar(String texto_encriptado) throws Exception
    {

        Key key = new SecretKeySpec(valor_clave, ALGORITMO);

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] decodificar_texto = Base64.decode(texto_encriptado.getBytes("UTF-8"), Base64.DEFAULT);
        byte[] desencriptado = cipher.doFinal(decodificar_texto);

        return new String(desencriptado, "UTF-8");
    }
}
