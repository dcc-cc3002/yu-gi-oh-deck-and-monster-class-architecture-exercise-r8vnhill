package deck

import cards.Card

import scala.collection.mutable.ArrayBuffer

class MainDeck(override val cards: List[Card] = List.empty)
    extends AbstractDeck(cards) {

  override def createDeck(cards: List[Card]): Deck = MainDeck(cards)
}
