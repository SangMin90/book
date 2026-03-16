package sale.ver2

class Bag(
    private var amount: Long,
    private val invitation: Invitation? = null,
    var ticket: Ticket? = null
) {

    val hasInvitation: Boolean
        get() = invitation != null

    val hasTicket: Boolean
        get() = ticket != null

    fun minusAmount(amount: Long): Long {
        this.amount -= amount

        return this.amount
    }

    fun plusAmount(amount: Long): Long {
        this.amount += amount

        return this.amount
    }
}