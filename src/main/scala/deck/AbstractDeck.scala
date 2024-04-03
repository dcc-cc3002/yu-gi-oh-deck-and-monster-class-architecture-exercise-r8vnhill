package deck

import cards.Card

import scala.collection.mutable.ArrayBuffer

/** An abstract class that provides a skeletal implementation of the Deck trait,
  * to minimize the effort required to implement this interface.
  *
  * @param cards  A list of Card objects that initialize the deck. Defaults to an empty list.
  */
abstract class AbstractDeck(override val cards: List[Card] = List.empty)
    extends Deck {

  /** The size of the deck, determined by the length of the cards list. */
  override val length: Int = cards.length

  /** Abstract method to create a deck.
    * Implementing classes must provide a concrete implementation to create a specific deck.
    *
    * @param cards The list of Card instances to be included in the new deck.
    * @return A new instance of a deck containing the provided cards.
    */
  def createDeck(cards: List[Card]): Deck

  /** Adds a card to the deck.
    *
    * @param card The Card to add to the deck.
    * @return A new Deck instance with the card added to the top of the deck.
    */
  override def addCard(card: Card): Deck = createDeck(cards :+ card)

  /** Removes a card by name from the deck.
    *
    * @param name The name of the card to remove.
    * @return A new Deck instance with the specified card removed.
    *         If the card is not found, the original Deck instance is returned.
    */
  override def removeCard(name: String): Deck = {
    val acc = ArrayBuffer[Card]()
    cards.foreach(card => {
      if (card.name != name) {
        acc += card
      }
    })
    createDeck(acc.toList)
  }

  /** Draws the top card from the deck if the deck is not empty.
    *
    * @return An Option containing a tuple with the drawn Card and the resulting Deck, or None if the deck is empty.
    */
  override def draw: Option[(Card, Deck)] = {
    if (cards.isEmpty) {
      None
    } else {
      val card = cards.head
      Some((card, createDeck(cards.tail)))
    }
  }

  /** Searches for a card by name in the deck.
    *
    * @param name The name of the card to search for.
    * @return An Option containing the Card if found, or None otherwise.
    */
  override def search(name: String): Option[Card] = {
    cards.foreach(card =>
      if (card.name == name) {
        return Some(card)
      }
    )
    None
  }
}
