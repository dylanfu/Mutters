/* Licensed under Apache-2.0 */
package com.rabidgremlin.mutters.core.bot;

import java.util.List;

import com.rabidgremlin.mutters.core.MatcherScores;

public class IntentBotResponse extends BotResponse
{
  private String matchedIntent;

  private MatcherScores matchingScores;

  public IntentBotResponse(String response, String hint, boolean askResponse, List<BotResponseAttachment> attachments,
      List<String> quickReplies, String matchedIntent, MatcherScores matchingScores)
  {
    super(response, hint, askResponse, attachments, quickReplies);
    this.matchedIntent = matchedIntent;
    this.matchingScores = matchingScores;
  }

  public String getMatchedIntent()
  {
    return matchedIntent;
  }

  public MatcherScores getMatchingScores()
  {
    return matchingScores;
  }

}
