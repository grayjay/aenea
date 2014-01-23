from dragonfly import Grammar, MappingRule

import aenea

from proxy_nicknames import Key

grammar = Grammar("awesome", context=aenea.global_context)

awesome = "w"

identifiers = ["1", "one", "to", "two", "too", "3", "three", "4",
               "for", "fore", "four", "5", "five", "6", "six", "7", "seven", "8",
               "9", "nine"]

ion = "(whim | notion | ion) "

class Basics(MappingRule):
  mapping = {
      "termie":Key("w-enter"),
      ion + "screen":Key(awesome + "c-k"),
      ion + "up":Key(awesome + "-k"),
      ion + "down":Key(awesome + "-j"),
      ion + "left":Key(awesome + "s-k"),
      ion + "right":Key(awesome + "s-j"),
      ion + "change screen [<n>]":Key(awesome + "-o:%(n)d"),
      ion + "close client":Key(awesome + "s-c"),
      ion + "snap":Key(awesome + "c-enter"),
      ion + "full":Key(awesome + "-m"),
      ion + "[work] <n>":Key(awesome + "-%(n)d"),
      ion + "tag <n>":Key(awesome + "sc-%(n)d"),
      ion + "tag marked <n>":Key(awesome + "s-%(n)d"),
      ion + "move marked <n>":Key(awesome + "s-%(n)d")
    }

  extras = [aenea.DigitalInteger("n", 1, None)]

grammar.add_rule(Basics())
grammar.load()

def unload():
  global grammar
  if grammar: grammar.unload()
  grammar = None
