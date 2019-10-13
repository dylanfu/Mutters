/* Licensed under Apache-2.0 */
package com.rabidgremlin.mutters.slots;

import java.util.HashMap;

import com.rabidgremlin.mutters.core.Context;
import com.rabidgremlin.mutters.core.Slot;
import com.rabidgremlin.mutters.core.SlotMatch;

/**
 * This slot maps a number of possible inputs to a list of expected values.
 * 
 * @author rabidgremlin
 *
 */
public class CustomSlot extends Slot
{
  /** Name of the slot. */
  private String name;

  /** Map of options. */
  private HashMap<String, String> options = new HashMap<String, String>();

  /**
   * Constructor.
   * 
   * @param name    The name of the slot.
   * @param options The list of expected options.
   */
  public CustomSlot(String name, String[] options)
  {
    this.name = name;
    for (String option : options)
    {
      this.options.put(option.toLowerCase(), option);
    }
  }

  /**
   * Constructor.
   * 
   * @param name           The name of the slot.
   * @param optionValueMap A map of possible input values mapped to output values.
   */
  public CustomSlot(String name, HashMap<String, String> optionValueMap)
  {
    this.name = name;
    for (String key : optionValueMap.keySet())
    {
      this.options.put(key.toLowerCase(), optionValueMap.get(key));
    }
  }

  @Override
  public SlotMatch match(String token, Context context)
  {
    String id = token.toLowerCase();

    if (options.containsKey(id))
    {
      return new SlotMatch(this, token, options.get(id));
    }
    return null;
  }

  public String getName()
  {
    return name;
  }

  @Override
  public String toString()
  {
    return "CustomSlot [name=" + name + ", options=" + options + "]";
  }

}
