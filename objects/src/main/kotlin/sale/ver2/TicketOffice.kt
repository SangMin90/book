package sale.ver2

class TicketOffice(
    private var amount: Long,
    vararg tickets: Ticket
) {
    private val tickets: MutableList<Ticket> = tickets.toMutableList()

    private val ticket: Ticket
        get() = tickets.removeFirst()

    val ticketCount: Int
        get() = tickets.size

    private fun minusAmount(amount: Long): Long {
        this.amount -= amount

        return this.amount
    }

    private fun plusAmount(amount: Long): Long {
        this.amount += amount

        return this.amount
    }

    fun sellTicketTo(audience: Audience) {
        plusAmount(audience.buy(ticket))
    }

}