package deck

import cards.Card

import scala.collection.mutable.ArrayBuffer

/**
 * Represents the Main Deck in a "Yu-Gi-Oh!" style card game.
 * It is a concrete implementation of the AbstractDeck class.
 *
 * This class specifically deals with the management and operations of the Main Deck, 
 * which is the primary deck from where players draw their cards during the game.
 *
 * @param cards Initializes the deck with a list of Main Deck monster cards. Defaults to an empty list.
 */
class MainDeck(override val cards: List[Card] = List.empty)
  extends AbstractDeck(cards) {

  /**
   * Creates a new instance of MainDeck containing the provided cards.
   * This method is an override of the AbstractDeck's createDeck method, 
   * ensuring that a new MainDeck instance is returned when deck-manipulating methods are called.
   *
   * @param cards The list of Card instances to be included in the new Main Deck.
   * @return A new instance of MainDeck containing the provided cards.
   */
  override def createDeck(cards: List[Card]): Deck = new MainDeck(cards)
}

