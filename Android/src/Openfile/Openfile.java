package Openfile;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Openfile {

	public static String fileReader(String chemin) {
		
		String chaine="";
		try{
			
			
			InputStream ips=new FileInputStream(chemin); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){						
				chaine+=ligne+"\n";
		}
			br.close(); 
		}		



		catch (Exception e){
			System.out.println(e.toString());
		}
					
return chaine;
}
}
