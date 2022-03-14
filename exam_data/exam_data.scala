package com.training.doors

object exam_data {

  def main(args: Array[String]): Unit = {

    val lines = io.Source.fromFile("C:\\Work\\Training1\\exam_data.txt").getLines
    lines.foreach(
      {l => val col = l.split(",")
        if (col(0).toDouble * col(1).toDouble <= col(2).toDouble) println("Yes"+ col(0)) else println("No"+col(0))
      })

  }

}
