package com.zeroTrustApp.ZeroTrustApp.repository;

import com.zeroTrustApp.ZeroTrustApp.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
