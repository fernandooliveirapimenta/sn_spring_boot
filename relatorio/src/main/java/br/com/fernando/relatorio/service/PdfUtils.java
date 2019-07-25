package br.com.fernando.relatorio.service;

import br.com.fernando.relatorio.model.City;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

public class PdfUtils {

    public static ByteArrayInputStream generatePdf(List<City> list) throws Exception {

        Document doc = new Document();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfPTable table = new PdfPTable(2);
        table.setWidths(new int[] {1, 2});

        PdfPCell header;

        header = new PdfPCell(new Phrase("ID"));
        header.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(header);

        header = new PdfPCell(new Phrase("NAME"));
        header.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(header);

        for (City data : list) {
            PdfPCell body;

            body = new PdfPCell(new Phrase(data.getId().toString()));
            body.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(body);

            body = new PdfPCell(new Phrase(data.getName()));
            body.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(body);

        }

        PdfWriter.getInstance(doc, outputStream);
        doc.open();
        doc.add(table);
        doc.close();
        return new ByteArrayInputStream(outputStream.toByteArray());
    }
}
