/* Licensed under Apache-2.0 */
package com.rabidgremlin.mutters.bot.ink;

import com.rabidgremlin.mutters.core.Context;
import com.rabidgremlin.mutters.core.IntentMatch;
import com.rabidgremlin.mutters.core.session.Session;

public interface RepromptGenerator
{
  CurrentResponse generateReprompt(Session session, Context context, String messageText, IntentMatch intentMatch,
      CurrentResponse currentResponse);
}
