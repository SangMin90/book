package ver1

import org.junit.jupiter.api.Assertions.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals

class TicketOfficeTest {

    private lateinit var sut: TicketOffice
    private val fee = 5000L

    @Test
    fun `티켓이 존재하면 티켓을 얻을 수 있다_getTicket`() {
        sut = TicketOffice(
            amount = 10000L,
            tickets = arrayOf(Ticket(fee), Ticket(fee))
        )

        val ticket = sut.ticket

        assertEquals(sut.ticketCount, 1)
        assertEquals(ticket.fee, fee)
    }

    @Test
    fun `티켓이 존재하지 않으면 예외가 발생한다_getTicket`() {
        sut = TicketOffice(
            amount = 10000L,
        )

        assertThrows(NoSuchElementException::class.java) { sut.ticket }
    }

    @Test
    fun `금액을 차감하면 보유금액이 감소한다_minusAmount`()     {
        sut = TicketOffice(10000L)

        val amount = sut.minusAmount(5000L)

        assertEquals(5000L, amount)
    }

    @Test
    fun `금액을 추가하면 보유금액이 증가한다_plusAmount`() {
        sut = TicketOffice(10000L)

        val amount = sut.plusAmount(5000L)

        assertEquals(15000L, amount)
    }
}