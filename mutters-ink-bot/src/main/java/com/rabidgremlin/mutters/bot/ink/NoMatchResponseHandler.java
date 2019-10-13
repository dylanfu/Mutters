/* Licensed under Apache-2.0 */
package com.rabidgremlin.mutters.bot.ink;

import com.rabidgremlin.mutters.core.Context;
import com.rabidgremlin.mutters.core.bot.BotResponse;
import com.rabidgremlin.mutters.core.session.Session;

public interface NoMatchResponseHandler
{
  BotResponse getResponse(Session session, Context context, String messageText);
}
