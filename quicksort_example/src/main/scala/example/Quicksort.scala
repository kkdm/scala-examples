object QuickSort extends App { 
  def quicksort(seq: Seq[Int], s: Int, e: Int): Seq[Int] = {
    if (s >= e) return seq

    def part(seq: Seq[Int], s: Int, e: Int): (Int, Seq[Int]) = {
      def swap(seq: Seq[Int], l: Int, r: Int): Seq[Int] = {
        val swap = seq(r)
        return seq.updated(r, seq(l)).updated(l, swap)
      }

      var res = seq
      var i = s
      for {
        j <- s.until(e) 
        if res(j) <= seq(e) 
      } { 
        res = swap(res, i, j)
        i += 1
      }

      res = res.updated(e, res(i)).updated(i, seq(e))
      return (i, res)
    }

    val t = part(seq, s, e)
    val res = quicksort(quicksort(t._2, s, t._1 - 1), t._1 + 1, e)
    return res
  }

  val random = new scala.util.Random
  val seq = for (i <- 0.to(10000)) yield random.nextInt(100000)
  println("10000 Randomized Numbers between 0 and 100000 as Sequence:")
  println(seq.mkString(" "))
  val result = quicksort(seq, 0, seq.length - 1)
  println("Sorted Value:")
  println(s"${result.mkString(" ")}")
}
