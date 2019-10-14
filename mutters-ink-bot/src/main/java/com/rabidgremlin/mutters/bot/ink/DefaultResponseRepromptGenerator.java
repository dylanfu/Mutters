/* Licensed under Apache-2.0 */
package com.rabidgremlin.mutters.bot.ink;

import java.util.Random;

import com.rabidgremlin.mutters.core.Context;
import com.rabidgremlin.mutters.core.IntentMatch;
import com.rabidgremlin.mutters.core.session.Session;

public class DefaultResponseRepromptGenerator implements RepromptGenerator
{
  private String[] defaultResponses;

  /** Random for default reponses. */
  private Random rand = new Random();

  public DefaultResponseRepromptGenerator()
  {
    this.defaultResponses = new String[] { "Pardon?" };
  }

  public DefaultResponseRepromptGenerator(String[] defaultResponses)
  {
    this.defaultResponses = defaultResponses.clone();
  }

  @Override
  public CurrentResponse generateReprompt(Session session, Context context, String messageText, IntentMatch intentMatch,
      CurrentResponse currentResponse)
  {
    // choose a default response
    String defaultResponse = defaultResponses[rand.nextInt(defaultResponses.length)];

    // grab the last response we sent to the user
    String lastResponse = InkBotSessionUtils.getLastPrompt(session);

    // do we have a last response ? If so add it to default response to create
    // reprompt
    if (lastResponse != null)
    {
      currentResponse.setResponseText(defaultResponse + " " + lastResponse);
    }
    else
    {
      // no last response so just use default response
      currentResponse.setResponseText(defaultResponse);
    }

    return currentResponse;
  }

}
