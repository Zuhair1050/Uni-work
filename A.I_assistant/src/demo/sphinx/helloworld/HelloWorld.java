package demo.sphinx.helloworld;


import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;
import edu.cmu.sphinx.util.props.PropertyException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.speech.recognition.ResultToken;


/**
 * speech recognition application 
 * built using Sphinx-4. This application uses the Sphinx-4 endpointer,
 * which automatically segments incoming audio into utterances and silences.
 */
public class HelloWorld {

    /**
     * Main method for running the HelloWorld demo.
     */
	static int i=1;
	static String resultText;
    public static void main(String[] args) {
        try {
            URL url;
           if (args.length > 0) {
               url = new File(args[0]).toURI().toURL();
            } else {
                url = HelloWorld.class.getResource("helloworld.config.xml");
            }
            System.out.println("Loading...");

            ConfigurationManager cm = new ConfigurationManager(url);

	    Recognizer recognizer = (Recognizer) cm.lookup("recognizer");
	    Microphone microphone = (Microphone) cm.lookup("microphone");

            /* allocate resources necessary for the recognizer */
            recognizer.allocate();

            /* microphone will keep recording until the program terminates */
	    
            if (microphone.startRecording())
            {	

            while (true) 
            {
            		
                    /*
                     * This method denotes when the speech ends 
                     */ 
		  
		    Result result = recognizer.recognize();
		    if (result != null)
		    {
		    	
		    		System.out.println("Enter your choise"+ "\n");
			 resultText = result.getBestFinalResultNoFiller();
			System.out.println("You said: " + resultText + "\n");
			
			if(resultText.equalsIgnoreCase("command"))
 			{
 				try{
 				Process p;
 				p = Runtime.getRuntime().exec("cmd /c start cmd");
 				}catch(Exception er)
 				{}
 			}if (resultText.equalsIgnoreCase("close command"))
 		    {
 		        try{
 		        Process p;	
 		        p = Runtime.getRuntime().exec("cmd /c start taskkill /im cmd.exe /f");
 		        }catch(Exception ae){}
 		    }
 			if (resultText.equalsIgnoreCase("Power Options"))
 		    {
 		        try{
 		        Process p;	
 		        p = Runtime.getRuntime().exec("cmd /c powercfg.cpl");
 		     
 		        }catch(Exception ae){}
 		    }
 			if (resultText.equalsIgnoreCase("Blue tooth"))
 		    {
 		        try{
 		        Process p;	
 		        p = Runtime.getRuntime().exec("cmd /c fsquirt");
 		     
 		        }catch(Exception ae){}
 		    }
 			if (resultText.equalsIgnoreCase("calculator"))
 		    {
 		        try{
 		        Process p;	
 		        p = Runtime.getRuntime().exec("cmd /c start calc");
 		     
 		        }catch(Exception ae){}
 		    }
 			if (resultText.equalsIgnoreCase("Windows Security Center"))
 		    {
 		        try{
 		        Process p;	
 		        p = Runtime.getRuntime().exec("cmd /c wscui.cpl");
 		     
 		        }catch(Exception ae){}
 		    }
 			else  if (resultText.equalsIgnoreCase("Program"))
 		    {
 		        try{
 		        Process p;
 		        p = Runtime.getRuntime().exec("cmd /c start appwiz.cpl");
 		        }catch(Exception ae){}
 		    }
 			else if (resultText.equalsIgnoreCase("Control"))
 			{
 			        try{
 			        Process p;
 			        p = Runtime.getRuntime().exec("cmd /c control");
 			        }catch(Exception ae){}
 			}
 			
 			else if(resultText.equalsIgnoreCase("close calculator"))
 			{	 try{
 		        Process p;
 		    	
 		        p = Runtime.getRuntime().exec("cmd /c start taskkill /im calc.exe /f");
 		       
 		        }catch(Exception ae){}
 	}
 			else if (resultText.equalsIgnoreCase("open Browser"))
 		    {
 		        try{
 		        Process p;
 		        p = Runtime.getRuntime().exec("cmd /c start opera.exe");
 		      
 		        }catch(Exception ae){}
 		     }else if (resultText.equalsIgnoreCase("close Browser"))
 			    {
 			        try{
 			        Process p;
 			        p = Runtime.getRuntime().exec("cmd /c start taskkill /im opera.exe /f");
 			      
 			        }catch(Exception ae){}
 			     }
 			
 			else if(resultText.equalsIgnoreCase("task manager"))
 				{	 try{
 			        Process p;
 			    	
 			        p = Runtime.getRuntime().exec("cmd /c start taskmgr.exe");
 			       
 			        }catch(Exception ae){}
 				}
 			else if(resultText.equalsIgnoreCase("site face book"))
 			{	 try{
 		        Process p;
 		    	
 		        p = Runtime.getRuntime().exec("cmd /c start chrome www.facebook.com");
 		       
 		        }catch(Exception ae){}
 			}
 			else if(resultText.equalsIgnoreCase("site goo gil"))
 			{	 try{
 		        Process p;
 		    	
 		        p = Runtime.getRuntime().exec("cmd /c start chrome www.google.com");
 		       
 		        }catch(Exception ae){}
 			}
 			else if(resultText.equalsIgnoreCase("site mail"))
 			{	 try{
 		        Process p;
 		    	
 		        p = Runtime.getRuntime().exec("cmd /c start chrome https://mail.google.com");
 		       
 		        }catch(Exception ae){}
 			}
 		     else if(resultText.equalsIgnoreCase("close task manager"))
 				{	 try{
 			        Process p;
 			        p = Runtime.getRuntime().exec("cmd /c start taskkill /im taskmgr.exe /f");
 			        }catch(Exception ae){}
 		}
 			else if (resultText.equalsIgnoreCase("open pad"))
 		    {
 		        try{
 		        Process p;	
 		        p = Runtime.getRuntime().exec("cmd /c start notepad");
 		        }catch(Exception ae){}
 		     }
 			else if (resultText.equalsIgnoreCase("close pad"))
 		    {
 		        try{
 		        Process p;	
 		        p = Runtime.getRuntime().exec("cmd /c start taskkill /im notepad.exe /f");
 		        }catch(Exception ae){}
 		     }
 			else if (resultText.equalsIgnoreCase("open word"))
 		    {
 		        try{
 		        Process p;	
 		        p = Runtime.getRuntime().exec("cmd /c start winword");
 		        }catch(Exception ae){}
 		     }
 			else if (resultText.equalsIgnoreCase("close word"))
 		    {
 		        try{
 		        Process p;	
 		        p = Runtime.getRuntime().exec("cmd /c start taskkill /im winword.exe /f");
 		        }catch(Exception ae){}
 		     }
 			else if (resultText.equalsIgnoreCase("start word pad"))
 		    {
 		        try{
 		        Process p;	
 		        p = Runtime.getRuntime().exec("cmd /c  write");
 		        }catch(Exception ae){}
 		     }
 			else if (resultText.equalsIgnoreCase("stop word pad"))
 		    {
 		        try{
 		        Process p;	
 		        p = Runtime.getRuntime().exec("cmd /c  start taskkill /im wordpad.exe /f");
 		        }catch(Exception ae){}
 		     }
 			
 			else if (resultText.equalsIgnoreCase("start Excel"))
 		    {
 		        try{
 		        Process p;	
 		        p = Runtime.getRuntime().exec("cmd /c start excel");
 		        }catch(Exception ae){}
 		     }else if (resultText.equalsIgnoreCase("stop Excel"))
 			 {
 			        try{
 			        Process p;	
 			        p = Runtime.getRuntime().exec("cmd /c start taskkill /im excel.exe /f");
 			        }catch(Exception ae){}
 			}
 			else if (resultText.equalsIgnoreCase("open Access"))
 		    {
 		        try{
 		        Process p;	
 		        p = Runtime.getRuntime().exec("cmd /c start msaccess");
 		        }catch(Exception ae){}
 		     }
 			else if (resultText.equalsIgnoreCase("close access"))
 		    {
 		        try{
 		        Process p;	
 		        p = Runtime.getRuntime().exec("cmd /c start taskkill /im msaccess.exe /f");
 		        }catch(Exception ae){}
 		     }
 			else if(resultText.equalsIgnoreCase("speech recognize complete"))
 		    {
 				try{
 					System.out.println("Thanks for using !");
 					recognizer.deallocate();
 					System.exit(0);}
 				catch(Exception ecomp ){}
 		    }
// 			else if(resultText.equalsIgnoreCase("speech recognize start"))
// 		    {
// 				try{
// 					
// 					recognizer.notify();
// 					System.out.println("Hello again :-) ");
// 					System.exit(0);}
// 				catch(Exception estart ){}
// 		    }
 			else if(resultText.equalsIgnoreCase("stop speech"))
 		    {
 				try{
 					microphone.stopRecording();
 					recognizer.wait();
 					System.out.println("See you later!");
 					System.exit(0);}
 				catch(Exception estop ){}
 		    }
 			else if (resultText.equalsIgnoreCase("Device Manager"))
 			    {
 			        try{
 			        Process p;	
 			        p = Runtime.getRuntime().exec("cmd /c start devmgmt.msc");
 			        }catch(Exception ae){}
 			     }
 		
 		    }
		    
	    	else
		   	{
						System.out.println("Cannot hear what was said.\n");
		    }
       }
	   } 
        else
        {
        	System.out.println("Cannot start microphone.");
        	recognizer.deallocate();
        	
        	microphone.stopRecording();
        	
        	
	    }
            
        } catch (IOException e) {
            System.err.println("Problem when loading HelloWorld: " + e);
            e.printStackTrace();
        } catch (PropertyException e) {
            System.err.println("Problem configuring HelloWorld: " + e);
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.err.println("Problem creating HelloWorld: " + e);
            e.printStackTrace();
        }
        
    }
}
