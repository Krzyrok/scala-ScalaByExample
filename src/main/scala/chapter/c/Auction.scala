package chapter.c

import java.util.Date
import akka.actor.{Actor, ReceiveTimeout}
import scala.concurrent.duration._

class Auction(seller: Actor, minBid: Int, closing: Date) extends Actor {
  val timeoutToShutdown = 36000000
  val bidIncrement = 10

  private var maxBid = minBid - bidIncrement
  var maxBidder: Actor = _

  private val durationTime = closing.getTime - new Date().getTime
  context.setReceiveTimeout(durationTime millisecond)

  override def receive: Receive = {
    case Offer(bid, client) =>
      if (bid >= maxBid + bidIncrement) {
        if (maxBid >= minBid) {
          maxBidder ! BeatenOffer(bid)
        }
        maxBid = bid
        maxBidder = client
        client ! BestOffer
      } else {
        client ! BeatenOffer(maxBid)
      }

    case Inquire(client) =>
      client ! Status(maxBid, closing)

    case ReceiveTimeout =>
      if (maxBid >= minBid) {
        val reply = AuctionConcluded(seller, maxBidder)
        maxBidder ! reply
        seller ! reply
      } else {
        seller ! AuctionFailed
      }

      context.setReceiveTimeout(timeoutToShutdown millisecond)
      context.become({
        case Offer(_, client) =>
          client ! AuctionOver
        case ReceiveTimeout =>
          context stop self
      })
  }
}
