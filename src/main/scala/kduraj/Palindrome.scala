package kduraj

import scala.collection.mutable

/*
  Interview: October 24, 2015
  Written by: Kevin Duraj

  Find all unique palindromes in all substring of abba
  List(abba, bba, ba, a, abb, bb, b, ab, b, a)
  HashMap: Map(b -> 2, abba -> 1, bb -> 1, a -> 2)
  HashMap: 4

 */
object Palindrome extends App {

  substring_palindrome("abba")

  def substring_palindrome(str: String): Unit = {

    val hash = mutable.HashMap[String, Int]()

    // find all substring withing the string
    val subStr = str.inits.flatMap(_.tails.toList.init).toList
    println(subStr)

    subStr.foreach { temp =>

      // check for palindrome
      if (temp == temp.reverse) {

        if (hash.getOrElse(temp, null) == null) {
          hash += (temp -> 1)
        } else {
          hash.update(temp, hash(temp) + 1)
        }
      }
    }

    println("HashMap: " + hash.toString())
    println("HashMap: " + hash.size)

  }

}