package org.howard.edu.lsp.exam.question42.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.howard.edu.lsp.exam.question42.SongsDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This class tests the song database
 * 
 * @author Ibukunoluwa Esan
 *
 */
public class SongsDatabaseTest {

  SongsDatabase db;

  /**
   * Initialize song database
   */
  @BeforeEach
  void initializeDB() {
    db = new SongsDatabase();
  }

  /**
   * Test adding songs to database
   */
  @Test
  @DisplayName("test cases for addSong")
  void testAddSong() {
    db.addSong("gospel", "it is well");
    db.addSong("rap", "a rap song");
    db.addSong("gospel", "another gospel");
    assertThrows(IllegalArgumentException.class, () -> db.addSong("", "won't add this song"));
    assertThrows(IllegalArgumentException.class, () -> db.addSong("won't add this genre", ""));
    Exception e = assertThrows(IllegalArgumentException.class, () -> db.addSong("", ""));
    assertEquals(e.getMessage(), "Neither song nor genre should be empty");

    Set<String> gospelSongs = db.getSongs("gospel");
    Set<String> rapSongs = db.getSongs("rap");
    assertTrue(gospelSongs.equals(new HashSet<>(Arrays.asList("it is well", "another gospel"))));
    assertTrue(rapSongs.equals(new HashSet<>(Arrays.asList("a rap song"))));
  }

  /**
   * Test getting songs by genre from database
   */
  @Test
  @DisplayName("test cases for getSongs")
  void getSongs() {
    db.addSong("gospel", "it is well");
    db.addSong("rap", "a rap song");
    db.addSong("gospel", "another gospel");
    Set<String> gospelSongs = db.getSongs("gospel");
    Set<String> rapSongs = db.getSongs("rap");
    assertTrue(gospelSongs.equals(new HashSet<>(Arrays.asList("it is well", "another gospel"))));
    assertTrue(rapSongs.equals(new HashSet<>(Arrays.asList("a rap song"))));

    Set<String> nonExistent = db.getSongs("non existent genre");
    assertTrue(nonExistent.isEmpty());
  }

  /**
   * Tests querying the a song for its genre
   */
  @Test
  @DisplayName("test cases for getGenreOfSong")
  void testGetGenreOfSong() {
    db.addSong("gospel", "it is well");
    db.addSong("rap", "a rap song");
    db.addSong("gospel", "another gospel");
    db.addSong("another genre", "song from that genre");
    assertEquals(db.getGenreOfSong("a rap song"), "rap");
    assertEquals(db.getGenreOfSong("it is well"), "gospel");
    assertEquals(db.getGenreOfSong("another gospel"), "gospel");
    assertEquals(db.getGenreOfSong("song from that genre"), "another genre");
    assertEquals(db.getGenreOfSong("nonexistent song"), "");
  }
}
