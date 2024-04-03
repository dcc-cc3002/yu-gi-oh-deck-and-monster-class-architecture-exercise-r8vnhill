import java.util.Objects

/** A class representing the fundamental properties of a card in a Yu-Gi-Oh! deck.
 *
 * @param name The name of the card.
 */
class Card(val name: String) {
  override def toString: String = s"Card(name='$name')"

  //noinspection TypeCheckCanBeMatch
  override def equals(obj: Any): Boolean = if (obj.isInstanceOf[Card]) {
    val other = obj.asInstanceOf[Card]
    name == other.name
  } else {
    false
  }

  override def hashCode(): Int = Objects.hash(classOf[Card].hashCode(), name)
}
