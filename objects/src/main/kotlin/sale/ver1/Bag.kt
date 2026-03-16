package sale.ver1

class Bag(
    var amount: Long,
    val invitation: Invitation? = null,
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