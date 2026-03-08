package ver1

class TicketOffice(
    private var amount: Long,
    vararg tickets: Ticket
) {
    private val tickets: MutableList<Ticket> = tickets.toMutableList()

    val ticket: Ticket
        get() = tickets.removeFirst()

    val ticketCount: Int
        get() = tickets.size

    fun minusAmount(amount: Long): Long {
        this.amount -= amount

        return this.amount
    }

    fun plusAmount(amount: Long): Long {
        this.amount += amount

        return this.amount
    }

}