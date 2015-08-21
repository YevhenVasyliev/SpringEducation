package com.epam.util;

import com.epam.entity.Ticket;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import com.lowagie.text.Document;

/**
 * Created by Yevhen_Vasyliev on 21.08.2015.
 */
public class TicketPDFDocumentBuilder extends AbstractPdfView{

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Ticket> tickets = (List<Ticket>) model.get("tickets");
        Table table = getTableWithHeaders();
        for (Ticket ticket : tickets) {
            fillTableRow(table, ticket);
        }
    }

    private Table getTableWithHeaders() throws BadElementException {
        Table table = new Table(5);
        table.addCell("ID");
        table.addCell("EventId");
        table.addCell("Date");
        table.addCell("User name");
        table.addCell("Seats");
        return table;
    }

    private void fillTableRow(Table table, Ticket ticket) throws BadElementException {
        table.addCell(String.valueOf(ticket.getId()));
        table.addCell(String.valueOf(ticket.getIdEvent()));
        table.addCell(ticket.getDate().toString());
        table.addCell(ticket.getUser().getFirstName() + " " + ticket.getUser().getLastName());
        table.addCell(String.valueOf(ticket.getSeat().getNumber()));
    }
}
