package org.cibertec.edu.pe.util;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cibertec.edu.pe.model.Boleta;
import org.cibertec.edu.pe.model.DetalleBoleta;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component("PDFboleta")
public class BoletaPDF extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        @SuppressWarnings("unchecked")
        List<DetalleBoleta> detalles = (List<DetalleBoleta>) model.get("detalles");
        Boleta boleta = (Boleta) model.get("boleta");

        /* FUENTES, TAMAÑOS Y COLORES PARA CADA SECCIÓN */
        Font fuenteTitulo = FontFactory.getFont("Helvetica", 18, Color.WHITE);
        Font fuenteCabecera = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);
        Font fuenteData = FontFactory.getFont(FontFactory.COURIER, 10, Color.BLACK);

        document.setPageSize(PageSize.LETTER.rotate());
        document.setMargins(-20, -20, 20, 20);
        document.open();

        /* TÍTULO DEL PDF */
        PdfPTable tablaTitulo = new PdfPTable(1);

        /* CELDAS */
        PdfPCell celda = null;

        celda = new PdfPCell(new Phrase("DETALLE DE BOLETA", fuenteTitulo));
        celda.setBorder(0);
        celda.setBackgroundColor(new Color(255, 130, 103)); // Cambié el color a azul
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(15);

        tablaTitulo.addCell(celda);
        tablaTitulo.setSpacingAfter(30);

        /* INFORMACIÓN DE LA BOLETA */
        PdfPTable tablaBoleta = new PdfPTable(2);
        tablaBoleta.setWidths(new float[] { 1.5f, 1.5f });

        celda = new PdfPCell(new Phrase("ID Boleta: " + boleta.getIdBoleta(), fuenteCabecera));
        celda.setColspan(2);
        celda.setBorder(0);
        celda.setPadding(5);
        tablaBoleta.addCell(celda);

        celda = new PdfPCell(new Phrase("Fecha: " + new SimpleDateFormat("dd/MM/yyyy").format(boleta.getFecha()), fuenteCabecera));
        celda.setPadding(5);
        tablaBoleta.addCell(celda);

        celda = new PdfPCell(new Phrase("Cliente: " + boleta.getCliente().getNombre(), fuenteCabecera));
        celda.setPadding(5);
        tablaBoleta.addCell(celda);

        celda = new PdfPCell(new Phrase("Descuento: " + boleta.getDescuento(), fuenteCabecera));
        celda.setPadding(5);
        tablaBoleta.addCell(celda);

        celda = new PdfPCell(new Phrase("Total: " + boleta.getTotal(), fuenteCabecera));
        celda.setPadding(5);
        tablaBoleta.addCell(celda);

        document.add(tablaTitulo);
        document.add(tablaBoleta);

        /* DETALLE DE LA BOLETA */
        PdfPTable tablaDetalle = new PdfPTable(3); // Ajusta según tus necesidades
        tablaDetalle.setWidths(new float[] {1.0f, 0.5f, 0.5f }); // Ajusta según tus necesidades


        celda = new PdfPCell(new Phrase("Producto", fuenteCabecera));
        celda.setBackgroundColor(new Color(255, 183, 167 ));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaDetalle.addCell(celda);

        celda = new PdfPCell(new Phrase("Cantidad", fuenteCabecera));
        celda.setBackgroundColor(new Color(255, 183, 167 ));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaDetalle.addCell(celda);

        celda = new PdfPCell(new Phrase("Subtotal", fuenteCabecera));
        celda.setBackgroundColor(new Color(255, 183, 167 ));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaDetalle.addCell(celda);

        /* BUCLE, PARA MOSTRAR LOS DATOS DEL DETALLE */
        for (DetalleBoleta detalle : detalles) {
          
            celda = new PdfPCell(new Phrase(detalle.getProducto().getNombre(), fuenteData));
            celda.setPadding(5);
            tablaDetalle.addCell(celda);

            celda = new PdfPCell(new Phrase(Integer.toString(detalle.getCantidad()), fuenteData));
            celda.setPadding(5);
            tablaDetalle.addCell(celda);

            celda = new PdfPCell(new Phrase(Double.toString(detalle.getSubtotal()), fuenteData));
            celda.setPadding(5);
            tablaDetalle.addCell(celda);
        }

        document.add(tablaDetalle);
        document.close();
    }
}
