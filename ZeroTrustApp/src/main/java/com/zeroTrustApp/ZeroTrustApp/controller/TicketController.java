package com.zeroTrustApp.ZeroTrustApp.controller;

import com.zeroTrustApp.ZeroTrustApp.model.Ticket;
import com.zeroTrustApp.ZeroTrustApp.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TicketController {

    // Inject your ticket service here
    @Autowired
    private TicketService ticketService;

    @GetMapping("/tickets")
    public String tickets(Model model) {
        // Fetch the list of tickets and add it to the model
        model.addAttribute("tickets", ticketService.findAllTickets());
        return "tickets"; // Name of the HTML file
    }

    @PostMapping("/submit-ticket")
    public String submitTicket(@ModelAttribute("ticket") Ticket ticket, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "tickets";
        }
        ticketService.saveTicket(ticket);
        return "redirect:/tickets";
    }

    @GetMapping("/read-ticket/{ticketId}")
    public String readTicket(@PathVariable("ticketId") Long ticketId, Model model) {
        Ticket ticket = ticketService.findTicketById(ticketId);
        model.addAttribute("ticket", ticket);
        return "ticket-details"; // Name of the HTML file to read a ticket
    }
}
