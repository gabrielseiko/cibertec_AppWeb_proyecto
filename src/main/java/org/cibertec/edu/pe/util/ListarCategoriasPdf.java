package org.cibertec.edu.pe.util;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cibertec.edu.pe.model.Categoria;
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

@Component("PDFcategory")
public class ListarCategoriasPdf extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        @SuppressWarnings("unchecked")
        List<Categoria> PDFcategory = (List<Categoria>) model.get("categorias");

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

        celda = new PdfPCell(new Phrase("LISTADO DE CATEGORÍAS", fuenteTitulo));
        celda.setBorder(0);
        celda.setBackgroundColor(new Color(199, 0, 57));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(15);

        tablaTitulo.addCell(celda);
        tablaTitulo.setSpacingAfter(30);

        /* TABLA PARA MOSTRAR EL LISTADO */
        PdfPTable tablaCategorias = new PdfPTable(3); // Modificado el número de columnas
        tablaCategorias.setWidths(new float[] { 0.2f, 1.3f, 0.5f }); // Modificado los tamaños de las columnas

        celda = new PdfPCell(
                new Phrase("ID", new Font(fuenteCabecera.getFamily(), fuenteCabecera.getSize(), 0, Color.WHITE)));
        celda.setBackgroundColor(new Color(199, 0, 57));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaCategorias.addCell(celda);

        celda = new PdfPCell(new Phrase("Categoría", new Font(fuenteCabecera.getFamily(), fuenteCabecera.getSize(), 0,
                Color.WHITE)));
        celda.setBackgroundColor(new Color(199, 0, 57));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaCategorias.addCell(celda);

        celda = new PdfPCell(new Phrase("Estado", new Font(fuenteCabecera.getFamily(), fuenteCabecera.getSize(), 0,
                Color.WHITE)));
        celda.setBackgroundColor(new Color(199, 0, 57));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaCategorias.addCell(celda);

        /* BUCLE, PARA MOSTRAR LOS DATOS */
        for (Categoria categoria : PDFcategory) {
            celda = new PdfPCell(new Phrase(Integer.toString(categoria.getIdCategoria()), fuenteData));
            celda.setPadding(5);
            tablaCategorias.addCell(celda);

            celda = new PdfPCell(new Phrase(categoria.getNombreCate(), fuenteData));
            celda.setPadding(5);
            tablaCategorias.addCell(celda);

            celda = new PdfPCell(new Phrase(categoria.isEstado() ? "Disponible" : "No Disponible", fuenteData));
            celda.setPadding(5);
            tablaCategorias.addCell(celda);
        }

        document.add(tablaTitulo);
        document.add(tablaCategorias);
        document.close();
    }
}

