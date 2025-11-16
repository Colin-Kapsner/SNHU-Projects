package com.snhu.sslserver;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.HexFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SslServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SslServerApplication.class, args);
	}

}
//FIXME: Add route to enable check sum return of static data example:  String data = "Hello World Check Sum!";

@RestController
class ServerController{  
    @RequestMapping("/hash")
    public String myHash(){
    	
        String data = "name: Colin Kapsner";

        // create and initialize MessageDigest with chosen algorithm
        String algorithm = "SHA-256";
        byte[] digest;
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            // hash the bytes of the data string
            digest = md.digest(data.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // convert hash bytes to hex
        String hex = HexFormat.of().formatHex(digest);

        
        return data + "\n Name of Cipher Algorithm Used : " + algorithm + "\n CheckSum Value:" + hex;
    }
    
}