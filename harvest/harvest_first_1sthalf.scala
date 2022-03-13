package com.training.week3

object harvest_first_1sthalf {
  def main(args: Array[String]): Unit = {
    ///////////////////Answer 1 1. Who is your best gatherer in terms of the amounts of fruits gathered every month?////

    //// drop 1st line from csv file////
    val lines = io.Source.fromFile("C:\\Work\\Scala_Training\\harvest\\harvest.csv").getLines.drop(1).toList
    val make_list = lines.map(_.split(","))

    //val gatherer = make_list.groupBy(v => (v(0),v(1).replace("-","").substring(0,6)))
    /// Group by Gatherer and month////
    val gatherer = make_list.groupBy(v => (v(0), v(1).dropRight(3)))

    // over all best gatherer///
    val Best_gatherer = gatherer.view.mapValues(f => f.map(_ (3).toDouble).sum).toMap.maxBy(_._2)
    println("Maximum Fruit gathered by whom and in which Month: " + Best_gatherer)

    // above function split into smaller parts //
    val gatherer2 = gatherer.view.mapValues(f => f.map(_ (3).toDouble).sum).toMap.toList
    val gatherer3 = gatherer2.map(v => {(v._1._1, v._1._2, v._2)}).groupBy(_._2)
    val gatherer4 = gatherer3.view.mapValues(f => (f.maxBy(_._3))).view.mapValues(x => (x._1, x._3)).toList.sortBy(_._1)

    println("Best Fruit gatherer every month :" + gatherer4)

  }
}