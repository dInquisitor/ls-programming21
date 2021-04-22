package org.howard.edu.lsp.exam.question42;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SongsDatabase {
  private Map<String, Set<String>> map = new HashMap<String, Set<String>>();

  /**
   * @param genre of song to be added to database
   * @param songTitle title of song to be added to database
   */
  public void addSong(String genre, String songTitle) {
    if (genre.isEmpty() || songTitle.isEmpty())
      throw new IllegalArgumentException("Neither song nor genre should be empty");
    if (!map.containsKey(genre)) {
      map.put(genre, new HashSet<String>());
    }
    map.get(genre).add(songTitle);
  }

  /**
   * @param genre genre to be queried
   * @return the Set that contains all songs for a genre
   */
  public Set<String> getSongs(String genre) {
    if (!map.containsKey(genre)) {
      return new HashSet<String>();
    }
    return map.get(genre);
  }

  /* Return genre, i.e., jazz, given a song title */
  /**
   * @param songTitle title of song to be queried
   * @return genre the song belongs to
   */
  public String getGenreOfSong(String songTitle) {
    for (String genre : map.keySet()) {
      for (String song : map.get(genre)) {
        if (song == songTitle) {
          return genre;
        }
      }
    }
    return "";
  }
}
