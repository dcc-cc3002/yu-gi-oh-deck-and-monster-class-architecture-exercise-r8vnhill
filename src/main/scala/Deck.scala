/** A trait representing a generic Deck of cards in Yu-Gi-Oh! */
trait Deck {

  /** Retrieves the current size of the deck. */
  val length: Int

  /** Holds the current list of cards in the deck. */
  val cards: List[Card]

  /** Draws a card from the deck.
   *
   *  @return A tuple containing the drawn card.Card and the resulting Deck.
   */
  def draw: Option[(Card, Deck)]

  /** Searches for a card by name in the deck.
   *
   * @param name The name of the card to search for.
   * @return An Option containing the card.Card if found, or None otherwise.
   */
  def search(name: String): Option[Card]

  /** Adds a card to the deck.
   *
   * @param card The card to add to the deck.
   * @return A new Deck instance with the card added.
   */
  def addCard(card: Card): Deck

  /** Removes a card by name from the deck.
   *
   * @param name The name of the card to remove from the deck.
   * @return A new Deck instance with the card removed.
   */
  def removeCard(name: String): Deck
}
