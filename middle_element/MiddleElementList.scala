package exercises

import scala.annotation.tailrec

object MiddleElementList extends App{

  val mList = List (1,2,5,4,6)
  var l = 0

  def matchmList(x:List[Int]):Int = x match {
    case Nil => 0
    case x :: xs => l= l+1
    matchmList(xs)
  }

  def findmiddle(x:List[Int]) = {
    @tailrec
    def accum(y:Int):Int = {if (y >= l / 2) x(y) else accum(y+1)}
    accum(0)
  }

  def casefindmilddle(x:List[Int], y: Int ):Int = x match {
    case x :: xs if (y < l/2) => casefindmilddle(xs,y+1)
    case x :: xs if (y >= l/2) => x
  }

  def flength[T](x:List[T]) = x.foldLeft(0)((acc,d)=> {acc+1})

  @tailrec
  def accum[T](y:Int,x:List[T]):Option[T] = {if (y >= flength(x) / 2) Some(x(y)) else accum(y+1,x)}

  def middle[T](list: List[T]): Option[T] = list match {
    case Nil => None
    case x::xs => accum(0,list)
  }

  println("flength:" + flength(List()))
  val one = List(1)
  val noone = List()
  matchmList(mList)
  println("MiddleElement: " + findmiddle(mList))
  println("middleElement2: " + casefindmilddle(mList,0))
  println("m1: " + middle(List(1, 4, 3, 2, 5)))
  println("m2: " + middle(List(1,2,3,4,5,6)))
  println("m3: " + middle(List(1)))
  println("m4: " + middle(List()))

}
