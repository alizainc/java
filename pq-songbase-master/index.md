# Songbase Programming Quiz

In this programming quiz you will write a class to represent songs, and a class that implements a simple database for music.

1. Download the zip file of this repository to the directory on your disk where you keep your CS 1331 course work.

2. Unzip the zip archive and navigate to the directory created by unzipping the archive at the command line. You should see a ``build.sbt`` file in this directory. This is the *project root*.

3. Create a directory under the project root named ``src/main/java``. On Linux/Mac, you can do this with ``mkdir -p src/main/java``

4. In the ``src/main/java`` directory create a Java source file to hold the definition of a public class named ``Song``.

5. Implement the following constructors and methods in ``Song``:

  - a constructor that takes three ``String`` parameters.
    - The first parameter is the title/name of the song and should be stored in an instance variable.
    - The second parameter is the artist who performs the song and should be stored in an instance variable.
    - The third parameter is the album that the song appears on.
  - ``public String toString()`` returns a ``String`` representation of a ``Song`` object in the form ``<title> by <artist> on <album>``. For example, ``new Song("Mr. Roboto", "Styx", "Killroy Was Here").toString()`` would return ``Mr. Roboto by Styx on Killroy Was Here``.
  - ``public String getTitle()`` returns the name of this song.
  - ``public String getArtist()`` returns the artist of this song.
  - ``public String getAlbum()`` returns the album of this song.

6. In the ``src/main/java`` directory create a Java source file to hold the definition of a public class named ``Songbase``.

7. Implement the following constructors and methods in ``Songbase``:

  - a constructor that takes a single parameter that is an array of ``Song``. The ``Song`` array passed as an argument to the constructor should be stored in an array instance variable.
  - ``public Song findByTitle(String title)`` returns the first ``Song`` instance stored in the array instance variable whose name matches ``title`` and ``null`` if no ``Song`` is found.
  - ``public Song findByArtist(String artist)`` returns the first ``Song`` instance stored in the array instance variable that was performed by the artist ``artist`` and ``null`` if no ``Song`` is found.

8. Submit your solution by running ``sbt submit`` in the project root directory.

Tips:

- First, create your ``Song`` and ``Songbase`` classes and stub out all the required contructors and methods with dummy return values. Then go back and fill in implementations. ("//TODO" comments may help you remember what you need to come back to.)
- Run ``sbt grade`` to get a report of style errors, test failures, and a final grade report of your current progress.
- As you add functionality, rerun the previous step and re-submit if your grade is improved.
- Look at the test code in ``src/test/java`` to see how your class is used.
