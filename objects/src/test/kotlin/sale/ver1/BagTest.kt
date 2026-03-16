package sale.ver1

import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BagTest {

    private lateinit var sut: Bag

    @Test
    fun `초대장이 없으면 false를 반환한다_hasInvitation`() {
        sut = Bag(
            amount = 10L,
        )

        assertFalse(sut.hasInvitation, "초대장이 없어야 합니다.")
    }

    @Test
    fun `초대장이 있으면 true를 반환한다_hasInvitation`() {
        sut = Bag(
            amount = 10L,
            invitation = Invitation(LocalDateTime.now()),
        )

        assertTrue(sut.hasInvitation, "초대장이 있어야 합니다.")
    }

    @Test
    fun `초기에는 티켓이 없다_hasTicket`() {
        sut = Bag(
            amount = 10L,
        )

        assertFalse(sut.hasTicket, "초기에는 티켓이 없어야 합니다.")
    }
    
    @Test
    fun `돈을 차감하면 amount가 감소한다_minusAmount`() {
        sut = Bag(
            amount = 10L,
        )

        val amount = sut.minusAmount(5L)

        assertEquals(5L, amount)
    }

    @Test
    fun `돈을 추가하면 amount가 증가한다_plusAmount`() {
        sut = Bag(
            amount = 10L,
        )

        val amount = sut.plusAmount(5L)

        assertEquals(15L, amount)
    }

    @Test
    fun `티켓을 넣으면 true를 반환한다_hasTicket`() {
        val ticket = Ticket(5L)
        sut = Bag(
            amount = 10L,
            invitation = Invitation(LocalDateTime.now()),
            null
        )

        sut.minusAmount(ticket.fee)
        sut.ticket = ticket

        assertTrue(sut.hasTicket, "넣은 티켓이 있어야 합니다.")
    }
}