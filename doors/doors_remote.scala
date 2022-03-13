package com.training.doors

object doors_remote {
  def main(args: Array[String]): Unit = {
    val lines = io.Source.fromFile("C:\\Work\\Training1\\thief_data.txt").getLines
    lines.foreach(line => {
      var previous: Int = 1
      val remote = line.foldLeft(0)((acc, d) => {
        if (d != previous) {previous = d; acc + 1} else {acc}
      })
      println("Flips: " + remote)
    })
  }
}
