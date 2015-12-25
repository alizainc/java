import Cs1331Build._
onLoadMessage := ""
showSuccess := false
com.etsy.sbt.Checkstyle.CheckstyleTasks.checkstyleConfig := file("cs1331-checkstyle.xml")

lazy val filesToSubmit = settingKey[Seq[String]]("Files to submit, test, and grade.")
lazy val collabs = settingKey[Seq[String]]("Users to add as collaborators.")

lazy val root = (project in file(".")).
  settings(
    com.etsy.sbt.Checkstyle.checkstyleSettings).
  settings(
    name := "pq-songbase",
    organization := "cs1331",
    // Must be a Seq of String
    collabs := Seq("tshields3", "dl155"),
    // Must be a Seq of String
    filesToSubmit := Seq("src/main/java/Song.java", "src/main/java/Songbase.java"),
    version := "1.0",
    Keys.commands += org.cs1331.gitsubmitter.GitSubmitterPlugin.submitCommand,
    libraryDependencies ++= Seq(
      "com.novocode" % "junit-interface" % "0.11" % "test",
      "junit" % "junit" % "4.12"
    ),
    grade := gradeImpl.value
  )
