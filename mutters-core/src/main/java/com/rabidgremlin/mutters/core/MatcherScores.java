/* Licensed under Apache-2.0 */
package com.rabidgremlin.mutters.core;

import java.util.Collections;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Holds the matching scores generated by an IntentMatcher.
 * 
 * @author rabidgremlin
 *
 */
public class MatcherScores
{
  /** Holds the matching scores. */
  private SortedMap<Double, SortedSet<String>> scores = new TreeMap<Double, SortedSet<String>>();

  /**
   * Creates a MatcherScores containing no scores.
   * 
   */
  public MatcherScores()
  {
    // do nothing
  }

  /**
   * Create a MatcherScores with the supplied scores. Map is keyed by score to
   * allow multiple intents to have the same score.
   * 
   * @param scores Map of scores mapped to sets of intent names.
   */
  public MatcherScores(SortedMap<Double, SortedSet<String>> scores)
  {
    this.scores = Objects.requireNonNull(scores);
  }

  /**
   * Add a score for an intent to the matcher scores.
   * 
   * @param intent The name of the intent to add the score for.
   * @param score  The score for the intent.
   * @return returns this.
   */
  public MatcherScores addScore(String intent, Double score)
  {
    scores.computeIfAbsent(score, k -> new TreeSet<>()).add(intent);
    return this;
  }

  /**
   * Gets the matcher scores as a sorted map of scores mapped to sets of intent
   * names.
   * 
   * @return The scores/intent name map.
   */
  public SortedMap<Double, SortedSet<String>> getScores()
  {
    return Collections.unmodifiableSortedMap(scores);
  }

  @Override
  public String toString()
  {
    return "MatcherScores [scores=" + scores + "]";
  }

  /**
   * Returns true if their are no scores.
   * 
   * @return True if there are no scores.
   */
  public boolean isEmpty()
  {
    return scores.isEmpty();
  }

  /**
   * Returns the best score in the set of scores.
   * 
   * @return Returns the nest score or null if no scores.
   */
  public OptionalDouble getBestScore()
  {
    if (scores.size() > 0)
    {
      return OptionalDouble.of(scores.lastKey());
    }
    else
    {
      return OptionalDouble.empty();
    }
  }

}
