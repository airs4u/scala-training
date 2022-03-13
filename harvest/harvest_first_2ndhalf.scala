package com.training.week3

object harvest_first_2ndhalf {

  def main(args: Array[String]): Unit = {

    //// drop 1st line from csv file////
    val lines = io.Source.fromFile("C:\\Work\\Scala_Training\\harvest\\harvest.csv").getLines.drop(1).toList
    val make_list = lines.map(_.split(","))

    //val gatherer = make_list.groupBy(v => (v(0),v(1).replace("-","").substring(0,6)))
    /// Group by Gatherer and month////
    val gatherer = make_list.groupBy(v => (v(0),v(2)))

    val maxfruits1 = gatherer.view.mapValues(v => v.map(_(3).toDouble).sum).toMap.map(v=>
    {(v._1._2, v._1._1,v._2)}).groupBy(_._1).view.mapValues(v =>
      v.maxBy(_._3)).toMap.toList.map(v => {(v._2._1,v._2._2,v._2._3)})
    println("Fruits and its best gatherer are:" + maxfruits1)

    // above command is split into smaller ones below//
    // val maxfruits1 = gatherer.view.mapValues(v => v.map(_(3).toDouble).sum).toMap
    //println("1: "+ maxfruits1)
    //val maxfruits2 = maxfruits1.map(v=> {(v._1._2, v._1._1,v._2)}).groupBy(_._1)
    //println("2: " + maxfruits2)
    //val maxfruits3 = maxfruits2.view.mapValues(v => v.maxBy(_._3)).toMap.toList
    //println("3: " + maxfruits3)

  }

}
