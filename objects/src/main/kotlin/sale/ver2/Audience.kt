package sale.ver2

class Audience(
    private val bag: Bag
) {
    fun buy(ticket: Ticket): Long {
        return if (bag.hasInvitation) {
            bag.ticket = ticket
            0L
        } else {
            bag.minusAmount(ticket.fee)
            bag.ticket = ticket
            ticket.fee
        }
    }
}
