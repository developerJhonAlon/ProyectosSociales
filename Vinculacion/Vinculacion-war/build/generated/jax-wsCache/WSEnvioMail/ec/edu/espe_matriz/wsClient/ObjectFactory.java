
package ec.edu.espe_matriz.wsClient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ec.edu.espe_matriz.wsClient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _EnviarMailResponse_QNAME = new QName("http://ws.espe_innovativa.edu.ec/", "enviarMailResponse");
    private final static QName _EnviarMail_QNAME = new QName("http://ws.espe_innovativa.edu.ec/", "enviarMail");
    private final static QName _HelloResponse_QNAME = new QName("http://ws.espe_innovativa.edu.ec/", "helloResponse");
    private final static QName _Hello_QNAME = new QName("http://ws.espe_innovativa.edu.ec/", "hello");
    private final static QName _EnviarMailArchivoAdjunto_QNAME = new QName("", "archivoAdjunto");
    private final static QName _EnviarMailArchivoAdjunto2_QNAME = new QName("", "archivoAdjunto2");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ec.edu.espe_matriz.wsClient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link EnviarMailResponse }
     * 
     */
    public EnviarMailResponse createEnviarMailResponse() {
        return new EnviarMailResponse();
    }

    /**
     * Create an instance of {@link EnviarMail }
     * 
     */
    public EnviarMail createEnviarMail() {
        return new EnviarMail();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnviarMailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.espe_innovativa.edu.ec/", name = "enviarMailResponse")
    public JAXBElement<EnviarMailResponse> createEnviarMailResponse(EnviarMailResponse value) {
        return new JAXBElement<EnviarMailResponse>(_EnviarMailResponse_QNAME, EnviarMailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnviarMail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.espe_innovativa.edu.ec/", name = "enviarMail")
    public JAXBElement<EnviarMail> createEnviarMail(EnviarMail value) {
        return new JAXBElement<EnviarMail>(_EnviarMail_QNAME, EnviarMail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.espe_innovativa.edu.ec/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.espe_innovativa.edu.ec/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "archivoAdjunto", scope = EnviarMail.class)
    public JAXBElement<byte[]> createEnviarMailArchivoAdjunto(byte[] value) {
        return new JAXBElement<byte[]>(_EnviarMailArchivoAdjunto_QNAME, byte[].class, EnviarMail.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "archivoAdjunto2", scope = EnviarMail.class)
    public JAXBElement<byte[]> createEnviarMailArchivoAdjunto2(byte[] value) {
        return new JAXBElement<byte[]>(_EnviarMailArchivoAdjunto2_QNAME, byte[].class, EnviarMail.class, ((byte[]) value));
    }

}
