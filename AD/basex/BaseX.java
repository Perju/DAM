package basex;

import java.io.IOException;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

import org.basex.BaseXServer;

public class BaseX {

	private final static String CONTROLADOR = "net.xqj.basex.BaseXXQDataSource";
	
	public static void main(String[] args) throws XQException, IOException {
		try {
			BaseXServer servidor = new BaseXServer();
			//BaseXServer.start(1984, args);
			
			// (XQDataSource) Class.forName(CONTROLADOR).newInstance();
			// net.xqj.basex.BaseXXQDataSource.class.newInstance();
			XQDataSource origen = net.xqj.basex.BaseXXQDataSource.class.newInstance(); 
					
			
			origen.setProperty("serverName","localhost");
			origen.setProperty("port", "1984");
			origen.setProperty("user", "admin");// son los valores por defecto
			origen.setProperty("password", "admin");// son los valores por defecto
			
			XQConnection conexion = origen.getConnection(); 
			
			String strDocumento = "AD/basex/ST.xml";
			String xquery = "for $x in doc('"+strDocumento+"')//nave return $x";
			//String xquery = "for $x in db:open-pre('myf',0)//arma return $x";
			XQPreparedExpression consulta = conexion.prepareExpression(xquery);
			
			XQResultSequence resultado = consulta.executeQuery();
			
			while(resultado.next()) {
				System.out.println(resultado.getItemAsString(null));
			}
			consulta.close();
			servidor.stop();
			//BaseXServer.stop("localhost", 1984);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} /*catch (ClassNotFoundException e) {
			e.printStackTrace();
		} */
	}
}