package com.training.week3

object CoreDigit {

  def main(args: Array[String]): Unit = {

    val lines = io.Source.fromFile("C:\\Work\\Training1\\CoreDigit.txt").getLines.toList
    val split_number = lines(0).split(" ")
    val result = split_number.toList(0).toList.map(_.toString.toInt).foldLeft(0)(_ + _) * split_number.toList(1).toInt
    
    println("Result: " + result)


  }

}
