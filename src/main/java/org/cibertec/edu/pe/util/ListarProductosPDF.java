package org.cibertec.edu.pe.util;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cibertec.edu.pe.model.Producto;
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

@Component("PDFproductos")
public class ListarProductosPDF extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        @SuppressWarnings("unchecked")
        List<Producto> listarProductos = (List<Producto>) model.get("productos");

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

        celda = new PdfPCell(new Phrase("LISTADO DE PRODUCTOS", fuenteTitulo));
        celda.setBorder(0);
        celda.setBackgroundColor(new Color(0, 123, 255)); // Cambié el color a azul
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(15);

        tablaTitulo.addCell(celda);
        tablaTitulo.setSpacingAfter(30);

        /* TABLA PARA MOSTRAR EL LISTADO */
        PdfPTable tablaProductos = new PdfPTable(8); // Ajusté la cantidad de columnas a mostrar
        tablaProductos.setWidths(new float[] { 0.4f, 1.0f, 1.1f, 1.5f, 0.5f, 0.6f, 0.9f, 0.6f }); // Ajusté los tamaños de las columnas

        celda = new PdfPCell(
                new Phrase("ID", new Font(fuenteCabecera.getFamily(), fuenteCabecera.getSize(), 0, Color.WHITE)));
        celda.setBackgroundColor(new Color(0, 123, 255));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaProductos.addCell(celda);

        celda = new PdfPCell(new Phrase("Nombre", new Font(fuenteCabecera.getFamily(), fuenteCabecera.getSize(), 0,
                Color.WHITE)));
        celda.setBackgroundColor(new Color(0, 123, 255));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaProductos.addCell(celda);

        celda = new PdfPCell(new Phrase("Descripción", new Font(fuenteCabecera.getFamily(), fuenteCabecera.getSize(), 0,
                Color.WHITE)));
        celda.setBackgroundColor(new Color(0, 123, 255));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaProductos.addCell(celda);

        celda = new PdfPCell(new Phrase("Categoría", new Font(fuenteCabecera.getFamily(), fuenteCabecera.getSize(), 0,
                Color.WHITE)));
        celda.setBackgroundColor(new Color(0, 123, 255));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaProductos.addCell(celda);

        celda = new PdfPCell(new Phrase("Talla", new Font(fuenteCabecera.getFamily(), fuenteCabecera.getSize(), 0,
                Color.WHITE)));
        celda.setBackgroundColor(new Color(0, 123, 255));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaProductos.addCell(celda);

        celda = new PdfPCell(new Phrase("Stock", new Font(fuenteCabecera.getFamily(), fuenteCabecera.getSize(), 0,
                Color.WHITE)));
        celda.setBackgroundColor(new Color(0, 123, 255));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaProductos.addCell(celda);

        celda = new PdfPCell(new Phrase("Precio", new Font(fuenteCabecera.getFamily(), fuenteCabecera.getSize(), 0,
                Color.WHITE)));
        celda.setBackgroundColor(new Color(0, 123, 255));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaProductos.addCell(celda);

        celda = new PdfPCell(new Phrase("Estado", new Font(fuenteCabecera.getFamily(), fuenteCabecera.getSize(), 0,
                Color.WHITE)));
        celda.setBackgroundColor(new Color(0, 123, 255));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaProductos.addCell(celda);

        /* BUCLE, PARA MOSTRAR LOS DATOS */
        for (Producto producto : listarProductos) {
            celda = new PdfPCell(new Phrase(Integer.toString(producto.getIdProducto()), fuenteData));
            celda.setPadding(5);
            tablaProductos.addCell(celda);

            celda = new PdfPCell(new Phrase(producto.getNombre(), fuenteData));
            celda.setPadding(5);
            tablaProductos.addCell(celda);

            celda = new PdfPCell(new Phrase(producto.getDescripcion(), fuenteData));
            celda.setPadding(5);
            tablaProductos.addCell(celda);

            celda = new PdfPCell(new Phrase(producto.getCategoria().getNombreCate(), fuenteData));
            celda.setPadding(5);
            tablaProductos.addCell(celda);

            celda = new PdfPCell(new Phrase(producto.getTalla(), fuenteData));
            celda.setPadding(5);
            tablaProductos.addCell(celda);

            celda = new PdfPCell(new Phrase(Integer.toString(producto.getStock()), fuenteData));
            celda.setPadding(5);
            tablaProductos.addCell(celda);

            celda = new PdfPCell(new Phrase(Double.toString(producto.getPrecio()), fuenteData));
            celda.setPadding(5);
            tablaProductos.addCell(celda);

            celda = new PdfPCell(new Phrase(producto.isEstado() ? "Activo" : "Inactivo", fuenteData));
            celda.setPadding(5);
            tablaProductos.addCell(celda);
        }

        document.add(tablaTitulo);
        document.add(tablaProductos);
        document.close();
    }
}

