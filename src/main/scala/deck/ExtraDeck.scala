package deck

import cards.Card

/**
 * Represents the Extra Deck in a "Yu-Gi-Oh!" style card game. 
 * It is a concrete implementation of the `AbstractDeck` class.
 *
 * @param cards Initializes the deck with a list of Extra Deck monster cards. Defaults to an empty list.
 */
class ExtraDeck(override val cards: List[Card] = List.empty)
  extends AbstractDeck(cards) {

  /**
   * Creates a new instance of ExtraDeck containing the provided cards.
   *
   * @param cards The list of Card instances to be included in the new Extra Deck.
   * @return A new instance of ExtraDeck containing the provided cards.
   */
  override def createDeck(cards: List[Card]): Deck = new ExtraDeck(cards)
}
