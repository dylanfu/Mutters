/* Licensed under Apache-2.0 */
package com.rabidgremlin.mutters.core;

import java.util.HashMap;

public class NoIntentMatch extends IntentMatch
{
  public NoIntentMatch()
  {
    super(Intent.NONE, new HashMap<Slot, SlotMatch>(), null, new MatcherScores());
  }

  public NoIntentMatch(MatcherScores matcherScores)
  {
    super(Intent.NONE, new HashMap<Slot, SlotMatch>(), null, matcherScores);
  }
}
