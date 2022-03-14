package com.training.week3

object harvest_second_2ndhalf {

  def main(args: Array[String]): Unit = {

  ////Process input files and convert them to map with same key/////
  val price_lines = io.Source.fromFile("C:\\Work\\Scala_Training\\harvest\\prices.csv").getLines.drop(1).toList
  val price_list = price_lines.map(_.split(","))
  val prices = price_list.groupBy(p => (p(0),p(1))).view.mapValues(p => p(0)(2)).toMap
  val harvestlines = io.Source.fromFile("C:\\Work\\Scala_Training\\harvest\\harvest.csv").getLines.drop(1).toList
  val harvestlist = harvestlines.map(_.split(","))

  /// Best Fruit gatherer overall/////
    val date_fruit = harvestlist.map(x => (x(0),x(1),x(2),x(3),((prices.getOrElse((x(2),x(1)),0.0)))))
    val date_fruit1 = date_fruit.map(x=> (x._1,x._2.dropRight(3),x._3,(x._4.toDouble * x._5.toString.toDouble)))
    val date_fruit2 = date_fruit1.groupBy(v=> (v._3))
    val date_fruit3 = date_fruit2.view.mapValues(v=> (v.map(_._4).sum)).toMap
    val date_fruit4 = date_fruit3.filter(p => p._2 >0).minBy(v=> v._2)

  println("Least profitable Fruit: " + date_fruit4)

    val month_fruit1 = date_fruit.map(v => (v._1,v._2,v._3,v._4,(v._4.toDouble * v._5.toString.toDouble)))
    val month_fruit2 = month_fruit1.groupBy(k => (k._2.dropRight(3),k._3))
    val month_fruit3 = month_fruit2.view.mapValues(v=> (v.map(_._5).sum)).toMap
    val month_fruit4 = month_fruit3.filter(x => x._2 >0).map(v=> (v._1._1,v._1._2,v._2)).groupBy(x=> x._1)
    val month_fruit5 = month_fruit4.view.mapValues(v=> v.minBy(_._3)).toMap.toList.sortBy(_._1)
    println("1: " + month_fruit5)
  }
}