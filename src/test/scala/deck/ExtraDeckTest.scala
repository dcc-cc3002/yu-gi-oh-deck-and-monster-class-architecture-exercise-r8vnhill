package deck

import cards.Card

class ExtraDeckTest extends munit.FunSuite {
  val cards: List[Card] = List(
    new Card("The Weather Painter Rainbow"),
    new Card("I.P. Masquerena"),
    new Card("Knightmare Unicorn"),
  )
  val nCards = 3
  var _deck: Option[ExtraDeck] = None
  var _emptyDeck: Option[ExtraDeck] = None

  override def beforeEach(context: BeforeEach): Unit = {
    _deck = Some(new ExtraDeck(cards))
    _emptyDeck = Some(new ExtraDeck())
  }

  test("A non-empty deck can be constructed") {
    assert(_deck.isDefined)
    assertEquals(_deck.get.length, cards.length)
    assertEquals(_deck.get.cards, cards)
  }

  test("An empty deck can be constructed") {
    assert(_emptyDeck.isDefined)
    assertEquals(_emptyDeck.get.length, 0)
    assertEquals(_emptyDeck.get.cards, List())
  }

  test("Adding a card to a deck returns a new deck with the card added") {
    assert(_deck.isDefined)
    val card = new Card("Borrelsword Dragon")
    val newDeck = _deck.get.addCard(card)
    val expectedCards = cards :+ card
    assertEquals(newDeck.length, nCards + 1)
    assertEquals(newDeck.cards, expectedCards)
  }
}
