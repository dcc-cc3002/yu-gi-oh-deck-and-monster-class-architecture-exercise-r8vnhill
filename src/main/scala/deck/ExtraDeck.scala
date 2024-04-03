package deck

import cards.Card

class ExtraDeck(override val cards: List[Card] = List.empty)
    extends AbstractDeck(cards) {
  
  override def createDeck(cards: List[Card]): Deck = new ExtraDeck(cards)
}
