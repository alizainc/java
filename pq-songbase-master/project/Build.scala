import sbt._
import sbt.Keys._
import com.etsy.sbt._

object Cs1331Build extends Build{

  lazy val grade = taskKey[Unit]("Grade project solution.")

  lazy val gradeImpl = Def.task {
    val compileFailed = (compile in Compile).result.value.isInstanceOf[Inc]
    
    if (compileFailed) {
      println("Your code failed to compile; or else caused a compile error in the tests")
      println(scala.Console.RED + "Final score:       0" + scala.Console.RESET)
    } else {
      (Checkstyle.CheckstyleTasks.checkstyle in Compile).result.value
      (test in Test).result.value
      val stylePoints = checkstylePoints
      val testPoints = junitPoints
      val score = 100 - stylePoints - testPoints

      println(f"Style points: -${stylePoints}%3d")
      println(f"Test points:  -${testPoints}%3d")
      println(scala.Console.GREEN + f"Final score:   ${score}%3d" + scala.Console.RESET)
    }
  }

  def checkstylePoints = {
    val checkstyleReport = xml.XML.loadFile("target/checkstyle-report.xml")
    val files = (checkstyleReport \ "file")
    val errors = files.map(file => (file \ "error")).flatten
    val report = new StringBuilder
    report.append("\nStyle errors:\n")
    for (file <- files) {
      val name = (file \ "@name").text
      // TODO: this regex will fail on unix files with \ in them
      val fileName = name.split("[\\/]").last
      val errors = (file \ "error")
      if (errors.length > 0)
        report.append(scala.Console.YELLOW + s"$fileName:\n" + scala.Console.RESET)
      for (error <- errors) {
        val msg = (error \ "@message").text
        val line = (error \ "@line").text
        report.append(s"- Line $line: $msg\n")
      }
    }
    report.append(if (errors.size == 0) scala.Console.GREEN + "No style errors!\n" + scala.Console.RESET else scala.Console.RED + s"${errors.size} Total style errors\n" + scala.Console.RESET)
    println(report.toString)
    errors.size
  }

  def junitPoints = {
    // Hard-coded for now, we'll fix in next version
    Seq("SongTest", "SongbaseTest").map(parseReport(_)).sum
  }

  def parseReport(testName: String) = {
    val testReportFile = s"target/test-reports/${testName}.xml"
    val testReport = xml.XML.loadFile(testReportFile)
    val errors = (testReport \ "testcase" \ "failure").
      map(error => {
        if ((error \ "@message").text == "") {
          "-10 Unanticipated test failure: " + (error \ "@type").text
        } else {
          (error \ "@message").text
        }
      })
//    println(s"Test errors in $testName:")
//    errors.foreach(println)
    val points = errors.map(_.tail.takeWhile(!_.isWhitespace)).map(_.toInt).sum
    points
  }
}
