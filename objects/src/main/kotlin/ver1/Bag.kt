package ver1

class Bag(
    var amount: Long,
    val invitation: Invitation?,
    var ticket: Ticket?
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