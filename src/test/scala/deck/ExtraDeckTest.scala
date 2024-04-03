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

  test("Searching a card by name returns the card if it exists") {
    assert(_deck.isDefined)
    assert(_deck.get.length > 0)
    val cardName = cards(1).name
    val card = _deck.get.search(cardName)
    assert(card.isDefined)
    assertEquals(card.get.name, cardName)
  }

  test("Searching a card by name returns None if the card does not exist") {
    assert(_deck.isDefined)
    assert(_deck.get.length > 0)
    val cardName = "Dark Magician"
    val card = _deck.get.search(cardName)
    assert(card.isEmpty)
  }

  test("Removing a card returns a new deck if the card exists in the deck") {
    assert(_deck.isDefined)
    val cardName = cards(1).name
    val newDeck = _deck.get.removeCard(cardName)
    val expectedCards = List(cards.head, cards.last)
    assertEquals(newDeck.length, nCards - 1)
    assertEquals(newDeck.cards, expectedCards)
  }

  test(
    "Removing a card returns the same deck if the card does not exist in the deck"
  ) {
    assert(_deck.isDefined)
    val cardName = "Dark Magician"
    val newDeck = _deck.get.removeCard(cardName)
    assertEquals(newDeck.length, nCards)
    assertEquals(newDeck.cards, cards)
  }

  test(
    "Drawing a card returns a tuple with the card and the new deck if the deck is not empty"
  ) {
    assert(_deck.isDefined)
    val cardDeckTuple = _deck.get.draw
    assert(cardDeckTuple.isDefined)
    val card = cardDeckTuple.get._1
    val newDeck = cardDeckTuple.get._2
    assertEquals(newDeck.length, nCards - 1)
    assert(newDeck.search(card.name).isEmpty)
  }

  test("Drawing a card returns None if the deck is empty") {
    assert(_emptyDeck.isDefined)
    val cardDeckTuple = _emptyDeck.get.draw
    assert(cardDeckTuple.isEmpty)
  }
}
