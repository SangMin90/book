package sale.ver1

class Theater(
    val ticketSeller: TicketSeller,
) {

    fun enter(audience: Audience) {
        val bag = audience.bag
        val ticketOfficer = ticketSeller.ticketOffice
        if (bag.hasInvitation) {
            val ticket = ticketOfficer.ticket
            bag.ticket = ticket
        } else {
            val ticket = ticketOfficer.ticket
            val fee = ticket.fee
            bag.minusAmount(fee)
            ticketOfficer.plusAmount(fee)
            bag.ticket = ticket
        }

    }
}