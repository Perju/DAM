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

public class Persecuciones {

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
			ResultSet rs2=sql2.executeQuery("");// para poder cerrarlo sin problemas
			//perseguidor, perseguido, arma, disfraz, Invento, causa, frasePerseguidor, frasePerseguido
			while(rs.next()) {
				Element elemento = documento.createElement("Persecucion");
				documento.getDocumentElement().appendChild(elemento);
				String valor;

				rs2=sql2.executeQuery("select nombre from personaje where id="+rs.getInt("perseguidor"));
				if(rs2.next()) {
					valor=rs2.getString("nombre");
					crearElemento("perseguidor",valor,elemento,documento);
				}

				rs2=sql2.executeQuery("select nombre from personaje where id="+rs.getInt("perseguido"));
				if(rs2.next()) {
					valor=rs2.getString("nombre");
					crearElemento("perseguido",valor,elemento,documento);
				}

				rs2=sql2.executeQuery("select arma from arma where id="+rs.getInt("arma"));
				if(rs2.next()) {
					valor=rs2.getString("arma");
					crearElemento("arma",valor,elemento,documento);
				}

				rs2=sql2.executeQuery("select disfraz from disfraz where id="+rs.getInt("disfraz"));
				if(rs2.next()) {
					valor=rs2.getString("disfraz");
					crearElemento("disfraz",valor,elemento,documento);}


				rs2=sql2.executeQuery("select invento from invento where id="+rs.getInt("invento"));
				if(rs2.next()) {
					valor=rs2.getString("invento");
					crearElemento("invento",valor,elemento,documento);
				}
				
				valor=rs.getString("causa");
				if(valor!=null) {System.out.println("Causa: "+valor);
				crearElemento("causa",valor,elemento,documento);}
				
				valor=rs.getString("frasePerseguidor");
				if(valor!=null) {System.out.println("frasePerseguidor: "+valor);
				crearElemento("frasePerseguidor",valor,elemento,documento);}
				
				valor=rs.getString("frasePerseguido");
				if(valor!=null) {System.out.println("frasePerseguido: "+valor);
				crearElemento("frasePerseguido",valor,elemento,documento);}
				
				System.out.println("primerElementoCreado");
			}
			// creamos el XML
			Source origen = new DOMSource(documento);
			Result resultado = new StreamResult(new File(System.getProperty("user.home")+"/Desktop/ficheroPersecuciones.xml"));
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(origen,resultado);
			// cerramos las conexiones SQL
			rs.close();
			sql.close();
			rs2.close();
			sql2.close();
			conexion.close();

		} catch (ParserConfigurationException e) {e.printStackTrace();} catch (SQLException e) {
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
