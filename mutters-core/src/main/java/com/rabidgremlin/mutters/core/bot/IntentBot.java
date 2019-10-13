/* Licensed under Apache-2.0 */
package com.rabidgremlin.mutters.core.bot;

import com.rabidgremlin.mutters.core.Context;
import com.rabidgremlin.mutters.core.session.Session;

public interface IntentBot extends Bot
{
  @Override
  IntentBotResponse respond(Session session, Context context, String messageText) throws BotException;
}
