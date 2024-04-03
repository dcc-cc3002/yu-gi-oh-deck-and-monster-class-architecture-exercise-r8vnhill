package deck

import cards.Card

import scala.collection.mutable.ArrayBuffer

abstract class AbstractDeck(override val cards: List[Card] = List.empty) extends Deck {
  override val length: Int = cards.length
  
  def createDeck(cards: List[Card]): Deck
  
  override def addCard(card: Card): Deck = createDeck(cards :+ card)

  override def search(name: String): Option[Card] = {
    cards.foreach(card => {
      if (card.name == name) {
        return Some(card)
      }
    })
    None
  }


  override def removeCard(name: String): Deck = {
    val acc = ArrayBuffer[Card]()
    cards.foreach(card => {
      if (card.name != name) {
        acc += card
      }
    })
    createDeck(acc.toList)
  }
}
