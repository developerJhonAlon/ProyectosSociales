
package ec.edu.espe_matriz.wsClient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for enviarMail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="enviarMail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="remitente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="destinatarios" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="asunto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mensaje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="esHtml" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="archivoAdjunto" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="nombreArchivoAdjunto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="archivoAdjunto2" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="nombreArchivoAdjunto2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "enviarMail", propOrder = {
    "remitente",
    "destinatarios",
    "asunto",
    "mensaje",
    "esHtml",
    "archivoAdjunto",
    "nombreArchivoAdjunto",
    "archivoAdjunto2",
    "nombreArchivoAdjunto2"
})
public class EnviarMail {

    protected String remitente;
    protected String destinatarios;
    protected String asunto;
    protected String mensaje;
    protected Boolean esHtml;
    @XmlElementRef(name = "archivoAdjunto", type = JAXBElement.class, required = false)
    protected JAXBElement<byte[]> archivoAdjunto;
    protected String nombreArchivoAdjunto;
    @XmlElementRef(name = "archivoAdjunto2", type = JAXBElement.class, required = false)
    protected JAXBElement<byte[]> archivoAdjunto2;
    protected String nombreArchivoAdjunto2;

    /**
     * Gets the value of the remitente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemitente() {
        return remitente;
    }

    /**
     * Sets the value of the remitente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemitente(String value) {
        this.remitente = value;
    }

    /**
     * Gets the value of the destinatarios property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinatarios() {
        return destinatarios;
    }

    /**
     * Sets the value of the destinatarios property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinatarios(String value) {
        this.destinatarios = value;
    }

    /**
     * Gets the value of the asunto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAsunto() {
        return asunto;
    }

    /**
     * Sets the value of the asunto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAsunto(String value) {
        this.asunto = value;
    }

    /**
     * Gets the value of the mensaje property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Sets the value of the mensaje property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensaje(String value) {
        this.mensaje = value;
    }

    /**
     * Gets the value of the esHtml property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEsHtml() {
        return esHtml;
    }

    /**
     * Sets the value of the esHtml property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEsHtml(Boolean value) {
        this.esHtml = value;
    }

    /**
     * Gets the value of the archivoAdjunto property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public JAXBElement<byte[]> getArchivoAdjunto() {
        return archivoAdjunto;
    }

    /**
     * Sets the value of the archivoAdjunto property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public void setArchivoAdjunto(JAXBElement<byte[]> value) {
        this.archivoAdjunto = value;
    }

    /**
     * Gets the value of the nombreArchivoAdjunto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreArchivoAdjunto() {
        return nombreArchivoAdjunto;
    }

    /**
     * Sets the value of the nombreArchivoAdjunto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreArchivoAdjunto(String value) {
        this.nombreArchivoAdjunto = value;
    }

    /**
     * Gets the value of the archivoAdjunto2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public JAXBElement<byte[]> getArchivoAdjunto2() {
        return archivoAdjunto2;
    }

    /**
     * Sets the value of the archivoAdjunto2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public void setArchivoAdjunto2(JAXBElement<byte[]> value) {
        this.archivoAdjunto2 = value;
    }

    /**
     * Gets the value of the nombreArchivoAdjunto2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreArchivoAdjunto2() {
        return nombreArchivoAdjunto2;
    }

    /**
     * Sets the value of the nombreArchivoAdjunto2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreArchivoAdjunto2(String value) {
        this.nombreArchivoAdjunto2 = value;
    }

}
