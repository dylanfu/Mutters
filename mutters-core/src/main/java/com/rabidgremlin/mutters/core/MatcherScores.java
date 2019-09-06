package com.rabidgremlin.mutters.core;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class MatcherScores 
{
	private SortedMap<Double, Set<String>> scores = new TreeMap<Double, Set<String>>();

	public MatcherScores()
	{
		// do nothing
	}
	
	public MatcherScores(SortedMap<Double, Set<String>> scores) 
	{
		this.scores = scores;
	}
	
	public void addScore(String intent, Double score)
	{
		Set<String> intents = scores.get(score);
		if (intents == null)
		{
			intents = new HashSet<String>();
			scores.put(score, intents);
		}
		intents.add(intent);
	}

	public SortedMap<Double, Set<String>> getScores() 
	{
		return Collections.unmodifiableSortedMap(scores);
	}
	
}
