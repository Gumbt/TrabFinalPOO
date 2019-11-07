package apresentacao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gumb
 */
public class Principal {

	public static PainelContribuinte tc;
	public static TelaPrincipal tp;
    
    public static void main(String args[]) throws IOException{
       
    	//tc = new TelaContribuinte();
    	tp = new TelaPrincipal();
        tp.setVisible(true);
        
    }
    
}