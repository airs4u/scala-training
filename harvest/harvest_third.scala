package com.training.week3

object harvest_third {

  def main(args: Array[String]): Unit = {

    ////Process input files and convert them to map with same key/////
    val price_lines = io.Source.fromFile("C:\\Work\\Scala_Training\\harvest\\prices.csv").getLines.drop(1)
    val price_list = price_lines.map(_.split(",")).toList
    val prices = price_list.groupBy(p => (p(0),p(1))).view.mapValues(p => p(0)(2)).toMap
    val harvestlines = io.Source.fromFile("C:\\Work\\Scala_Training\\harvest\\harvest.csv").getLines.drop(1).toList
    val harvestlist = harvestlines.map(_.split(","))


    val gath_fruit = harvestlist.map(x => (x(0),x(1),x(2),x(3),((prices.getOrElse((x(2),x(1)),0.0)))))
    val gath_fruit1 = gath_fruit.map(v => (v._1,v._2.dropRight(3),v._3,v._4,(v._4.toDouble * v._5.toString.toDouble)))
    val gath_fruit2 = gath_fruit1.groupBy(v=> v._1).view.mapValues(v=> v.map(_._5).sum).toMap.maxBy(_._2)

    println ("Best gatherer in income for the year: " + gath_fruit2)

    val gath_fruit3 = gath_fruit1.groupBy(v=> (v._1,v._2))
    val gath_fruit4 = gath_fruit3.view.mapValues(v=> v.map(_._5).sum).toMap
    val gath_fruit5 = gath_fruit4.map(x=> (x._1._1,x._1._2,x._2)).groupBy(v=> v._2).view.mapValues(v=>
    v.maxBy(v=> v._3)).toMap.toList.sortBy(_._1)
    println ("Best gatherer in income for every month:" + gath_fruit5)

  }

}
