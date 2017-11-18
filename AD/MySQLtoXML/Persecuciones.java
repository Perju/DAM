import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class principal {

	private static void crearElemento(String nombre,String valor,Element raiz, Document docu) {
		Element elem = docu.createElement(nombre);
		Text texto = docu.createTextNode(valor);
		raiz.appendChild(elem);
		elem.appendChild(texto);
	}

	public static void main(String[] args) {

		DocumentBuilderFactory fabricaXML = DocumentBuilderFactory.newInstance();

		// vamos creando el documento XML
		DocumentBuilder constructor;
		try {
			//para el XML
			constructor = fabricaXML.newDocumentBuilder();
			DOMImplementation implementacion = constructor.getDOMImplementation();
			Document documento = implementacion.createDocument(null, "Persecuciones", null);
			documento.setXmlVersion("1.0");

			//conexion para el SQL
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion =DriverManager.getConnection("jdbc:mysql://localhost:3307/mortadelo","root","usbw");
			// consulta SQL
			String consulta="select * from persecucion";
			// para la consulta principal
			Statement sql = conexion.createStatement();
			ResultSet rs = sql.executeQuery(consulta);
			// para las subconsultas
			Statement sql2 = conexion.createStatement();
			ResultSet rs2=sql2.executeQuery(consulta);// para poder cerrarlo sin problemas
			//perseguidor, perseguido, arma, disfraz, Invento, causa, frasePerseguidor, frasePerseguido
			while(rs.next()) {
				Element elemento = documento.createElement("Persecucion");
				documento.getDocumentElement().appendChild(elemento);
				String valor;
				// cadenas para crear las stentencias sql
				// para la consulta principal
				String camposRs1[]= {"perseguidor","perseguido","arma","disfraz","invento",	"causa","fraseperseguidor","fraseperseguido"};
				//para las subconsultas
				String camposRs2[]= {"nombre","nombre","arma","disfraz","invento"};
				String tablas[]= {"personaje","personaje","arma","disfraz","invento"};
				// las 5 primeras subconsultas en un bucle
				for(int i=0;i<camposRs2.length;i++) {
					rs2=sql2.executeQuery("select "+camposRs2[i]+" from "+ tablas[i]+" "
							+ "where id="+rs.getInt(camposRs1[i]));
					if(rs2.next()) {
						valor=rs2.getString(camposRs2[i]);
						crearElemento(camposRs1[i],valor,elemento,documento);
					}
				}
				// y las tres ultimas en otro
				for(int i = camposRs2.length ; i<camposRs1.length;i++ ) {
					valor=rs.getString(camposRs1[i]);
					if(valor!=null) {
						crearElemento(camposRs1[i],valor,elemento,documento);
					}	
				}
			}
			// creamos el XML
			Source origen = new DOMSource(documento);
			Result resultado = new StreamResult(new File(System.getProperty("user.home")+"/Desktop/ficheroPersecuciones.xml"));
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(origen,resultado);
			// cerramos las conexiones SQL
			rs.close();
			sql.close();
			rs2.close(); // puede que nos saltemos el bucle y hay que ejecutar una consulta innecesaria
			sql2.close();
			conexion.close();
			System.out.println("Tarea completada");
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SQLException e) {
				e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}
